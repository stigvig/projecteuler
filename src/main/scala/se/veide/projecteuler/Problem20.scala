package se.veide.projecteuler

object Problem20 {

  def main(args: Array[String]): Unit = {
    val foo = BigInt(1) to BigInt(100)
    val res1 = foo.reduceLeft(_ * _)
    val res2 = res1.toString().foldLeft(0) { (acc, cur) => cur.getNumericValue + acc }
    println(res2)
  }

}