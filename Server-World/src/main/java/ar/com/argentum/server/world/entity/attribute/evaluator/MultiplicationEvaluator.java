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

/**
 * Encapsulate an {@linkplain Attribute.Evaluator} which evaluates as multiplication.
 *
 * @author Agustin L. Alvarez <wolftein1@gmail.com>
 */
@FunctionalInterface
public interface MultiplicationEvaluator extends Attribute.Evaluator {
    /**
     * {@inheritDoc}
     */
    @Override
    default double applyBonus(AttributeManager manager, double applyOn) {
        return applyOn * getBonusApplied();
    }

    /**
     * Retrieves the bonus applied of the {@linkplain Attribute.Evaluator}.
     *
     * @return the bonus applied of the evaluator.
     */
    double getBonusApplied();
}
