@file:JvmName("ColorExtensions")

package dev.vladleesi.color

import androidx.annotation.ColorInt
import androidx.annotation.FloatRange

/**
 * Created by Vladislav Kochetov on 7/28/2023.
 */

/**
 * Represents a fully opaque alpha value (255) for a color in the ColorInt format.
 */
private const val ALPHA_FULLY_OPAQUE = 0xFF

/**
 * Number of bits to shift to extract the green component from an RGB color.
 */
private const val GREEN_SHIFT = 8

/**
 * Number of bits to shift to extract the red component from an RGB color.
 */
private const val RED_SHIFT = 16

/**
 * Number of bits to shift to position the alpha component in the ColorInt format.
 */
private const val ALPHA_SHIFT = 24

/**
 * Maximum value for an 8-bit color channel (0xFF).
 */
private const val COLOR_CHANNEL_MAX = 255

/**
 * Lightens an RGB color by a given percentage.
 *
 * @param percentage The percentage by which to lighten the color. Should be a value between 0.0 and 1.0.
 *                   0.0 represents no change, and 1.0 represents the maximum lightening effect.
 *
 * @return The lightened color as an integer value representing ARGB (Alpha, Red, Green, Blue) components.
 */
@ColorInt
fun @receiver:ColorInt Int.lightenColor(@FloatRange(from = 0.0, to = 1.0) percentage: Float): Int {
    // Extract the red, green, and blue components from the RGB color
    val red = (this shr RED_SHIFT) and ALPHA_FULLY_OPAQUE
    val green = (this shr GREEN_SHIFT) and ALPHA_FULLY_OPAQUE
    val blue = this and ALPHA_FULLY_OPAQUE

    // Calculate the new RGB values after lightening
    val newRed = (red + (COLOR_CHANNEL_MAX - red) * percentage).toInt()
    val newGreen = (green + (COLOR_CHANNEL_MAX - green) * percentage).toInt()
    val newBlue = (blue + (COLOR_CHANNEL_MAX - blue) * percentage).toInt()

    // Combine the new RGB values to create the final color
    return (ALPHA_FULLY_OPAQUE shl ALPHA_SHIFT) or (newRed shl RED_SHIFT) or (newGreen shl GREEN_SHIFT) or newBlue
}
