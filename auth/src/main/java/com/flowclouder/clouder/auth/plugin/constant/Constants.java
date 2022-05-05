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

package com.flowclouder.clouder.auth.plugin.constant;

/**
 * All the constants
 * @author kingkiller
 */
public class Constants {

    public static class Auth {

        public static final String CLOUDER_CORE_AUTH_ENABLE = "clouder.core.auth.enable";

        public static final String CLOUDER_CORE_AUTH_SYSTEM_TYPE = "clouder.core.auth.system.type";

        public static final String CLOUDER_CORE_AUTH_CACHING_ENABLED = "clouder.core.auth.caching.enable";

        public static final String CLOUDER_CORE_AUTH_SEVER_IDENTITY_KEY = "clouder.core.auth.server.identity.key";

        public static final String CLOUDER_CORE_AUTH_SERVER_IDENTITY_VALUE = "clouder.core.auth.server.identity.value";

        public static final String CLOUDER_CORE_AUTH_ENABLE_USER_AGENT_AUTH_WHITE = "clouder.core.auth.enable.userAgentAuthWhite";

    }

    public static class Resource {

        public static final String SPLITTER = ":";

        public static final String ANY = "*";

        public static final String ACTION = "action";

        public static final String REQUEST_CLASS = "requestClass";

    }

    public static class Identity {

        public static final String IDENTITY_ID = "identity_id";

        public static final String X_REAL_IP = "X-Real-IP";

        public static final String REMOTE_IP = "remote_ip";

    }

}
