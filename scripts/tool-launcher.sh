#!/bin/sh -

PROJECT_ROOT_DIR="$(pwd)"
JAVA_CLASS_PATH_DIR="${PROJECT_ROOT_DIR}/classes"
SIMPLETOOL_JAR="${PROJECT_ROOT_DIR}/target/TCtool.jar"
JARS="${PROJECT_ROOT_DIR}/target/jars/*"

java --class-path "$JAVA_CLASS_PATH_DIR":"$JARS":. \
    "-Dtruffle.class.path.append=${SIMPLETOOL_JAR}" \
    launchers.EspressoLauncher sortingtest
