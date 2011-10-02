package se.veide.projecteuler

import scala.collection.mutable.Map

object Problem2 {
  val fib: (Int => Int) = memo {
    case 0 => 0
    case 1 => 1
    case n => fib(n - 1) + fib(n - 2)
  }

  def memo(f: Int => Int) = {
    val map = Map[Int, Int]()
    (i: Int) => map get i match {
      case Some(res) => res
      case None => val res = f(i); map += i -> res; res
    }
  }

  def main(args: Array[String]): Unit = {
    val acc =
      Stream.from(0)
        .map(fib(_))
        .takeWhile(_ <= 4000000)
        .filter(_ % 2 == 0)
        .sum
    println(acc)
  }
}

/*
object Problem2 extends App{

  lazy val solution = fibs.takeWhile(x => x < 4000000).filter(_ % 2 == 0).reduceLeft(_+_)

  def fibs:Stream[Int] = {
    def fib(i:Int, j:Int):Stream[Int] = {
      Stream.cons(i, fib(j, i+j))
    }
    fib(1,2)
  }
  println("The answer is: " + solution)
}
*/