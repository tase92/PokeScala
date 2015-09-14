/**
 * Project PokeScala: PokeApi Scala Wrapper
 * @author Tase Gula
 */
package com.tasegula.scala.pokescala.factories

import akka.actor.ActorSystem
import com.tasegula.scala.pokescala.factories.Factory._
import com.tasegula.scala.pokescala.objects.Sprite
import com.tasegula.scala.pokescala.objects.SpriteJson._

object SpriteFactory {

  type T = Sprite
  implicit val path: String = "sprite"

  def getSpriteFuture(id: Int)(implicit system: ActorSystem)      = getFutureById[T](id)
  def getSpriteFuture(name: String)(implicit system: ActorSystem) = getFutureByName[T](name)

  def getSpriteOption(id: Int)(implicit system: ActorSystem)      = getOptionById[T](id)
  def getSpriteOption(name: String)(implicit system: ActorSystem) = getOptionByName[T](name)

  def getSpriteResponse(id: Int)(implicit system: ActorSystem)      = getResponseById[T](id)
  def getSpriteResponse(name: String)(implicit system: ActorSystem) = getResponseByName[T](name)
}
