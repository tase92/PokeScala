/**
 * Project PokeScala: PokeApi Scala Wrapper
 * @author Tase Gula
 */
package com.tasegula.scala.pokescala.objects

import play.api.libs.json.Json

case class Type(id: Int,
                name: String,
                resource_uri: String,
                created: String,
                modified: String,
                ineffective: List[TypeMini],
                no_effect: List[TypeMini],
                resistance: List[TypeMini],
                super_effective: List[TypeMini],
                weakness: List[TypeMini])

case class TypeMini(override val name: String, override val resource_uri: String)
  extends Mini(name, resource_uri)

trait TypeJson {
  implicit val formatTypeMini = Json.format[TypeMini]
  implicit val formatType = Json.format[Type]
}

object TypeJson extends TypeJson
