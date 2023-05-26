@file:JvmName("BaseExtensions")

package dev.vladleesi.base

/**
 * @return The tag (simple name) of the class.
 */
fun Any.tag(): String = javaClass.simpleName
