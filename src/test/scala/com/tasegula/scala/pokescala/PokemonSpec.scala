/**
 * Project PokeScala: PokeApi Scala Wrapper
 * @author Tase Gula
 */
package com.tasegula.scala.pokescala

import com.tasegula.scala.pokescala.factories.PokemonFactory._
import com.tasegula.scala.pokescala.objects.Pokemon
import org.scalatest.{Matchers, WordSpecLike}

import scala.concurrent.Await

class PokemonSpec extends WordSpecLike with Matchers {

  type T = Pokemon
  val pokemonName = "Charmander"
  val pokemonId = 4

  val map = Map("name" -> (pokemonName.toLowerCase, "charmenderx"),
                "id" -> (pokemonId, 0))

  "Searching for a Pokemon by name" should {
    val queryType = "name"

    "return a positive response" when {
      val keyword = pokemonName.toLowerCase

      s"wanting a Future and the $queryType is $keyword" in {
        val result = getPokemonFuture(keyword)
        val option = Await.ready[Pokemon](result, timeout).value.get.toOption
        option should not be empty
      }

      s"wanting an Option and the $queryType is $keyword" in {
        val result = getPokemonOption(keyword)
        result should not be empty
        result.get should have (
          'name (pokemonName),
          'id (pokemonId)
        )
      }

      s"wanting a PokeApiResult and the $queryType is $keyword" in {
        val result = getPokemonResponse(keyword)
        result.resource should not be empty
        result.outcome shouldBe None
        result.resource should not be empty
      }
    }

    "return a negative response" when {
      val keyword = "charmender"

      s"wanting a Future and the $queryType is $keyword" in {
        val result = getPokemonFuture(keyword)
        val option = Await.ready[Pokemon](result, timeout)
        option.value.get.toOption shouldBe None
      }
      s"wanting an Option and the $queryType is $keyword" in {
        val result = getPokemonOption(keyword)
        result shouldBe None
      }

      s"wanting a PokeApiResult and the $queryType is $keyword" in {
        val result = getPokemonResponse(keyword)
        result.resource shouldBe None
        result.outcome should not be empty
        result.resource shouldBe None
      }
    }
  }

  "Searching for a Pokemon by id" should {
    val queryType = "id"

    "return a positive response" when {
      val keyword = pokemonId

      s"wanting a Future and the $queryType is $keyword" in {
        val result = getPokemonFuture(keyword)
        val option = Await.ready[Pokemon](result, timeout).value.get.toOption
        option should not be empty
      }

      s"wanting an Option and the $queryType is $keyword" in {
        val result = getPokemonOption(keyword)
        result should not be empty
        result.get should have (
          'name (pokemonName),
          'id (pokemonId)
        )
      }

      s"wanting a PokeApiResult and the $queryType is $keyword" in {
        val result = getPokemonResponse(keyword)
        result.resource should not be empty
        result.outcome shouldBe None
        result.resource should not be empty
      }
    }

    "return a negative response" when {
      val keyword = 0

      s"wanting a Future and the $queryType is $keyword" in {
        val result = getPokemonFuture(keyword)
        val option = Await.ready[Pokemon](result, timeout)
        option.value.get.toOption shouldBe None
      }
      s"wanting an Option and the $queryType is $keyword" in {
        val result = getPokemonOption(keyword)
        result shouldBe None
      }

      s"wanting a PokeApiResult and the $queryType is $keyword" in {
        val result = getPokemonResponse(keyword)
        result.resource shouldBe None
        result.outcome should not be empty
        result.resource shouldBe None
      }
    }
  }

}
