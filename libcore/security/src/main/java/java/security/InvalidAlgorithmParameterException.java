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
* @author Vera Y. Petrashkova
* @version $Revision$
*/

package java.security;

/**
 * This class represents invalid algorithm parameters to cryptographic services.
 * 
 */
public class InvalidAlgorithmParameterException extends
        GeneralSecurityException {
    /**
     * @com.intel.drl.spec_ref
     */
    private static final long serialVersionUID = 2864672297499471472L;

    /**
     * Constructs a new instance of this class with its walkback and message
     * filled in.
     * 
     * 
     * @param msg
     *            String The detail message for the exception.
     */
    public InvalidAlgorithmParameterException(String msg) {
        super(msg);
    }

    /**
     * Constructs a new instance of this class with its walkback filled in.
     * 
     */
    public InvalidAlgorithmParameterException() {
    }

    /**
     * @com.intel.drl.spec_ref
     */
    public InvalidAlgorithmParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @com.intel.drl.spec_ref
     */
    public InvalidAlgorithmParameterException(Throwable cause) {
        super(cause);
    }
}
