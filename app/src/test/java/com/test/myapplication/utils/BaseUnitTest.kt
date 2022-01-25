package com.test.myapplication.utils

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.outsideintddexample.acceptancetests.MainCoroutineScopeRule
import org.junit.Rule

open class BaseUnitTest {

    @get:Rule
    var coroutineScopeRule = MainCoroutineScopeRule()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

}