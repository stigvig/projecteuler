package se.veide.projecteuler

import Util.getPrimeFactors

object Problem3 {
  def main(args: Array[String]): Unit = {
    println( getPrimeFactors(600851475143L).max )
  }
}