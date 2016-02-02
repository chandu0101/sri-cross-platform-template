package sri.templates.crossplatform.web.router

import sri.core.ReactElement
import sri.templates.crossplatform.universal.components.HelloSri
import sri.universal.components.View
import sri.universal.router._
import sri.universal.styles.UniversalStyleSheet

object AppRouter {

  object HomePage extends StaticPage

  object config extends UniversalRouterConfig {
    override val initialRoute: (StaticPage, NavigatorRoute) = defineInitialRoute(HomePage, "Home", HelloSri())

    override def renderScene(route: NavigatorRoute): ReactElement = {
      View(style = UniversalStyleSheet.wholeContainer)(
        super.renderScene(route)
      )
    }

    override val notFound: (StaticPage, NavigatorRoute) = initialRoute
  }

  val router = UniversalRouter(config)
}
