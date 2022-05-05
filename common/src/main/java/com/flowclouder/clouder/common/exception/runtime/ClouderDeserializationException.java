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


import java.lang.reflect.Type;

import static com.flowclouder.clouder.common.constant.Constants.Exception.DESERIALIZE_ERROR_CODE;

/**
 * Clouder deserialization exception.
 * @author kingkiller
 */
public class ClouderDeserializationException extends ClouderRuntimeException{

    private static final long serialVersionUID = -2742350751684273728L;

    private static final String DEFAULT_MSG = "Nacos deserialize failed. ";

    private static final String MSG_FOR_SPECIFIED_CLASS = "Nacos deserialize for class [%s] failed. ";

    private Class<?> targetClass;

    public ClouderDeserializationException() {
        super(DESERIALIZE_ERROR_CODE);
    }

    public ClouderDeserializationException(Class<?> targetClass) {
        super(DESERIALIZE_ERROR_CODE, String.format(MSG_FOR_SPECIFIED_CLASS, targetClass.getName()));
        this.targetClass = targetClass;
    }

    public ClouderDeserializationException(Type targetType) {
        super(DESERIALIZE_ERROR_CODE, String.format(MSG_FOR_SPECIFIED_CLASS, targetType.toString()));
    }

    public ClouderDeserializationException(Throwable throwable) {
        super(DESERIALIZE_ERROR_CODE, DEFAULT_MSG, throwable);
    }

    public ClouderDeserializationException(Class<?> targetClass, Throwable throwable) {
        super(DESERIALIZE_ERROR_CODE, String.format(MSG_FOR_SPECIFIED_CLASS, targetClass.getName()), throwable);
        this.targetClass = targetClass;
    }

    public ClouderDeserializationException(Type targetType, Throwable throwable) {
        super(DESERIALIZE_ERROR_CODE, String.format(MSG_FOR_SPECIFIED_CLASS, targetType.toString()), throwable);
    }

    public Class<?> getTargetClass() {
        return targetClass;
    }

}
