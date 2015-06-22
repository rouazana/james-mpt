/****************************************************************
 * Licensed to the Apache Software Foundation (ASF) under one   *
 * or more contributor license agreements.  See the NOTICE file *
 * distributed with this work for additional information        *
 * regarding copyright ownership.  The ASF licenses this file   *
 * to you under the Apache License, Version 2.0 (the            *
 * "License"); you may not use this file except in compliance   *
 * with the License.  You may obtain a copy of the License at   *
 *                                                              *
 *   http://www.apache.org/licenses/LICENSE-2.0                 *
 *                                                              *
 * Unless required by applicable law or agreed to in writing,   *
 * software distributed under the License is distributed on an  *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY       *
 * KIND, either express or implied.  See the License for the    *
 * specific language governing permissions and limitations      *
 * under the License.                                           *
 ****************************************************************/
package org.apache.james.mpt.imapmailbox.cyrus.host;

import java.net.InetSocketAddress;

import org.apache.james.mpt.api.UserAdder;
import org.apache.james.mpt.host.ExternalHostSystem;
import org.apache.james.mpt.monitor.NullMonitor;

import com.google.common.base.Supplier;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;
import com.spotify.docker.client.messages.ContainerCreation;

@Singleton
public class CyrusHostSystem extends ExternalHostSystem implements Provider<ContainerCreation> {

    private static final String SHABANG = "* OK IMAP4rev1 Server ready";
    private final Docker docker;
    private Supplier<InetSocketAddress> addressSupplier;
    private ContainerCreation container;

    @Inject
    private CyrusHostSystem(Docker docker, UserAdder userAdder) {
        super(new NullMonitor(), SHABANG, userAdder);
        this.docker = docker;
        
    }

    @Override
    protected InetSocketAddress getAddress() {
        return addressSupplier.get();
    }
    
    public void beforeTest() throws Exception {
        container = docker.start();
        addressSupplier = new Supplier<InetSocketAddress>() {
            
            @Override
            public InetSocketAddress get() {
                return new InetSocketAddress(docker.getHost(container), docker.getIMAPPort(container));
            }
        };
    }

    public void afterTest() throws Exception {
        docker.stop(container);
        container = null;
        addressSupplier = null;
    }
    
    @Override
    public ContainerCreation get() {
        return container;
    }
}