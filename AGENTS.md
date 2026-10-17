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

**NVD key (optional):** `dependencyCheckAnalyze` reads the key from the `NVD_API_KEY` environment variable or the `nvd.apiKey` Gradle property. With a key, it updates the NVD data live. Without one, it uses the local NVD cache and logs a warning. CI runs without a key, so it also uses the cache.

**External dependencies:** Standalone library; no runtime dependencies beyond Java.

Build uses Java 25 toolchain, compiles to Java 22 bytecode (`release = "22"`) — unlike other projects. Requires Java 22 APIs. CI tests on Java 22 and 25 only.

## Key Entry Points

- `Codec<T>` — interface for encoding/decoding records
- `CompositeCodec` — chains multiple codecs together

## Architecture

Named JPMS module; provides composable record codecs for field-oriented I/O. Single-module structure.

## Shared build sections

`build.gradle` and `settings.gradle` wrap the build logic this project shares with the other Java/Gradle projects in `// shared:begin NAME` and `// shared:end NAME` markers. The canonical copies live in `claude-skills/init-java-project/shared/`. The `shared-build` CI job checks out that directory and fails if a wrapped section differs from its canonical copy. Indentation, blank lines and comment lines are ignored. To change a shared section, change the canonical copy and the same section in every project in one change set. Run the check locally with `bash <claude-skills>/init-java-project/shared/check-shared-sections.sh . <claude-skills>/init-java-project/shared`.

## Code style

Spotless enforces Google Java Format. Run `./gradlew spotlessApply` before committing.
`module-info.java` is excluded from Spotless.

## Security patches

For CVE patch management, see the `gradle-security-patch` skill. Use `/gradle-security-patch` to pin a CVE fix in the version catalog.
