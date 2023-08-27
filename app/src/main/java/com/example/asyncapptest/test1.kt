package com.example.asyncapptest

import androidx.compose.runtime.rememberCoroutineScope

suspend fun sus1(): List<String> {
    val myList = listOf<String>("ali", "jhon", "mamd", "jenifer","Saeed","qasem")
    return myList.filter { it.contains("a") }
}
suspend fun sus2(): List<String> {
    val myList = listOf<String>("ali", "sheep", "mamd", "jenifer")
    return myList.map { it+"ly" }
}
