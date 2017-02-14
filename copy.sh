#!/bin/bash

NEO=$1

if [ ! $NEO ]; then echo "Usage copy.sh /path/to/neo";exit 1;fi

echo "You need Apache Maven installed."

mvn clean package
mvn dependency:copy-dependencies
cp target/dependency/neo4j-server-*-tests.jar target/dependency/neo4j-kernel-*-tests.jar target/dependency/neo4j-io-*-tests.jar target/inmemory-*.jar ${NEO}/lib/

rm inmemory-server-3.1.zip
zip -j inmemory-server-3.1.zip target/dependency/neo4j-server-*-tests.jar target/dependency/neo4j-kernel-*-tests.jar target/dependency/neo4j-io-*-tests.jar target/inmemory-*.jar
