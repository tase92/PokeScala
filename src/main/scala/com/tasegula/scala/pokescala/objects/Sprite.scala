/**
 * Project PokeScala: PokeApi Scala Wrapper
 * @author Tase Gula
 */
package com.tasegula.scala.pokescala.objects

import play.api.libs.json.Json

case class Sprite(id: Int,
                  name: String,
                  resource_uri: String,
                  created: String,
                  modified: String,
                  pokemon: PokemonMini,
                  image: String)

case class SpriteMini(override val name: String, override val resource_uri: String)
  extends Mini(name, resource_uri)

trait SpriteJson {
  import PokemonJson._

  implicit val formatSprite = Json.format[Sprite]
}

object SpriteJson extends SpriteJson
