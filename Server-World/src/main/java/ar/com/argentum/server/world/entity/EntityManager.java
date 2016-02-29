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
package ar.com.argentum.server.world.entity;

import java.util.Optional;

/**
 * Represents a manager which handle {@linkplain Entity}(s).
 *
 * @author Agustin L. Alvarez <wolftein1@gmail.com>
 */
public interface EntityManager {
    /**
     * Retrieves an {@linkplain Entity}.
     *
     * @param id the unique identifier of the entity.
     *
     * @return an {@linkplain Optional} reference of the {@linkplain Entity} with the given identifier.
     */
    Optional<Entity> getEntity(int id);

    /**
     * Perform the movement operation of an {@linkplain Entity}.
     *
     * @param entity  the {@linkplain Entity} of the operation.
     * @param heading the {@linkplain Heading} of the operation.
     *
     * @return {@linkplain Boolean#TRUE} if the operation succeed, {@linkplain Boolean#FALSE} otherwise.
     */
    boolean move(Entity entity, Heading heading);

    /**
     * Perform the teleport operation of an {@linkplain Entity}.
     *
     * @param entity the {@linkplain Entity} of the operation.
     * @param x      the target x coordinate (in world coordinates) of the operation.
     * @param y      the target y coordinate (in world coordinates) of the operation.
     *
     * @return {@linkplain Boolean#TRUE} if the operation succeed, {@linkplain Boolean#FALSE} otherwise.
     */
    boolean teleport(Entity entity, int x, int y);
}
