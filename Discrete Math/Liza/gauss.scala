object gauss {
    def main(args: Array[String]) {
        val tmp: Array[Int] = readLineOfInt();
        if (tmp.length != 1) {                                                   
            println("Incorrect first line");
            return;
        }
        val n: Int = tmp(0)
        val matrix: Array[Array[Double]] = Array.fill[Array[Double]](n)(Array[Double]())
        for (i <- 0 to n - 1) {
            matrix(i) = readLineOfDouble()    
        }
        for (i <- 0 to n - 1) {
            for (j <- 0 to n - 1) {
                print(matrix(i)(j), ' ')
            }
            println()
        }
    }

  def readLineOfDouble() : Array[Double] = readLine().split(" ").map(_.toDouble)
  def readLineOfInt() : Array[Int] = readLine().split(" ").map(_.toInt)


  def balance(chars: List[Char]): Boolean = {
    def balance1(chars: List[Char], l: Int, r: Int): Boolean = {
      if (!chars.isEmpty) {
        if (l < r) false
        else {
          if(chars.head == '(') balance1(chars.tail, l + 1, r)
          else if(chars.head == ')') balance1(chars.tail, l, r + 1)
          else balance1(chars.tail, l, r)
        }
      }  
      else if(l == r) true
      else false 
    }
    balance1(chars, 0, 0)
  }
}
