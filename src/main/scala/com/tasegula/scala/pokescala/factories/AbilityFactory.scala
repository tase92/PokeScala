/**
 * Project PokeScala: PokeApi Scala Wrapper
 * @author Tase Gula
 */
package com.tasegula.scala.pokescala.factories

import akka.actor.ActorSystem
import com.tasegula.scala.pokescala.factories.Factory._
import com.tasegula.scala.pokescala.objects.Ability
import com.tasegula.scala.pokescala.objects.AbilityJson._

object AbilityFactory {

  type T = Ability
  implicit val path: String = "ability"

  def getAbilityFuture(id: Int)(implicit system: ActorSystem)      = getFutureById[T](id)
  def getAbilityFuture(name: String)(implicit system: ActorSystem) = getFutureByName[T](name)

  def getAbilityOption(id: Int)(implicit system: ActorSystem)      = getOptionById[T](id)
  def getAbilityOption(name: String)(implicit system: ActorSystem) = getOptionByName[T](name)

  def getAbilityResponse(id: Int)(implicit system: ActorSystem)      = getResponseById[T](id)
  def getAbilityResponse(name: String)(implicit system: ActorSystem) = getResponseByName[T](name)
}
