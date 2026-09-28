# Contributing Guide

### Here's a quick guide for new maintainers:

#### Getting Started
- Fork the repo and clone it to your local machine
- Check out the [README](README.md)
- Read the [code of conduct](CODE_OF_CONDUCT.md)
#### Making Changes
- Create a new branch for your changes
- Make small, atomic commits with clear messages
- Add tests to cover any new functionality
- Run existing tests to ensure nothing breaks
#### Submitting Changes
- Push your changes to your fork
- Open a pull request
- Describe the changes and why you're making them
- Link any relevant issues
#### Getting Help
- Open an issue if you run into problems
#### Your PR is merged!
- Congratulations :tada::tada: Thanks for contributing! :sparkles:

## Releasing

1. Update `publication.version` in `gradle.properties`, the dependency examples, and `CHANGELOG.md`.
2. Run `./gradlew test build ktlintCheck`.
3. Push the release commit to `develop` and wait for the build workflow to promote it to `master`.
4. Tag the promoted commit with the exact `publication.version` value and push the tag.
5. The Maven publishing workflow validates, signs, and releases every module through the Maven Central Portal.
6. Create the matching GitHub release from the changelog after Maven Central reports the deployment as published.

The repository must define `MAVEN_CENTRAL_USERNAME`, `MAVEN_CENTRAL_PASSWORD`, `SIGNING_KEY`, and `SIGNING_PASSWORD` as GitHub Actions secrets. `SIGNING_KEY` is the ASCII-armored private GPG key.
