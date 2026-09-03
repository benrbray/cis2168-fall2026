# Shapes Example

HappyCoding, ["Processing in Java"](https://happycoding.io/tutorials/java/processing-in-java)

## Installing Processing

We need the Processing CLI on our machine.  Download the `*.deb` and run:

```
dpkg -i processing.deb
```

(actually this wasn't necessary when installing processing with maven)

## Maven

[Maven in 5 Minutes](https://maven.apache.org/guides/getting-started/maven-in-five-minutes.html)

```
mvn install
mvn compile
```

## CLEAN JAVA LANGUAGE SERVER WORKSPACE

Ctrl+P

"Java:  Clean Java Language Server Workspace"

## Running Manually

## Why doesn't the VS Code play button work?

Running the Java program with VS Code ran this command, which **failed with an error**.

```
cd /home/ben/temple/courses/cis2168-f26/code/shapes ; /usr/bin/env /usr/lib/jvm/java-21-openjdk-amd64/bin/java @/tmp/cp_3drqc8a5hbn35xy8rjl0x879m.argfile cs2168.shapes.MySketch
```
```
Cannot run sketch without a display. Read this for possible solutions:
https://github.com/processing/processing/wiki/Running-without-a-Display
```

The `.argfile` listed above contains the following:

```
 -XX:+ShowCodeDetailsInExceptionMessages -cp "/home/ben/temple/courses/cis2168-f26/code/shapes/target/classes:/home/ben/.m2/repository/org/processing/core/4.5.6/core-4.5.6.jar:/home/ben/.m2/repository/org/jetbrains/kotlin/kotlin-stdlib/2.3.21/kotlin-stdlib-2.3.21.jar:/home/ben/.m2/repository/org/jetbrains/annotations/13.0/annotations-13.0.jar:/home/ben/.m2/repository/org/jogamp/jogl/jogl-all-main/2.6.0/jogl-all-main-2.6.0.jar:/home/ben/.m2/repository/org/jogamp/jogl/jogl-all/2.6.0/jogl-all-2.6.0.jar:/home/ben/.m2/repository/org/jogamp/jogl/jogl-all/2.6.0/jogl-all-2.6.0-natives-android-aarch64.jar:/home/ben/.m2/repository/org/jogamp/jogl/jogl-all/2.6.0/jogl-all-2.6.0-natives-android-x86_64.jar:/home/ben/.m2/repository/org/jogamp/jogl/jogl-all/2.6.0/jogl-all-2.6.0-natives-freebsd-amd64.jar:/home/ben/.m2/repository/org/jogamp/jogl/jogl-all/2.6.0/jogl-all-2.6.0-natives-linux-amd64.jar:/home/ben/.m2/repository/org/jogamp/jogl/jogl-all/2.6.0/jogl-all-2.6.0-natives-linux-armv6hf.jar:/home/ben/.m2/repository/org/jogamp/jogl/jogl-all/2.6.0/jogl-all-2.6.0-natives-linux-aarch64.jar:/home/ben/.m2/repository/org/jogamp/jogl/jogl-all/2.6.0/jogl-all-2.6.0-natives-macosx-universal.jar:/home/ben/.m2/repository/org/jogamp/jogl/jogl-all/2.6.0/jogl-all-2.6.0-natives-windows-amd64.jar:/home/ben/.m2/repository/org/jogamp/gluegen/gluegen-rt-main/2.6.0/gluegen-rt-main-2.6.0.jar:/home/ben/.m2/repository/org/jogamp/gluegen/gluegen-rt/2.6.0/gluegen-rt-2.6.0.jar:/home/ben/.m2/repository/org/jogamp/gluegen/gluegen-rt/2.6.0/gluegen-rt-2.6.0-natives-android-aarch64.jar:/home/ben/.m2/repository/org/jogamp/gluegen/gluegen-rt/2.6.0/gluegen-rt-2.6.0-natives-android-x86_64.jar:/home/ben/.m2/repository/org/jogamp/gluegen/gluegen-rt/2.6.0/gluegen-rt-2.6.0-natives-freebsd-amd64.jar:/home/ben/.m2/repository/org/jogamp/gluegen/gluegen-rt/2.6.0/gluegen-rt-2.6.0-natives-linux-amd64.jar:/home/ben/.m2/repository/org/jogamp/gluegen/gluegen-rt/2.6.0/gluegen-rt-2.6.0-natives-linux-armv6hf.jar:/home/ben/.m2/repository/org/jogamp/gluegen/gluegen-rt/2.6.0/gluegen-rt-2.6.0-natives-linux-aarch64.jar:/home/ben/.m2/repository/org/jogamp/gluegen/gluegen-rt/2.6.0/gluegen-rt-2.6.0-natives-macosx-universal.jar:/home/ben/.m2/repository/org/jogamp/gluegen/gluegen-rt/2.6.0/gluegen-rt-2.6.0-natives-windows-amd64.jar:/home/ben/.m2/repository/antlr/antlr/2.7.7/antlr-2.7.7.jar"
```

Explicitly setting the Java version to 25 was required, because it was using a (headless?) version of Java 21 instead.

```
<!-- Use Java 25-->
<properties>
  <maven.compiler.source>25</maven.compiler.source>
  <maven.compiler.target>25</maven.compiler.target>
  <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
</properties>
```