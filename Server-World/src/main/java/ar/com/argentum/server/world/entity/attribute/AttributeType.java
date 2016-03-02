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

import com.gs.collections.api.collection.ImmutableCollection;
import com.gs.collections.impl.list.mutable.FastList;

/**
 * Represent all {@linkplain Attribute}(s).
 */
public enum AttributeType {
    /**
     * A measure of how physically strong a entity is. Strength often controls
     * the maximum weight the entity can carry, melee attack and/or damage,
     * and sometimes hit points. Armor and weapons might also have a Strength requirement.
     */
    STRENGTH(0, 1_000),

    /**
     * A measure of how agile a entity is. Dexterity controls attack and movement speed
     * and accuracy, as well as evading an opponent's attack.
     */
    DEXTERITY(0, 1_000),

    /**
     * A measure of a entity's problem-solving ability. Intelligence often controls a
     * entity's ability to comprehend foreign languages and their skill in magic.
     */
    INTELLIGENCE(0, 1_000),

    /**
     * A measure of a entity's social skills, and sometimes their physical appearance.
     * Charisma generally influences prices while trading, and NPC reactions.
     */
    CHARISMA(0, 1_000),

    /**
     * A measure of how resilient a entity is. Constitution often influences hit points,
     * resistances for special types of damage (poisons, illness, heat etc.) and fatigue.
     */
    CONSTITUTION(0, 1_000),

    /**
     * A measure of a entity's luck. Luck might influence anything, but mostly random items,
     * encounters and outstanding successes/failures (such as critical hits).
     */
    LUCK(0, 1_000);

    private final double mMinimum;
    private final double mMaximum;
    private final double mBase;
    private final ImmutableCollection<Attribute.Evaluator> mEvaluators;

    /**
     * Constructor for {@linkplain AttributeType}.
     *
     * @param minimum    the minimal value of the attribute (cannot go lower than that).
     * @param maximum    the maximum value of the attribute (cannot go higher than that).
     * @param evaluators an immutable collection that contain(s) {@linkplain Attribute.Evaluator}.
     */
    AttributeType(double minimum, double maximum, Attribute.Evaluator... evaluators) {
        this(minimum, maximum, minimum, evaluators);
    }

    /**
     * Constructor for {@linkplain AttributeType}.
     *
     * @param minimum    the minimal value of the attribute (cannot go lower than that).
     * @param maximum    the maximum value of the attribute (cannot go higher than that).
     * @param base       the base value of the attribute.
     * @param evaluators an immutable collection that contain(s) {@linkplain Attribute.Evaluator}.
     */
    AttributeType(double minimum, double maximum, double base, Attribute.Evaluator... evaluators) {
        this(minimum, maximum, base, FastList.newListWith(evaluators).toImmutable());
    }

    /**
     * Constructor for {@linkplain AttributeType}.
     *
     * @param minimum    the minimal value of the attribute (cannot go lower than that).
     * @param maximum    the maximum value of the attribute (cannot go higher than that).
     * @param base       the base value of the attribute.
     * @param evaluators an immutable collection that contain(s) {@linkplain Attribute.Evaluator}.
     */
    AttributeType(double minimum, double maximum, double base, ImmutableCollection<Attribute.Evaluator> evaluators) {
        this.mMinimum = minimum;
        this.mMaximum = maximum;
        this.mBase = base;
        this.mEvaluators = evaluators;
    }

    /**
     * Retrieves the base value of the {@linkplain Attribute}.
     *
     * @return the base value of the attribute.
     */
    public double getBase() {
        return mBase;
    }

    /**
     * Retrieves the minimum possible value of the {@linkplain Attribute}.
     *
     * @return the minimum possible value of the attribute.
     */
    public double getMinimum() {
        return mMinimum;
    }

    /**
     * Retrieves the maximum possible value of the {@linkplain Attribute}.
     *
     * @return the maximum possible value of the attribute.
     */
    public double getMaximum() {
        return mMaximum;
    }

    /**
     * Retrieves default {@linkplain Attribute.Evaluator}(s).
     *
     * @return an immutable collection that contain(s) default evaluator(s).
     */
    public ImmutableCollection<Attribute.Evaluator> getDefaultEvaluators() {
        return mEvaluators;
    }
}
