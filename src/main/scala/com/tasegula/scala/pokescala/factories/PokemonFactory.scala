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

  def getPokemonFuture(id: Int)(implicit system: ActorSystem) = getFutureById[T](id)
  def getPokemonFuture(name: String)(implicit system: ActorSystem) = getFutureByName[T](name)

  def getPokemon(id: Int)(implicit system: ActorSystem) = getById[T](id)
  def getPokemon(name: String)(implicit system: ActorSystem) = getByName[T](name)
}
