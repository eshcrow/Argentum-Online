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

import ar.com.argentum.server.world.entity.Entity;

/**
 * Represent an Adventure {@linkplain Entity}.
 *
 * @author Agustin L. Alvarez <wolftein1@gmail.com>
 */
public final class Character extends Entity {
    private Race mRace;
    private Gender mGender;
    private Religion mReligion;
    private Alignment mAlignment;
    private Orientation mOrientation;

    /**
     * Constructor for {@linkplain Character}.
     *
     * @param id the unique identifier of the entity.
     */
    public Character(int id) {
        super(id);
    }

    /**
     * Changes the {@linkplain Race} of the {@linkplain Character}.
     *
     * @param race the new race of the character.
     */
    public void setRace(Race race) {
        mRace = race;
    }

    /**
     * Retrieves the {@linkplain Race} of the {@linkplain Character}.
     *
     * @return the race of the adventurer.
     */
    public Race getRace() {
        return mRace;
    }

    /**
     * Changes the {@linkplain Gender} of the {@linkplain Character}.
     *
     * @param gender the new gender of the character.
     */
    public void setGender(Gender gender) {
        mGender = gender;
    }

    /**
     * Retrieves the {@linkplain Gender} of the {@linkplain Character}.
     *
     * @return the gender of the adventurer.
     */
    public Gender getGender() {
        return mGender;
    }

    /**
     * Changes the {@linkplain Religion} of the {@linkplain Character}.
     *
     * @param religion the new religion of the character.
     */
    public void setReligion(Religion religion) {
        mReligion = religion;
    }

    /**
     * Retrieves the {@linkplain Religion} of the {@linkplain Character}.
     *
     * @return the religion of the adventurer.
     */
    public Religion getReligion() {
        return mReligion;
    }

    /**
     * Changes the {@linkplain Alignment} of the {@linkplain Character}.
     *
     * @param alignment the new alignment of the character.
     */
    public void setAlignment(Alignment alignment) {
        mAlignment = alignment;
    }

    /**
     * Retrieves the {@linkplain Alignment} of the {@linkplain Character}.
     *
     * @return the alignment of the adventurer.
     */
    public Alignment getAlignment() {
        return mAlignment;
    }

    /**
     * Changes the {@linkplain Orientation} of the {@linkplain Character}.
     *
     * @param orientation the new orientation of the character.
     */
    public void setOrientation(Orientation orientation) {
        mOrientation = orientation;
    }

    /**
     * Retrieves the {@linkplain Orientation} of the {@linkplain Character}.
     *
     * @return the orientation of the adventurer.
     */
    public Orientation getOrientation() {
        return mOrientation;
    }
}
