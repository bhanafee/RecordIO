# Codebase Guidance

This file documents key information about the project architecture, build commands, code style, and security practices.

## Project overview

Composable record codecs for field-oriented I/O. Published to GitHub Packages as `com.maybeitssquid:recordio`.

## Commands

```bash
./gradlew build                   # compile, test, spotless check, javadoc
./gradlew test                    # run tests
./gradlew test --tests "..."      # run a single test class
./gradlew spotlessApply           # auto-format (required before commit)
./gradlew javadoc                 # generate Javadoc
./gradlew dependencyCheckAnalyze  # OWASP vulnerability scan (slow; fails at CVSS ≥ 7)
```

Build uses Java 25 toolchain, compiles to Java 22 bytecode (`release = "22"`) — unlike other projects. Requires Java 22 APIs. CI tests on Java 22 and 25 only.

## Architecture

[TODO: describe the module structure and key design decisions]

## Code style

Spotless enforces Google Java Format. Run `./gradlew spotlessApply` before committing.
`module-info.java` is excluded from Spotless.

## Security patches

For CVE patch management, see the `gradle-security-patch` skill. Use `/gradle-security-patch` to pin a CVE fix in the version catalog.
