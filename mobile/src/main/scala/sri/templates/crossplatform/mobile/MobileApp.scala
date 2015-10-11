package sri.templates.crossplatform.mobile

import sri.mobile.ReactNative
import sri.mobile.all._
import sri.templates.crossplatform.mobile.router.AppRouter

import scala.scalajs.js.JSApp


object MobileApp extends JSApp {

  def main() = {

    val root = createMobileRoot(
      AppRouter.router
    )
    ReactNative.AppRegistry.registerComponent("SriCrossPlatformTemplate", () => root)
  }
}
