package org.neo4j.server.inmemory;

import org.neo4j.server.CommunityBootstrapper;
import org.neo4j.server.NeoServer;

public class InMemoryBootstrapper extends CommunityBootstrapper {
    @Override
    protected NeoServer createNeoServer() {
        return new InMemoryCommunityNeoServer(createConfigurator());
    }
}
