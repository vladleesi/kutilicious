@file:JvmName("NumberExtensions")

package dev.vladleesi.base

import java.math.BigDecimal

/**
 * Returns the integer value if it is not null, or zero if it is null.
 *
 * @return The integer value if not null, zero if null.
 */
fun Int?.orZero(): Int = this ?: 0

/**
 * Returns the positive integer value if it is greater than zero, or null if it is not.
 *
 * @return The positive integer value if greater than zero, null otherwise.
 */
fun Int.takePositiveOrNull(): Int? = if (this > 0) this else null

/**
 * Checks if the integer value is zero.
 *
 * @return True if the value is not null and is zero, false otherwise.
 */
fun Int?.isZero(): Boolean = this != null && this == 0

/**
 * Checks if the integer value is not zero.
 *
 * @return True if the value is not null and is not zero, false otherwise.
 */
fun Int?.isNotZero(): Boolean = !isZero()

/**
 * Divides the integer value by the specified divisor and returns the result as a percentage.
 * Returns 0 if the divisor is 0.
 *
 * @param divideTo The divisor.
 * @return The resulting percentage value.
 */
@Suppress("MagicNumber")
fun Int.divideToPercent(divideTo: Int): Int {
    return if (divideTo == 0) 0
    else (this / divideTo.toFloat() * 100).toInt()
}

/**
 * Returns the float value if it is not null, or zero if it is null.
 *
 * @return The float value if not null, zero if null.
 */
fun Float?.orZero(): Float = this ?: 0.0F

/**
 * Checks if the float value is zero.
 *
 * @return True if the value is not null and is zero, false otherwise.
 */
fun Float?.isZero(): Boolean = this != null && this == 0.0F

/**
 * Checks if the float value is not zero.
 *
 * @return True if the value is not null and is not zero, false otherwise.
 */
fun Float?.isNotZero(): Boolean = !isZero()

/**
 * Returns the double value if it is not null, or zero if it is null.
 *
 * @return The double value if not null, zero if null.
 */
fun Double?.orZero(): Double = this ?: 0.0

/**
 * Checks if the double value is zero.
 *
 * @return True if the value is not null and is zero, false otherwise.
 */
fun Double?.isZero(): Boolean = this != null && this == 0.0

/**
 * Checks if the double value is not zero.
 *
 * @return True if the value is not null and is not zero, false otherwise.
 */
fun Double?.isNotZero(): Boolean = !isZero()

/**
 * Returns the BigDecimal value if it is not null, or BigDecimal.ZERO if it is null.
 *
 * @return The BigDecimal value if not null, BigDecimal.ZERO if null.
 */
fun BigDecimal?.orZero(): BigDecimal = this ?: BigDecimal.ZERO

/**
 * Checks if the BigDecimal value is zero.
 *
 * @return True if the value is not null and is zero, false otherwise.
 */
fun BigDecimal?.isZero(): Boolean = this != null && this == BigDecimal.ZERO

/**
 * Checks if the BigDecimal value is not zero.
 *
 * @return True if the value is not null and is not zero, false otherwise.
 */
fun BigDecimal?.isNotZero(): Boolean = !isZero()

/**
 * Checks if two BigDecimal values are equal.
 *
 * @param value The other BigDecimal value to compare.
 * @return True if both values are
 * */
infix fun BigDecimal?.same(value: BigDecimal?): Boolean =
    this != null && value != null && this == value
