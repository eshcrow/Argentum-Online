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
 * Enumerates all alignment of an {@linkplain Alignment}.
 */
public enum Orientation {
    /**
     * Possible: Chaotic Good, Chaotic Neutral, Chaotic Evil.
     */
    CHAOTIC,

    /**
     * Possible: Lawful Good, Lawful Neutral, Lawful Evil.
     */
    LAWFUL,

    /**
     * Possible: Neutral Good, Neutral, Neutral Evil.
     */
    NUETRAL;

    /**
     * An array that contain(s) all enumeration values.
     */
    public static final Orientation[] VALUES = Orientation.values();
    public static final int LENGTH = VALUES.length;

    /**
     * Retrieve the enumeration value given the index.
     *
     * @param index the index of the enumeration.
     *
     * @return the enumeration representation of the given index.
     */
    public static Orientation getEnumeration(int index) {
        if (index < 0 || index >= LENGTH) {
            throw new IllegalArgumentException("Enumeration index is out of bounds");
        }
        return VALUES[index];
    }
}
