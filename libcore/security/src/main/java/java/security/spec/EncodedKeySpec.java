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
* @author Vladimir N. Molotkov
* @version $Revision$
*/

package java.security.spec;

/**
 * @com.intel.drl.spec_ref
 * 
 */
public abstract class EncodedKeySpec implements KeySpec {
    // Encoded key
    private final byte[] encodedKey;

    /**
     * @com.intel.drl.spec_ref
     */
    public EncodedKeySpec(byte[] encodedKey) {
        // Defensively copies parameter
        // to prevent subsequent modification
        this.encodedKey = new byte[encodedKey.length];
        System.arraycopy(encodedKey, 0,
                this.encodedKey, 0, this.encodedKey.length);
    }

    /**
     * @com.intel.drl.spec_ref
     */
    public byte[] getEncoded() {
        // Defensively copies private array
        // to prevent subsequent modification
        byte[] ret = new byte[encodedKey.length];
        System.arraycopy(encodedKey, 0, ret, 0, ret.length);
        return ret;
    }

    /**
     * @com.intel.drl.spec_ref
     */
    public abstract String getFormat();
}
