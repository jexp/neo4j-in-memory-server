/**
 * Copyright (c) 2002-2013 "Neo Technology,"
 * Network Engine for Objects in Lund AB [http://neotechnology.com]
 *
 * This file is part of Neo4j.
 *
 * Neo4j is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.neo4j.server.inmemory;

import org.neo4j.server.CommunityNeoServer;
import org.neo4j.server.configuration.PropertyFileConfigurator;
import org.neo4j.server.database.Database;
import org.neo4j.server.inmemory.InMemoryCommunityNeoServer;
import org.neo4j.test.ImpermanentGraphDatabase;

import java.io.File;
import java.net.URI;
import java.net.URL;

import static org.neo4j.helpers.collection.IteratorUtil.asCollection;

/**
 * @author mh
 * @since 24.03.11
 */
public class LocalTestServer {
    private CommunityNeoServer neoServer;
    protected String propertiesFile = "test-db.properties";


    public void start() {
        if (neoServer != null) throw new IllegalStateException("Server already running");
        URL url = getClass().getResource("/" + propertiesFile);
        if (url == null) throw new IllegalArgumentException("Could not resolve properties file " + propertiesFile);
        neoServer = new InMemoryCommunityNeoServer(new PropertyFileConfigurator(new File(url.getPath())));
        neoServer.start();
    }

    public void stop() {
        try {
            neoServer.stop();
        } catch (Exception e) {
            System.err.println("Error stopping server: " + e.getMessage());
        }
        neoServer = null;
    }

    private Database getDatabase() {
        return neoServer.getDatabase();
    }

    public URI baseUri() {
        return neoServer.baseUri();
    }

    public void cleanDb() {
        getGraphDatabase().cleanContent();
    }

    public ImpermanentGraphDatabase getGraphDatabase() {
        return ((ImpermanentGraphDatabase) getDatabase().getGraph());
    }
}
