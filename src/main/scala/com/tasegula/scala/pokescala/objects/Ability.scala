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
  implicit val formatAbility     = Json.format[Ability]
  implicit val formatAbilityMini = Json.format[AbilityMini]
}

object AbilityJson extends AbilityJson

