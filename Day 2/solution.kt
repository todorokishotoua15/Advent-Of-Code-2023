import java.io.File
import java.util.*
import kotlin.text.*

fun main() {
    val filename = "input.txt"

    var file = File(filename)
    var sum = 0

    var ans = 0
    file.forEachLine {
        var curr = it
        curr = curr.replace("Game ", "")
        var arr: List<String> = curr.split(" ")

        var id = arr[0].toInt()

        var red = 0
        var green = 0
        var blue = 0

        var flag = 0
        var flag2 = 0

        for (i in arr.indices) {

            if (i == 0) {
                red = 0
                blue = 0
                green = 0
                continue
            }

            if (flag == 1) {
                flag = 0
                continue
            }

            var num = arr[i].toInt()

            if (num == -1) {

                continue
            } else {
                var type = arr[i + 1].toInt()
                // println(num.toString() + " " + type.toString())
                if (type == 0) red = Math.max(red, num)
                if (type == 2) blue = Math.max(blue, num)
                if (type == 1) green = Math.max(green, num)
                flag = 1
            }
        }
        // println(
        //         id.toString() +
        //                 " " +
        //                 red.toString() +
        //                 " " +
        //                 green.toString() +
        //                 " " +
        //                 blue.toString()
        // )
        ans += (red * blue * green)
        // println(ans)
    }

    println(ans)
}
