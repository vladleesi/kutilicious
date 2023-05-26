package dev.vladleesi.base

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Created by Vladislav Kochetov on 5/26/2023.
 */
class BaseExtensionsTest {

    @Test
    fun `tag function should return simple name of the class`() {
        val result = TestClass().tag()
        assertEquals("TestClass", result)
    }
}

private class TestClass
