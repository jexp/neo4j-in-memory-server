package org.neo4j.harness.internal;

import org.neo4j.kernel.GraphDatabaseDependencies;
import org.neo4j.kernel.configuration.Config;
import org.neo4j.logging.LogProvider;
import org.neo4j.server.CommunityBootstrapper;
import org.neo4j.server.NeoServer;
import org.neo4j.server.helpers.CommunityServerBuilder;

import java.io.IOException;

public class InMemoryBootstrapper extends CommunityBootstrapper {
    protected NeoServer createNeoServer(Config config, GraphDatabaseDependencies dependencies, LogProvider logProvider) {
        try {
            logProvider.getLog(InMemoryBootstrapper.class).warn("Starting In-Memory Server, use only for testing purposes");
            return CommunityServerBuilder.server(logProvider).withThirdPartyJaxRsPackage("org.neo4j.inmemory","/test").build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        InProcessServerBuilder builder = new InProcessServerBuilder();
//        builder.withConfig(GraphDatabaseFacadeFactory.Configuration.ephemeral.name(),"true");
//        return builder.createNeoServer(config.getParams(),dependencies,(FormattedLogProvider)logProvider);
    }
}
