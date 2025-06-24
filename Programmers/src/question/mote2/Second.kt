package question.mote2

class Second(
    private val value: Int
) {
    fun sum(input: Int) = Second(value + input)
    fun sub(input: Int) = Second(value - input)
    fun mul(input: Int) = Second(value * input)
    fun dev(input: Int) = Second(value / input)
    fun result() = value
}

fun main() {
    val second = Second(0);
    println(second) // class
    println(second.sum(1).sub(10).result()) // -9
    println(second.sum(1).sub(10).dev(1).result()) // -9 / 1 = -9
    //클래스를 새로 만든거니까 계산된 값은 새로 만들어진 inner 클래스에 있겠지...
    println(second.sum(1).mul(100)) // class
}