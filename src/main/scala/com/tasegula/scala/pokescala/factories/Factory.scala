/**
 * Project PokeScala: PokeApi Scala Wrapper
 * @author Tase Gula
 */
package com.tasegula.scala.pokescala.factories

import akka.actor.ActorSystem
import com.tasegula.scala.pokescala._
import com.tasegula.scala.pokescala.client.PokeClient
import play.api.libs.json.{Format, Json}
import spray.http.StatusCodes

import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success}

object Factory extends PokeClient {

  def getById[T](id: Int)(implicit system: ActorSystem, format: Format[T], path: String): T = {
    val future = getFutureById[T](id)
    val option = Await.ready[T](future, timeout)
    option.value.get match {
      case Success(pokemon) => pokemon
      case Failure(f) => throw f
    }
  }

  def getFutureById[T](id: Int)(implicit system: ActorSystem, format: Format[T], path: String): Future[T] = {
    import system.dispatcher
    val response = getFuture(s"$path/$id")
    response.map(httpResponse =>
      if (httpResponse.status == StatusCodes.OK) Json.parse(httpResponse.entity.data.asString).as[T]
      else throw new Exception(httpResponse.entity.data.asString))
  }

  def getByName[T](name: String)(implicit system: ActorSystem, format: Format[T], path: String): T = {
    val future = getFutureByName[T](name)
    val option = Await.ready[T](future, timeout)
    option.value.get match {
      case Success(pokemon) => pokemon
      case Failure(f) => throw f
    }
  }

  def getFutureByName[T](name: String)(implicit system: ActorSystem, format: Format[T], path: String): Future[T] = {
    import system.dispatcher
    val query = name.split("/").head
    val response = getFuture(s"$path/$query")
    response.map(httpResponse =>
      if (httpResponse.status == StatusCodes.OK) Json.parse(httpResponse.entity.data.asString).as[T]
      else throw new Exception(httpResponse.entity.data.asString))
  }
}