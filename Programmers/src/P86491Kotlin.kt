/**
 * 최소직사각형
 * playtime = 15m 27s
 */

class P86491Kotlin {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val sol = Solution()
            val arr = arrayOf(
                intArrayOf(60, 50),
                intArrayOf(30, 70),
                intArrayOf(60, 30),
                intArrayOf(80, 40)
            )
            val ans = sol.solution(arr)
            println(ans)
        }
    }

    class Solution {
        fun solution(sizes: Array<IntArray>): Int {
            sizes.forEach { it.sort() }

            val firstValues = sizes.map { it[0] }
            val secondValues = sizes.map { it[1] }

            val maxFirst = firstValues.maxOrNull() ?: 0
            val maxSecond = secondValues.maxOrNull() ?: 0

            return maxFirst * maxSecond
        }
    }

}