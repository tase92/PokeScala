/**
 * Project PokeScala: PokeApi Scala Wrapper
 * @author Tase Gula
 */
package com.tasegula.scala.pokescala

import akka.actor.ActorSystem
import com.tasegula.scala.pokescala.client.PokeClient
import com.tasegula.scala.pokescala.factories.PokemonFactory

import scala.util.{Failure, Success}

object Main
  extends App
  with PokeClient {

  // we always need an ActorSystem to host our application in
  implicit val system = ActorSystem("simple-example")

  import system.dispatcher

  val p2 = PokemonFactory.getPokemon(1)
  println(p2)

  val p = PokemonFactory.getPokemonFuture(0)
  p onComplete {
    case Success(s) => println(s)
    case Failure(f) => println(f.getMessage)
  }

  system.shutdown()

}
