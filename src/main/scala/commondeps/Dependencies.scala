package commondeps

import sbt._

/** Default dependencies.*/
object Dependencies {

  val extendedLibraries = Seq(
    "prickle",
  )


  val extensionLibraries = Seq(
    "effx",
    "monoclex",
    "shapelessx",
  )

  val baseLibraries = Seq(
    "cats-core",
    "cats-mtl",
    "alleycats-core",
    "eff",
    "monocle-core",
    "monocle-generic",
    "monocle-macro",
    "mouse",
    "hoard",
    "simulacrum",
    "refined",
    "fs2",
  )

  val testLibraries = Seq(
    "specs2-core",
    "specs2-scalacheck",
    "scalacheck",
  )

  val clientLibraries = Seq(
    "gesture",
  )


  /**
   * Versions for libraries and packages
   *
   * Format: Package -> version
   */
  val versions = Map[String, String](
    "algebra"        -> "1.0.0",
    "catalysts"      -> "0.1.0",
    "cats"           -> "1.1.0",
    "cats-effect"    -> "0.10.1",
    "cats-mtl"       -> "0.2.3",
    "discipline"     -> "0.8",
    "export-hook"    -> "1.2.0",
    "kind-projector" -> "0.9.6",
    "machinist"      -> "0.6.1",
    "macro-compat"   -> "1.1.1",
    "monocle"        -> "1.5.1-cats",
    "paradise"       -> "2.1.1",
    "refined"        -> "0.8.7",
    "scalacheck"     -> "1.13.5",
    "scalatest"      -> "3.0.3",
    "scalac"         -> "2.12.5",
    "scalac_2.13"    -> "2.13.0-M1",
    "scalac_2.12"    -> "2.12.3",
    "scalac_2.11"    -> "2.11.11",
    "scalac_2.10"    -> "2.10.6",
    "shapeless"      -> "2.3.2",
    "simulacrum"     -> "0.12.0",
    "specs2"         -> "4.0.3",
    "eff"            -> "5.2.0",
    "fs2"            -> "0.10.4",
    "mouse"          -> "0.16",
    "hoard"          -> "0.4",
    "prickle"        -> "1.1.13",
    "gesture"        ->  "0.4",
    "effx"           ->  "0.1-SNAPSHOT",
    "shapelessx"     ->  "0.1-SNAPSHOT",
    "monoclex"       ->  "0.1-SNAPSHOT",
  )

