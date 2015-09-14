/**
 * Project PokeScala: PokeApi Scala Wrapper
 * @author Tase Gula
 */
package com.tasegula.scala.pokescala.client

import akka.actor.ActorSystem
import akka.io.IO
import akka.pattern.ask
import akka.util.Timeout
import spray.can.Http
import spray.http.HttpMethods._
import spray.http._

import com.tasegula.scala.pokescala._

import scala.concurrent.{Await, Future}

trait PokeClient {

  private val host = "http://pokeapi.co/api/v1"

  implicit val _timeout: Timeout = timeout

  protected def getFutureFullPath(path: String)(implicit system: ActorSystem): Future[HttpResponse] = {
    import system.dispatcher

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

  protected def getFuture(path: String)(resource: String)(implicit system: ActorSystem): Future[HttpResponse] = {
    getFutureFullPath(s"$path/${resource.split("/").last}")
  }
}
