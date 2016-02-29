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

import java.util.Map;
import java.util.Objects;

/**
 * Represent a religion definition for an {@linkplain Character}.
 *
 * @author Agustin L. Alvarez <wolftein1@gmail.com>
 */
public final class Religion {
    private final String mName;
    private final Map<String, Boolean> mReligions;
    private final Map<Alignment, Boolean> mAlignments;

    /**
     * Constructor for {@link Religion}.
     *
     * @param name       the name of the religion.
     * @param religions  a collection that contain(s) all relationship with other religion(s).
     * @param alignments a collection that contain(s) all relationship with other alignment(s).
     */
    public Religion(String name, Map<String, Boolean> religions, Map<Alignment, Boolean> alignments) {
        this.mName = name;
        this.mReligions = religions;
        this.mAlignments = alignments;
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
     * Check whenever the given {@linkplain Religion} is enemy.
     *
     * @param religion the other religion.
     *
     * @return true if the given religion is enemy, false otherwise.
     */
    public boolean isEnemy(Religion religion) {
        Objects.nonNull(religion);

        return !mReligions.getOrDefault(religion.getName(), true);
    }

    /**
     * Check whenever the given {@linkplain Religion} is allied.
     *
     * @param religion the other religion.
     *
     * @return true if the given religion is allied, false otherwise.
     */
    public boolean isAllied(Religion religion) {
        Objects.nonNull(religion);

        return mReligions.getOrDefault(religion.getName(), false);
    }

    /**
     * Check whenever the given {@linkplain Religion} is neutral.
     *
     * @param religion the other religion.
     *
     * @return true if the given religion is neutral, false otherwise.
     */
    public boolean isNeutral(Religion religion) {
        Objects.nonNull(religion);

        return mReligions.getOrDefault(religion.getName(), true);
    }

    /**
     * Check whenever the given {@linkplain Alignment} is allowed.
     *
     * @param alignment the alignment of the adventurer.
     *
     * @return true if the given alignment is allowed, false otherwise.
     */
    public boolean isAllowed(Alignment alignment) {
        Objects.nonNull(alignment);

        return mAlignments.getOrDefault(alignment, false);
    }
}
