/**
 * Project PokeScala: PokeApi Scala Wrapper
 * @author Tase Gula
 */
package com.tasegula.scala.pokescala.objects

import play.api.libs.json.Json

case class Move(id: Int,
                name: String,
                resource_uri: String,
                created: String,
                modified: String,
                accuracy: Int,
                category: String,
                description: String,
                power: Int,
                pp: Int)

case class MoveMini(override val name: String, override val resource_uri: String)
  extends Mini(name, resource_uri)

trait MoveJson {
  implicit val formatMove = Json.format[Move]
  implicit val formatMoveMini = Json.format[MoveMini]
}

object MoveJson extends MoveJson