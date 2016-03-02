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

import com.gs.collections.api.block.predicate.Predicate;
import com.gs.collections.api.collection.ImmutableCollection;

import java.util.Optional;

/**
 * Represents a manager which handles {@linkplain Chunk}(s).
 *
 * @author Agustin L. Alvarez <wolftein1@gmail.com>
 */
public interface ChunkManager {
    /**
     * Check whenever the {@linkplain Chunk} at the given coordinates is loaded.
     *
     * @param x the x coordinates (in chunk coordinates).
     * @param y the y coordinates (in chunk coordinates).
     *
     * @return true if the chunk is loaded, false otherwise.
     */
    boolean isChunkLoaded(int x, int y);

    /**
     * Check whenever the {@linkplain Chunk} at the given coordinates can be disposed.
     *
     * @param x the x coordinates (in chunk coordinates).
     * @param y the y coordinates (in chunk coordinates).
     *
     * @return true if the chunk can be disposed, false otherwise
     */
    boolean isChunkDisposable(int x, int y);

    /**
     * Retrieves the {@linkplain Chunk} at the given coordinates.
     *
     * @param x the x coordinates (in chunk coordinates).
     * @param y the y coordinates (in chunk coordinates).
     *
     * @return an {@linkplain Optional} reference of the {@linkplain Chunk} at the given position.
     */
    Optional<Chunk> getChunk(int x, int y);

    /**
     * Retrieves the {@linkplain Chunk} at the given coordinates.
     *
     * @param x              the x coordinates (in chunk coordinates).
     * @param y              the y coordinates (in chunk coordinates).
     * @param loadIfUnloaded true if the chunk should be loaded if is unloaded, false otherwise.
     *
     * @return an {@linkplain Optional} reference of the {@linkplain Chunk} at the given position.
     */
    Optional<Chunk> getChunk(int x, int y, boolean loadIfUnloaded);

    /**
     * Retrieves the {@linkplain Chunk} at the given world coordinates.
     *
     * @param x the x coordinates (in world coordinates).
     * @param y the y coordinates (in world coordinates).
     *
     * @return an {@linkplain Optional} reference of the {@linkplain Chunk} at the given position.
     */
    Optional<Chunk> getChunkAt(int x, int y);

    /**
     * Retrieves the {@linkplain Chunk} at the given world coordinates.
     *
     * @param x              the x coordinates (in world coordinates).
     * @param y              the y coordinates (in world coordinates).
     * @param loadIfUnloaded true if the chunk should be loaded if is unloaded, false otherwise.
     *
     * @return an {@linkplain Optional} reference of the {@linkplain Chunk} at the given position.
     */
    Optional<Chunk> getChunkAt(int x, int y, boolean loadIfUnloaded);

    /**
     * Retrieves all available {@linkplain Chunk}(s).
     *
     * @return an immutable collection that contains all available chunk(s).
     */
    ImmutableCollection<Chunk> getAvailableChunks();

    /**
     * Retrieves all available {@linkplain Chunk} that matches the given {@linkplain Predicate}.
     *
     * @param predicate the predicate for filtering chunk(s).
     *
     * @return an immutable collection that contains all available chunk(s).
     */
    ImmutableCollection<Chunk> getAvailableChunks(Predicate<Chunk> predicate);

    /**
     * Loads a {@linkplain Chunk} at the given coordinates.
     *
     * @param x the x coordinates (in chunk coordinates).
     * @param y the y coordinates (in chunk coordinates).
     *
     * @return an {@linkplain Optional} reference of the {@linkplain Chunk} at the given position.
     */
    Optional<Chunk> loadChunk(int x, int y);

    /**
     * Loads a {@linkplain Chunk} at the given world coordinates.
     *
     * @param x the x coordinates (in world coordinates).
     * @param y the y coordinates (in world coordinates).
     *
     * @return an {@linkplain Optional} reference of the {@linkplain Chunk} at the given position.
     */
    Optional<Chunk> loadChunkAt(int x, int y);

    /**
     * Unloads the chunk of the given coordinates.
     *
     * @param x the x coordinates (in chunk coordinates).
     * @param y the y coordinates (in chunk coordinates).
     *
     * @return an {@linkplain Optional} reference of the {@linkplain Chunk} at the given position.
     */
    Optional<Chunk> unloadChunk(int x, int y);

    /**
     * Unloads the chunk of the given world coordinates.
     *
     * @param x the x coordinates (in world coordinates).
     * @param y the y coordinates (in world coordinates).
     *
     * @return an {@linkplain Optional} reference of the {@linkplain Chunk} at the given position.
     */
    Optional<Chunk> unloadChunkAt(int x, int y);
}