/*
 * Copyright (c) 2022  Flow Clouder Organization Holding Ltd.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.flowclouder.clouder.common.exception.runtime;

import static com.flowclouder.clouder.common.constant.Constants.Exception.SERIALIZE_ERROR_CODE;

/**
 * Clouder Serialization exception
 * @author kingkiller
 */
public class ClouderSerializationException extends ClouderRuntimeException {

    private static final long serialVersionUID = -4308536346316915612L;

    private static final String DEFAULT_MSG = "Nacos serialize failed. ";

    private static final String MSG_FOR_SPECIFIED_CLASS = "Nacos serialize for class [%s] failed. ";

    private Class<?> serializedClass;

    public ClouderSerializationException() {
        super(SERIALIZE_ERROR_CODE);
    }

    public ClouderSerializationException(Class<?> serializedClass) {
        super(SERIALIZE_ERROR_CODE, String.format(MSG_FOR_SPECIFIED_CLASS, serializedClass.getName()));
        this.serializedClass = serializedClass;
    }

    public ClouderSerializationException(Throwable throwable) {
        super(SERIALIZE_ERROR_CODE, DEFAULT_MSG, throwable);
    }

    public ClouderSerializationException(Class<?> serializedClass, Throwable throwable) {
        super(SERIALIZE_ERROR_CODE, String.format(MSG_FOR_SPECIFIED_CLASS, serializedClass.getName()), throwable);
        this.serializedClass = serializedClass;
    }

    public Class<?> getSerializedClass() {
        return serializedClass;
    }
}
