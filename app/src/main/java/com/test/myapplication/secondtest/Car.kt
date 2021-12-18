package com.test.myapplication.secondtest

class Car(val engine: Engine,  var fuel: Double) {

    fun turnOn() {
        fuel -= 0.5
        engine.turnOn()
    }


}