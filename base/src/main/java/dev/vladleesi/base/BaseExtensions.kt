@file:JvmName("BaseExtensions")

package dev.vladleesi.base

/**
 * @return The tag (simple name) of the class.
 */
fun Any.tag(): String = javaClass.simpleName

/**
 * Casts the current object to the specified type [T].
 *
 * @return The casted object of type [T] if the cast is successful, or `null` otherwise.
 *
 * @param T The target type to cast to.
 */
inline fun <reified T : Any> Any.castOrNull(): T? = this as? T
