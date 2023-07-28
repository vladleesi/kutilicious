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
    fun testLightenColorByPercentage_withZeroPercentage() {
        val originalColor = Color.rgb(100, 150, 200)
        val lightenedColor = originalColor.lightenColor(0.0f)

        assertEquals("Lightening by 0% should return the original color", originalColor, lightenedColor)
    }

    @Test
    fun testLightenColorByPercentage_withMaxPercentage() {
        val originalColor = Color.rgb(100, 150, 200)
        val lightenedColor = originalColor.lightenColor(1.0f)

        val expectedColor = Color.rgb(255, 255, 255)

        assertEquals("Lightening by 100% should return a completely white color", expectedColor, lightenedColor)
    }

    @Test
    fun testLightenColorByPercentage_withDifferentColors() {
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
}
