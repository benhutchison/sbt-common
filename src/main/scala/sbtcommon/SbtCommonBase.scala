package sbtcommon

import sbt.Keys._
import sbt._

import org.scalajs.sbtplugin.ScalaJSPlugin
import ScalaJSPlugin.autoImport._


object SbtCommonBase extends AutoPlugin {
  override def requires = plugins.JvmPlugin
  override def trigger = allRequirements

  object autoImport extends SbtCommonBase {
  }
}

trait SbtCommonBase {

  type VersionsType = Map[String, String]
  type LibrariesType = Map[String, (String, String, String)]
  type ScalacPluginType = Map[String, (String, String, String, CrossVersion)]

  /** Container for the version, library and scala plugin Maps.*/
  case class Versions(vers: VersionsType, libs: LibrariesType, plugs: ScalacPluginType) {
    def vLibs  = (vers, libs)
    def vPlugs = (vers, plugs)

    def asLibraryDependencies(key: String,
      maybeScope: Option[String] = None,
      exclusions: List[ExclusionRule] = Nil) = Seq(
        libraryDependencies += {
          val mainModule = libs(key)._2 %%% libs(key)._3 % vers(libs(key)._1)
          (maybeScope, exclusions) match {
            case (Some(scope), Nil) => mainModule % scope
            case (None, ex) => mainModule excludeAll (ex: _*)
            case (Some(scope), ex) => mainModule % scope excludeAll (ex: _*)
            case _ => mainModule
          }
        }
      )
  }

  /** Using the supplied Versions map, adds the list of libraries to a module.*/
  def addLibs(versions: Versions, libs: String*) =
    libs flatMap (versions.asLibraryDependencies(_))/** Using the supplied Versions map, adds the list of libraries to a module.*/

  def addLibSeq(versions: Versions, libs: Seq[String]) =
    libs flatMap (versions.asLibraryDependencies(_))

  /** Using the supplied Versions map, adds the list of libraries to a module as a compile dependency.*/
  def addCompileLibs(versions: Versions, libs: String*) = addLibsScoped(versions, "compile", libs:_*)

  /** Using the supplied Versions map, adds the list of libraries to a module as a test dependency.*/
  def addTestLibs(versions: Versions, libs: String*) = addLibsScoped(versions, "test", libs:_*)

  /** Using versions map, adds the list of libraries to a module using the given dependency.*/
  def addLibsScoped(versions: Versions, scope: String, libs: String*) =
    libs flatMap (versions.asLibraryDependencies(_, Some(scope)))

  /** Using versions map, adds the list of libraries to a module using the given dependency.*/
  def addLibsExcluding(versions: Versions, exclusions: List[ExclusionRule], libs: String*) =
    libs flatMap (versions.asLibraryDependencies(_, exclusions = exclusions))

  def addLibsExcluding(versions: Versions, scope: String, exclusions: List[ExclusionRule], libs: String*) =
    libs flatMap (versions.asLibraryDependencies(_, Some(scope), exclusions))

  /** Using the supplied Versions map, adds the list of compiler plugins to a module.*/
  def addCompilerPlugins(v: Versions, plugins: String*) =
    plugins.flatMap(s => Seq(libraryDependencies += compilerPlugin(
      v.plugs(s)._2 %% v.plugs(s)._3 % v.vers(v.plugs(s)._1) cross v.plugs(s)._4)))


  lazy val noPublishSettings = Seq(
    (skip in publish) := true,
  )

  lazy val scalacCommonOptions = Seq(
    "-deprecation",
    "-encoding", "UTF-8",
    "-feature",
    "-unchecked",
    "-Ypartial-unification",
    "-language:_",
  )

  lazy val scalacStrictOptions = Seq(
    "-Yno-adapted-args",
    "-Ywarn-dead-code",
    "-Ywarn-value-discard",
    "-Xfuture"
  )

  lazy val publishSettings = Seq(
    xerial.sbt.Sonatype.SonatypeKeys.sonatypeProfileName := "com.github.benhutchison",
    publishMavenStyle := true,
    licenses += ("MIT license", url("http://opensource.org/licenses/MIT")),
    homepage := Some(url("https://github.com/benhutchison")),
    developers := List(Developer("benhutchison", "Ben Hutchison", "brhutchison@gmail.com", url = url("https://github.com/benhutchison"))),
    scmInfo := Some(ScmInfo(url("https://github.com/benhutchison"), "scm:git:https://github.com/benhutchison")),
    publishArtifact in Test := false,
    publishTo := Some(
      if (isSnapshot.value)
        Opts.resolver.sonatypeSnapshots
      else
        Opts.resolver.sonatypeStaging
    ),
  )

  lazy val scalacAllOptions = scalacCommonOptions ++ scalacStrictOptions

  def crossProjectRef(relPath: String) = (subpart: String) => ProjectRef(file(relPath), subpart)

  sealed trait JvmOrJs
  case object Jvm extends JvmOrJs {
    override def toString = "JVM"
  }
  case object Js extends JvmOrJs {
    override def toString = "JS"
  }

  sealed trait ProjOrLib
  case object Proj extends ProjOrLib
  case object Lib extends ProjOrLib


  def dependProjectOrLibrary(name: String, depType: ProjOrLib)(
    groupId: String, version: String, artifactId: String = name, projPath: String = s"../$name")(
    jvmOrJs: JvmOrJs)(
    p: Project): Project = depType match {
    case Proj =>
      val proj = ProjectRef(file(projPath), s"$name$jvmOrJs")
      p.dependsOn(proj).aggregate(proj)
    case Lib =>
      p.settings(libraryDependencies += groupId %%% artifactId % version)
  }

  implicit class RichProject(p: Project) {
    def dependAggregate(proj: ProjectReference) = p.dependsOn(proj).aggregate(proj)





  }


}

