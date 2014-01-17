# Neo4j-In-Memory Server

**Only for Testing**

Uses the Neo4j ImpermanentGraphDatabase as Database for your Neo4j server.
So should not access disk but needs more RAM as it writes / reads all the data from an in-memory filesystem abstraction.

Might be faster to start and incur less transactional overhead.

To deploy run `copy.sh /path/to/neo4j-2.0.0` to build the latest version or unzip
the provided [inmemory-server-2.0.zip](./inmemory-server-2.0.zip) in your `/path/to/neo4j-2.0.0/system/lib` directory.

Content of `inmemory-server-2.0.zip`:

* inmemory-2.0-SNAPSHOT.jar
* neo4j-kernel-2.0.0-tests.jar

And restart your server.

The in-memory server will be picked up automatically.
