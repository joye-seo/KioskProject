package com.example.kioskproject.newmenu

class Menu {
    val Coffee = listOf(
        MenuItem(1, "아메리카노", 3000),
        MenuItem(2, "카페라떼", 4000),
        MenuItem(3, "카푸치노", 5000)
    )

    val NonCoffee = listOf(
        MenuItem(1, "초코라떼(HOT)", 4000),
        MenuItem(2, "초코라떼(ICE)", 4500),
        MenuItem(3, "그린티라떼(HOT)", 4000)
    )

    val Ade = listOf(
        MenuItem(1, "레몬에이드", 5000),
        MenuItem(2, "청포도에이드", 5000),
        MenuItem(3, "딸기에이드", 5000)
    )

    val Smoothie = listOf(
        MenuItem(1, "요거트스무디", 5500),
        MenuItem(2, "딸기스무디", 5500),
        MenuItem(3, "망고스무디", 5500)
    )

    val Tea = listOf(
        MenuItem(1, "페퍼민트(HOT)", 5500),
        MenuItem(2, "페퍼민트(ICE)", 6000),
        MenuItem(3, "캐모마일(HOT)", 5500)
    )

    val Dessert = listOf(
        MenuItem(1, "허니브레드", 8000),
        MenuItem(2, "치즈케이크", 8500),
        MenuItem(3, "딸기케이크", 8500)
    )

    fun sub(category: Int): List<MenuItem>? {
        return when(category){
            1 -> Coffee
            2 -> NonCoffee
            3 -> Ade
            4 -> Smoothie
            5 -> Tea
            6 -> Dessert
            else -> null
        }
    }

}