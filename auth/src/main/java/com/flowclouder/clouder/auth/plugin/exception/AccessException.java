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

package com.flowclouder.clouder.auth.plugin.exception;

import com.flowclouder.clouder.common.exception.ClouderException;

/**
 * Exception to be thrown if authorization is failed.
 * @author kingkiller
 */
public class AccessException extends ClouderException {

    private static final long serialVersionUID = -2926344920552803270L;

    public AccessException() {

    }

    public AccessException(int code) {
        this.setErrCode(code);
    }

    public AccessException(String msg) {
        this.setErrMsg(msg);
    }

}
