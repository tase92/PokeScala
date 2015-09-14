/**
 * Project PokeScala: PokeApi Scala Wrapper
 * @author Tase Gula
 */
package com.tasegula.scala.pokescala.factories

import com.tasegula.scala.pokescala.client.PokeClient
import com.tasegula.scala.pokescala.{timeout, _}
import com.tasegula.scala.pokescala.util.PokeApiResponse
import play.api.libs.json.{Format, Json}
import spray.http.HttpResponse

import scala.concurrent.{Await, Future}
import scala.util.{Failure, Success, Try}

object Factory extends PokeClient {

  import system.dispatcher

  def getFutureById[T](id: Int)(implicit format: Format[T], path: String)        = toFuture[T](getFuture(path)(s"$id"))

  def getFutureByName[T](name: String)(implicit format: Format[T], path: String) = {
    val x = toFuture[T](getFuture(path)(s"$name"))
    println(x)
    x
  }

  def getOptionById[T](id: Int)(implicit format: Format[T], path: String)        = toOption[T](getFutureById[T](id))

  def getOptionByName[T](name: String)(implicit format: Format[T], path: String) = toOption[T](getFutureByName[T](name))

  def getResponseById[T](id: Int)(implicit format: Format[T], path: String)        = toResponse[T](getFuture(path)(s"$id"))

  def getResponseByName[T](name: String)(implicit format: Format[T], path: String) = toResponse[T](getFuture(path)(s"$name"))

  // --------------------------------------------------------------------------
  // PRIVATE HELPERS
  // --------------------------------------------------------------------------

  private[this] def toFuture[T](future: Future[HttpResponse])(implicit format: Format[T], path: String): Future[T] = {
    future.map { httpResponse =>
      Try[T](Json.parse(httpResponse.entity.data.asString).as[T]) match {
        case Success(resource) => resource
        case Failure(f) => throw new Exception(httpResponse.entity.data.asString)
      }
    }
  }

  private[this] def toOption[T](future: Future[T])(implicit format: Format[T], path: String): Option[T] = {
    val option = Await.ready[T](future, timeout)
    option.value.get.toOption
  }

  private[this] def toResponse[T](future: Future[HttpResponse])(implicit format: Format[T], path: String): PokeApiResponse[T] = {
    val futureOption = future.map { httpResponse =>
      Try[T](Json.parse(httpResponse.entity.data.asString).as[T]) match {
        case Success(resource) => PokeApiResponse[T](resource = Some(resource), httpResponse = Some(httpResponse))
        case Failure(f) =>        PokeApiResponse[T](outcome = Some(f.getMessage), httpResponse = Some(httpResponse))
      }
    }

    val option = Await.ready[PokeApiResponse[T]](futureOption, timeout)
    option.value.get match {
      case Success(x) => x
      case Failure(f) => PokeApiResponse[T](outcome = Some(f.getMessage))
    }
  }
}