/**
 * Project PokeScala: PokeApi Scala Wrapper
 * @author Tase Gula
 */
package com.tasegula.scala.pokescala.factories

import akka.actor.ActorSystem
import com.tasegula.scala.pokescala.factories.Factory._
import com.tasegula.scala.pokescala.objects.Pokemon
import com.tasegula.scala.pokescala.objects.PokemonJson._

object PokemonFactory {

  type T = Pokemon
  implicit val path: String = "pokemon"

  def getPokemonFuture(id: Int)(implicit system: ActorSystem)      = getFutureById[T](id)
  def getPokemonFuture(name: String)(implicit system: ActorSystem) = getFutureByName[T](name)

  def getPokemonOption(id: Int)(implicit system: ActorSystem)      = getOptionById[T](id)
  def getPokemonOption(name: String)(implicit system: ActorSystem) = getOptionByName[T](name)

  def getPokemonResponse(id: Int)(implicit system: ActorSystem)      = getResponseById[T](id)
  def getPokemonResponse(name: String)(implicit system: ActorSystem) = getResponseByName[T](name)
}
