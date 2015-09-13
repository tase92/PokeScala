/**
 * Project PokeScala: PokeApi Scala Wrapper
 * @author Tase Gula
 */
package com.tasegula.scala.pokescala.client

import akka.actor.ActorSystem
import akka.event.Logging
import akka.io.IO
import akka.pattern.ask
import akka.util.Timeout
import spray.can.Http
import spray.http.HttpMethods._
import spray.http._

import scala.concurrent.duration._
import scala.concurrent.{Await, Future}

trait PokeClient {
  private implicit val timeout: Timeout = 5.seconds

  private val host = "http://pokeapi.co/api/v1"

  protected def get(path: String)(implicit system: ActorSystem): HttpResponse = {
    Await.result(getFuture(path), timeout.duration)
  }

  protected def getFuture(path: String)(implicit system: ActorSystem): Future[HttpResponse] = {
    import system.dispatcher
    // execution context for future transformation below
    val log = Logging(system, getClass)

    // construct the request
    val request = HttpRequest(GET, Uri(s"$host/$path/"))
    println(s"REQUEST: $request")

    // send the request and return the response
    for {
      response <- (IO(Http) ? request).mapTo[HttpResponse]
    } yield {
      println(s"RESPONSE: $response")
      response
    }
  }
}
