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

package com.flowclouder.clouder.common.model;

import java.io.Serializable;

/**
 * Response Util Class
 * @author kingkiller
 */
public class Response<T> implements Serializable {

    private static final long serialVersionUID = -6285932585951691898L;

    private boolean success;

    private Integer code;

    private String message;

    private T data;

    public Response() {
    }

    public Response(T data) {
        this.success = true;
        this.code = 200;
        this.message = "success";
        this.data = data;
    }

    public Response(Integer code, String message) {
        this.success = false;
        this.code = code;
        this.message = message;
    }

    public boolean isSuccess() {
        return this.success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
