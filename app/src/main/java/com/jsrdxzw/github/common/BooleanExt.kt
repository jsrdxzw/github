package com.jsrdxzw.github.common

sealed class BooleanExt<out T>

object Otherwise : BooleanExt<Nothing>()

class WithData<T>(val data: T) : BooleanExt<T>()

inline fun <T> Boolean.yes(block: () -> T) = when (this) {
    true -> WithData(block())
    else -> Otherwise
}

inline fun <T> Boolean.no(block: () -> T) = when (this) {
    false -> WithData(block())
    else -> Otherwise
}

inline fun <T> BooleanExt<T>.otherwise(block: () -> T) = when (this) {
    is Otherwise -> block()
    is WithData -> this.data
}