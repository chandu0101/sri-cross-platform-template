package sri.templates.crossplatform.mobile.router

import sri.core.ReactElement
import sri.templates.crossplatform.universal.components.HelloSri
import sri.universal.components.View
import sri.universal.router._
import sri.universal.styles.UniversalStyleSheet


object AppRouter {

  object HomePage extends StaticPage

  object Config extends UniversalRouterConfig {

    override val initialRoute = defineInitialRoute(HomePage, "Home", HelloSri())

    override val notFound: (StaticPage, NavigatorRoute) = initialRoute

    override def renderScene(route: NavigatorRoute): ReactElement = {
      View(style = UniversalStyleSheet.wholeContainer)(
        super.renderScene(route)
      )
    }
  }

  val router = UniversalRouter(Config)

}

