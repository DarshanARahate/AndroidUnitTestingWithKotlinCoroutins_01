package com.test.myapplication.firsttest

import org.junit.Assert.assertEquals
import org.junit.Test

class Engine1Test {

    private val engine = Engine1(2000, 189, 15, false)

    @Test
    fun engineTurnOn() {
        engine.turnOn()

        assertEquals(true, engine.isTurnedOn)

        assertEquals(95, engine.temprature)
    }

    @Test
    fun engineTurnOff() {
        engine.turnOn()

        engine.turnOff()

        assertEquals(false, engine.isTurnedOn)

        assertEquals(15, engine.temprature)
    }

}