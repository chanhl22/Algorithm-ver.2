/**
 * 크기가 작은 부분 문자열
 * playtime = 19m 35s
 */

class P147355Kotlin {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val sol = Solution()
//            val ans = sol.solution("3141592", "271")
//            val ans = sol.solution("500220839878", "7")
//            val ans = sol.solution("10203", "15")
            val ans = sol.solution("999999999999999999", "999999999999999990")
            println(ans)
        }
    }

    class Solution {
        fun solution(t: String, p: String): Int {
            var answer = 0

            val tLen = t.length
            val pLen = p.length

            for (i in 0 until tLen - pLen + 1) {
                val substring = t.substring(i, i + pLen)
                val tToInt = substring.toLong()
                val pToInt = p.toLong()
                if (tToInt <= pToInt) {
                    answer++
                }
            }

            return answer
        }
    }

}