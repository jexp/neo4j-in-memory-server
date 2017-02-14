package org.neo4j.inmemory;

import org.neo4j.graphdb.GraphDatabaseService;
import org.neo4j.test.GraphDatabaseServiceCleaner;

import javax.ws.rs.DELETE;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

/**
 * @author mh
 * @since 14.02.17
 */
@Path("/")
public class CleanResource {

    @DELETE
    @Path("/clean")
    public Response clean(@Context GraphDatabaseService gds) {
        GraphDatabaseServiceCleaner.cleanDatabaseContent(gds);
        return Response.ok().build();
    }
}
