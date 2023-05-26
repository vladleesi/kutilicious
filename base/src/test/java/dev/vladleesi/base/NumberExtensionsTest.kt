package dev.vladleesi.base

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Test
import java.math.BigDecimal

/**
 * Created by Vladislav Kochetov on 5/26/2023.
 */

class NumberExtensionsTest {

    @Test
    fun `orZero should return the value if it's not null`() {
        val number = 42
        val result = number.orZero()
        assertEquals(42, result)
    }

    @Test
    fun `orZero should return 0 if the value is null`() {
        val number: Int? = null
        val result = number.orZero()
        assertEquals(0, result)
    }

    @Test
    fun `takePositiveOrNull should return the value if it's positive`() {
        val number = 42
        val result = number.takePositiveOrNull()
        assertEquals(42, result)
    }

    @Test
    fun `takePositiveOrNull should return null if the value is not positive`() {
        val number = -42
        val result = number.takePositiveOrNull()
        assertNull(result)
    }

    @Test
    fun `isZero should return true if the value is zero`() {
        val number = 0
        val result = number.isZero()
        assertTrue(result)
    }

    @Test
    fun `isZero should return false if the value is not zero`() {
        val number = 42
        val result = number.isZero()
        assertFalse(result)
    }

    @Test
    fun `isNotZero should return true if the value is not zero`() {
        val number = 42
        val result = number.isNotZero()
        assertTrue(result)
    }

    @Test
    fun `isNotZero should return false if the value is zero`() {
        val number = 0
        val result = number.isNotZero()
        assertFalse(result)
    }

    @Test
    fun `divideToPercent should return 0 if divideTo is 0`() {
        val number = 42
        val divideTo = 0
        val result = number.divideToPercent(divideTo)
        assertEquals(0, result)
    }

    @Test
    fun `divideToPercent should calculate the correct percentage`() {
        val number = 75
        val divideTo = 100
        val result = number.divideToPercent(divideTo)
        assertEquals(75, result)
    }

    @Test
    fun `orZero should return the value if it's not null for Float`() {
        val number = 3.14F
        val result = number.orZero()
        assertEquals(3.14F, result)
    }

    @Test
    fun `orZero should return 0 if the value is null for Float`() {
        // Arrange
        val number: Float? = null

        // Act
        val result = number.orZero()

        // Assert
        assertEquals(0.0F, result)
    }

    @Test
    fun `isZero should return true if the value is zero for Float`() {
        val number = 0.0F
        val result = number.isZero()
        assertTrue(result)
    }

    @Test
    fun `isZero should return false if the value is not zero for Float`() {
        val number = 3.14F
        val result = number.isZero()
        assertFalse(result)
    }

    @Test
    fun `isNotZero should return true if the value is not zero for Float`() {
        val number = 3.14F
        val result = number.isNotZero()
        assertTrue(result)
    }

    @Test
    fun `isNotZero should return false if the value is zero for Float`() {
        val number = 0.0F
        val result = number.isNotZero()
        assertFalse(result)
    }

    @Test
    fun `orZero should return the value if it's not null for Double`() {
        val number = 3.14159
        val result = number.orZero()
        assertEquals(3.14159, result, 0.0)
    }

    @Test
    fun `orZero should return 0 if the value is null for Double`() {
        val number: Double? = null
        val result = number.orZero()
        assertEquals(0.0, result, 0.0)
    }

    @Test
    fun `isZero should return true if the value is zero for Double`() {
        val number = 0.0
        val result = number.isZero()
        assertTrue(result)
    }

    @Test
    fun `isZero should return false if the value is not zero for Double`() {
        val number = 3.14159
        val result = number.isZero()
        assertFalse(result)
    }

    @Test
    fun `isNotZero should return true if the value is not zero for Double`() {
        val number = 3.14159
        val result = number.isNotZero()
        assertTrue(result)
    }

    @Test
    fun `isNotZero should return false if the value is zero for Double`() {
        val number = 0.0
        val result = number.isNotZero()
        assertFalse(result)
    }

    @Test
    fun `orZero should return the value if it's not null for BigDecimal`() {
        val number = BigDecimal(10.5)
        val result = number.orZero()
        assertEquals(BigDecimal(10.5), result)
    }

    @Test
    fun `orZero should return 0 if the value is null for BigDecimal`() {
        val number: BigDecimal? = null
        val result = number.orZero()
        assertEquals(BigDecimal.ZERO, result)
    }

    @Test
    fun `isZero should return true if the value is zero for BigDecimal`() {
        val number: BigDecimal? = BigDecimal.ZERO
        val result = number.isZero()
        assertTrue(result)
    }

    @Test
    fun `isZero should return false if the value is not zero for BigDecimal`() {
        val number = BigDecimal(10.5)
        val result = number.isZero()
        assertFalse(result)
    }

    @Test
    fun `isNotZero should return true if the value is not zero for BigDecimal`() {
        val number = BigDecimal(10.5)
        val result = number.isNotZero()
        assertTrue(result)
    }

    @Test
    fun `isNotZero should return false if the value is zero for BigDecimal`() {
        val number: BigDecimal? = BigDecimal.ZERO
        val result = number.isNotZero()
        assertFalse(result)
    }

    @Test
    fun `same should return true if both BigDecimal values are equal`() {
        val number1 = BigDecimal(10.5)
        val number2 = BigDecimal(10.5)
        val result = number1 same number2
        assertTrue(result)
    }

    @Test
    fun `same should return false if either BigDecimal value is null`() {
        val number1 = BigDecimal(10.5)
        val number2: BigDecimal? = null
        val result = number1 same number2
        assertFalse(result)
    }

    @Test
    fun `same should return false if BigDecimal values are not equal`() {
        val number1 = BigDecimal(10.5)
        val number2 = BigDecimal(20.0)
        val result = number1 same number2
        assertFalse(result)
    }
}
