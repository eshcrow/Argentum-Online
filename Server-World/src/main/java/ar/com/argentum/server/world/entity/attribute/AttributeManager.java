/**
 * This file is part of Argentum Online <https://github.com/Argentum-Online/Game-Server>.
 *
 * Copyright (c) 2015-2016 - Argentum Online Team <https://github.com/Argentum-Online>.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package ar.com.argentum.server.world.entity.attribute;

import java.util.Optional;

/**
 * Represents a manager which handles {@linkplain Attribute}(s).
 *
 * @author Agustin L. Alvarez <wolftein1@gmail.com>
 */
public interface AttributeManager {
    /**
     * Register a new {@linkplain Attribute}.
     * </p>
     * NOTE: If the attribute is already registered, an {@linkplain IllegalStateException} is thrown.
     *
     * @param type the {@linkplain AttributeType} identifier of the attribute.
     *
     * @return a reference to the {@linkplain Attribute} registered.
     */
    Attribute registerAttribute(AttributeType type);

    /**
     * Unregister an {@linkplain Attribute}.
     *
     * @param type the {@linkplain AttributeType} identifier of the attribute.
     *
     * @return an {@linkplain Optional} reference of the {@linkplain Attribute} unregistered.
     */
    Optional<Attribute> unregisterAttribute(AttributeType type);

    /**
     * Retrieves an {@linkplain Attribute}.
     *
     * @param type the {@linkplain AttributeType} identifier of the attribute.
     *
     * @return an {@linkplain Optional} reference of the {@linkplain Attribute} with the given identifier.
     */
    Optional<Attribute> getAttribute(AttributeType type);
}
