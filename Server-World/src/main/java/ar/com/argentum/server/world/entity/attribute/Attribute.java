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

import ar.com.argentum.server.world.entity.attribute.evaluator.AdapterEvaluator;
import com.gs.collections.api.block.procedure.Procedure;
import com.gs.collections.api.collection.ImmutableCollection;
import com.gs.collections.api.list.MutableList;
import com.gs.collections.impl.factory.Lists;

/**
 * Represent an attribute which change though external {@linkplain Evaluator}.
 *
 * @author Agustin L. Alvarez <wolftein1@gmail.com>
 */
public final class Attribute {
    /**
     * Represent the {@linkplain AttributeManager} of the {@linkplain Attribute}.
     */
    private final AttributeManager mManager;

    /**
     * Represent the {@linkplain AttributeType} of the {@linkplain Attribute}.
     */
    private final AttributeType mType;

    /**
     * Represent the final value of the {@linkplain Attribute} (After evaluator(s) applied).
     */
    private double mFinal;

    /**
     * Represent all {@linkplain Procedure<Attribute>} notification(s).
     */
    private final MutableList<Procedure<Attribute>> mNotification = Lists.mutable.<Procedure<Attribute>>empty();

    /**
     * Represent all {@linkplain Evaluator} evaluator(s) applied over {@linkplain #getBase()}.
     */
    private final MutableList<Evaluator> mBaseModifiers = Lists.mutable.empty();

    /**
     * Represent all {@linkplain Evaluator} evaluator(s) applied over {@linkplain #getFinal()}.
     */
    private final MutableList<Evaluator> mFinalModifiers = Lists.mutable.empty();

    /**
     * Represent a status to prevent calculating the {@linkplain Attribute} multiple time(s).
     */
    private boolean mUpdated = true;

    /**
     * Constructor for {@linkplain Attribute}.
     *
     * @param manager the {@linkplain AttributeManager} of the attribute.
     * @param type    the {@linkplain AttributeType} of the attribute.
     */
    public Attribute(AttributeManager manager, AttributeType type) {
        this.mManager = manager;
        this.mType = type;
    }

    /**
     * Adds an {@linkplain Procedure<Attribute>}.
     *
     * @param observer the {@linkplain Procedure<Attribute>} for listening to change(s).
     */
    public void addAttributeListener(Procedure<Attribute> observer) {
        mNotification.add(observer);
    }

    /**
     * Removes an {@linkplain Procedure<Attribute>}.
     *
     * @param observer the {@linkplain Procedure<Attribute>} for stop listening to change(s).
     */
    public void removeAttributeListener(Procedure<Attribute> observer) {
        mNotification.remove(observer);
    }

    /**
     * Adds a {@linkplain Evaluator} to apply over the value.
     * </p>
     * NOTE: Requires reflection for {@linkplain ApplyToBase}, {@linkplain ApplyToFinal}.
     *
     * @param evaluator the {@linkplain Evaluator} of the attribute.
     */
    public void addModifier(Evaluator evaluator) {
        if (evaluator instanceof ApplyToBase) {
            addBaseModifier(EvaluatorProxy.class.cast(evaluator).getEvaluator());
        } else if (evaluator instanceof ApplyToFinal) {
            addFinalModifier(EvaluatorProxy.class.cast(evaluator).getEvaluator());
        } else {
            throw new IllegalArgumentException("ApplyToBase or ApplyToFinal not present.");
        }
    }

    /**
     * Removes a {@linkplain Evaluator} that applied over the value.
     * </p>
     * NOTE: Requires reflection for {@linkplain ApplyToBase}, {@linkplain ApplyToFinal}.
     *
     * @param evaluator the {@linkplain Evaluator} of the attribute.
     */
    public void removeModifier(Evaluator evaluator) {
        if (evaluator instanceof ApplyToBase) {
            removeBaseModifier(EvaluatorProxy.class.cast(evaluator).getEvaluator());
        } else if (evaluator instanceof ApplyToFinal) {
            removeFinalModifier(EvaluatorProxy.class.cast(evaluator).getEvaluator());
        } else {
            throw new IllegalArgumentException("ApplyToBase or ApplyToFinal not present.");
        }
    }

