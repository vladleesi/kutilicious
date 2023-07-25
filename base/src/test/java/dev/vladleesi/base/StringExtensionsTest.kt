package dev.vladleesi.base

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Created by Vladislav Kochetov on 5/26/2023.
 */
class StringExtensionsTest {

    @Test
    fun `firstLetterUpperCase should capitalize the first letter of a string`() {
        val string = "hello, world!"
        val result = string.firstLetterUpperCase()
        assertEquals("Hello, world!", result)
    }

    @Test
    fun `addMissingPrefix should add the missing prefix to a string`() {
        val string = "example.com"
        val prefix = "http://"
        val result = string.addMissingPrefix(prefix)
        assertEquals("http://example.com", result)
    }

    @Test
    fun `addMissingPrefix should not add the prefix if it already exists in a case-sensitive manner`() {
        val string = "http://example.com"
        val prefix = "http://"
        val result = string.addMissingPrefix(prefix)
        assertEquals("http://example.com", result)
    }

    @Test
    fun `addMissingPrefix should add the missing prefix ignoring the case of the prefix`() {
        val string = "example.com"
        val prefix = "HTTP://"
        val result = string.addMissingPrefix(prefix, ignoreCase = true)
        assertEquals("HTTP://example.com", result)
    }

    @Test
    fun `isNotNullOrEmpty should return false for null string`() {
        val string: String? = null
        val result = string.isNotNullOrEmpty()
        assertFalse(result)
    }

    @Test
    fun `isNotNullOrEmpty should return false for empty string`() {
        val string = ""
        val result = string.isNotNullOrEmpty()
        assertFalse(result)
    }

    @Test
    fun `isNotNullOrEmpty should return true for non-empty string`() {
        val string = "Hello, World!"
        val result = string.isNotNullOrEmpty()
        assertTrue(result)
    }

    @Test
    fun `isUrl should return true for a valid URL string`() {
        val url = "https://example.com"
        val result = url.isUrl()
        assertTrue(result)
    }

    @Test
    fun `isUrl should return false for an invalid URL string`() {
        val url = "example.com"
        val result = url.isUrl()
        assertFalse(result)
    }

    @Test
    fun `isUrlWithCustomScheme should return true for a URL string with a custom scheme`() {
        val url = "myapp://example.com"
        val result = url.isUrlWithCustomScheme()
        assertTrue(result)
    }

    @Test
    fun `isUrlWithCustomScheme should return false for a URL string without a custom scheme`() {
        val url = "https://example.com"
        val result = url.isUrlWithCustomScheme()
        assertFalse(result)
    }

    @Test
    fun `getQueryMap should return a map of query parameters`() {
        val url = "https://example.com?param1=value1&param2=value2&param3=value3"
        val result = url.getQueryMap()
        val expectedMap = mapOf(
            "param1" to "value1",
            "param2" to "value2",
            "param3" to "value3"
        )
        assertEquals(expectedMap, result)
    }

    @Test
    fun `removeQueries should remove the specified query keys from the URL string`() {
        val url = "https://example.com?param1=value1&param2=value2&param3=value3"
        val result = url.removeQueries("param1", "param3")
        assertEquals("https://example.com?param2=value2", result)
    }

    @Test
    fun `removeQueries should return the original URL if none of the query keys match`() {
        val url = "https://example.com?param1=value1&param2=value2&param3=value3"
        val result = url.removeQueries("param4", "param5")
        assertEquals(url, result)
    }
}
