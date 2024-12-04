import java.io.File

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun checkSafe(values : List<Int>) : Boolean {
    val distances = ArrayList<Int>()
    for(i in 0..values.size-2) {
        distances.add(values[i+1]-values[i])
    }
    return ((distances.all { it > 0 } || distances.all { it < 0 }) && distances.all { (it >= -3 && it <= 3) })
}

fun day2Part1() {
    var c=0
    File("inputs/day2.txt").forEachLine { it ->
        val values = it.split(" ").map {
            it.toInt()
        }
        if (checkSafe(values)) c++
    }
    println(c)
}

fun day2Part2() {
    var c=0
    File("inputs/day2.txt").forEachLine { it ->
        val values  = it.split(" ").map {
            it.toInt()
        }

        if(!checkSafe(values))
        for(i in 0..values.size-1) {
            val remainder = ArrayList(values)
            remainder.removeAt(i)
            if (checkSafe(remainder)){
                c++
                break
            }
        }
        else c++

    }
    println(c)
}


fun main() {
    day2Part2();
}
