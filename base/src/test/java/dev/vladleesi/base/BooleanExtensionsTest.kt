package dev.vladleesi.base

import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Created by Vladislav Kochetov on 5/26/2023.
 */
class BooleanExtensionsTest {

    @Test
    fun `ifTrue should execute block if the boolean is true`() {
        var executed = false
        val result = true.ifTrue {
            executed = true
        }
        assertTrue(executed)
        assertNotNull(result)
        assertTrue(result!!)
    }

    @Test
    fun `ifTrue should not execute block if the boolean is false`() {
        var executed = false
        val result = false.ifTrue {
            executed = true
        }
        assertFalse(executed)
        assertNotNull(result)
        assertFalse(result!!)
    }

    @Test
    fun `ifTrue should return null if the boolean is null`() {
        var executed = false
        val result = null.ifTrue {
            executed = true
        }
        assertFalse(executed)
        assertNull(result)
    }

    @Test
    fun `ifFalse should execute block if the boolean is false`() {
        var executed = false
        val result = false.ifFalse {
            executed = true
        }
        assertTrue(executed)
        assertFalse(result)
    }

    @Test
    fun `ifFalse should not execute block if the boolean is true`() {
        var executed = false
        val result = true.ifFalse {
            executed = true
        }
        assertFalse(executed)
        assertTrue(result)
    }

    @Test
    fun `nullOrFalse should return true if the boolean is null`() {
        val boolean: Boolean? = null
        val result = boolean.nullOrFalse()
        assertTrue(result)
    }

    @Test
    fun `nullOrFalse should return true if the boolean is false`() {
        val boolean = false
        val result = boolean.nullOrFalse()
        assertTrue(result)
    }

    @Test
    fun `nullOrFalse should return false if the boolean is true`() {
        val boolean = true
        val result = boolean.nullOrFalse()
        assertFalse(result)
    }

    @Test
    fun `orFalse should return false if the boolean is null`() {
        val boolean: Boolean? = null
        val result = boolean.orFalse()
        assertFalse(result)
    }

    @Test
    fun `orFalse should return the boolean if it's not null`() {
        val boolean = true
        val result = boolean.orFalse()
        assertTrue(result)
    }
}
