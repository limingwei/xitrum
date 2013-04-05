package xitrum

import org.jboss.netty.channel.{ChannelFuture, ChannelFutureListener}

import xitrum.action._
import xitrum.scope.request.RequestEnv
import xitrum.scope.session.SessionEnv
import xitrum.view.{Renderer, Responder}

trait ActionEnv extends RequestEnv with SessionEnv
    with Logger
    with Net
    with Filter
    with BasicAuth
    with WebSocket
    with Redirect
    with UrlFor
    with Renderer
    with Responder
    with I18n
{
  lazy val currentAction = this

  def addConnectionClosedListener(listener: => Unit) {
    channel.getCloseFuture.addListener(new ChannelFutureListener {
      def operationComplete(future: ChannelFuture) { listener }
    })
  }
}