/**
 * 가장 큰 수
 * playtime = 24m 24s
 */

class P42746Kotlin {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val sol = Solution()
            val ans = sol.solution(intArrayOf(6, 10, 2))
            println(ans)
        }
    }

    class Solution {
        fun solution(numbers: IntArray): String {

            val strings = numbers.map { i -> i.toString() }

            if (strings.all { it == "0" }) {
                return "0"
            }

            val sorted = strings.sortedWith(Comparator { x, y -> (y + x).compareTo(x + y) })

            var answer = ""
            for (s in sorted) {
                answer += s
            }

            return answer
        }
    }

}