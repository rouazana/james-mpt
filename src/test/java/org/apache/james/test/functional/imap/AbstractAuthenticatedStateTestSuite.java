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

package org.apache.james.test.functional.imap;


abstract public class AbstractAuthenticatedStateTestSuite extends BaseTestForAuthenticatedState {

    public AbstractAuthenticatedStateTestSuite(HostSystem system) throws Exception
    {
        super(system);
    }

    public void testNoop() throws Exception {
        scriptTest("Noop"); 
    }
    
    public void testLogout() throws Exception {
        scriptTest("Logout"); 
    }
    
    public void testCapability() throws Exception {
        scriptTest("Capability"); 
    }
    
    public void testAppendExamineInbox() throws Exception {
        scriptTest("AppendExamineInbox");
    }

    public void testAppendSelectInbox() throws Exception {
        scriptTest("AppendSelectInbox");
    }
    
    public void testCreate() throws Exception {
        scriptTest("Create"); 
    }
    
    public void testExamineEmpty() throws Exception {
        scriptTest("ExamineEmpty"); 
    }
    
    public void testSelectEmpty() throws Exception {
        scriptTest("SelectEmpty");
    }
        
    public void testListNamespace() throws Exception {
        scriptTest("ListNamespace"); 
    }
    
    public void testListMailboxes() throws Exception {
        scriptTest("ListMailboxes");
    }
    
    public void testStatus() throws Exception {
        scriptTest("Status"); 
    }
    
    public void testSubscribe() throws Exception {
        scriptTest("Subscribe");
    }
    
    public void testDelete() throws Exception {
        scriptTest("Delete"); 
    }
    
    public void testAppend() throws Exception {
        scriptTest("Append");
    }
    
    public void testAppendExpunge() throws Exception {
        scriptTest("AppendExpunge");
    }
    
    public void testSelectAppend() throws Exception {
        scriptTest("SelectAppend");
    }
    
    public void testStringArgs() throws Exception {
        scriptTest("StringArgs");
    }
    
    public void testValidNonAuthenticated() throws Exception {
        scriptTest("ValidNonAuthenticated");
    }
}