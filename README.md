# Spring Native Seed Project

This is a seed repository for building CLI applications with Spring Native.  It leverages
[Picocli](https://picocli.info/) for bootstrapping the CLI execution, 
[GraalVM native-image](https://www.graalvm.org/reference-manual/native-image/) and 
[Spring Native](https://docs.spring.io/spring-native/docs/current/reference/htmlsingle/) for building
a native image executable

**NOTE:** If you don't need Spring Native at all, the forked parent of this project will serve you far better

* **JDK Version**: `17`
* **Spring Version**: `2.6.3`
* **Spring Native Version**: `0.11.2`
* **GraalVM Version**: `22.0.0.2` 

## Build

### Maven
For the `native-image` build, see instructions at bottom for tooling pre-requisites.  Your 
`JAVA_HOME` will need to be set with `GraalVM` installation.

```sh
./mvnw clean install # Build executable JAR
./mvnw clean install -D nativeImage # Build native image
```

## Run

### Maven

#### Executable JAR
```sh
java -jar target/java-cli-template-*.jar --help
java -jar target/java-cli-template-*.jar hello-world
java -jar target/java-cli-template-*.jar hello-world Brian
echo "Brian" | java -jar target/java-cli-template-*.jar hello-world -
```

#### Native Image
```sh
./target/app --help
./target/app hello-world
./target/app hello-world Brian
echo "Brian" | ./target/app hello-world -
```

#### Native Image
```sh
./build/graal/app --help
./build/graal/app hello-world
./build/graal/app hello-world Brian
echo "Brian" | ./build/graal/app hello-world -
```

## Reflection in Native Image

Runtime reflection in a native image is tricky.  GraalVM can detect basic usage of class loading with reflection, 
however it cannot determine classes loaded dynamically. To allow it to work, some configuration needs to be done.

See `Reflect.java` for how the class is loaded "dynamically".

### This Will Work
```sh
./app reflect java.lang.String
```
This is because it has been configured in `reflect-config.json`.

### This Will Not Work
```sh
./app reflect java.util.List
```
This is because it is not included in `reflect-config.json`

## Native Image Prerequisites When Using Maven
The maven build requires that GraalVM and `native-image` tooling already be available on the machine.

- GraalVM CE
- GraalVM CE `native-image`
- `zlib` / `xcode`

### GraalVM Installation

```sh
./install-graalvm.sh
```

#### GraalVM and Native Image Installation Instructions
- Getting Started
  - https://www.graalvm.org/docs/getting-started/macos/
  - https://www.graalvm.org/docs/getting-started/linux/
- https://www.graalvm.org/reference-manual/native-image/#install-native-image
- https://www.graalvm.org/reference-manual/ruby/Installingzlib/
