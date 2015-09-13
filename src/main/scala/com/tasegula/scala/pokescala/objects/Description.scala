/**
 * Project PokeApi: Scala Wrapper
 * @author Tase Gula
 */
package com.tasegula.scala.pokescala.objects

import play.api.libs.json.Json

case class Description(id: Int,
                       name: String,
                       resource_uri: String,
                       created: String,
                       modified: String,
                       games: List[GameMini],
                       pokemon: PokemonMini)

case class DescriptionMini(override val name: String, override val resource_uri: String)
  extends Mini(name, resource_uri)

trait DescriptionJson {

  import PokemonJson.formatPokemonMini
  import GameJson.formatGameMini

  implicit val formatDescription     = Json.format[Description]
  implicit val formatDescriptionMini = Json.format[DescriptionMini]
}

object DescriptionJson extends DescriptionJson