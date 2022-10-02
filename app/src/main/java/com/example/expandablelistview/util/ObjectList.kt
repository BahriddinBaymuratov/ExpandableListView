package com.example.expandablelistview.util

object ObjectList {
    val title: MutableList<String> = ArrayList()
    val subtitle: MutableList<MutableList<String>> = ArrayList()

    fun footballerList(): MutableList<String> {
        return mutableListOf(
            "Real Madrid",
            "Barcelona",
            "Liverpool",
            "Bayern Munch",
            "Man City",
            "Tottenham",
            "Juventus",
            "Inter",
            "Atm Madrid",
            "Chelsea",
            "PSG",
            "Man UN",
        )
    }
    fun languages(): MutableList<String> {
        return mutableListOf(
            "Kotlin",
            "Java",
            "C++",
            "C#",
            "JavaScript",
            "Python",
            "Css",
            "Swift",
            "Jango",
        )
    }


}