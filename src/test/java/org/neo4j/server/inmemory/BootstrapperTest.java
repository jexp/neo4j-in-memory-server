package org.neo4j.server.inmemory;

import org.neo4j.harness.internal.InMemoryBootstrapper;
import org.neo4j.server.ServerBootstrapper;

/**
 * @author mh
 * @since 17.01.14
 */
public class BootstrapperTest {
    public static void main(String[] args) {
        ServerBootstrapper.start(new InMemoryBootstrapper(),"--home-dir","/tmp/test");
    }
}
