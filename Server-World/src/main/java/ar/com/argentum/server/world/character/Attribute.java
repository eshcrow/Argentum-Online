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

/**
 * Enumerates all attributes of an {@linkplain Character}.
 *
 * @author Agustin L. Alvarez <wolftein1@gmail.com>
 */
public enum Attribute {
    /**
     * A measure of how physically strong a entity is. Strength often controls
     * the maximum weight the entity can carry, melee attack and/or damage,
     * and sometimes hit points. Armor and weapons might also have a Strength requirement.
     */
    STRENGTH,

    /**
     * A measure of how agile a entity is. Dexterity controls attack and movement speed
     * and accuracy, as well as evading an opponent's attack.
     */
    DEXTERITY,

    /**
     * A measure of a entity's problem-solving ability. Intelligence often controls a
     * entity's ability to comprehend foreign languages and their skill in magic.
     */
    INTELLIGENCE,

    /**
     * A measure of a entity's social skills, and sometimes their physical appearance.
     * Charisma generally influences prices while trading, and NPC reactions.
     */
    CHARISMA,

    /**
     * A measure of how resilient a entity is. Constitution often influences hit points,
     * resistances for special types of damage (poisons, illness, heat etc.) and fatigue.
     */
    CONSTITUTION,

    /**
     * A measure of a entity's luck. Luck might influence anything, but mostly random items,
     * encounters and outstanding successes/failures (such as critical hits).
     */
    LUCK;

    /**
     * An array that contain(s) all enumeration values.
     */
    public static final Attribute[] VALUES = Attribute.values();
    public static final int LENGTH = VALUES.length;

    /**
     * Retrieve the enumeration value given the indice.
     *
     * @param index the index of the enumeration.
     *
     * @return the enumeration representation of the given index.
     */
    public static Attribute getEnumeration(int index) {
        if (index < 0 || index >= LENGTH) {
            throw new IllegalArgumentException("Enumeration index is out of bounds");
        }
        return VALUES[index];
    }
}
