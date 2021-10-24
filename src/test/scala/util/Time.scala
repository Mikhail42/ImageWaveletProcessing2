package util

object Time {
  def measure[R](name: String)(block: => R): R = {
    val t0 = System.currentTimeMillis()
    val result = block // call-by-name
    val t1 = System.currentTimeMillis()
    println(s"'${name}' time: " + (t1 - t0) / 1000 + "ms")
    result
  }
}
