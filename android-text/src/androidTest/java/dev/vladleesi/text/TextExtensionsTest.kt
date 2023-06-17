package dev.vladleesi.text

import android.content.Context
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import androidx.core.content.ContextCompat
import androidx.test.core.app.ApplicationProvider
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

/**
 * Created by Vladislav Kochetov on 6/17/2023.
 */
class TextExtensionsTest {

    private lateinit var context: Context

    @Before
    fun init() {
        context = ApplicationProvider.getApplicationContext()
    }

    @Test
    fun test_fromHTML() {
        val inputString = "<b>Test</b>"
        val expectedOutput = "Test".bold()

        val output = inputString.fromHTML()

        assertEquals(expectedOutput.toString(), output.toString())
        assertSpanCount(output as Spanned, 1)
        assertSpanType(output, 0, StyleSpan::class.java)
    }

    @Test
    fun test_bold() {
        val inputText = "Hello"
        val expectedOutput = "<b>Hello</b>".fromHTML()

        val output = inputText.bold()

        assertEquals(expectedOutput.toString(), output.toString())
        assertSpanCount(output as Spanned, 1)
        assertSpanType(output, 0, StyleSpan::class.java)
    }

    @Test
    fun test_withAsterisk() {
        val inputText = "Important"
        val colorResId = androidx.appcompat.R.color.error_color_material_light
        val expectedOutput = "<string>Important <span style=\"color:#FF0000;\">*</span></string>".fromHTML()

        val output = inputText.withAsterisk(context, colorResId)

        assertEquals(expectedOutput.toString(), output.toString())
        assertSpanCount(output as Spanned, 1)
        assertSpanType(output, 0, ForegroundColorSpan::class.java)
    }

    @Test
    fun test_applyColorSpanToSubstrings() {
        val inputText = "This is a test"
        val colorHex = ContextCompat.getColor(context, androidx.appcompat.R.color.error_color_material_light)
        val subStrings = arrayOf("is", "test")
        val expectedOutput = (
            "Th<span style=\"color:#FF0000;\">is</span> <span style=\"color:#FF0000;\">" +
                "is</span> a <span style=\"color:#FF0000;\">test</span>"
            ).fromHTML()

        val output = inputText.applyColorSpanToSubstrings(colorHex, false, *subStrings)

        assertEquals(expectedOutput.toString(), output.toString())
        assertSpanCount(output as Spanned, 3)
        assertSpanType(output, 0, ForegroundColorSpan::class.java)
        assertSpanType(output, 1, ForegroundColorSpan::class.java)
        assertSpanType(output, 2, ForegroundColorSpan::class.java)
    }

    @Test
    fun test_applyBoldSpanToSubstrings() {
        val inputText = "This is a test"
        val subStrings = arrayOf("is", "test")
        val expectedOutput = "Th<b>is</b> <b>is</b> a <b>test</b>".fromHTML()

        val output = inputText.applyBoldSpanToSubstrings(*subStrings)

        assertEquals(expectedOutput.toString(), output.toString())
        assertSpanCount(output as Spanned, 3)
        assertSpanType(output, 0, StyleSpan::class.java)
        assertSpanType(output, 1, StyleSpan::class.java)
        assertSpanType(output, 2, StyleSpan::class.java)
    }

    private fun assertSpanCount(spanned: Spanned, expectedCount: Int) {
        val spans = spanned.getSpans(0, spanned.length, Any::class.java)
        assertEquals(expectedCount, spans.size)
    }

    private fun assertSpanType(spanned: Spanned, index: Int, expectedType: Class<*>) {
        val spans = spanned.getSpans(0, spanned.length, Any::class.java)
        assertEquals(expectedType, spans[index]::class.java)
    }
}
