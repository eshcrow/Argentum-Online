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
 * Encapsulate a {@linkplain Component} which encapsulate {@linkplain Heading}.
 */
public final class PositionMovemenetComponent extends Component {
    private boolean mIsMoving;
    private Heading mHeading;

    /**
     * Constructor for {@linkplain PositionMovemenetComponent}.
     *
     * @param heading the {@linkplain Heading} of the movement.
     */
    public PositionMovemenetComponent(Heading heading) {
        this.mIsMoving = false;
        this.mHeading = heading;
    }

    /**
     * Retrieves the moving property of the {@linkplain Component}.
     *
     * @return {@linkplain Boolean#TRUE} if moving {@linkplain Boolean#FALSE} otherwise.
     */
    public boolean isMoving() {
        return mIsMoving;
    }

    /**
     * Changes the moving property of the {@linkplain Component}.
     *
     * @param isMoving {@linkplain Boolean#TRUE} if moving {@linkplain Boolean#FALSE} otherwise.
     */
    public void setMoving(boolean isMoving) {
        mIsMoving = isMoving;
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