package se.veide.projecteuler

object Problem1 {
  def main(args: Array[String]): Unit = { 
    val answer = 0 until 1000 filter (x => x % 5 == 0 || x % 3 == 0) sum;
    println(answer)
  }
}