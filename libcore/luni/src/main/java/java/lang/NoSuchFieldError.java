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

package java.lang;


/**
 * This error is thrown when the VM notices that a an attempt is being made to
 * reference a field of a class which does not exist in that class.
 * <p>
 * Note that this can only occur when inconsistant class files are being loaded.
 */
public class NoSuchFieldError extends IncompatibleClassChangeError {

    private static final long serialVersionUID = -3456430195886129035L;

    /**
     * Constructs a new instance of this class with its walkback filled in.
     */
    public NoSuchFieldError() {
        super();
    }

    /**
     * Constructs a new instance of this class with its walkback and message
     * filled in.
     * 
     * @param detailMessage
     *            String The detail message for the exception.
     */
    public NoSuchFieldError(String detailMessage) {
        super(detailMessage);
    }
}
