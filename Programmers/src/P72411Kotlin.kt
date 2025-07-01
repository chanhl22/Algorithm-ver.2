/**
 * 메뉴 리뉴얼
 * playtime = 1s 39m 32s
 */

class P72411Kotlin {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val sol = Solution()
            val ans = sol.solution(arrayOf("ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"), intArrayOf(2, 3, 4))
            println(ans)
        }
    }

    class Solution {

        private val mixture = HashMap<String, Int>()

        fun solution(orders: Array<String>, course: IntArray): Array<String> {

            val sortedOrders = orders.map { str ->
                val chars = str.toCharArray()
                chars.sort()
                String(chars)
            }

            // 각 orders에 해당하는 모든 조합을 다 구해야함.
            for (order in sortedOrders) {
                go(0, "", order)
            }

            var answer = mutableListOf<String>()
            for (count in course) {
                var temp = mutableListOf<String>()
                var max = 0;
                for (entry in mixture) {
                    if (entry.key.length == count) {
                        if (max < entry.value) {
                            max = entry.value
                        }
                    }
                }
                for (entry in mixture) {
                    if (entry.value == max && entry.key.length == count && entry.value != 1) {
                        answer.add(entry.key)
                    }
                }
            }

            answer.sort()

            return answer.toTypedArray()
        }

        private fun checkContains(entry: MutableMap.MutableEntry<String, Int>): Boolean {
            for (mutableEntry in mixture) {
                if (mutableEntry.key.contains(entry.key)) {
                    return false
                }
            }
            return true
        }

        private fun go(index: Int, cur: String, order: String) {
            if (index == order.length) {
                mixture.put(cur, mixture.getOrDefault(cur, 0) + 1)
                return
            }

            go(index + 1, cur + order[index], order)
            go(index + 1, cur, order)
        }
    }

}