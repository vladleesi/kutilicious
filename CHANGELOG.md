# Changelog

All notable changes to this project are documented in this file.

## [2.0.0] - 2026-09-27

### Changed

- Migrated the build to Android Gradle Plugin 9.4.0 and its built-in Kotlin 2.4.20 support.
- Updated the Gradle wrapper to 9.8.0 and ktlint Gradle plugin to 14.2.0.
- Updated Android modules to compile and target API 37, require API 23, and emit JVM 11 bytecode.
- Updated AndroidX Core to 1.19.1, AppCompat to 1.8.0, AndroidX Test JUnit to 1.3.0, and Espresso to 3.7.0.
- Migrated Maven Central publishing from the retired OSSRH service to the Central Portal, including sources and Javadoc artifacts.
- Updated CI to JDK 17 and current major versions of the official GitHub Actions.
- Updated the README and documentation for version 2.0.0 and added GitHub Pages deployment status.

### Compatibility

- Android API 23 is now the minimum supported version. This is a breaking change from 1.x.
- No public Kotlin extension APIs were removed or renamed.

[2.0.0]: https://github.com/vladleesi/kutilicious/compare/1.0.3...2.0.0