    /**
     * Adds a {@linkplain Evaluator} to apply over the base value.
     *
     * @param evaluator the {@linkplain Evaluator} of the attribute.
     */
    public void addBaseModifier(Evaluator evaluator) {
        mUpdated = !mBaseModifiers.add(evaluator);
        if (!mUpdated) {
            //!
            //! Threat AdapterEvaluator as special.
            //!
            if (evaluator instanceof AdapterEvaluator) {
                notifyAttributeAdapter((AdapterEvaluator) evaluator, true);
            }

            //!
            //! Notify every {@linkplain Procedure<Attribute>} registered.
            //!
            mNotification.each(T -> T.value(this));
        }
    }

    /**
     * Removes a {@linkplain Evaluator} that applied over the base value.
     *
     * @param evaluator the {@linkplain Evaluator} of the attribute.
     */
    public void removeBaseModifier(Evaluator evaluator) {
        mUpdated = !mBaseModifiers.remove(evaluator);
        if (!mUpdated) {
            //!
            //! Threat AdapterEvaluator as special.
            //!
            if (evaluator instanceof AdapterEvaluator) {
                notifyAttributeAdapter((AdapterEvaluator) evaluator, false);
            }

            //!
            //! Notify every {@linkplain Procedure<Attribute>} registered.
            //!
            mNotification.each(T -> T.value(this));
        }
    }

    /**
     * Adds a {@linkplain Evaluator} to apply over the final value.
     *
     * @param evaluator the {@linkplain Evaluator} of the attribute.
     */
    public void addFinalModifier(Evaluator evaluator) {
        mUpdated = !mFinalModifiers.add(evaluator);
        if (!mUpdated) {
            //!
            //! Threat AdapterEvaluator as special.
            //!
            if (evaluator instanceof AdapterEvaluator) {
                notifyAttributeAdapter((AdapterEvaluator) evaluator, true);
            }

            //!
            //! Notify every {@linkplain Procedure<Attribute>} registered.
            //!
            mNotification.each(T -> T.value(this));
        }
    }

    /**
     * Removes a {@linkplain Evaluator} that applied over the final value.
     *
     * @param evaluator the {@linkplain Evaluator} of the attribute.
     */
    public void removeFinalModifier(Evaluator evaluator) {
        mUpdated = !mFinalModifiers.remove(evaluator);
        if (!mUpdated) {
            //!
            //! Threat AdapterEvaluator as special.
            //!
            if (evaluator instanceof AdapterEvaluator) {
                notifyAttributeAdapter((AdapterEvaluator) evaluator, false);
            }

            //!
            //! Notify every {@linkplain Procedure<Attribute>} registered.
            //!
            mNotification.each(T -> T.value(this));
        }
    }

    /**
     * Retrieves the {@linkplain AttributeType} of the {@linkplain Attribute}.
     *
     * @return the type of the attribute.
     */
    public AttributeType getType() {
        return mType;
    }

    /**
     * Retrieves the base value of the {@linkplain Attribute}.
     *
     * @return the base value of the attribute.
     */
    public double getBase() {
        return mType.getBase();
    }

    /**
     * Retrieves the minimum possible value of the {@linkplain Attribute}.
     *
     * @return the minimum possible value of the attribute.
     */
    public double getMinimum() {
        return mType.getMinimum();
    }

    /**
     * Retrieves the maximum possible value of the {@linkplain Attribute}.
     *
     * @return the maximum possible value of the attribute.
     */
    public double getMaximum() {
        return mType.getMaximum();
    }

