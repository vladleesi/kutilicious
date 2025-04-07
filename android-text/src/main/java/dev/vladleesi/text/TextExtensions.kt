@file:JvmName("TextExtensions")

package dev.vladleesi.text

import android.content.Context
import android.graphics.Typeface
import android.text.Html
import android.text.Html.ImageGetter
import android.text.Spannable
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.text.style.StyleSpan
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.text.HtmlCompat
import androidx.core.text.buildSpannedString
import androidx.core.text.parseAsHtml

/**
 * Created by Vladislav Kochetov on 6/17/2023.
 */

private const val FORMAT_COLOR_SUBSTRING_INDEX = 2

/**
 * Retrieves the hexadecimal representation of the highlight color resource specified by the given colorResId.
 *
 * @param context The context to retrieve the color resource from.
 * @param colorResId The color resource ID.
 * @return The hexadecimal representation of the highlight color.
 */
private fun getHighlightColor(context: Context, @ColorRes colorResId: Int): String {
    val highlightColor = ContextCompat.getColor(context, colorResId)
    return String.format("%X", highlightColor).substring(FORMAT_COLOR_SUBSTRING_INDEX)
}

/**
 * Converts the string to a CharSequence with HTML formatting.
 *
 * @param flags Flags to control how the HTML is parsed. Default is HtmlCompat.FROM_HTML_MODE_LEGACY.
 * @param tagHandler The tag handler for handling special HTML tags. Default is null.
 * @param imageGetter The image getter for loading and displaying images. Default is null.
 * @return The CharSequence with HTML formatting.
 */
fun String.fromHTML(
    flags: Int = HtmlCompat.FROM_HTML_MODE_LEGACY,
    tagHandler: Html.TagHandler? = null,
    imageGetter: ImageGetter? = null
): CharSequence = this.parseAsHtml(flags, imageGetter, tagHandler)

/**
 * Formats the CharSequence to be displayed in bold using HTML tags.
 *
 * @return The CharSequence formatted in bold.
 */
fun CharSequence.bold(): CharSequence =
    "<b>$this</b>".fromHTML()

/**
 * Appends an asterisk to the CharSequence and applies the specified highlight color to it.
 *
 * @param context The context to access resources and colors.
 * @param colorResId The resource ID of the color to apply to the asterisk.
 * @return A CharSequence with an asterisk appended and highlighted with the specified color.
 */
fun CharSequence.withAsterisk(context: Context, @ColorRes colorResId: Int): CharSequence {
    // Retrieve the color from resources
    val color = ContextCompat.getColor(context, colorResId)

    // Create a SpannableString with the original text and the asterisk appended
    return SpannableStringBuilder(this).apply {
        // Add the asterisk at the end
        append(" *")
        // Apply the color to the asterisk using ForegroundColorSpan
        setSpan(ForegroundColorSpan(color), length - 1, length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
    }
}

/**
 * Applies a foreground color span to the specified substrings within the CharSequence.
 *
 * @param colorHex The hexadecimal representation of the color to apply to the substrings.
 * @param ignoreCase Whether to ignore case when searching for the substrings. Default is false.
 * @param subStrings The substrings to apply the color span to.
 * @return The CharSequence with the color spans applied to the specified substrings.
 */
fun CharSequence.applyColorSpanToSubstrings(
    colorHex: Int,
    ignoreCase: Boolean = false,
    vararg subStrings: String
): CharSequence = buildSpannedString {
    append(this@applyColorSpanToSubstrings)

    subStrings.forEach { sub ->
        var start = indexOf(sub, ignoreCase = ignoreCase)
        while (start != -1) {
            val end = start + sub.length
            val colorSpan = ForegroundColorSpan(colorHex)
            setSpan(colorSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            start = indexOf(sub, start + 1, ignoreCase = ignoreCase)
        }
    }
}

/**
 * Applies a bold style span to the specified substrings within the CharSequence.
 *
 * @param subStrings The substrings to apply the bold style span to.
 * @param ignoreCase Whether to ignore case when searching for the substrings. Default is false.
 * @return The CharSequence with the bold style spans applied to the specified substrings.
 */
fun CharSequence.applyBoldSpanToSubstrings(
    vararg subStrings: String,
    ignoreCase: Boolean = false
): CharSequence = buildSpannedString {
    append(this@applyBoldSpanToSubstrings)

    subStrings.forEach { sub ->
        var start = indexOf(sub, ignoreCase = ignoreCase)
        while (start != -1) {
            val end = start + sub.length
            val boldSpan = StyleSpan(Typeface.BOLD)
            setSpan(boldSpan, start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
            start = indexOf(sub, start + 1, ignoreCase = ignoreCase)
        }
    }
}
