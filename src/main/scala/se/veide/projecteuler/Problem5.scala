package se.veide.projecteuler

import scala.collection.SortedSet
import scala.collection.Set
import scala.collection.mutable.Map

object Problem5 {
  def main(args: Array[String]): Unit = {
    val all = 1 to 20 map (getPrimeFactors(_)) map (count(_)) reduceLeft (merge(_,_))
    val res = all.foldLeft(1)(gen(_,_))
    println( res )
  }

  def gen(total: Int, curr: (Int, Int)): Int = {
    val (prime, num) = curr
    total * math.pow(prime, num).toInt
  }

  def merge(total: Map[Int, Int], curr: Map[Int, Int]): Map[Int, Int] = {
    curr.foreach { pair =>
      val (key, value) = pair
      val a = total.getOrElseUpdate(key, 0)
      total.update(key, math.max(a, value))
    }
    total
  }
  
  def count(factors: List[Int]): Map[Int, Int] = {
	val map	= Map[Int, Int]()
    factors.foreach { factor =>
      val curr = map.getOrElseUpdate(factor, 0)
      map.update(factor, curr + 1)
    }
	map
  }

  def getPrimeFactors(i: Int): List[Int] = {
    (i / 2).until(1, -1) foreach { n =>
      if (i % n == 0) {
        return getPrimeFactors(i / n) ++ getPrimeFactors(n)
      }
    }
    List(i)
  }
}