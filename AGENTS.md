# Codebase Guidance

This file documents key information about the project architecture, build commands, code style, and security practices.

## Project overview

Composable record codecs for field-oriented I/O. Published to GitHub Packages as `com.maybeitssquid:recordio`.

## Commands

**Build and test:**
```bash
./gradlew build              # compile, test, spotless check
./gradlew test               # run all tests
./gradlew test --tests "*CodecTest"           # run tests by class name
./gradlew test --tests "*CodecTest.test*"     # run tests by method pattern
```

**Code quality:**
```bash
./gradlew spotlessApply           # auto-format (required before commit)
./gradlew dependencyCheckAnalyze  # OWASP vulnerability scan (slow; fails at CVSS ≥ 7)
```

**External dependencies:** Standalone library; no runtime dependencies beyond Java.

Build uses Java 25 toolchain, compiles to Java 22 bytecode (`release = "22"`) — unlike other projects. Requires Java 22 APIs. CI tests on Java 22 and 25 only.

## Key Entry Points

- `Codec<T>` — interface for encoding/decoding records
- `CompositeCodec` — chains multiple codecs together

## Architecture

Named JPMS module; provides composable record codecs for field-oriented I/O. Single-module structure.

## Code style

Spotless enforces Google Java Format. Run `./gradlew spotlessApply` before committing.
`module-info.java` is excluded from Spotless.

## Security patches

For CVE patch management, see the `gradle-security-patch` skill. Use `/gradle-security-patch` to pin a CVE fix in the version catalog.
