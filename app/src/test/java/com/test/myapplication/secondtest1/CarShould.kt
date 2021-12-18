package com.test.myapplication.secondtest1

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.test.myapplication.secondtest.Car
import com.test.myapplication.secondtest.Engine
import junit.framework.TestCase.assertEquals
import org.junit.Test

class CarShould {

    private val engine: Engine = mock()
    private val car = Car(engine, 5.0)

    @Test
    fun looseFuelWhenItTurnsOn() {
        car.turnOn()

        assertEquals(4.5, car.fuel)
    }

    @Test
    fun turnOnItsEngine() {
        car.turnOn()

        verify(engine, times(1)).turnOn()
    }

}