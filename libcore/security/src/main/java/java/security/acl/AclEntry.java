/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

/**
* @author Aleksei Y. Semenov
* @version $Revision$
*/

package java.security.acl;

import java.security.Principal;
import java.util.Enumeration;

/**
 * @com.intel.drl.spec_ref
 * 
 */

public interface AclEntry extends Cloneable {

    /**
     * @com.intel.drl.spec_ref
     */
    boolean setPrincipal(Principal user);
    
    /**
     * @com.intel.drl.spec_ref
     */
    Principal getPrincipal();
    
    /**
     * @com.intel.drl.spec_ref
     */
    void setNegativePermissions();
    
    /**
     * @com.intel.drl.spec_ref
     */
    boolean isNegative();
    
    /**
     * @com.intel.drl.spec_ref
     */
    boolean addPermission(Permission permission);
    
    /**
     * @com.intel.drl.spec_ref
     */
    boolean removePermission(Permission permission);
    
    /**
     * @com.intel.drl.spec_ref
     */
    boolean checkPermission(Permission permission);
    
    /**
     * @com.intel.drl.spec_ref
     */
    Enumeration<Permission> permissions();
    
    /**
     * @com.intel.drl.spec_ref
     */
    String toString();
    
    /**
     * @com.intel.drl.spec_ref
     */
    Object clone();
    
}
