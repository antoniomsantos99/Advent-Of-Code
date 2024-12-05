import java.io.File
import kotlin.math.ceil



fun day5Part1(){
    val input = File("inputs/test5.txt").readText()
    val (rules,orders) = input.split("\n\n")
    val rulesMap = HashMap<Int,HashSet<Int>>()

    rules.split("\n").forEach {
        val (before,after) = it.split("|").map{it.toInt()}
        if (!rulesMap.containsKey(before)) rulesMap.put(before,HashSet(listOf(after)))
        else{
            rulesMap[before]?.add(after)
        }
    }

    var res=0
    orders.split("\n").forEach {
        var check = true
        val order = it.split(",").map{it.toInt()}
        for (i in 0..< order.size-1)
            if (rulesMap[order[i]]?.contains(order[i+1]) == false || rulesMap[order[i+1]]?.contains(order[i]) == true ) {
                check = false
                println(order)
                println("${order[i]},${order[i+1]}")
                break
            }
        if(check)
            res += order[ceil((order.size/2).toDouble()).toInt()]
    }
    println(res)

}



fun day5Part2(){
    val input = File("inputs/day5.txt").readText()
    val (rules,orders) = input.split("\n\n")
    val rulesMap = HashMap<Int,HashSet<Int>>()

    rules.split("\n").forEach {
        val (before,after) = it.split("|").map{it.toInt()}
        if (!rulesMap.containsKey(before)) rulesMap.put(before,HashSet(listOf(after)))
        else{
            rulesMap[before]?.add(after)
        }
    }


    println(rulesMap)

    // Create the comparator
    val comparator = Comparator<Int> { a, b ->
        if (rulesMap[a]?.contains(b) == true) {
            return@Comparator -1
        }
        return@Comparator 1
    }


    var res=0
    orders.split("\n").forEach {
        var check = true
        var order = it.split(",").map{it.toInt()}
        for (i in 0..< order.size-1)
            if (rulesMap[order[i]]?.contains(order[i+1]) == false || rulesMap[order[i+1]]?.contains(order[i]) == true ) {
                check = false
                order = order.sortedWith(comparator)
                println("${order[i]},${order[i+1]}")
                break
            }
        if(!check)
            res += order[ceil((order.size/2).toDouble()).toInt()]
    }
    println(res)


}


fun main() {
    day5Part1()
    day5Part2()
}