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

/**
 * Enumerates all possible heading of an entity.
 */
public enum Heading {
    /**
     * North heading.
     */
    NORTH,

    /**
     * East heading.
     */
    EAST,

    /**
     * South heading.
     */
    SOUTH,

    /**
     * West heading.
     */
    WEST,

    /**
     * No heading.
     */
    NONE;

    /**
     * An array that contain(s) all enumeration values.
     */
    public static final Heading[] VALUES = Heading.values();
    public static final int LENGTH = VALUES.length;

    /**
     * Retrieve the enumeration value given the indice.
     *
     * @param index the index of the enumeration.
     *
     * @return the enumeration representation of the given index.
     */
    public static Heading getEnumeration(int index) {
        if (index < 0 || index >= LENGTH) {
            throw new IllegalArgumentException("Enumeration index is out of bounds");
        }
        return VALUES[index];
    }
}