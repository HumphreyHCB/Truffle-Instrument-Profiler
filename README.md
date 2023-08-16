#  Truffle Instrument Profiler


This Repository is for conducting tests on graalVM,  to test Instrument Profiler and how the deal with dynamic compilation

## How to Use

```
mvn clean package
bash scripts/build-java.sh
bash scripts/tool-launcher.sh

```

Some CMD that can be usefull

```
export PATH=<*path/to/grall*>/bin:$PATH

export JAVA_HOME=<*path/to/grall*>

$GRAALVM/bin/gu install nodejs
$GRAALVM/bin/gu install espresso

```
