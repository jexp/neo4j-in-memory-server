#!/bin/bash

NEO=$1

if [ ! $NEO ]; then echo "Usage copy.sh /path/to/neo";exit 1;fi
	
mvn package
mvn dependency:copy-dependencies
cp target/inmemory-2.0-SNAPSHOT.jar target/dependency/neo4j-kernel-2.0.0-tests.jar ${NEO}/system/lib/

rm inmemory-server-2.0.zip 
zip -j inmemory-server-2.0.zip target/inmemory-2.0-SNAPSHOT.jar target/dependency/neo4j-kernel-2.0.0-tests.jar