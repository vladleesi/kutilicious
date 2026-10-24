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

[![License: MIT](https://img.shields.io/badge/License-MIT-brightgreen.svg)](LICENSE) [![Maven Central](https://img.shields.io/maven-central/v/dev.vladleesi.kutilicious/base?versionPrefix=2.0.0&color=blue)](https://central.sonatype.com/namespace/dev.vladleesi.kutilicious) [![GitHub Pages](https://img.shields.io/github/deployments/vladleesi/kutilicious/github-pages?label=docs)](https://github.com/vladleesi/kutilicious/deployments)

Small Kotlin and Android extensions for a better development experience.

## Setup

``` groovy
// build.gradle

repositories {
    mavenCentral()
}

dependencies {
    implementation 'dev.vladleesi.kutilicious:base:2.0.0'
    implementation 'dev.vladleesi.kutilicious:android-preferences:2.0.0'
    implementation 'dev.vladleesi.kutilicious:android-view:2.0.0'
    implementation 'dev.vladleesi.kutilicious:android-text:2.0.0'
    implementation 'dev.vladleesi.kutilicious:android-color:2.0.0'
}
```

Version 2.0.0 requires Android API 23 or newer.

## Documentation

For detailed documentation and usage instructions, please visit [documentation site](https://vladleesi.dev/kutilicious).

## Dependency updates

Renovate tracks Gradle dependencies, the Gradle wrapper, and GitHub Actions, and opens pull requests against `develop`.
Minor and patch updates to Gradle dependencies and GitHub Actions are grouped separately; major updates and Gradle wrapper updates remain separate. Updates require manual review and merging.
Pull requests run the build and tests. Successful pushes to `develop` promote changes to `master` and deploy the documentation.

The hosted Renovate app already has repository access (see [onboarding PR #5](https://github.com/vladleesi/kutilicious/pull/5)).
This configuration becomes active once `renovate.json` reaches the default branch (`master`) through the existing promotion workflow.

## License

This project is licensed under the [MIT License](LICENSE).
