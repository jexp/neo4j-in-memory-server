#!/bin/bash

NEO=$1

if [ ! $NEO ]; then echo "Usage restore.sh /path/to/neo";exit 1;fi
	
rm ${NEO}/system/lib/inmemory-2.0-SNAPSHOT.jar ${NEO}/system/lib/neo4j-kernel-2.0.0-tests.jar