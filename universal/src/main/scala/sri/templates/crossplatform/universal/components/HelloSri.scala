package sri.templates.crossplatform.universal.components

import sri.core._
import sri.universal.all._
import sri.universal.components._
import sri.universal.styles.UniversalStyleSheet

import scala.scalajs.js
import scala.scalajs.js.annotation.ScalaJSDefined
import scala.scalajs.js.{UndefOr => U}

object HelloSri {

  @ScalaJSDefined
  class Component extends ReactComponent[Unit, Unit] {
    def render() = {

      val text = if (isIOSPlatform) "iOS"
      else if (isAndroidPlatform) "Android"
      else "Web"

      View(style = styles.container)(
        Text(style = styles.text)(s"Welcome to Sri $text "),
        Image(style = styles.image, source = ImageSource(uri = "http://www.scala-js.org/images/scala-js-logo-256.png"))(),
        Text(style = styles.text)("Scala.js - Future of app development!")
      )
    }
  }

  object styles extends UniversalStyleSheet {

    val container = style(flexOne,
      backgroundColor := "rgb(162, 3, 112)",
      justifyContent.center,
      alignItems.center)

    val image = style(width := 256, height := 256, margin := 20)

    val text = style(fontWeight._500,
      fontSize := 18,
      color := "white")

  }

  val ctor = getTypedConstructor(js.constructorOf[Component], classOf[Component])

  def apply() = createElementNoProps(ctor)

}

