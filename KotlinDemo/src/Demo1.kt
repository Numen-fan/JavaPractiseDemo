import java.awt.Rectangle
import java.lang.IllegalArgumentException
import java.math.BigDecimal

fun main() {
    println("你好啊")

    println(sum(2, 3))


    val oneMillion = 1_000_000

    val b: Boolean? = null;
    if (b == true) {
        println("b is true")
    } else {
        println("b is false or null")
    }

    val myRectange = Rectangle().apply {
        x = 1
        y = 1
        width = 2
        height = 4
    }

    println("2 + 3 = ${sum(2,3)}")

    println("red code is ${transform("Blue")}")

    calcTaxes()
}

private fun sum(a:Int, b:Int): Int {
    return a + b
}

fun transform(color: String): Int = when(color) {
    "red" -> 0
    "Green" -> 1
    "Blue" -> 2
    else -> throw IllegalArgumentException("Invalid color param value")
}

fun calcTaxes(): BigDecimal {
//    TODO("waiting for feedback from accounting")
    return BigDecimal("3.5")
}
