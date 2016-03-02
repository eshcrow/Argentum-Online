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
package ar.com.argentum.server.world.entity.component;

import ar.com.argentum.server.world.entity.attribute.Attribute;
import ar.com.argentum.server.world.entity.attribute.AttributeManager;
import ar.com.argentum.server.world.entity.attribute.AttributeModifier;
import ar.com.argentum.server.world.entity.attribute.AttributeType;
import com.artemis.Component;

import java.util.EnumMap;
import java.util.Optional;

/**
 * Encapsulate a {@linkplain Component} which encapsulate {@linkplain Attribute}(s).
 */
public final class AttributeComponent extends Component implements AttributeManager {
    private final EnumMap<AttributeType, Attribute> mDictionary = new EnumMap<>(AttributeType.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public Attribute registerAttribute(AttributeType type) {
        if (mDictionary.containsKey(type)) {
            //!
            //! Prevent registration of an existing Attribute.
            //!
            throw new IllegalStateException("Attribute already exist(s).");
        }

        //!
        //! Creates the Attribute and add each base evaluator.
        //!
        final Attribute newAttribute = new Attribute(this, type);
        type.getDefaultEvaluators().each(newAttribute::addModifier);

        //!
        //! Add the attribute into the dictionary.
        //!
        mDictionary.put(type, newAttribute);
        return newAttribute;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Attribute> unregisterAttribute(AttributeType type) {
        return Optional.ofNullable(mDictionary.remove(type));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Attribute> getAttribute(AttributeType type) {
        return Optional.ofNullable(mDictionary.get(type));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addModifier(AttributeModifier modifier) {
        //!
        //! Retrieves the Attribute or create a new one.
        //!
        final Attribute attribute = getAttribute(modifier.getType()).orElse(registerAttribute(modifier.getType()));
        attribute.addModifier(modifier.getEvaluator());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removeModifier(AttributeModifier modifier) {
        //!
        //! Removes the Attribute only if present.
        //!
        getAttribute(modifier.getType()).ifPresent(Attribute -> Attribute.removeModifier(modifier.getEvaluator()));
    }
}
