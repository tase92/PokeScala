/**
 * Project PokeScala: PokeApi Scala Wrapper
 * @author Tase Gula
 */
package com.tasegula.scala.pokescala.objects

import play.api.libs.json.Json

case class Evolution(level: Int,
                     method: String,
                     resource_uri: String,
                     to: String)

trait EvolutionJson {
  implicit val formatEvolution = Json.format[Evolution]
}

object EvolutionJson extends EvolutionJson