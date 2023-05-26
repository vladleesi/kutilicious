@file:JvmName("BooleanExtensions")

package dev.vladleesi.base

/**
 * Executes the specified block of code if the Boolean value is true.
 *
 * @param block The block of code to execute.
 * @return The original Boolean value.
 */
inline fun Boolean?.ifTrue(block: Boolean.() -> Unit): Boolean? {
    if (this == true) {
        block()
    }
    return this
}

/**
 * Executes the specified block of code if the Boolean value is false.
 *
 * @param block The block of code to execute.
 * @return The original Boolean value.
 */
inline fun Boolean.ifFalse(block: Boolean?.() -> Unit): Boolean {
    if (!this) {
        block()
    }
    return this
}

/**
 * Checks if the Boolean value is null or false.
 *
 * @return True if the value is null or false, false otherwise.
 */
fun Boolean?.nullOrFalse(): Boolean {
    return this == null || this == false
}

/**
 * Returns the Boolean value if it is not null, or false if it is null.
 *
 * @return The Boolean value if not null, false if null.
 */
fun Boolean?.orFalse() = this ?: false
