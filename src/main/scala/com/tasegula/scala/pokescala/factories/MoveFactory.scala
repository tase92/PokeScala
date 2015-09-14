/**
 * Project PokeScala: PokeApi Scala Wrapper
 * @author Tase Gula
 */
package com.tasegula.scala.pokescala.factories

import akka.actor.ActorSystem
import com.tasegula.scala.pokescala.factories.Factory._
import com.tasegula.scala.pokescala.objects.Move
import com.tasegula.scala.pokescala.objects.MoveJson._

object MoveFactory {

  type T = Move
  implicit val path: String = "move"

  def getMoveFuture(id: Int)(implicit system: ActorSystem)      = getFutureById[T](id)
  def getMoveFuture(name: String)(implicit system: ActorSystem) = getFutureByName[T](name)

  def getMoveOption(id: Int)(implicit system: ActorSystem)      = getOptionById[T](id)
  def getMoveOption(name: String)(implicit system: ActorSystem) = getOptionByName[T](name)

  def getMoveResponse(id: Int)(implicit system: ActorSystem)      = getResponseById[T](id)
  def getMoveResponse(name: String)(implicit system: ActorSystem) = getResponseByName[T](name)
}
