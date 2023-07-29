@file:JvmName("ColorExtensions")

package dev.vladleesi.color

import android.graphics.Color
import androidx.annotation.ColorInt
import androidx.annotation.FloatRange
import androidx.core.graphics.ColorUtils

/**
 * Created by Vladislav Kochetov on 7/28/2023.
 */

/**
 * Lightens an RGB color by a given percentage.
 *
 * @param percentage The percentage by which to lighten the color. Should be a value between 0.0 and 1.0.
 *                   0.0 represents no change, and 1.0 represents the maximum lightening effect.
 *
 * @return The lightened color as an integer value representing ARGB (Alpha, Red, Green, Blue) components.
 */
@ColorInt
fun @receiver:ColorInt Int.lightenColor(@FloatRange(from = 0.0, to = 1.0) percentage: Float): Int =
    ColorUtils.blendARGB(this, Color.WHITE, percentage)

/**
 * Darkens an RGB color by a given percentage.
 *
 * @param percentage The percentage by which to darken the color. Should be a value between 0.0 and 1.0.
 *                   0.0 represents no change, and 1.0 represents the maximum darkening effect.
 *
 * @return The darkened color as an integer value representing ARGB (Alpha, Red, Green, Blue) components.
 */
@ColorInt
fun @receiver:ColorInt Int.darkenColor(@FloatRange(from = 0.0, to = 1.0) percentage: Float): Int =
    ColorUtils.blendARGB(this, Color.BLACK, percentage)
