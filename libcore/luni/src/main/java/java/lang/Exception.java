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
 * This class is the superclass of all classes which represent recoverable
 * exceptions. When Exceptions are thrown, they may be caught by application
 * code.
 * 
 * @see Throwable
 * @see Error
 * @see RuntimeException
 */
public class Exception extends Throwable {
    private static final long serialVersionUID = -3387516993124229948L;

    /**
     * Constructs a new instance of this class with its walkback filled in.
     */
    public Exception() {
        super();
    }

    /**
     * Constructs a new instance of this class with its walkback and message
     * filled in.
     * 
     * @param detailMessage
     *            String The detail message for the exception.
     */
    public Exception(String detailMessage) {
        super(detailMessage);
    }

    /**
     * Constructs a new instance of this class with its walkback, message and
     * cause filled in.
     * 
     * @param detailMessage
     *            String The detail message for the exception.
     * @param throwable
     *            The cause of this Throwable
     */
    public Exception(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    /**
     * Constructs a new instance of this class with its walkback and cause
     * filled in.
     * 
     * @param throwable
     *            The cause of this Throwable
     */
    public Exception(Throwable throwable) {
        super(throwable);
    }
}