    /**
     * Retrieves the final value of the {@linkplain Attribute}.
     *
     * @return the final value of the attribute.
     */
    public double getFinal() {
        if (!mUpdated) {
            //!
            //! Apply raw bonus(es) over the base attribute.
            //!
            final double rawValue = getBase();
            final double rawBonusesApplied
                    = rawValue + mBaseModifiers.sumOfDouble(T -> T.applyBonus(mManager, rawValue));

            //!
            //! Apply final bonus(es) over the final attribute.
            //!
            mFinal = rawBonusesApplied + mFinalModifiers.sumOfDouble(T -> T.applyBonus(mManager, rawBonusesApplied));
            mFinal = Math.min(getMaximum(), Math.max(getMinimum(), mFinal));
            mUpdated = true;
        }
        return mFinal;
    }

    /**
     * Notify any underlying {@linkplain Attribute} has been changed.
     * </p>
     * NOTE: This procedure is for internal usage.
     *
     * @param attribute the underlying {@linkplain Attribute} that has changed.
     */
    private void notifyAttributeChanged(Attribute attribute) {
        mUpdated = false;

        //!
        //! Notify every {@linkplain Procedure<Attribute>} registered.
        //!
        mNotification.each(T -> T.value(this));
    }

    /**
     * Notify the {@linkplain Attribute} an {@linkplain AdapterEvaluator} has changed.
     * </p>
     * NOTE: This procedure is for internal usage.
     *
     * @param evaluator {@linkplain AdapterEvaluator} that has changed.
     * @param isAdded   {@linkplain Boolean#TRUE} if added, {@linkplain Boolean#FALSE} otherwise.
     */
    private void notifyAttributeAdapter(AdapterEvaluator evaluator, boolean isAdded) {
        final ImmutableCollection<AttributeType> adapter = evaluator.getDependencies();

        if (isAdded) {
            adapter.each(T -> mManager.getAttribute(T).ifPresent(
                    J -> J.addAttributeListener(this::notifyAttributeChanged)));
        } else {
            adapter.each(T -> mManager.getAttribute(T).ifPresent(
                    J -> J.removeAttributeListener(this::notifyAttributeChanged)));
        }
    }

    /**
     * Represent the {@linkplain FunctionalInterface} for applying modification(s) over an {@linkplain Attribute}(s).
     *
     * @author Agustin L. Alvarez <wolftein1@gmail.com>
     */
    @FunctionalInterface
    public interface Evaluator {
        /**
         * Retrieves the bonus of the given {@linkplain Attribute}.
         *
         * @param manager the {@linkplain AttributeManager} that owns the {@linkplain Attribute}.
         * @param applyOn the current value of the {@linkplain Attribute}.
         *
         * @return the bonus applied to the value given.
         */
        double applyBonus(AttributeManager manager, double applyOn);
    }

    /**
     * Represent the {@linkplain FunctionalInterface} for proxy an {@linkplain Evaluator}.
     *
     * @author Agustin L. Alvarez <wolftein1@gmail.com>
     */
    @FunctionalInterface
    public interface EvaluatorProxy extends Evaluator {
        /**
         * Retrieves the bonus of the given {@linkplain Attribute}.
         *
         * @param collection the {@linkplain AttributeManager} that owns the {@linkplain Attribute}.
         * @param applyOn    the current value of the {@linkplain Attribute}.
         *
         * @return the bonus applied to the value given.
         */
        default double applyBonus(AttributeManager collection, double applyOn) {
            return getEvaluator().applyBonus(collection, applyOn);
        }

        /**
         * Retrieves the proxy {@linkplain Evaluator}.
         *
         * @return the proxy evaluator being access directly.
         */
        Evaluator getEvaluator();
    }

    /**
     * Represent an {@linkplain EvaluatorProxy} for base {@linkplain Evaluator}(s).
     *
     * @author Agustin L. Alvarez <wolftein1@gmail.com>
     */
    @FunctionalInterface
    public interface ApplyToBase extends EvaluatorProxy {
    }

    /**
     * Represent an {@linkplain EvaluatorProxy} for final {@linkplain Evaluator}(s).
     *
     * @author Agustin L. Alvarez <wolftein1@gmail.com>
     */
    @FunctionalInterface
    public interface ApplyToFinal extends EvaluatorProxy {
    }
}