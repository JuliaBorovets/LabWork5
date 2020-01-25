package com.example.labwork5

import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.roundToInt

class Work {

    fun solve(A: Array<DoubleArray>,  B: DoubleArray): DoubleArray {
        val n = B.size
        val x = DoubleArray(n)
        val result = DoubleArray(n)
        for (k in 0 until n) {
            var max = k
            for (i in k + 1 until n) {
                if (abs(A[i][k]) > abs(A[max][k])) {
                    max = i
                }
            }
            val temp = A[k]
            A[k] = A[max]
            A[max] = temp
            // swap corresponding values in constants matrix

            val t = B[k]
            B[k] = B[max]
            B[max] = t
            // pivot within A and B
            for (i in k + 1 until n) {
                val m = A[i][k] / A[k][k]
                B[i] -= m * B[k]
                for (j in k until n) A[i][j] -= m * A[k][j]
            }

            // back substitution
            for (i in n - 1 downTo 0) {
                var s = 0.0
                for (j in i + 1 until n) s += A[i][j] * x[j]
                x[i] = (B[i] - s) / A[i][i]
            }
        }
        for (i in 0 until n) {
            result[i] = roundNum(x[i])
        }
        return result
    }

    private fun roundNum(value: Double): Double {
        val scale = 10.0.pow(4.0)
        return (value * scale).roundToInt() / scale
    }
}