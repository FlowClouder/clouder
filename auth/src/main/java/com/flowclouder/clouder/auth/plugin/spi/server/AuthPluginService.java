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

package com.flowclouder.clouder.auth.plugin.spi.server;

import com.flowclouder.clouder.auth.plugin.api.IdentityContext;
import com.flowclouder.clouder.auth.plugin.api.Permission;
import com.flowclouder.clouder.auth.plugin.api.Resource;
import com.flowclouder.clouder.auth.plugin.constant.ActionTypes;
import com.flowclouder.clouder.auth.plugin.exception.AccessException;

import java.util.Collection;

/**
 * Auth service.
 *
 * @author kingkiller
 */
public interface AuthPluginService {

    /**
     * Define which identity information needed from request. e.q: username, password, accessToken.
     * @return identity names
     */
    Collection<String> identityNames();

    /**
     * Judgement whether this plugin enable auth for this action and type.
     * @param action action of request, see {@link ActionTypes}
     * @param type   type of request, see {@link com.flowclouder.clouder.auth.plugin.constant.SignType}
     * @return {@code true} if enable auth, otherwise {@code false}
     */
    boolean enableAuth(ActionTypes action, String type);

    /**
     * To validate whether the identity context from request is legal or illegal.
     * @param identityContext where we can find the user information
     * @param resource        resource about this user information
     * @return {@code true} if legal, otherwise {@code false}
     * @throws AccessException if authentication is failed
     */
    boolean validateIdentity(IdentityContext identityContext, Resource resource) throws AccessException;

    /**
     * Validate the identity whether has the resource authority.
     * @param identityContext where we can find the user information.
     * @param permission      permission to auth.
     * @return Boolean if the user has the resource authority.
     * @throws AccessException if authentication is failed
     */
    Boolean validateAuthority(IdentityContext identityContext, Permission permission) throws AccessException;

    /**
     * AuthPluginService Name which for conveniently find AuthPluginService instance.
     * @return AuthServiceName mark a AuthPluginService instance.
     */
    String getAuthServiceName();

}