  /**
   * Library definitions and links to their versions.
   *
   * Note that one version may apply to more than one library.
   * Format: Library name -> version key, org, library
   */
  val libraries = Map[String, (String, String, String)](
    "algebra"               -> ("algebra"         , "org.typelevel"                , "algebra"),
    "algebra-laws"          -> ("algebra"         , "org.typelevel"                , "algebra-laws"),
    "alleycats-core"        -> ("cats"            , "org.typelevel"                , "alleycats-core"),
    "catalysts"             -> ("catalysts"       , "org.typelevel"                , "catalysts"),
    "catalysts-checklite"   -> ("catalysts"       , "org.typelevel"                , "catalysts-checklite"),
    "catalysts-lawkit"      -> ("catalysts"       , "org.typelevel"                , "catalysts-lawkit"),
    "catalysts-macros"      -> ("catalysts"       , "org.typelevel"                , "catalysts-macros"),
    "catalysts-platform"    -> ("catalysts"       , "org.typelevel"                , "catalysts-platform"),
    "catalysts-scalatest"   -> ("catalysts"       , "org.typelevel"                , "catalysts-scalatest"),
    "catalysts-specbase"    -> ("catalysts"       , "org.typelevel"                , "catalysts-specbase"),
    "catalysts-speclite"    -> ("catalysts"       , "org.typelevel"                , "catalysts-speclite"),
    "catalysts-specs2"      -> ("catalysts"       , "org.typelevel"                , "catalysts-specs2"),
    "catalysts-testkit"     -> ("catalysts"       , "org.typelevel"                , "catalysts-testkit"),
    "cats-core"             -> ("cats"            , "org.typelevel"                , "cats-core"),
    "cats-kernel"           -> ("cats"            , "org.typelevel"                , "cats-kernel"),
    "cats-free"             -> ("cats"            , "org.typelevel"                , "cats-free"),
    "cats-laws"             -> ("cats"            , "org.typelevel"                , "cats-laws"),
    "cats-macros"           -> ("cats"            , "org.typelevel"                , "cats-macros"),
    "cats-testkit"          -> ("cats"            , "org.typelevel"                , "cats-testkit"),
    "cats-effect"           -> ("cats-effect"     , "org.typelevel"                , "cats-effect"),
    "cats-mtl"              -> ("cats-mtl"        , "org.typelevel"                , "cats-mtl-core"),
    "discipline"            -> ("discipline"      , "org.typelevel"                , "discipline"),
    "export-hook"           -> ("export-hook"     , "org.typelevel"                , "export-hook"),
    "machinist"             -> ("machinist"       , "org.typelevel"                , "machinist"),
    "macro-compat"          -> ("macro-compat"    , "org.typelevel"                , "macro-compat"),
    "monocle-core"          -> ("monocle"         , "com.github.julien-truffaut"   , "monocle-core"),
    "monocle-generic"       -> ("monocle"         , "com.github.julien-truffaut"   , "monocle-generic"),
    "monocle-macro"         -> ("monocle"         , "com.github.julien-truffaut"   , "monocle-macro"),
    "monocle-state"         -> ("monocle"         , "com.github.julien-truffaut"   , "monocle-state"),
    "monocle-law"           -> ("monocle"         , "com.github.julien-truffaut"   , "monocle-law"),
    "refined"               -> ("refined"         , "eu.timepit"                   , "refined"),
    "refined-scalacheck"    -> ("refined"         , "eu.timepit"                   , "refined-scalacheck"),
    "refined-scalaz"        -> ("refined"         , "eu.timepit"                   , "refined-scalaz"),
    "refined-scodec"        -> ("refined"         , "eu.timepit"                   , "refined-scodec"),
    "scalatest"             -> ("scalatest"       , "org.scalatest"                , "scalatest"),
    "scalacheck"            -> ("scalacheck"      , "org.scalacheck"               , "scalacheck"),
    "shapeless"             -> ("shapeless"       , "com.chuusai"                  , "shapeless"),
    "simulacrum"            -> ("simulacrum"      , "com.github.mpilquist"         , "simulacrum"),
    "specs2-core"           -> ("specs2"          , "org.specs2"                   , "specs2-core"),
    "specs2-scalacheck"     -> ("specs2"          , "org.specs2"                   , "specs2-scalacheck"),
    "eff"                   -> ("eff"             , "org.atnos"                    , "eff"),
    "mouse"                 -> ("mouse"           , "org.typelevel"                , "mouse"),
    "fs2"                   -> ("fs2"             , "co.fs2"                       , "fs2-core"),

    "hoard"                 -> ("hoard"           , "com.github.benhutchison"      , "hoard"),
    "prickle"               -> ("prickle"         , "com.github.benhutchison"      , "prickle"),
    "gesture"               -> ("gesture"         , "com.github.benhutchison"      , "gesture"),
    "effx"                  -> ("effx"            , "com.github.benhutchison"      , "effx"),
    "monoclex"              -> ("monoclex"        , "com.github.benhutchison"      , "monoclex"),
    "shapelessx"            -> ("shapelessx"      , "com.github.benhutchison"      , "shapelessx"),
  )

  /**
   * Compiler plugins definitions and links to their versions
   *
   * Note that one version may apply to more than one plugin.
   *
   * Format: Library name -> version key, org, librar, crossVersion
   */
  val scalacPlugins = Map[String, (String, String, String, CrossVersion)](
    "kind-projector"    -> ("kind-projector"  , "org.spire-math"      , "kind-projector" , CrossVersion.binary),
    "paradise"          -> ("paradise"        , "org.scalamacros"     , "paradise"       , CrossVersion.full)
  )

}
