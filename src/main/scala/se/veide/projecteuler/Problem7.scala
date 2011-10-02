package se.veide.projecteuler

import Util.getPrimeFactors
import scala.collection.JavaConversions._
import java.util.TreeSet
import scala.collection.SortedSet

object Problem7 {
  def main(args: Array[String]): Unit = {
    val set = new TreeSet[Long]()
    Stream.from(2)
      .map(getPrimeFactors(_))
      .takeWhile(_ => set.size < 10001)
      .foreach(_.foreach(set add _))
      println(set)
      println(set.size())
      println(set.last())
  }
}