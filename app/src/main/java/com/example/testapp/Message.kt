package com.example.testapp

import kotlin.random.Random

class Message (
    val ttype: Int,
    val name: String,
    val ttime: String,
    val text: String
) {
    companion object {
        val name_list = listOf("vinolentia", "arrivederci", "dimochkakoshchei", "jukeboxlera")
        val text_list = listOf(
            "у россии два врага - чернослив и курага",
            "всем доброе утро",
            "пми момент",
            "самый лучший в мире вуз - это наш двгупс",
            "тьма твердеет"
        )

        fun set_type(): Int {
            return Random.nextInt(0, 2)
        }
        fun set_name(): String {
            return name_list[Random.nextInt(0, name_list.size)]
        }
        fun set_text(): String {
            return text_list[Random.nextInt(0, text_list.size)]
        }
    }
}


