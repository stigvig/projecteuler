package se.veide.projecteuler

import scala.collection.mutable.Map
import scala.annotation.tailrec

object Util {
  def memo[A, B](f: A => B) = {
    val map = Map[A, B]()
    (i: A) => map get i match {
      case Some(res) => res
      case None => val res = f(i); map += i -> res; res
    }
  }

  val getPrimeFactors: (Long) => List[Long] = memo { i =>
    val half = i / 2
    var n = 2
    
    while (n <= half && i % n != 0) {
      n += 1
    }

    if (n <= half) {
      getPrimeFactors(i / n) ++ getPrimeFactors(n)
    } else {
      List(i)
    }
  }
}