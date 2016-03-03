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
 * Enumerates all alignment of an {@linkplain com.artemis.Entity}.
 */
public enum Alignment {
    /**
     * Good means it combines honor and compassion.
     */
    GOOD,

    /**
     * Neutral means acts naturally without prejudice or compulsion.
     */
    NEUTRAL,

    /**
     * evil beings believe combines self-interest and pure freedom.
     */
    EVIL;

    /**
     * An array that contain(s) all enumeration values.
     */
    public static final Alignment[] VALUES = Alignment.values();
    public static final int LENGTH = VALUES.length;

    /**
     * Retrieve the enumeration value given the index.
     *
     * @param index the index of the enumeration.
     *
     * @return the enumeration representation of the given index.
     */
    public static Alignment getEnumeration(int index) {
        if (index < 0 || index >= LENGTH) {
            throw new IllegalArgumentException("Enumeration index is out of bounds");
        }
        return VALUES[index];
    }

    /**
     * Retrieves the {@linkplain Relation} of both {@linkplain Alignment}.
     *
     * @param first  the first alignment for the comparison.
     * @param second the second alignment for the comparison.
     *
     * @return {@linkplain Relation} of the given {@linkplain Alignment}.
     */
    public static Relation getRelation(Alignment first, Alignment second) {
        switch (first) {
            case GOOD:
                switch (second) {
                    case EVIL:
                        return Relation.ENEMY;
                    case GOOD:
                        return Relation.ALLY;
                    case NEUTRAL:
                        return Relation.NEUTRAL;
                }
                throw new IllegalArgumentException("Alignment is unsupported");
            case EVIL:
                switch (second) {
                    case EVIL:
                        return Relation.ALLY;
                    case GOOD:
                        return Relation.ENEMY;
                    case NEUTRAL:
                        return Relation.NEUTRAL;
                }
                throw new IllegalArgumentException("Alignment is unsupported");
            case NEUTRAL:
                return Relation.NEUTRAL;
        }
        throw new IllegalArgumentException("Alignment is unsupported");
    }
}
