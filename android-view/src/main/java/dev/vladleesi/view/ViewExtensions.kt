package dev.vladleesi.view

import android.os.Build
import android.util.TypedValue
import android.view.View
import androidx.annotation.RequiresApi

/**
 * Sets the visibility of a View to [View.VISIBLE].
 * @see [setVisibilityInner]
 */
fun View.visible() = setVisibilityInner(View.VISIBLE)

/**
 * Sets the visibility of a View to [View.GONE].
 * @see [setVisibilityInner]
 */
fun View.gone() = setVisibilityInner(View.GONE)

/**
 * Sets the visibility of a View to [View.INVISIBLE].
 * @see [setVisibilityInner]
 */
fun View.invisible() = setVisibilityInner(View.INVISIBLE)

/**
 * Sets the visibility of a View to the specified value.
 * @param visibility The visibility value to be set. Should be one of [View.VISIBLE], [View.GONE], or [View.INVISIBLE].
 */
private fun View.setVisibilityInner(visibility: Int) {
    if (this.visibility != visibility) {
        this.visibility = visibility
    }
}

/**
 * Adds a ripple effect to the background of a View.
 * The ripple effect is obtained from the theme's selectableItemBackground attribute.
 */
fun View.addRipple() = with(TypedValue()) {
    context.theme.resolveAttribute(android.R.attr.selectableItemBackground, this, true)
    setBackgroundResource(resourceId)
}

/**
 * Adds a circular ripple effect to the background of a View.
 * The circular ripple effect is obtained from the theme's selectableItemBackgroundBorderless attribute.
 * @throws [android.content.res.Resources.NotFoundException]
 * if the API level is lower than [android.os.Build.VERSION_CODES.LOLLIPOP].
 */
@RequiresApi(Build.VERSION_CODES.LOLLIPOP)
fun View.addCircleRipple() = with(TypedValue()) {
    context.theme.resolveAttribute(android.R.attr.selectableItemBackgroundBorderless, this, true)
    setBackgroundResource(resourceId)
}

/**
 * Sets a callback function to be invoked when the focus state of a View changes.
 * @param block The block of code to be executed when the focus state changes.
 * It receives a single Boolean parameter indicating whether the View has gained or lost focus.
 */
fun View.onFocus(block: (hasFocus: Boolean) -> Unit) {
    setOnFocusChangeListener { _, focus -> block(focus) }
}
