/**
 * Project PokeScala: PokeApi Scala Wrapper
 * @author Tase Gula
 */
package com.tasegula.scala.pokescala.objects

import play.api.libs.json.Json

case class Game(id: Int,
                name: String,
                resource_uri: String,
                created: String,
                modified: String,
                release_year: Int,
                generation: Int)

case class GameMini(override val name: String, override val resource_uri: String)
  extends Mini(name, resource_uri)

trait GameJson {
  implicit val formatGameMini = Json.format[GameMini]
  implicit val formatGame = Json.format[Game]
}

object GameJson extends GameJson
