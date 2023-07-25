@file:JvmName("StringExtensions")

package dev.vladleesi.base

import java.net.URI
import java.util.*

const val HTTP_PREFIX = "http"
const val HTTPS_PREFIX = "https"
const val EMAIL_SCHEME = "mailto"
const val TEL_SCHEME = "tel"
const val FTP_SCHEME = "ftp"
const val FILE_SCHEME = "file"

private const val AMPERSAND_SEPARATOR = "&"
private const val EQUALS_SEPARATOR = "="

private const val SCHEME_REGEX = "\\w+:"
private const val URL_REGEX =
    "(?i)^(?:$HTTPS_PREFIX?|$FTP_SCHEME|$FILE_SCHEME)://(?:\\S+(?::\\S*)?@)?" +
        "(?:(?!(?:10|127)(?:\\.\\d{1,3}){3})(?!(?:169\\.254|192\\.168)(?:\\.\\d{1,3}){2})" +
        "(?!172\\.(?:1[6-9]|2\\d|3[0-1])(?:\\.\\d{1,3}){2})(?:[1-9]\\d?|1\\d\\d|2[01]\\d|22[0-3])" +
        "(?:\\.(?:1?\\d{1,2}|2[0-4]\\d|25[0-5])){2}(?:\\.(?:[1-9]\\d?|1\\d\\d|2[0-4]\\d|25[0-4]))|" +
        "(?:(?:[a-z\\u00a1-\\uffff0-9]-*)*[a-z\\u00a1-\\uffff0-9]+)(?:\\.(?:[a-z\\u00a1-\\uffff0-9]-*)*" +
        "[a-z\\u00a1-\\uffff0-9]+)*(?:\\.(?:[a-z\\u00a1-\\uffff]{2,}))\\.?)(?::\\d{2,5})?(?:[/?#]\\S*)?$"

/**
 * Converts the first letter of the string to uppercase.
 *
 * @return The string with the first letter converted to uppercase.
 */
fun String.firstLetterUpperCase(): String =
    substring(0, 1).uppercase(Locale.getDefault()) + substring(1)

/**
 * Adds a prefix to the string if it doesn't already start with it.
 *
 * @param prefix The prefix to add.
 * @param ignoreCase Whether to ignore the case when comparing the prefix.
 * @return The string with the prefix added if necessary.
 */
fun String.addMissingPrefix(prefix: String, ignoreCase: Boolean = false): String =
    if (!startsWith(prefix, ignoreCase)) {
        prefix + this
    } else {
        this
    }

/**
 * Checks if the string is not null and not empty.
 *
 * @return True if the string is not null and not empty, false otherwise.
 */
fun String?.isNotNullOrEmpty(): Boolean {
    if (this == null) {
        return false
    }

    if (this.isEmpty()) {
        return false
    }

    return true
}

/**
 * Checks if the string is a valid URL.
 *
 * @return True if the string is a valid URL, false otherwise.
 */
fun String.isUrl(): Boolean = Regex(URL_REGEX).containsMatchIn(this)

/**
 * Checks if the string is a URL with a custom scheme.
 *
 * @return True if the string is a URL with a custom scheme, false otherwise.
 */
fun String.isUrlWithCustomScheme(): Boolean {
    return Regex(SCHEME_REGEX).containsMatchIn(this) && !this.startsWith(HTTP_PREFIX)
}

/**
 * Extracts the query parameters from the string URL and returns them as a map.
 *
 * @return The map of query parameters.
 */
fun String.getQueryMap(): Map<String, String> {
    val queryParameters = mutableMapOf<String, String>()
    val queryStartIndex = indexOf('?')

    if (queryStartIndex != -1) {
        val query = substring(queryStartIndex.inc())
        val pairs = query.split('&')

        for (pair in pairs) {
            val (key, value) = pair.split('=')
            queryParameters[key] = value
        }
    }
    return queryParameters
}

/**
 * Removes the specified query parameters from the string URL and returns the updated URL.
 *
 * @param queryKeys The query parameter keys to remove.
 * @return The updated URL string with the specified query parameters removed.
 */
fun String.removeQueries(vararg queryKeys: String): String {
    val uri = URI(this)
    val queryParameters = uri.query
        ?.split(AMPERSAND_SEPARATOR)
        ?.mapNotNull { query ->
            val queryKey = query.split(EQUALS_SEPARATOR).firstOrNull()
            if (queryKeys.any { queryKeyExtended -> queryKeyExtended == queryKey }) {
                null
            } else {
                query
            }
        }
        ?.joinToString(separator = AMPERSAND_SEPARATOR)
        ?.takeIf { queryRaw -> queryRaw.isNotEmpty() }
    val filteredUri = URI(uri.scheme, uri.authority, uri.path, queryParameters, uri.fragment)
    return filteredUri.toString()
}
