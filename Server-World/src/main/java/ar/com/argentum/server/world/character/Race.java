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
package ar.com.argentum.server.world.character;

import java.util.Objects;

/**
 * Represent a race definition for an {@linkplain Character}.
 *
 * @author Agustin L. Alvarez <wolftein1@gmail.com>
 */
public final class Race {
    private final String mName;
    private final int mHitpoint;
    private final int mManapoint;
    private final int mEnergy;
    private final int mAttributes[];

    /**
     * Constructor for {@link Race}.
     *
     * @param name       the name of the race.
     * @param hitpoint   the base hitpoint value of the race.
     * @param manapoint  the base manapoint value of the race.
     * @param energy     the base energy value of the race.
     * @param attributes an array that contain(s) all attribute(s) of the race.
     */
    public Race(String name, int hitpoint, int manapoint, int energy, int[] attributes) {
        this.mName = name;
        this.mHitpoint = hitpoint;
        this.mManapoint = manapoint;
        this.mEnergy = energy;
        this.mAttributes = attributes;
    }

    /**
     * Retrieves the name of the {@linkplain Race}.
     *
     * @return the name for identify the race.
     */
    public String getName() {
        return mName;
    }

    /**
     * Retrieves the base hitpoint of the {@linkplain Race}.
     *
     * @return the base hitpoint.
     */
    public int getHitpoint() {
        return mHitpoint;
    }

    /**
     * Retrieves the base manapoint of the {@linkplain Race}.
     *
     * @return the base manapoint.
     */
    public int getManapoint() {
        return mManapoint;
    }

    /**
     * Retrieves the base energy of the {@linkplain Race}.
     *
     * @return the base energy.
     */
    public int getEnergy() {
        return mEnergy;
    }

    /**
     * Retrieves the {@linkplain Attribute} of the {@linkplain Race}.
     *
     * @param attribute the attribute to be retrieved.
     *
     * @return the base modifier for the given attribute.
     */
    public int getAttribute(Attribute attribute) {
        Objects.nonNull(attribute);

        return mAttributes[attribute.ordinal()];
    }

    /**
     * Retrieves all {@linkplain Attribute} of the {@linkplain Race}.
     *
     * @return a collection that contains all modifiers for each attribute.
     */
    public int[] getAttributes() {
        return mAttributes;
    }
}
