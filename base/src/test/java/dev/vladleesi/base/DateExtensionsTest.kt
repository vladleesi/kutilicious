package dev.vladleesi.base

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

/**
 * Created by Vladislav Kochetov on 6/8/2023.
 */
class DateExtensionsTest {

    @Test
    fun testNow() {
        val currentDate = Date()
        assertEquals(currentDate.time / 1000, now.time / 1000) // Allow a difference of 1 second
    }

    @Test
    fun testNowTime() {
        val currentTime = System.currentTimeMillis()
        assertEquals(currentTime / 1000, nowTime / 1000) // Allow a difference of 1 second
    }

    @Test
    fun testToDateLong() {
        val time = 1621900800000L // June 8, 2021, 10:46:11 AM GMT
        val expectedDate = Date(time)
        val actualDate = time.toDate()
        assertEquals(expectedDate, actualDate)
    }

    @Test
    fun testToDatePatternAndLocale() {
        val dateStr = "2021-06-08"
        val pattern = "yyyy-MM-dd"
        val locale = Locale.US
        val expectedDate = SimpleDateFormat(pattern, locale).parse(dateStr)
        val actualDate = dateStr.toDate(pattern, locale)
        assertEquals(expectedDate, actualDate)
    }

    @Test
    fun testToDateFormat() {
        val dateStr = "June 8, 2021"
        val pattern = "MMMM d, yyyy"
        val format = SimpleDateFormat(pattern, Locale.US)
        val expectedDate = format.parse(dateStr)
        val actualDate = dateStr.toDate(format)
        assertEquals(expectedDate, actualDate)
    }

    @Test
    fun testToDateInvalidInput() {
        val dateStr = "Invalid Date"
        val pattern = "yyyy-MM-dd"
        val locale = Locale.US
        val actualDate = dateStr.toDate(pattern, locale)
        assertNull(actualDate)
    }

    @Test
    fun testDateToStringPatternAndLocale() {
        val date = Date(1623179571000L) // June 8, 2021, 10:46:11 AM GMT
        val pattern = "yyyy-MM-dd HH:mm:ss"
        val locale = Locale.US
        val expectedString = SimpleDateFormat(pattern, locale).format(date)
        val actualString = date.toString(pattern, locale)
        assertEquals(expectedString, actualString)
    }

    @Test
    fun testDateToStringSimpleDateFormat() {
        val date = Date(1623179571000L) // June 8, 2021, 10:46:11 AM GMT
        val pattern = "yyyy-MM-dd HH:mm:ss"
        val format = SimpleDateFormat(pattern, Locale.US)
        val expectedString = format.format(date)
        val actualString = date.toString(format)
        assertEquals(expectedString, actualString)
    }

    @Test
    fun testDateToStringInvalidInput() {
        val date = Date(1623179571000L) // June 8, 2021, 10:46:11 AM GMT
        val pattern = "Invalid Pattern"
        val locale = Locale.US
        val actualString = date.toString(pattern, locale)
        assertNull(actualString)
    }
}
