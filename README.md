# kutilicious

Small Kotlin and Android extensions for a better development experience

## Utility Functions Summary

### Base Extensions
`tag()`: Returns the tag (simple name) of the class.
### Boolean Extensions
`ifTrue(block: Boolean.() -> Unit)`: Executes the specified block of code if the Boolean value is true.
`ifFalse(block: Boolean?.() -> Unit)`: Executes the specified block of code if the Boolean value is false.
`nullOrFalse()`: Checks if the Boolean value is null or false.
`orFalse()`: Returns the Boolean value if it is not null, or false if it is null.
### Integer Extensions
`orZero()`: Returns the integer value if it is not null, or zero if it is null.
`takePositiveOrNull()`: Returns the positive integer value if it is greater than zero, or null if it is not.
`isZero()`: Checks if the integer value is zero.
`isNotZero()`: Checks if the integer value is not zero.
`divideToPercent(divideTo: Int)`: Divides the integer value by the specified divisor and returns the result as a percentage. Returns 0 if the divisor is 0.
### Float Extensions
`orZero()`: Returns the float value if it is not null, or zero if it is null.
`isZero()`: Checks if the float value is zero.
`isNotZero()`: Checks if the float value is not zero.
### Double Extensions
`orZero()`: Returns the double value if it is not null, or zero if it is null.
`isZero()`: Checks if the double value is zero.
`isNotZero()`: Checks if the double value is not zero.
### BigDecimal Extensions
`orZero()`: Returns the BigDecimal value if it is not null, or BigDecimal.ZERO if it is null.
`isZero()`: Checks if the BigDecimal value is zero.
`isNotZero()`: Checks if the BigDecimal value is not zero.
`same(value: BigDecimal?)`: Checks if two BigDecimal values are equal.
### String Extensions
`isNullOrEmptyAfterTrim()`: Implements deprecated logic from PojoUtils.isNull(). Checks if the string is null or the trimmed string is empty.
`isNotNullOrEmptyAfterTrim()`: Implements deprecated logic from PojoUtils.isNotNull(). Checks if the string is not null and the trimmed string is not empty.
`firstLetterUpperCase()`: Converts the first letter of the string to uppercase.
`addMissingPrefix(prefix: String, ignoreCase: Boolean = false)`: Adds a prefix to the string if it doesn't already start with it.
`isNotNullOrEmpty()`: Checks if the string is not null and not empty.
##### String as URL
`isUrl()`: Checks if the string is a valid URL.
`isUrlWithCustomScheme()`: Checks if the string is a URL with a custom scheme.
`getQueryMap()`: Extracts the query parameters from the string URL and returns them as a map.
`removeQueries(vararg queryKeys: String)`: Removes the specified query parameters from the string URL and returns the updated URL.

## License

This project is licensed under the [MIT License](LICENSE).