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

import ar.com.argentum.server.world.entity.Heading;
import com.artemis.Component;

/**
 * Encapsulate a {@linkplain Component} which encapsulate coordinates from a movement.
 */
public final class PositionMovementComponent extends Component {
    private int mX;
    private int mY;
    private Heading mHeading;

    /**
     * Constructor for {@linkplain PositionMovementComponent}.
     */
    public PositionMovementComponent() {
        this(0, 0, Heading.NORTH);
    }

    /**
     * Constructor for {@linkplain PositionMovementComponent}.
     *
     * @param x       the x coordinate (in world coordinates).
     * @param y       the y coordinate (in world coordinates).
     * @param heading the {@linkplain Heading}  of the movement.
     */
    public PositionMovementComponent(int x, int y, Heading heading) {
        this.mX = x;
        this.mY = y;
        this.mHeading = heading;
    }

    /**
     * Retrieves the x coordinate (in world coordinates).
     *
     * @return the x coordinate (in world coordinates).
     */
    public int getX() {
        return mX;
    }

    /**
     * Changes the x coordinate (in world coordinates).
     *
     * @param x the new x coordinate (in world coordinates).
     */
    public void setX(int x) {
        mX = x;
    }

    /**
     * Retrieves the y coordinate (in world coordinates).
     *
     * @return the y coordinate (in world coordinates).
     */
    public int getY() {
        return mY;
    }

    /**
     * Changes the y coordinate (in world coordinates).
     *
     * @param y the new y coordinate (in world coordinates).
     */
    public void setY(int y) {
        mY = y;
    }

    /**
     * Retrieves the {@linkplain Heading} of the {@linkplain Component}.
     *
     * @return the heading of the component.
     */
    public Heading getHeading() {
        return mHeading;
    }

    /**
     * Changes the {@linkplain Heading} of the {@linkplain Component}.
     *
     * @param heading the new heading of the component.
     */
    public void setHeading(Heading heading) {
        mHeading = heading;
    }
}