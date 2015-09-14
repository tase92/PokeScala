/**
 * Project PokeScala: PokeApi Scala Wrapper
 * @author Tase Gula
 */
package com.tasegula.scala.pokescala.util

import com.tasegula.scala.pokescala.objects.Pokemon
import play.api.libs.json.Json
import spray.http.HttpResponse

case class PokeApiResponse[T](resource: Option[T] = None,
                              outcome: Option[String] = None,
                              httpResponse: Option[HttpResponse] = None) {
  
  def getResource = resource.getOrElse(Pokemon)
  def getOutcome = outcome.getOrElse("")
  def getHttpResponse = httpResponse.getOrElse(HttpResponse)
}