# Neo4j-In-Memory Server for Neo4j 3.1.x

**Only for Testing**

Uses the Neo4j ImpermanentGraphDatabase as Database for your Neo4j server.
So should not access disk but needs more RAM as it writes / reads all the data from an in-memory filesystem abstraction.

Might be faster to start and incur less transactional overhead.

To deploy run `copy.sh /path/to/neo4j-3.1.1` to build the latest version and add this bootstrap file into that server.  

or unzip the provided [inmemory-server-3.1.zip](https://dl.dropboxusercontent.com/u/14493611/inmemory-server-3.1.zip) in your `$NEO4J_HOME/lib` directory.

Content of `inmemory-server-3.1.zip`:

* neo4j-server-3.1.1-tests.jar
* neo4j-kernel-3.1.1-tests.jar
* neo4j-io-3.1.1-tests.jar
* inmemory-3.1-SNAPSHOT.jar

And restart your server, it will not keep content across restarts.

and there is an REST endpoint to delete the db content while the server is running.

`curl -XDELETE http://localhost:7474/test/clean`

The in-memory server will be picked up automatically.

Starts / Restarts should also be faster.
