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

  def getSpriteFuture(id: Int)(implicit system: ActorSystem) = getFutureById[T](id)
  def getSpriteFuture(name: String)(implicit system: ActorSystem) = getFutureByName[T](name)

  def getSprite(id: Int)(implicit system: ActorSystem) = getById[T](id)
  def getSprite(name: String)(implicit system: ActorSystem) = getByName[T](name)
}
