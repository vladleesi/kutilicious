package dev.vladleesi.preferences

import android.content.Context
import android.content.SharedPreferences
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Vladislav Kochetov on 5/26/2023.
 */

@RunWith(AndroidJUnit4::class)
class PreferencesExtensionsTest {

    private lateinit var sharedPreferences: SharedPreferences

    @Before
    fun setUp() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        sharedPreferences = context.getSharedPreferences("my_preferences", Context.MODE_PRIVATE)
    }

    @Test
    fun testEditSync() {
        // Perform synchronous editing of SharedPreferences
        sharedPreferences.editSync {
            putString("key", "value")
            putInt("count", 5)
        }
        // Verify the changes made using SharedPreferences methods
        val value = sharedPreferences.getString("key", null)
        val count = sharedPreferences.getInt("count", 0)
        // Assert the value
        assertEquals("value", value)
        assertEquals(5, count)
    }

    @Test
    fun testEditAsync() {
        // Perform asynchronous editing of SharedPreferences
        sharedPreferences.editAsync {
            putBoolean("isFirstLaunch", false)
        }
        // Verify the changes made using SharedPreferences methods
        val isFirstLaunch = sharedPreferences.getBoolean("isFirstLaunch", true)
        // Assert the value
        assertEquals(false, isFirstLaunch)
    }

    @Test
    fun testSharedPreferencesGet() {
        // Write data to SharedPreferences using the extension function
        sharedPreferences.putSync("key", "value")
        // Read data from SharedPreferences using the extension function
        val value = sharedPreferences.get("key", "default_value")
        // Assert the value
        assertEquals("value", value)
    }

    @Test
    fun testSharedPreferencesGetDefaultValue() {
        // Attempt to read data that does not exist using the extension function
        val value = sharedPreferences.get("non_existing_key", "default_value")
        // Assert the default value
        assertEquals("default_value", value)
    }

    @Test
    fun testGetBooleanValue() {
        // Store a boolean value in SharedPreferences
        sharedPreferences.edit().putBoolean("key", true).apply()
        // Retrieve the boolean value using the get function
        val retrievedValue = sharedPreferences.get("key", false)
        // Assert that the retrieved value matches the stored value
        assertEquals(true, retrievedValue)
    }

    @Test
    fun testGetFloatValue() {
        // Store a float value in SharedPreferences
        sharedPreferences.edit().putFloat("key", 3.14f).apply()
        // Retrieve the float value using the get function
        val retrievedValue = sharedPreferences.get("key", 0.0f)
        // Assert that the retrieved value matches the stored value
        assertEquals(3.14f, retrievedValue)
    }

    @Test
    fun testGetIntValue() {
        // Store an int value in SharedPreferences
        sharedPreferences.edit().putInt("key", 42).apply()
        // Retrieve the int value using the get function
        val retrievedValue = sharedPreferences.get("key", 0)
        // Assert that the retrieved value matches the stored value
        assertEquals(42, retrievedValue)
    }

    @Test
    fun testGetLongValue() {
        // Store a long value in SharedPreferences
        sharedPreferences.edit().putLong("key", 1234567890L).apply()
        // Retrieve the long value using the get function
        val retrievedValue = sharedPreferences.get("key", 0L)
        // Assert that the retrieved value matches the stored value
        assertEquals(1234567890L, retrievedValue)
    }

    @Test
    fun testGetStringValue() {
        // Store a string value in SharedPreferences
        sharedPreferences.edit().putString("key", "Hello").apply()
        // Retrieve the string value using the get function
        val retrievedValue = sharedPreferences.get("key", "")
        // Assert that the retrieved value matches the stored value
        assertEquals("Hello", retrievedValue)
    }

    @Test
    fun testGetStringSetValue() {
        // Store a string set value in SharedPreferences
        sharedPreferences.edit().putStringSet("key", setOf("value1", "value2")).apply()
        // Retrieve the string set value using the get function
        val retrievedValue = sharedPreferences.get("key", emptySet<String>())
        // Assert that the retrieved value matches the stored value
        assertEquals(setOf("value1", "value2"), retrievedValue)
    }

    @Test
    fun testGetUnsupportedType() {
        // Store an unsupported type in SharedPreferences
        sharedPreferences.edit().putBoolean("key", true).apply()
        // Try to retrieve an unsupported type using the get function
        val retrievedValue = sharedPreferences.get("key", 42)
        // Assert that the retrieved value is the default value since the type is unsupported
        assertEquals(42, retrievedValue)
    }

    @Test
    fun testGetDefaultValueOnClassCastException() {
        // Store a string value in SharedPreferences
        sharedPreferences.edit().putString("key", "123").apply()
        // Try to retrieve the string value as an integer using the get function
        val retrievedValue = sharedPreferences.get("key", 0)
        // Assert that the retrieved value is the default value since a ClassCastException occurred
        assertEquals(0, retrievedValue)
    }

    @Test
    fun testSharedPreferencesRemoveKey() {
        // Write data to SharedPreferences using the extension function
        sharedPreferences.putSync("key", "value")
        // Remove the key from SharedPreferences using the extension function
        sharedPreferences.edit().remove("key").commit()
        // Attempt to read the removed key using the extension function
        val value = sharedPreferences.get("key", "default_value")
        // Assert that the value is null
        assertEquals(value, "default_value")
    }

    @Test
    fun testPutAsyncSupportedType() {
        val stringSet = setOf("1", "2", "3")
        // Call putAsync with a supported type
        sharedPreferences.putAsync("key", stringSet)
        // Wait for the async operation to complete
        Thread.sleep(100)
        // Read the stored value
        val storedValue = sharedPreferences.getStringSet("key", null)
        // Assert the stored value
        assertEquals(stringSet, storedValue)
    }

    @Test
    fun testPutAsyncUnsupportedType() {
        // Call putAsync with an unsupported type
        sharedPreferences.putAsync("key", Any())
        // Wait for the async operation to complete
        Thread.sleep(100)
        // Try to read the stored value
        val storedValue = sharedPreferences.get("key", "null")
        // Assert that the stored value is null since the unsupported type is ignored
        assertEquals("null", storedValue)
    }

    @Test
    fun testPutAsyncUnsupportedTypeReturnsEarly() {
        // Call putAsync with an unsupported type
        sharedPreferences.putAsync("key", setOf(1, 2, 3))
        // Wait for the async operation to complete
        Thread.sleep(100)
        // Try to read the stored value
        val storedValue = sharedPreferences.getStringSet("key", emptySet())
        // Assert that the stored value is empty since the unsupported type is ignored
        assertFalse(storedValue?.contains("1") ?: false)
    }
}
