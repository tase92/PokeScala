/**
 * Project PokeScala: PokeApi Scala Wrapper
 * @author Tase Gula
 */
package com.tasegula.scala.pokescala.objects

import play.api.libs.json.Json

case class Ability(id: Int,
                   name: String,
                   resource_uri: String,
                   created: String,
                   modified: String,
                   description: String)

case class AbilityMini(override val name: String, override val resource_uri: String)
  extends Mini(name, resource_uri)

trait AbilityJson {
  implicit val formatAbilityMini = Json.format[AbilityMini]
  implicit val formatAbility = Json.format[Ability]
}

object AbilityJson extends AbilityJson

