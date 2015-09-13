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

  def getTypeFuture(id: Int)(implicit system: ActorSystem) = getFutureById[T](id)
  def getTypeFuture(name: String)(implicit system: ActorSystem) = getFutureByName[T](name)

  def getType(id: Int)(implicit system: ActorSystem) = getById[T](id)
  def getType(name: String)(implicit system: ActorSystem) = getByName[T](name)
}
