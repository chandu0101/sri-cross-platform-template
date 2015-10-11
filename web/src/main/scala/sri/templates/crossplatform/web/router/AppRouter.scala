package sri.templates.crossplatform.web.router

import sri.core.ReactElement
import sri.templates.crossplatform.universal.components.HelloSri
import sri.universal.components.View
import sri.universal.router._

object AppRouter {

  object HomePage extends StaticPage

  object config extends UniversalRouterConfig {
    override val initialRoute: (StaticPage, NavigatorRoute) = defineInitialRoute(HomePage, "Home", HelloSri())

    override def renderScene(route: NavigatorRoute): ReactElement = {
      View()(
        super.renderScene(route)
      )
    }

    override val notFound: (StaticPage, NavigatorRoute) = initialRoute
  }

  val router = UniversalRouter(config)
}
