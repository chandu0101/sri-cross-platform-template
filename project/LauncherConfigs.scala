import org.scalajs.sbtplugin.ScalaJSPlugin.AutoImport._
import sbt.Keys._
import sbt._

object LauncherConfigs {

  /** ================ React_native task   ================ */
  val fullOptIOS = Def.taskKey[File]("Generate the file given to react native")

  lazy val iosLauncher =
    Seq(
      artifactPath in Compile in fullOptIOS :=
        baseDirectory.value / "index.ios.js",
      fullOptIOS in Compile := {
        val outFile = (artifactPath in Compile in fullOptIOS).value

        val loaderFile = (resourceDirectory in Compile).value / "loader.js"

        IO.copyFile(loaderFile, outFile)
        //        val loaders = IO.read((resourceDirectory in Compile).value / "loader.js")
        //
        //        IO.append(outFile, loaders)

        val fullOutputCode = IO.read((fullOptJS in Compile).value.data)

        IO.append(outFile, fullOutputCode)

        //        IO.copyFile((fullOptJS in Compile).value.data, outFile)

        val launcher = (scalaJSLauncher in Compile).value.data.content
        IO.append(outFile, launcher)

        outFile
      }
    )

  val fullOptMobile = Def.taskKey[File]("Generate the file given to react native")

  lazy val mobilelauncher =
    Seq(
      artifactPath in Compile in fullOptMobile :=
        baseDirectory.value / "index.ios.js",
      fullOptMobile in Compile := {
        val outFile = (artifactPath in Compile in fullOptMobile).value

        val loaderFile = (resourceDirectory in Compile).value / "loader.js"

        IO.copyFile(loaderFile, outFile)

        val fullOutputCode = IO.read((fullOptJS in Compile).value.data)

        IO.append(outFile, fullOutputCode)

        val launcher = (scalaJSLauncher in Compile).value.data.content
        IO.append(outFile, launcher)

        IO.copyFile(outFile,baseDirectory.value / "index.android.js")
        outFile
      }
    )





  val webAssets = "web/assets"

  lazy val webLauncher = Seq(crossTarget in(Compile, fullOptJS) := file(webAssets),
    crossTarget in(Compile, fastOptJS) := file(webAssets),
    crossTarget in(Compile, packageScalaJSLauncher) := file(webAssets),
    artifactPath in(Compile, fastOptJS) := ((crossTarget in(Compile, fastOptJS)).value /
      ((moduleName in fastOptJS).value + "-opt.js"))
  )


}