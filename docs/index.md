``` bash
/$$                   /$$     /$$ /$$ /$$           /$$                              
| $$                  | $$    |__/| $$|__/          |__/                              
| $$   /$$ /$$   /$$ /$$$$$$   /$$| $$ /$$  /$$$$$$$ /$$  /$$$$$$  /$$   /$$  /$$$$$$$
| $$  /$$/| $$  | $$|_  $$_/  | $$| $$| $$ /$$_____/| $$ /$$__  $$| $$  | $$ /$$_____/
| $$$$$$/ | $$  | $$  | $$    | $$| $$| $$| $$      | $$| $$  \ $$| $$  | $$|  $$$$$$ 
| $$_  $$ | $$  | $$  | $$ /$$| $$| $$| $$| $$      | $$| $$  | $$| $$  | $$ \____  $$
| $$ \  $$|  $$$$$$/  |  $$$$/| $$| $$| $$|  $$$$$$$| $$|  $$$$$$/|  $$$$$$/ /$$$$$$$/
|__/  \__/ \______/    \___/  |__/|__/|__/ \_______/|__/ \______/  \______/ |_______/
```

Lightweight library with a set of small Kotlin and Android extensions for a better development experience.

## Setup

``` groovy
// build.gradle

repositories {
    mavenCentral()
}

dependencies {
    implementation 'dev.vladleesi.kutilicious:base:1.0.3'
    implementation 'dev.vladleesi.kutilicious:android-preferences:1.0.3'
    implementation 'dev.vladleesi.kutilicious:android-view:1.0.3'
    implementation 'dev.vladleesi.kutilicious:android-text:1.0.3'
    implementation 'dev.vladleesi.kutilicious:android-color:1.0.3'
}
```

## Base

### Base Extensions
- `tag()`: Returns the tag (simple name) of the class.
- `castOrNull()`: Returns the casted object of type [T] if the cast is successful, or `null` otherwise.
### Boolean Extensions
- `ifTrue(block: Boolean.() -> Unit)`: Executes the specified block of code if the Boolean value is true.
- `ifFalse(block: Boolean?.() -> Unit)`: Executes the specified block of code if the Boolean value is false.
- `nullOrFalse()`: Checks if the Boolean value is null or false.
- `orFalse()`: Wraps a nullable type and returns the Boolean value if it is not null, or false if it is null.
### Integer Extensions
- `orZero()`: Wraps a nullable type and returns the integer value if it is not null, or zero if it is null.
- `takePositiveOrNull()`: Returns the positive integer value if it is greater than zero, or null if it is not.
- `isZero()`: Checks if the integer value is zero.
- `isNotZero()`: Checks if the integer value is not zero.
- `divideToPercent(divideTo: Int)`: Divides the integer value by the specified divisor and returns the result as a percentage. Returns 0 if the divisor is 0.
### Float Extensions
- `orZero()`: Wraps a nullable type and returns the float value if it is not null, or zero if it is null.
- `isZero()`: Checks if the float value is zero.
- `isNotZero()`: Checks if the float value is not zero.
### Double Extensions
- `orZero()`: Wraps a nullable type and returns the double value if it is not null, or zero if it is null.
- `isZero()`: Checks if the double value is zero.
- `isNotZero()`: Checks if the double value is not zero.
### BigDecimal Extensions
- `orZero()`: Wraps a nullable type and returns the BigDecimal value if it is not null, or BigDecimal.ZERO if it is null.
- `isZero()`: Checks if the BigDecimal value is zero.
- `isNotZero()`: Checks if the BigDecimal value is not zero.
- `same(value: BigDecimal?)`: Checks if two BigDecimal values are equal.
### String Extensions
- `firstLetterUpperCase()`: Converts the first letter of the string to uppercase.
- `addMissingPrefix(prefix: String, ignoreCase: Boolean = false)`: Adds a prefix to the string if it doesn't already start with it.
- `isNotNullOrEmpty()`: Checks if the string is not null and not empty and returns a non-null boolean.
##### String as URL
- `isUrl()`: Checks if the string is a valid URL.
- `isUrlWithCustomScheme()`: Checks if the string is a URL with a custom scheme.
- `getQueryMap()`: Extracts the query parameters from the string URL and returns them as a map.
- `removeQueries(vararg queryKeys: String)`: Removes the specified query parameters from the string URL and returns the updated URL.
### Date Extensions
- `now: Date`: Returns the current date and time.
- `nowTime: Long`: Returns the current time in milliseconds since January 1, 1970, 00:00:00 GMT.
- `Long.toDate(): Date`: Converts a long value representing the time in milliseconds to a Date object.
- `String.toDate(pattern: String, locale: Locale = Locale.getDefault()): Date?`: Converts a String representation of a date to a Date object using the specified pattern and locale.
- `String.toDate(simpleDateFormat: SimpleDateFormat): Date?`: Converts a String representation of a date to a Date object using the specified SimpleDateFormat instance.
- `Date.toString(pattern: String, locale: Locale = Locale.getDefault()): String?`: Converts the Date object to a string representation using the specified pattern and locale.
- `Date.toString(simpleDateFormat: SimpleDateFormat): String?`: Converts the Date object to a string representation using the specified SimpleDateFormat instance.

