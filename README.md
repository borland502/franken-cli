# Spring Native Seed Project

This is a seed repository for building CLI applications with Spring Native.  It leverages
[Picocli](https://picocli.info/) for bootstrapping the CLI execution, 
[GraalVM native-image](https://www.graalvm.org/reference-manual/native-image/) and 
[Spring Native](https://docs.spring.io/spring-native/docs/current/reference/htmlsingle/) for building
a native image executable

**NOTE:** If you don't need Spring Native at all, the forked parent of this project will serve you far better

* **JDK Version**: `17`
* **Spring Version**: `3.1.3`
* **GraalVM Version**: `17.0.8` 

## Build

### Maven
For the `native-image` build, see instructions at bottom for tooling pre-requisites.  Your 
`JAVA_HOME` will need to be set with `GraalVM` installation.

```sh
./mvnw clean install # Build executable JAR
./mvnw clean install -Pnative # Build native image 
./mvnw -Pnative native:compile # Build native executable
```

## Run

### Maven

#### Executable JAR
```sh
java -jar target/frankencli-*.jar --help
java -jar target/frankencli-*.jar hello-world
```

#### Native Image
```sh
./target/frankencli
```

#### GraalVM and Native Image Installation Instructions
- Getting Started
  - https://www.graalvm.org/docs/getting-started/macos/
  - https://www.graalvm.org/docs/getting-started/linux/
- https://www.graalvm.org/reference-manual/native-image/#install-native-image
- https://www.graalvm.org/reference-manual/ruby/Installingzlib/
