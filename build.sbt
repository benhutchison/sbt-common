
sbtPlugin := true
organization := "com.github.benhutchison"
name := "sbt-common"
description := "SBT plugin for reusing common settings"

addSbtPlugin("com.timushev.sbt"  %  "sbt-updates"           % "0.3.4")
addSbtPlugin("com.github.gseitz" %  "sbt-release"           % "1.0.8")
addSbtPlugin("net.virtual-void"  %  "sbt-dependency-graph"  % "0.9.0")
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.22")
addSbtPlugin("org.xerial.sbt" % "sbt-sonatype" % "2.3")
addSbtPlugin("com.jsuereth" % "sbt-pgp" % "1.1.1")

scalacOptions ++= Seq(Opts.compile.deprecation, "-feature")

resolvers += Resolver.url("typesafe", url("http://repo.typesafe.com/typesafe/ivy-releases/"))(Resolver.ivyStylePatterns)

sonatypeProfileName := "com.github.benhutchison"
publishMavenStyle := true
licenses += ("MIT license", url("http://opensource.org/licenses/MIT"))
homepage := Some(url("https://github.com/benhutchison"))
developers := List(Developer("benhutchison", "Ben Hutchison", "brhutchison@gmail.com", url = url("https://github.com/benhutchison")))
scmInfo := Some(ScmInfo(url("https://github.com/benhutchison"), "scm:git:https://github.com/benhutchison"))
publishArtifact in Test := false
publishTo := Some(
  if (isSnapshot.value)
    Opts.resolver.sonatypeSnapshots
  else
    Opts.resolver.sonatypeStaging
)
