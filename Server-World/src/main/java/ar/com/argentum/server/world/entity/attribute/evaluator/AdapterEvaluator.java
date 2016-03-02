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
package ar.com.argentum.server.world.entity.attribute.evaluator;

import ar.com.argentum.server.world.entity.attribute.Attribute;
import ar.com.argentum.server.world.entity.attribute.AttributeManager;
import ar.com.argentum.server.world.entity.attribute.AttributeType;
import com.gs.collections.api.collection.ImmutableCollection;
import com.gs.collections.impl.factory.Lists;

/**
 * Encapsulate an {@linkplain Attribute.Evaluator} which evaluates as division.
 */
public final class AdapterEvaluator implements Attribute.Evaluator {
    private final Evaluator mEvaluator;
    private final ImmutableCollection<AttributeType> mDependencies;

    /**
     * Constructor of {@linkplain AdapterEvaluator}.
     *
     * @param evaluator    a reference to the {@linkplain Evaluator} being adapted.
     * @param dependencies a collection that contain(s) all {@linkplain Attribute} being adapted.
     */
    public AdapterEvaluator(Evaluator evaluator, AttributeType... dependencies) {
        this.mEvaluator = evaluator;
        this.mDependencies = Lists.immutable.with(dependencies);
    }

    /**
     * Retrieves all {@linkplain Attribute} dependencies.
     *
     * @return an array that contain(s) all dependencies.
     */
    public ImmutableCollection<AttributeType> getDependencies() {
        return mDependencies;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double applyBonus(AttributeManager manager, double applyOn) {
        final Attribute[] attributes = new Attribute[mDependencies.size()]; //! (TODO: Cached)

        return mEvaluator.applyBonus(applyOn,
                getDependencies().collect(T -> manager.getAttribute(T).get()).toArray(attributes));
    }

    /**
     * Represent the {@linkplain Attribute.Evaluator} for multiple dependencies.
     *
     * @author Agustin L. Alvarez <wolftein1@gmail.com>
     */
    @FunctionalInterface
    public interface Evaluator {
        /**
         * Retrieves the bonus of the given {@linkplain Attribute}.
         *
         * @param applyOn   the current value of the {@linkplain Attribute}.
         * @param applyWith the array that contain(s) all attribute dependency.
         *
         * @return the bonus applied to the value given.
         */
        double applyBonus(double applyOn, Attribute[] applyWith);
    }
}
