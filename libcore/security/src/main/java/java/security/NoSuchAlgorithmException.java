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
 * Instances of this class are thrown when an attempt is made to access an
 * algorithm which is not provided by the library.
 * 
 * @see Throwable
 */
public class NoSuchAlgorithmException extends GeneralSecurityException {

    /**
     * @com.intel.drl.spec_ref
     */
    private static final long serialVersionUID = -7443947487218346562L;

    /**
     * Constructs a new instance of this class with its walkback and message
     * filled in.
     * 
     * 
     * @param msg
     *            String The detail message for the exception.
     */
    public NoSuchAlgorithmException(String msg) {
        super(msg);
    }

    /**
     * Constructs a new instance of this class with its walkback filled in.
     * 
     */
    public NoSuchAlgorithmException() {
    }

    /**
     * @com.intel.drl.spec_ref
     */
    public NoSuchAlgorithmException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @com.intel.drl.spec_ref
     */
    public NoSuchAlgorithmException(Throwable cause) {
        super(cause);
    }
}
