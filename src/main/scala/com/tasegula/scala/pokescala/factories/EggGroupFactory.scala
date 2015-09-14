/**
 * Project PokeScala: PokeApi Scala Wrapper
 * @author Tase Gula
 */
package com.tasegula.scala.pokescala.factories

import akka.actor.ActorSystem
import com.tasegula.scala.pokescala.factories.Factory._
import com.tasegula.scala.pokescala.objects.EggGroup
import com.tasegula.scala.pokescala.objects.EggGroupJson._

object EggGroupFactory {

  type T = EggGroup
  implicit val path: String = "egg"

  def getEggGroupFuture(id: Int)(implicit system: ActorSystem)      = getFutureById[T](id)
  def getEggGroupFuture(name: String)(implicit system: ActorSystem) = getFutureByName[T](name)

  def getEggGroupOption(id: Int)(implicit system: ActorSystem)      = getOptionById[T](id)
  def getEggGroupOption(name: String)(implicit system: ActorSystem) = getOptionByName[T](name)

  def getEggGroupResponse(id: Int)(implicit system: ActorSystem)      = getResponseById[T](id)
  def getEggGroupResponse(name: String)(implicit system: ActorSystem) = getResponseByName[T](name)
}
