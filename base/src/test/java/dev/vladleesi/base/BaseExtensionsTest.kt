package dev.vladleesi.base

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
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

    @Test
    fun `castOrNull should return the correct type when the cast is successful`() {
        val input: Any = "Hello, World!"
        val result: String? = input.castOrNull()
        assertEquals("Hello, World!", result)
    }

    @Test
    fun `castOrNull should return null when the cast is not successful`() {
        val input: Any = 42
        val result: String? = input.castOrNull()
        assertNull(result)
    }

    @Test
    fun `castOrNull should handle reified type parameters`() {
        val input: Any = 42
        val result: Int? = input.castOrNull()
        assertEquals(42, result)
    }

    @Test
    fun `castOrNull should return the correct type using a private class`() {
        val input: Any = TestClass()
        val result = input.castOrNull<TestClass>()
        assertEquals(TestClass::class.java, result!!.javaClass)
    }
}

private class TestClass
