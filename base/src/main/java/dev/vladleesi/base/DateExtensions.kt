@file:JvmName("DateExtensions")

package dev.vladleesi.base

import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Returns the current date and time.
 *
 * @return The current date and time.
 */
val now: Date
    get() = Date()

/**
 * Returns the current time in milliseconds since January 1, 1970, 00:00:00 GMT.
 *
 * @return The current time in milliseconds.
 */
val nowTime: Long
    get() = now.time

/**
 * Converts a long value representing the time in milliseconds since January 1, 1970, 00:00:00 GMT to a Date object.
 *
 * @param time The time in milliseconds.
 * @return The converted Date object.
 */
fun Long.toDate(): Date = Date(this)

/**
 * Converts a String representation of a date to a Date object using the specified pattern and locale.
 *
 * @param pattern The pattern describing the format of the date string.
 * @param locale  The locale used for interpreting the date string. Defaults to the system default locale.
 * @return The converted Date object, or null if the parsing fails.
 */
fun String.toDate(pattern: String, locale: Locale = Locale.getDefault()): Date? =
    try {
        SimpleDateFormat(pattern, locale).parse(this)
    } catch (ex: ParseException) {
        null
    }

/**
 * Converts a String representation of a date to a Date object using the specified SimpleDateFormat instance.
 *
 * @param simpleDateFormat The SimpleDateFormat instance used for parsing the date string.
 * @return The converted Date object, or null if the parsing fails.
 */
fun String.toDate(simpleDateFormat: SimpleDateFormat): Date? =
    try {
        simpleDateFormat.parse(this)
    } catch (ex: ParseException) {
        null
    }

/**
 * Converts the Date object to a string representation using the specified pattern and locale.
 *
 * @param pattern The pattern describing the format of the date string.
 * @param locale  The locale used for formatting the date string. Defaults to the system default locale.
 * @return The string representation of the date, or null if an error occurs during formatting.
 */
fun Date.toString(pattern: String, locale: Locale = Locale.getDefault()): String? =
    try {
        SimpleDateFormat(pattern, locale).format(this)
    } catch (ex: IllegalArgumentException) {
        null
    }

/**
 * Converts the Date object to a string representation using the specified SimpleDateFormat instance.
 *
 * @param simpleDateFormat The SimpleDateFormat instance used for formatting the date.
 * @return The string representation of the date, or null if an error occurs during formatting.
 */
fun Date.toString(simpleDateFormat: SimpleDateFormat): String? =
    try {
        simpleDateFormat.format(this)
    } catch (ex: IllegalArgumentException) {
        null
    }
