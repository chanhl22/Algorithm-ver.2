/**
 * playtime = 1h 42m 32s
 */

import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val k = sc.nextInt()
    val a = Array(n) { IntArray(n) }

    repeat(k) {
        val x = sc.nextInt() - 1
        val y = sc.nextInt() - 1
        a[x][y] = 4 // 사과를 놓음
    }

    val l = sc.nextInt()
    val x = IntArray(l)
    val c = Array(l) { "" }
    repeat(l) {
        x[it] = sc.nextInt()
        c[it] = sc.next()
    }

    var headX = 0
    var headY = 0
    val snake = ArrayList<Int>()
    snake.add(0)
    snake.add(0)

    var dir = 0
    var time = 0
    val dx = intArrayOf(0, 1, 0, -1)
    val dy = intArrayOf(1, 0, -1, 0)

    while (true) {
        // 시간 증가
        time++

        // 방향에 따른 이동
        val nx = headX + dx[dir]
        val ny = headY + dy[dir]

        if (nx !in 0 until n || ny !in 0 until n || a[nx][ny] == 1) {
            break
        } else if (a[nx][ny] == 4) {
            headX += dx[dir]
            headY += dy[dir]
            a[headX][headY] = 1
            snake.add(headX)
            snake.add(headY)
        } else {
            headX += dx[dir]
            headY += dy[dir]
            a[headX][headY] = 1
            snake.add(headX)
            snake.add(headY)
            val delX = snake.removeAt(0)
            val delY = snake.removeAt(0)
            a[delX][delY] = 0
        }

        // 방향 전환
        for (i in 0 until l) {
            if (time == x[i]) {
                dir = if (c[i] == "D") {
                    (dir + 1) % 4
                } else {
                    (dir + 3) % 4
                }
            }
        }
    }
    println(time)
}
