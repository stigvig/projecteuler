package se.veide.projecteuler

import scala.collection.SortedSet
import scala.collection.Set
import scala.collection.mutable.Map
import Util.getPrimeFactors

object Problem5 {
  def main(args: Array[String]): Unit = {
    val all = 1 to 20 map (getPrimeFactors(_)) map (count(_)) reduceLeft (merge(_,_))
    val res = all.foldLeft(1L)(gen(_,_))
    println( res )
  }

  def gen(total: Long, curr: (Long, Long)): Long = {
    val (prime, num) = curr
    total * math.pow(prime, num).toLong
  }

  def merge(total: Map[Long, Long], curr: Map[Long, Long]): Map[Long, Long] = {
    curr.foreach { pair =>
      val (key, value) = pair
      val a = total.getOrElseUpdate(key, 0)
      total.update(key, math.max(a, value))
    }
    total
  }
  
  def count(factors: List[Long]): Map[Long, Long] = {
	val map	= Map[Long, Long]()
    factors.foreach { factor =>
      val curr = map.getOrElseUpdate(factor, 0)
      map.update(factor, curr + 1)
    }
	map
  }
}