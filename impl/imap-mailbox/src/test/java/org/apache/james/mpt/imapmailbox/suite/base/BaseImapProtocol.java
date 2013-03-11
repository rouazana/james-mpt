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
package org.apache.james.mpt.imapmailbox.suite.base;

import org.apache.james.mpt.api.HostSystem;
import org.apache.james.mpt.imapmailbox.ImapTestConstants;
import org.apache.james.mpt.script.AbstractSimpleScriptedTestProtocol;

/**
 * Specialise the protocol test framework for IMAP.
 */
public abstract class BaseImapProtocol extends AbstractSimpleScriptedTestProtocol implements ImapTestConstants {

    public BaseImapProtocol(final HostSystem hostSystem) throws Exception {
        super(hostSystem, USER, PASSWORD, "/org/apache/james/imap/scripts/");
    }

}
