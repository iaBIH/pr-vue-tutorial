#!/bin/bash

./mvnw -q install:install-file -Dfile=lib/arx-3.9-main.jar -DgroupId=org.deidentifier -DartifactId=libarx -Dversion=3.9.0 -Dpackaging=jar
./mvnw clean package
