/**
 * Project PokeScala: PokeApi Scala Wrapper
 * @author Tase Gula
 */
package com.tasegula.scala

import akka.actor.ActorSystem

import scala.concurrent.duration._

package object pokescala {

  implicit val timeout = 5 seconds

  // we always need an ActorSystem to host our application in
  implicit val system = ActorSystem("simple-example")
}
