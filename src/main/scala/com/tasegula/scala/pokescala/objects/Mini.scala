/**
 * Project PokeScala: PokeApi Scala Wrapper
 * @author Tase Gula
 */
package com.tasegula.scala.pokescala.objects

import play.api.libs.json.Json

class Mini(val name: String, val resource_uri: String)

object Mini {
  def apply(name: String, resource_uri: String) = new Mini(name, resource_uri)

  def unapply(obj: Mini): Option[(String, String)] = Some((obj.name, obj.resource_uri))
}

trait MiniJson {
  implicit val formatMini = Json.format[Mini]
}

object MiniJson extends MiniJson
