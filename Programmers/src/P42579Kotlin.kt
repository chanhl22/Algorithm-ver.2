/**
 * 베스트앨범
 * playtime = 36m 20s
 */

class P42579Kotlin {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val sol = Solution()
            val ans = sol.solution(
                arrayOf("classic", "pop", "classic", "classic", "pop"),
                intArrayOf(500, 600, 150, 800, 2500)
            )
            println(ans.contentToString())
        }
    }

    class Solution {
        fun solution(genres: Array<String>, plays: IntArray): IntArray {
            val len = genres.size

            val musics = mutableListOf<Music>()
            for (i in 0 until len) {
                musics.add(Music(genres[i], plays[i], i))
            }

            val genresMap = HashMap<String, Int>()
            for (i in 0 until len) {
                genresMap.put(genres[i], genresMap.getOrDefault(genres[i], 0) + plays[i])
            }

            val sortedGenres = mutableListOf<String>()
            while (genresMap.isNotEmpty()) {
                var max = 0
                var maxString = ""
                for (entry in genresMap) {
                    if (max < entry.value) {
                        max = entry.value
                        maxString = entry.key
                    }
                }
                sortedGenres.add(maxString)
                genresMap.remove(maxString)
            }

            val sortedIndex = mutableListOf<Int>()
            for (genre in sortedGenres) {
                val findIndex = musics.filter { it.type == genre }
                    .sortedWith(
                        compareByDescending<Music> { it.playCount }
                            .thenBy { it.index }
                    )
                    .map { it.index }
                    .take(2)
                sortedIndex.addAll(findIndex)
            }

            return sortedIndex.toIntArray()
        }
    }

    class Music(
        var type: String,
        var playCount: Int,
        var index: Int
    )

}