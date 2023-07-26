package com.example.kioskproject

sealed class CafeMethod(val method: String) {
    object DineIn : CafeMethod("매장식사")
    object TakeOut : CafeMethod("포장하기")
    object Exit : CafeMethod("프로그램 종료")
}