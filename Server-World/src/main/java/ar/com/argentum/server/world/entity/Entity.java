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

/**
 * Represent the base definition of any entity that resides in the world.
 *
 * @author Agustin L. Alvarez <wolftein1@gmail.com>
 */
public abstract class Entity {
    protected final int mID;
    protected int mX;
    protected int mY;
    protected Heading mHeading;

    /**
     * Constructor for {@linkplain Entity}.
     *
     * @param id the unique identifier of the entity.
     */
    public Entity(int id) {
        this.mID = id;
    }

    /**
     * Retrieves the unique identifier of the {@linkplain Entity}.
     *
     * @return the unique identifier of the entity.
     */
    public final int getID() {
        return mID;
    }

    /**
     * Retrieves the x coordinate (in world coordinates) of the {@linkplain Entity}.
     *
     * @return the x coordinate (in world coordinates) of the entity.
     */
    public final int getX() {
        return mX;
    }

    /**
     * Changes the x coordinate (in world coordinates) of the {@linkplain Entity}.
     *
     * @param x the new x coordinate (in world coordinates) of the entity.
     */
    public final void setX(int x) {
        mX = x;
    }

    /**
     * Retrieves the y coordinate (in world coordinates) of the {@linkplain Entity}.
     *
     * @return the y coordinate (in world coordinates) of the entity.
     */
    public final int getY() {
        return mY;
    }

    /**
     * Changes the y coordinate (in world coordinates) of the {@linkplain Entity}.
     *
     * @param y the new y coordinate (in world coordinates) of the entity.
     */
    public final void setY(int y) {
        mY = y;
    }

    /**
     * Retrieves the {@linkplain Heading} of the {@linkplain Entity}.
     *
     * @return the heading of the entity.
     */
    public final Heading getHeading() {
        return mHeading;
    }

    /**
     * Changes the {@linkplain Heading} of the {@linkplain Entity}.
     *
     * @param heading the new heading of the entity.
     */
    public final void setHeading(Heading heading) {
        mHeading = heading;
    }
}