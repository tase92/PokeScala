/**
 * Project PokeScala: PokeApi Scala Wrapper
 * @author Tase Gula
 */
package com.tasegula.scala.pokescala.objects

import play.api.libs.json.Json

case class EggGroup(id: Int,
                    name: String,
                    resource_uri: String,
                    created: String,
                    modified: String,
                    pokemon: List[PokemonMini])

case class EggGroupMini(override val name: String, override val resource_uri: String)
  extends Mini(name, resource_uri)

trait EggGroupJson {

  import PokemonJson._

  implicit val formatEggGroup     = Json.format[EggGroup]
  implicit val formatEggGroupMini = Json.format[EggGroupMini]
}

object EggGroupJson extends EggGroupJson
