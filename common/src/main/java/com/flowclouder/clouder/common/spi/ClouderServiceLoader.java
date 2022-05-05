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

package com.flowclouder.clouder.common.spi;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Clouder SPI Service Loader.
 *
 * @author kingkiller
 */
public class ClouderServiceLoader {

    private static final Map<Class<?>, Collection<Class<?>>> SERVICES = new ConcurrentHashMap<>();

    /**
     * Load service
     *
     * <p>Load service by SPI and cache the classes for reducing cost when load second time.</p>
     *
     * @param service service class
     * @param <T> type of service
     * @return service instances
     */
    public static <T> Collection<T> load(final Class<T> service) {
        if (SERVICES.containsKey(service)) {
            return newServiceInstances(service);
        }
        Collection<T> result = new LinkedHashSet<>();
        for (T each : ServiceLoader.load(service)) {
            result.add(each);
            cacheServiceClass(service, each);
        }
        return result;
    }

    private static <T> void cacheServiceClass(final  Class<T> service, final T instance) {
        if (!SERVICES.containsKey(service)) {
            SERVICES.put(service, new LinkedHashSet<Class<?>>());
        }
        SERVICES.get(service).add(instance.getClass());
    }

    /**
     * New service instances.
     * @param service service class
     * @param <T> type of service
     * @return service instances
     */
    public static <T> Collection<T> newServiceInstances(final Class<T> service) {
        return SERVICES.containsKey(service) ? newServiceInstanceFromCache(service) : Collections.<T>emptyList();
    }


    @SuppressWarnings("unchecked")
    private static <T> Collection<T> newServiceInstanceFromCache(Class<T> service) {
        Collection<T> result = new LinkedHashSet<T>();
        for (Class<?> each : SERVICES.get(service)) {
            result.add((T) newServiceInstance(each));
        }
        return result;
    }


    private static Object newServiceInstance(final Class<?> clazz) {
        try {
            return clazz.newInstance();
        } catch (IllegalAccessException | InstantiationException e) {
            throw new ServiceLoaderException(clazz, e);
        }
    }

}
