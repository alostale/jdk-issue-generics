# jdk-issue-generics
Simple case to reproduce issue with generics in JDK 9

With JDK 9+ (tested with 9, 10.0.1 and 11ea18) run:

```
mvn clean test
...
[INFO] Compiling 1 source file to /tmp/jdk-issue-generics/target/test-classes
[INFO] -------------------------------------------------------------
[ERROR] COMPILATION ERROR : 
[INFO] -------------------------------------------------------------
[ERROR] /tmp/jdk-issue-generics/src/test/java/org/alostale/issues/generics/TestGenerics.java:[17,17] no suitable method found for assertThat(java.lang.String,java.util.List<java.lang.String>,org.hamcrest.Matcher<java.lang.Iterable<? super java.lang.Object>>)
    method org.junit.Assert.<T>assertThat(java.lang.String,T,org.hamcrest.Matcher<? super T>) is not applicable
      (inference variable T has incompatible bounds
        upper bounds: java.lang.String,java.lang.Object
        lower bounds: capture#1 of ? super T?,capture#2 of ? super java.lang.Object,capture#3 of ? super java.lang.Object,java.lang.Object,java.lang.String,capture#4 of ? super T?)
    method org.junit.Assert.<T>assertThat(T,org.hamcrest.Matcher<? super T>) is not applicable
      (cannot infer type-variable(s) T
        (actual and formal argument lists differ in length))
[INFO] 1 error
```

The same ran with previous JDK (1.8.0_171 and 1.7.0_95) versions works fine.

Reported as [JDK bug](https://bugs.openjdk.java.net/browse/JDK-8206142).
