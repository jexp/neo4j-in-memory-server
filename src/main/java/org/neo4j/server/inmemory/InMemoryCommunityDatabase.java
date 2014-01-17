package org.neo4j.server.inmemory;

import org.neo4j.graphdb.factory.GraphDatabaseSettings;
import org.neo4j.helpers.Settings;
import org.neo4j.kernel.AbstractGraphDatabase;
import org.neo4j.server.configuration.Configurator;
import org.neo4j.server.database.CommunityDatabase;
import org.neo4j.test.TestGraphDatabaseFactory;

import java.util.Map;

import static org.neo4j.server.configuration.Configurator.DATABASE_LOCATION_PROPERTY_KEY;
import static org.neo4j.server.configuration.Configurator.DEFAULT_DATABASE_LOCATION_PROPERTY_KEY;

/**
 * @author mh
 * @since 17.01.14
 */
class InMemoryCommunityDatabase extends CommunityDatabase {
    public InMemoryCommunityDatabase(Configurator configurator) {
        super(configurator);
    }

    @Override
    protected AbstractGraphDatabase createDb() {
        return (AbstractGraphDatabase) new TestGraphDatabaseFactory()
                .newImpermanentDatabaseBuilder()
                .setConfig(getDbTuningPropertiesWithServerDefaults())
                .newGraphDatabase();
    }

    @Override
    protected Map<String, String> getDbTuningPropertiesWithServerDefaults() {
        Map<String, String> config = super.getDbTuningPropertiesWithServerDefaults();
        config.put(GraphDatabaseSettings.keep_logical_logs.name(), Settings.FALSE);
        return config;
    }
}
