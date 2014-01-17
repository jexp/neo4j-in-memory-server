package org.neo4j.server.inmemory;

import org.neo4j.server.CommunityNeoServer;
import org.neo4j.server.configuration.Configurator;
import org.neo4j.server.database.Database;
import org.neo4j.server.preflight.EnsurePreparedForHttpLogging;
import org.neo4j.server.preflight.PreFlightTasks;

/**
* @author mh
* @since 17.01.14
*/
public class InMemoryCommunityNeoServer extends CommunityNeoServer {
    public InMemoryCommunityNeoServer(Configurator configurator) {
        super(configurator);
    }

    @Override
    protected Database createDatabase() {
        return new InMemoryCommunityDatabase(configurator);
    }

    @Override
    protected PreFlightTasks createPreflightTasks() {
        return new PreFlightTasks(
            new EnsurePreparedForHttpLogging(configurator.configuration())
        );
    }
}
