import java.io.File

fun day4Part1(){
    val packed = listOf(Pair(0,'X'),Pair(1,'M'),Pair(2,'A'),Pair(3,'S'))
    var res=0
    val charMatrix = File("inputs/day4.txt").readLines(Charsets.UTF_8)
    val sizey = charMatrix.size
    val sizex = charMatrix[0].length
    for (y in 0..<charMatrix.size)
        for (x in 0..<charMatrix[y].length) {
            val counts = ArrayList(listOf(0,0,0,0,0,0,0,0))
            if (charMatrix[y][x] == 'X') {
                packed.forEach {
                    //Front (y,x+1)
                    counts[0] += if (x+it.first < sizex && charMatrix[y][x+it.first] == it.second) 1 else 0
                    //Back (y,x-1)
                    counts[1] += if (x-it.first >= 0 && charMatrix[y][x-it.first] == it.second) 1 else 0
                    //Down (y+1,x)
                    counts[2] += if (y+it.first < sizey && charMatrix[y+it.first][x] == it.second) 1 else 0
                    //UP (y-1,x)
                    counts[3] += if (y-it.first >= 0 && charMatrix[y-it.first][x] == it.second) 1 else 0
                    //DownRight (y+1,x+1)
                    counts[4] += if (y+it.first < sizey && x+it.first < sizex && charMatrix[y+it.first][x+it.first] == it.second) 1 else 0
                    //DownLeft (y+1,x-1)
                    counts[5] += if (y+it.first < sizey && x-it.first >= 0 && charMatrix[y+it.first][x-it.first] == it.second) 1 else 0
                    //UpRight (y-1,x+1)
                    counts[6] += if (y-it.first >= 0 && x+it.first < sizex && charMatrix[y-it.first][x+it.first] == it.second) 1 else 0
                    //UpLeft (y-1,x-1)
                    counts[7] += if (y-it.first >= 0 && x-it.first >= 0 && charMatrix[y-it.first][x-it.first] == it.second) 1 else 0
                }
            }
            res+=counts.count { it==4 }
        }
    println(res)
}

fun day4Part2(){
    var res=0
    val charMatrix = File("inputs/day4.txt").readLines(Charsets.UTF_8)
    val sizey = charMatrix.size
    val sizex = charMatrix[0].length
    for (y in 0..<charMatrix.size)
        for (x in 0..<charMatrix[y].length) {
            if (charMatrix[y][x] == 'A' && y > 0 && y < sizey-1 && x > 0 && x < sizex-1)
                if (((charMatrix[y-1][x-1] == 'M' && charMatrix[y+1][x+1] == 'S')
                    || (charMatrix[y-1][x-1] == 'S' && charMatrix[y+1][x+1] == 'M'))
                    && ((charMatrix[y-1][x+1] == 'M' && charMatrix[y+1][x-1] == 'S')
                    || (charMatrix[y-1][x+1] == 'S' && charMatrix[y+1][x-1] == 'M')))
                    res++
        }
    println(res)
}


fun main() {
    day4Part1()
    day4Part2()
}