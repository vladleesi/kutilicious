package dev.vladleesi.color

import android.graphics.Color
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Vladislav Kochetov on 7/28/2023.
 */
@RunWith(AndroidJUnit4::class)
class ColorExtensionsTest {

    @Test
    fun testLightenColor_withZeroPercentage() {
        val originalColor = Color.rgb(100, 150, 200)
        val lightenedColor = originalColor.lightenColor(0.0f)

        assertEquals("Lightening by 0% should return the original color", originalColor, lightenedColor)
    }

    @Test
    fun testLightenColor_withMaxPercentage() {
        val originalColor = Color.rgb(100, 150, 200)
        val lightenedColor = originalColor.lightenColor(1.0f)

        val expectedColor = Color.rgb(255, 255, 255)

        assertEquals("Lightening by 100% should return a completely white color", expectedColor, lightenedColor)
    }

    @Test
    fun testLightenColor_withDifferentColors() {
        val originalColor1 = Color.rgb(50, 70, 90)
        val originalColor2 = Color.rgb(200, 50, 100)
        val originalColor3 = Color.rgb(0, 255, 0)

        val lightenedColor1 = originalColor1.lightenColor(0.3f)
        val lightenedColor2 = originalColor2.lightenColor(0.7f)
        val lightenedColor3 = originalColor3.lightenColor(0.2f)

        assertEquals("Incorrect lightened color for originalColor1", Color.rgb(111, 125, 139), lightenedColor1)
        assertEquals("Incorrect lightened color for originalColor2", Color.rgb(238, 193, 208), lightenedColor2)
        assertEquals("Incorrect lightened color for originalColor3", Color.rgb(51, 255, 51), lightenedColor3)
    }

    @Test
    fun testDarkenColor_withDifferentColors() {
        val originalColor1 = Color.rgb(50, 70, 90)
        val originalColor2 = Color.rgb(200, 50, 100)
        val originalColor3 = Color.rgb(0, 255, 0)

        val darkenedColor1 = originalColor1.darkenColor(0.3f)
        val darkenedColor2 = originalColor2.darkenColor(0.7f)
        val darkenedColor3 = originalColor3.darkenColor(0.2f)

        assertEquals("Incorrect darkened color for originalColor1", Color.rgb(35, 49, 63), darkenedColor1)
        assertEquals("Incorrect darkened color for originalColor2", Color.rgb(60, 15, 30), darkenedColor2)
        assertEquals("Incorrect darkened color for originalColor3", Color.rgb(0, 204, 0), darkenedColor3)
    }
}
