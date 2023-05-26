package dev.vladleesi.preferences

import android.content.SharedPreferences

/**
 * Retrieves a value from the SharedPreferences with the specified key.
 *
 * @param key The key used to retrieve the value.
 * @param defaultValue The default value to return if the key is not found or the value is null.
 * @return The value retrieved from the SharedPreferences, or the default value if not found or null.
 */
inline fun <reified T> SharedPreferences.get(key: String, defaultValue: T): T {
    try {
        when (T::class) {
            Boolean::class -> return this.getBoolean(key, defaultValue as Boolean) as T
            Float::class -> return this.getFloat(key, defaultValue as Float) as T
            Int::class -> return this.getInt(key, defaultValue as Int) as T
            Long::class -> return this.getLong(key, defaultValue as Long) as T
            String::class -> return this.getString(key, defaultValue as String) as T
            else -> {
                val stringSet = defaultValue as? Set<String> ?: return defaultValue
                return this.getStringSet(key, stringSet) as T
            }
        }
    } catch (ex: ClassCastException) {
        return defaultValue
    }
    return defaultValue
}

/**
 * Stores a value in the SharedPreferences with the specified key synchronously.
 *
 * @param key The key used to store the value.
 * @param value The value to store.
 * @return True if the value was successfully stored, false otherwise.
 */
inline fun <reified T> SharedPreferences.putSync(key: String?, value: T?): Boolean {
    val editor = this.edit()

    when (T::class) {
        Boolean::class -> editor.putBoolean(key, value as Boolean)
        Float::class -> editor.putFloat(key, value as Float)
        Int::class -> editor.putInt(key, value as Int)
        Long::class -> editor.putLong(key, value as Long)
        String::class -> editor.putString(key, value as String)
        else -> {
            val stringSet = value as? Set<String> ?: return false
            editor.putStringSet(key, stringSet)
        }
    }

    return editor.commit()
}

/**
 * Stores a value in the SharedPreferences with the specified key asynchronously.
 *
 * @param key The key used to store the value.
 * @param value The value to store.
 */
inline fun <reified T> SharedPreferences.putAsync(key: String?, value: T?) {
    val editor = this.edit()

    when (T::class) {
        Boolean::class -> editor.putBoolean(key, value as Boolean)
        Float::class -> editor.putFloat(key, value as Float)
        Int::class -> editor.putInt(key, value as Int)
        Long::class -> editor.putLong(key, value as Long)
        String::class -> editor.putString(key, value as String)
        else -> {
            val stringSet = value as? Set<String> ?: return
            editor.putStringSet(key, stringSet)
        }
    }

    editor.apply()
}
