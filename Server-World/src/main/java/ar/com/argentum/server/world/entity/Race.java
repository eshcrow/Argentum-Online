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

import com.gs.collections.api.collection.ImmutableCollection;
import org.ghrum.core.attributes.AttributeModifier;

/**
 * Represent a race definition for an {@linkplain com.artemis.Entity}.
 */
public final class Race {
    /**
     * The unique name of the race.
     */
    private final String mName;

    /**
     * A collection of {@linkplain AttributeModifier} that provides the race.
     */
    private final ImmutableCollection<AttributeModifier> mModifier;

    /**
     * Constructor for {@link Race}.
     *
     * @param name      the name of the race.
     * @param modifiers an immutable collection that contain(s) all {@linkplain AttributeModifier}.
     */
    public Race(String name, ImmutableCollection<AttributeModifier> modifiers) {
        this.mName = name;
        this.mModifier = modifiers;
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
     * Retrieves a collection that contain(s) {@linkplain AttributeModifier}(s).
     *
     * @return an immutable collection that contain(s) {@linkplain AttributeModifier}(s).
     */
    public ImmutableCollection<AttributeModifier> getModifiers() {
        return mModifier;
    }
}
