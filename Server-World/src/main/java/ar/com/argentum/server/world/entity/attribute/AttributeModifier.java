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
package ar.com.argentum.server.world.entity.attribute;

/**
 * Encapsulate a modifier that encapsulate the {@linkplain AttributeType} and {@linkplain Attribute.Evaluator}.
 * </p>
 * NOTE: Any external object that modify any {@linkplain Attribute} should do it though this class.
 */
public final class AttributeModifier {
    private final AttributeType mType;
    private final Attribute.Evaluator mEvaluator;

    /**
     * Constructor for {@linkplain AttributeModifier}.
     */
    public AttributeModifier(AttributeType type, Attribute.Evaluator evaluator) {
        this.mType = type;
        this.mEvaluator = evaluator;
    }

    /**
     * Retrieves the {@linkplain AttributeType} of the modifier.
     *
     * @return the {@linkplain AttributeType} of the modifier.
     */
    public AttributeType getType() {
        return mType;
    }

    /**
     * Retrieves the {@linkplain Attribute.Evaluator} of the modifier.
     *
     * @return the {@linkplain Attribute.Evaluator} of the modifier.
     */
    public Attribute.Evaluator getEvaluator() {
        return mEvaluator;
    }
}
