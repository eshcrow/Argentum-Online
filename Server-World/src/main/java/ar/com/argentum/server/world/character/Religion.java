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

import com.gs.collections.api.map.ImmutableMap;

import java.util.Objects;

/**
 * Represent a religion definition for an {@linkplain Character}.
 *
 * @author Agustin L. Alvarez <wolftein1@gmail.com>
 */
public final class Religion {
    /**
     * Define the name of the religion.
     */
    private final String mName;

    /**
     * Define the aligment of the religion.
     * </p>
     * Only {@linkplain Character} of the given {@linkplain Alignment} are allowed.
     */
    private final Alignment mAlignment;

    /**
     * Define all the relationship of the religion with other(s) religion(s).
     */
    private final ImmutableMap<String, Relation> mRelationship;

    /**
     * Constructor for {@link Religion}.
     *
     * @param name         the name of the religion.
     * @param alignment    the {@linkplain Alignment} of the religion.
     * @param relationship a collection that contain(s) all relationship with other religion(s).
     */
    public Religion(String name, Alignment alignment, ImmutableMap<String, Relation> relationship) {
        this.mName = name;
        this.mAlignment = alignment;
        this.mRelationship = relationship;
    }

    /**
     * Retrieves the name of the {@linkplain Religion}.
     *
     * @return the name of the religion.
     */
    public String getName() {
        return mName;
    }

    /**
     * Retrieves the {@linkplain Alignment} of the {@linkplain Religion}.
     *
     * @return the alignment of the religion.
     */
    public Alignment getAlignment() {
        return mAlignment;
    }

    /**
     * Check whenever the given {@linkplain Religion} is enemy.
     *
     * @param religion the other religion.
     *
     * @return {@linkplain Boolean#TRUE} if the given religion is enemy, {@linkplain Boolean#FALSE} otherwise.
     */
    public boolean isEnemy(Religion religion) {
        Objects.nonNull(religion);

        return mRelationship.getIfAbsentValue(religion.getName(), Relation.NEUTRAL) == Relation.ENEMY;
    }

    /**
     * Check whenever the given {@linkplain Religion} is allied.
     *
     * @param religion the other religion.
     *
     * @return {@linkplain Boolean#TRUE} if the given religion is allied, {@linkplain Boolean#FALSE} otherwise.
     */
    public boolean isAllied(Religion religion) {
        Objects.nonNull(religion);

        return mRelationship.getIfAbsentValue(religion.getName(), Relation.NEUTRAL) == Relation.ALLIED;
    }

    /**
     * Check whenever the given {@linkplain Religion} is neutral.
     *
     * @param religion the other religion.
     *
     * @return {@linkplain Boolean#TRUE} if the given religion is neutral, {@linkplain Boolean#FALSE} otherwise.
     */
    public boolean isNeutral(Religion religion) {
        Objects.nonNull(religion);

        return mRelationship.getIfAbsentValue(religion.getName(), Relation.NEUTRAL) == Relation.NEUTRAL;
    }

    /**
     * Check whenever the given {@linkplain Alignment} is allowed.
     *
     * @param alignment the alignment of the adventurer.
     *
     * @return {@linkplain Boolean#TRUE} if the given alignment is allowed, {@linkplain Boolean#FALSE} otherwise.
     */
    public boolean isAllowed(Alignment alignment) {
        Objects.nonNull(alignment);

        return Alignment.getRelation(mAlignment, alignment) == Relation.ALLIED;
    }
}
