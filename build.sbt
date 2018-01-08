
sbtPlugin := true
organization := "com.github.benhutchison"
name := "sbt-common"
description := "SBT plugin for reusing common settings"

addSbtPlugin("com.timushev.sbt"  %  "sbt-updates"           % "0.3.3")
addSbtPlugin("com.github.gseitz" %  "sbt-release"           % "1.0.6")
addSbtPlugin("net.virtual-void"  %  "sbt-dependency-graph"  % "0.9.0")
addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.21")

scalacOptions ++= Seq(Opts.compile.deprecation, "-feature")

resolvers += Resolver.url("typesafe", url("http://repo.typesafe.com/typesafe/ivy-releases/"))(Resolver.ivyStylePatterns)
