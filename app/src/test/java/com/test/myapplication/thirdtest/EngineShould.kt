package com.test.myapplication.thirdtest

import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertTrue
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test

class EngineShould {

    private val engine = Engine()

    @get:Rule
    var coroutineScopeRule = MainCoroutineScopeRule()

    @Test
    fun turnOn() = runBlockingTest {
        engine.turnOn()
        assertTrue(engine.isTurnedOn)
    }

    @Test
    fun riseTheTempratureWhenItTurnOn() = runBlockingTest {
        val flow = engine.turnOn()
        assertEquals(listOf(25,50,95), flow.toList())
    }


}