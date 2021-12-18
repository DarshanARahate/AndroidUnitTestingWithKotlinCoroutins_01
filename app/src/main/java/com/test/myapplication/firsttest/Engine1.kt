package com.test.myapplication.firsttest

class Engine1(val cc: Int,
              val horsePower: Int,
              var temprature : Int,
              var isTurnedOn: Boolean) {

    fun turnOn() {
        isTurnedOn = true
        temprature = 95
    }

    fun turnOff() {
        isTurnedOn = false
        temprature = 15
    }

}