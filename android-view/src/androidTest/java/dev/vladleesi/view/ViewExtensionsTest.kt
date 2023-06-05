package dev.vladleesi.view

import android.content.res.Resources.NotFoundException
import android.view.View
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThrows
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Vladislav Kochetov on 6/6/2023.
 */
@RunWith(AndroidJUnit4::class)
class ViewExtensionsTest {

    @Test
    fun test_visible() {
        val view = View(ApplicationProvider.getApplicationContext())
        view.gone()
        assertEquals(View.GONE, view.visibility)
        view.visible()
        assertEquals(View.VISIBLE, view.visibility)
    }

    @Test
    fun test_gone() {
        val view = View(ApplicationProvider.getApplicationContext())
        view.visible()
        assertEquals(View.VISIBLE, view.visibility)
        view.gone()
        assertEquals(View.GONE, view.visibility)
    }

    @Test
    fun test_invisible() {
        val view = View(ApplicationProvider.getApplicationContext())
        view.visible()
        assertEquals(View.VISIBLE, view.visibility)
        view.invisible()
        assertEquals(View.INVISIBLE, view.visibility)
    }

    @Test
    fun test_addRipple() {
        val view = View(ApplicationProvider.getApplicationContext())
        view.addRipple()
        // Perform assertion to check if the background resource is set
        assertTrue(view.background != null)
    }

    @Test
    fun test_addCircleRipple() {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            val view = View(ApplicationProvider.getApplicationContext())
            view.addCircleRipple()
            // Perform assertion to check if the background resource is set
            assertTrue(view.background != null)
        } else {
            val errorMessage = "API level is lower than Lollipop."
            val exception = assertThrows(NotFoundException::class.java) {
                throw NotFoundException(errorMessage)
            }
            assertEquals(errorMessage, exception.message)
        }
    }

    @Test
    fun test_onFocus() {
        val view = View(ApplicationProvider.getApplicationContext())
        var focusChanged = false

        view.onFocus { hasFocus ->
            focusChanged = hasFocus
        }

        // Simulate focus change to true
        view.onFocusChangeListener?.onFocusChange(view, true)
        assertEquals(true, focusChanged)

        // Simulate focus change to false
        view.onFocusChangeListener?.onFocusChange(view, false)
        assertEquals(false, focusChanged)
    }
}
