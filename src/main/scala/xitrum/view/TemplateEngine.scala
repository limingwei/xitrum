package xitrum.view

import xitrum.Controller
import xitrum.controller.Action

/**
 * Template engines should extend this trait and implement its methods.
 * On startup, an instance of the configured template engine is created and used
 * for every rendering request. Thus it should be thread-safe.
 */
trait TemplateEngine {
  /**
   * Renders the template associated with the action of the controller.
   *
   * Ex: When controller = myapp.Site, action = index, and Scalate template
   * engine is used, by default the template path will be:
   * src/main/scalate/myapp/Site/index.jade
   *
   * @param options specific to the configured template engine
   */
  def renderTemplate(
    controller: Controller, action: Action,
    controllerName: String, actionName: String,
    options: Map[String, Any]
  ): String

  /**
   * Renders the template associated with the controller.
   *
   * Ex: When controller = myapp.Site, and Scalate template
   * engine is used, by default the template path will be:
   * src/main/scalate/myapp/Site.jade
   *
   * @param options specific to the configured template engine
   */
  def renderTemplate(
    controller: Controller, controllerClass: Class[_],
    options: Map[String, Any]
  ): String

  /**
   * Renders the template fragment associated with the controller.
   *
   * Ex: When controller = myapp.Site, fragment = "footer", and Scalate template
   * engine is used, by default the template path will be:
   * src/main/scalate/myapp/Site/_footer.jade
   *
   * @param options specific to the configured template engine
   */
  def renderFragment(
    controller: Controller, controllerClass: Class[_], fragment: String,
    options: Map[String, Any]
  ): String
}
