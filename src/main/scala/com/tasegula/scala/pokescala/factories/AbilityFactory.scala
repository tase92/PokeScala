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

  def getAbilityFuture(id: Int)(implicit system: ActorSystem) = getFutureById[T](id)
  def getAbilityFuture(name: String)(implicit system: ActorSystem) = getFutureByName[T](name)

  def getAbility(id: Int)(implicit system: ActorSystem) = getById[T](id)
  def getAbility(name: String)(implicit system: ActorSystem) = getByName[T](name)
}
