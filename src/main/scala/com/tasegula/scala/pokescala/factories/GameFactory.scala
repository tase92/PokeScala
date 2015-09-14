/**
 * Project PokeScala: PokeApi Scala Wrapper
 * @author Tase Gula
 */
package com.tasegula.scala.pokescala.factories

import akka.actor.ActorSystem
import com.tasegula.scala.pokescala.factories.Factory._
import com.tasegula.scala.pokescala.objects.Game
import com.tasegula.scala.pokescala.objects.GameJson._

object GameFactory {

  type T = Game
  implicit val path: String = "game"

  def getGameFuture(id: Int)(implicit system: ActorSystem)      = getFutureById[T](id)
  def getGameFuture(name: String)(implicit system: ActorSystem) = getFutureByName[T](name)

  def getGameOption(id: Int)(implicit system: ActorSystem)      = getOptionById[T](id)
  def getGameOption(name: String)(implicit system: ActorSystem) = getOptionByName[T](name)

  def getGameResponse(id: Int)(implicit system: ActorSystem)      = getResponseById[T](id)
  def getGameResponse(name: String)(implicit system: ActorSystem) = getResponseByName[T](name)
}
