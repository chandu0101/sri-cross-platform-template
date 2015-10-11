import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt.Keys._
import sbt._

object Dependencies {

  val scalaAsyncVersion = "0.9.2"

  val upickleVersion = "0.3.1"

  val scalatestVersion = "3.0.0-M6"

  val utestVersion = "0.3.0"



  val sriVersion = "0.1.0-SNAPSHOT"


  val utestJS = libraryDependencies += "com.lihaoyi" %%% "utest" % "0.3.0" % Test

  val scalatestJS = libraryDependencies += "org.scalatest" %%% "scalatest" % scalatestVersion % Test

  val scalaAsync = libraryDependencies += "org.scala-lang.modules" %% "scala-async" % scalaAsyncVersion

  val scalaJSUpickle = libraryDependencies += "com.lihaoyi" %%% "upickle" % upickleVersion

  val sriUniversal = libraryDependencies += "com.github.chandu0101.sri" %%% "universal" % sriVersion

  val sriMobile = libraryDependencies += "com.github.chandu0101.sri" %%% "mobile" % sriVersion

  val sriWeb = libraryDependencies += "com.github.chandu0101.sri" %%% "web" % sriVersion


  val universalModuleDeps = Seq(
    sriUniversal,
    scalaAsync
  )

  val webModuleDeps = Seq(
    sriWeb
  )

  val mobileModuleDeps = Seq(
    sriMobile
  )

}