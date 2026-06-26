# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project overview

Composable record codecs for field-oriented I/O. Published to GitHub Packages as `com.maybeitssquid:recordio`.

## Commands

```bash
./gradlew build          # compile, test, spotless check, javadoc
./gradlew test           # tests only
./gradlew spotlessApply  # auto-format Java source (required before commit)
./gradlew javadoc        # generate Javadoc
./gradlew dependencyCheckAnalyze  # OWASP CVE scan (slow; fails build at CVSS >= 7)

# Run a single test class
./gradlew test --tests "com.maybeitssquid.recordio.ExampleTest"
```

On Windows, use `gradlew.bat` (or `.\gradlew` in PowerShell).

The build uses a Java 25 toolchain. Unlike the other projects (which target `release = "17"`), RecordIO deliberately compiles to Java 22 bytecode (`release = "22"`) because it requires Java 22 APIs/bytecode; its CI matrix is correspondingly narrower (it cannot run on Java 17 or 21).

## Architecture

[TODO: describe the module structure and key design decisions]

## Code style

Spotless enforces Google Java Format. Run `./gradlew spotlessApply` before committing.
`module-info.java` is excluded from Spotless.

## Security patches

Transitive CVE fixes go in `gradle/libs.versions.toml` as `patch-cve-XXXX-NNNNN` library
entries, collected in the `security-patches` bundle. See the global CLAUDE.md for the
full pattern.