## Android Preferences

`editSync`

Synchronously edits SharedPreferences. Changes made using this function are immediately committed using `commit()`.

```kotlin
sharedPreferences.editSync {
    putString("key", "value")
    putInt("count", 5)
}
```

`editAsync`

Asynchronously edits SharedPreferences. Changes made using this function are applied using `apply()`.

```kotlin
sharedPreferences.editAsync {
    putBoolean("isFirstLaunch", false)
}
```

`get`

Retrieves a value from SharedPreferences based on a given key and returns it. If the value is not found or is null, it returns a default value.

```kotlin
// Assuming you have an instance of SharedPreferences called "sharedPrefs"
val sharedPreferences = context.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
// Retrieve a boolean value with the key "isDarkModeEnabled", providing a default value of false
val isDarkModeEnabled = sharedPreferences.get("isDarkModeEnabled", false)
```

`putSync`

Stores a value in SharedPreferences synchronously using a specified key. It returns `true` if the value is successfully stored, and `false` otherwise.

```kotlin
// Assuming you have an instance of SharedPreferences called "sharedPrefs"
val sharedPreferences = context.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
// Store a boolean value with the key "isDarkModeEnabled"
sharedPreferences.putSync("isDarkModeEnabled", true)
```

`putAsync`

Stores a value in SharedPreferences asynchronously with a specified key. It performs the storage operation in the background and does not return a value.

```kotlin
// Assuming you have an instance of SharedPreferences called "sharedPrefs"
val sharedPreferences = context.getSharedPreferences("mySharedPreferences", Context.MODE_PRIVATE)
// Store a boolean value with the key "isDarkModeEnabled" asynchronously
sharedPreferences.putAsync("isDarkModeEnabled", true)
```

## Android View

- `visible()`: Sets the visibility of a View to VISIBLE.
- `gone()`: Sets the visibility of a View to GONE.
- `invisible()`: Sets the visibility of a View to INVISIBLE.
- `addRipple()`: Adds a ripple effect to the background of a View using the theme's selectableItemBackground attribute.
- `addCircleRipple()`: Adds a circular ripple effect to the background of a View using the theme's selectableItemBackgroundBorderless attribute (available for API level 21 and higher).
- `onFocus(block: (hasFocus: Boolean) -> Unit)`: Sets a callback function to be invoked when the focus state of a View changes.
- `forEachView`: Kotlin extension function recursively iterates through each view in the hierarchy, applying a specified action (lambda expression) to each view, including all child views if the current view is a ViewGroup.

## Android Text

- `getHighlightColor`: Retrieves the hexadecimal representation of a highlight color specified by a color resource ID.
- `fromHTML`: Converts a string to a CharSequence with HTML formatting.
- `bold`: Formats a CharSequence to be displayed in bold using HTML tags.
- `withAsterisk`: Formats a CharSequence with an asterisk and applies a highlight color to the asterisk using HTML tags.
- `applyColorSpanToSubstrings`: Applies a foreground color span to specified substrings within a CharSequence.
- `applyBoldSpanToSubstrings`: Applies a bold style span to specified substrings within a CharSequence.

## Android Color
- `lightenColor`: Lightens an RGB color by a given percentage. It takes an integer color value and a percentage value between 0.0 and 1.0 as inputs. The function returns the lightened color as an integer value representing ARGB components.
- `darkenColor`: Darkens an RGB color by a given percentage. See `lightenColor`.

## License

This project is licensed under the [MIT License](https://github.com/vladleesi/kutilicious/blob/master/LICENSE).
