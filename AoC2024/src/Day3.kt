import java.io.File
import kotlin.streams.asStream
import kotlin.streams.toList

fun day3Part1(){
    val pattern = Regex("mul\\((\\d+),(\\d+)\\)")

    println(pattern.findAll(File("inputs/day3.txt").readText()).asStream().map { it.groupValues[1].toInt() * it.groupValues[2].toInt() }.toList().sum())
}

fun day3Part2(){
    val pattern = Regex("(?:(don't)\\(\\)|(do)\\(\\)|(mul)\\((\\d+),(\\d+)\\))")
    var allowed = true
    var res = 0
    println(pattern.findAll(File("inputs/day3.txt").readText()).toList().map { it.groupValues.filter { it != "" } }.forEach {
        when (it.get(1)) {
           "don't" -> allowed = false
           "do" -> allowed = true
            "mul" -> if (allowed) {
                res+= it.get(2).toInt() * it.get(3).toInt()
            }

        }
    })
    println(res)
}


//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {
    val name = "Kotlin"
    //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
    // to see how IntelliJ IDEA suggests fixing it.
   day3Part2()
}