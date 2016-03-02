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
package ar.com.argentum.server.world.terrain;

/**
 * {@link Chunk}s are segments of the world containing a group of tiles.
 */
public final class Chunk {
    /**
     * Define the bit for shifting the chunk position.
     */
    public final static int CHUNK_BIT = 64;

    /**
     * Define the length of the chunk.
     */
    public final static int CHUNK_LENGTH = CHUNK_BIT * CHUNK_BIT;

    /**
     * Represent the property of a tile that is blocked.
     */
    public final static int TILE_PROPERTY_BLOCKED = 1;

    private boolean mDisposable;
    private final int mX;
    private final int mY;
    private final int[] mTiles;
    private final int[] mEntities;
    private final int[] mItems;
    private final int[] mProperties;

    /**
     * Constructor for {@link Chunk}.
     *
     * @param x the x coordinate of the chunk within the world.
     * @param y the y coordinate of the chunk within the world.
     */
    public Chunk(int x, int y) {
        this(x, y, new int[CHUNK_LENGTH], new int[CHUNK_LENGTH], new int[CHUNK_LENGTH], new int[CHUNK_LENGTH]);
    }

    /**
     * Constructor for {@link Chunk}.
     *
     * @param x          the x coordinate of the chunk within the world.
     * @param y          the y coordinate of the chunk within the world.
     * @param tiles      a collection that contains every terrain in the chunk.
     * @param entities   a collection that contains every entity in the chunk.
     * @param properties a collection that contains every properties in the chunk.
     */
    public Chunk(int x, int y, int[] tiles, int[] entities, int[] items, int[] properties) {
        this.mX = x;
        this.mY = y;
        this.mTiles = tiles;
        this.mEntities = entities;
        this.mItems = items;
        this.mProperties = properties;
    }

    /**
     * Retrieves the x coordinate of the chunk (in world coordinates).
     *
     * @return a number tht represent the x coordinate.
     */
    public int getX() {
        return mX;
    }

    /**
     * Retrieves the y coordinate of the chunk (in world coordinates).
     *
     * @return a number tht represent the y coordinate.
     */
    public int getY() {
        return mY;
    }

    /**
     * Change the disposable flag of the chunk.
     *
     * @param isDisposable true if the chunk is disposable, false otherwise.
     */
    public void setDisposable(boolean isDisposable) {
        mDisposable = isDisposable;
    }

    /**
     * Check whenever the chunk is allowed to be disposed automatically.
     *
     * @return true if the chunk is allowed to be disposed when is not active, false otherwise.
     */
    public boolean isDisposable() {
        return mDisposable;
    }

    /**
     * Check whenever the given coordinates are blocked.
     *
     * @param x the x coordinates (in relative coordinates).
     * @param y the y coordinates (in relative coordinates).
     *
     * @return true if the given terrain is blocked, false otherwise.
     */
    public boolean isBlocked(int x, int y) {
        return (getProperty(x, y) & TILE_PROPERTY_BLOCKED) != 0;
    }

    /**
     * Set the blocked state of the tile at the given coordinate.
     *
     * @param x         the x coordinates (in relative coordinates).
     * @param y         the y coordinates (in relative coordinates).
     * @param isBlocked true if the terrain should be blocked, false otherwise.
     */
    public void setBlocked(int x, int y, boolean isBlocked) {
        final int position = getTilePosition(x, y);

        if (isBlocked) {
            mProperties[position] |= TILE_PROPERTY_BLOCKED;
        } else {
            mProperties[position] &= ~TILE_PROPERTY_BLOCKED;
        }
    }

    /**
     * Set the property at the given coordinate.
     *
     * @param x  the x coordinates (in relative coordinates).
     * @param y  the y coordinates (in relative coordinates).
     * @param id the unique identifier of the terrain.
     */
    public void setProperty(int x, int y, int id) {
        mProperties[getTilePosition(x, y)] = id;
    }

    /**
     * Retrieves the property at the given coordinates.
     *
     * @param x the x coordinates (in relative coordinates).
     * @param y the y coordinates (in relative coordinates).
     *
     * @return the identifier of the property at the given coordinates.
     */
    public int getProperty(int x, int y) {
        return mProperties[getTilePosition(x, y)];
    }

    /**
     * Retrieves all properties from the chunk.
     *
     * @return an array that contain(s) all properties of the chunk.
     */
    public int[] getProperties() {
        return mProperties;
    }

    /**
     * Set the tile at the given coordinate.
     *
     * @param x  the x coordinates (in relative coordinates).
     * @param y  the y coordinates (in relative coordinates).
     * @param id the unique identifier of the terrain.
     */
    public void setTile(int x, int y, int id) {
        mTiles[getTilePosition(x, y)] = id;
    }

    /**
     * Retrieves the tile at the given coordinates.
     *
     * @param x the x coordinates (in relative coordinates).
     * @param y the y coordinates (in relative coordinates).
     *
     * @return the identifier of the tile at the given coordinates.
     */
    public int getTile(int x, int y) {
        return mTiles[getTilePosition(x, y)];
    }

    /**
     * Retrieves all tiles from the chunk.
     *
     * @return an array that contain(s) all tiles of the chunk.
     */
    public int[] getTiles() {
        return mTiles;
    }

    /**
     * Set the entity at the given coordinate.
     *
     * @param x  the x coordinates (in relative coordinates).
     * @param y  the y coordinates (in relative coordinates).
     * @param id the unique identifier of the entity.
     */
    public void setEntity(int x, int y, int id) {
        mEntities[getTilePosition(x, y)] = id;
    }

    /**
     * Retrieves the entity at the given coordinates.
     *
     * @param x the x coordinates (in relative coordinates).
     * @param y the y coordinates (in relative coordinates).
     *
     * @return the identifier of the entity at the given coordinates.
     */
    public int getEntity(int x, int y) {
        return mEntities[getTilePosition(x, y)];
    }

    /**
     * Retrieves all entities from the chunk.
     *
     * @return an array that contain(s) all entities of the chunk.
     */
    public int[] getEntities() {
        return mEntities;
    }

    /**
     * Set the item at the given coordinate.
     *
     * @param x  the x coordinates (in relative coordinates).
     * @param y  the y coordinates (in relative coordinates).
     * @param id the unique identifier of the item.
     */
    public void setItem(int x, int y, int id) {
        mItems[getTilePosition(x, y)] = id;
    }

    /**
     * Retrieves the item at the given coordinates.
     *
     * @param x the x coordinates (in relative coordinates).
     * @param y the y coordinates (in relative coordinates).
     *
     * @return the identifier of the item at the given coordinates.
     */
    public int getItem(int x, int y) {
        return mItems[getTilePosition(x, y)];
    }

    /**
     * Retrieves all item from the chunk.
     *
     * @return an array that contain(s) all item of the chunk.
     */
    public int[] getItems() {
        return mItems;
    }

    /**
     * Retrieves the relative position in relative coordinates from the given chunk coordinates.
     *
     * @param x the x coordinates (in relative coordinates).
     * @param y the y coordinates (in relative coordinates).
     *
     * @return a linear representation of the position.
     */
    private int getTilePosition(int x, int y) {
        if (x < 0 || y < 0 || x > CHUNK_BIT || y > CHUNK_BIT) {
            throw new IllegalArgumentException("Given position within chunk is out of bound.");
        }
        return (y * CHUNK_BIT) + x;
    }
}