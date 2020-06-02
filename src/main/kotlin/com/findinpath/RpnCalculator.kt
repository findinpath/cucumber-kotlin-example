package com.findinpath

import java.util.Deque
import java.util.LinkedList

class RpnCalculator {
    private val stack: Deque<Number> = LinkedList()
    fun push(arg: Any) {
        if (OPS.contains(arg)) {
            val y = stack.removeLast()
            val x = (if (stack.isEmpty()) 0.0 else stack.removeLast())!!

            val value: Number = when (arg) {
                "-" -> x.toDouble() - y.toDouble()
                "+" -> x.toDouble() + y.toDouble()
                "*" -> x.toDouble() * y.toDouble()
                "/" -> x.toDouble() / y.toDouble()
                else -> throw IllegalStateException("No handling defined for the operation $arg")
            }
            push(value)
        } else {
            stack.add(arg as Number)
        }
    }

    fun value(): Number? {
        return stack.last
    }

    companion object {
        private val OPS = listOf("-", "+", "*", "/")
    }
}
