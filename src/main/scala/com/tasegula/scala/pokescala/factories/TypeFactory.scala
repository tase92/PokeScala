/**
 * Project PokeScala: PokeApi Scala Wrapper
 * @author Tase Gula
 */
package com.tasegula.scala.pokescala.factories

import akka.actor.ActorSystem
import com.tasegula.scala.pokescala.factories.Factory._
import com.tasegula.scala.pokescala.objects.Type
import com.tasegula.scala.pokescala.objects.TypeJson._

object TypeFactory {

  type T = Type
  implicit val path: String = "type"

  def getTypeFuture(id: Int)(implicit system: ActorSystem)      = getFutureById[T](id)
  def getTypeFuture(name: String)(implicit system: ActorSystem) = getFutureByName[T](name)

  def getTypeOption(id: Int)(implicit system: ActorSystem)      = getOptionById[T](id)
  def getTypeOption(name: String)(implicit system: ActorSystem) = getOptionByName[T](name)

  def getTypeResponse(id: Int)(implicit system: ActorSystem)      = getResponseById[T](id)
  def getTypeResponse(name: String)(implicit system: ActorSystem) = getResponseByName[T](name)
}
