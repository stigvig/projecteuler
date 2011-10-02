package se.veide.projecteuler

object Problem6 {

  def main(args: Array[String]): Unit = {
    val (sumOfSquares, sum) = (1 to 100).foldLeft((0, 0)) { (acc, cur) =>
      val (a, b) = acc 
      (cur * cur + a, cur + b)
    }
    println(math.abs(sum * sum - sumOfSquares))
  }

}