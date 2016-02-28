/**
 * This file is part of Argentum Online <https://github.com/Argentum Online>.
 *
 * Copyright (c) 2015-2016 - Agustin L. Alvarez <wolftein1@gmail.com>
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
package ar.com.argentum_online.server.world;

import ar.com.argentum_online.server.world.entity.Entity;
import ar.com.argentum_online.server.world.entity.EntityManager;
import ar.com.argentum_online.server.world.terrain.Chunk;
import ar.com.argentum_online.server.world.terrain.ChunkManager;
import com.gs.collections.api.collection.ImmutableCollection;

import java.util.Optional;
import java.util.function.Predicate;

/**
 * Represents the world.
 *
 * @author Agustin L. Alvarez <wolftein1@gmail.com>
 */
public final class World implements ChunkManager, EntityManager {
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isChunkLoaded(int x, int y) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isChunkDisposable(int x, int y) {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Chunk> getChunk(int x, int y) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Chunk> getChunk(int x, int y, boolean loadIfUnloaded) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Chunk> getChunkAt(int x, int y) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Chunk> getChunkAt(int x, int y, boolean loadIfUnloaded) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ImmutableCollection<Chunk> getAvailableChunks() {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ImmutableCollection<Chunk> getAvailableChunks(Predicate<Chunk> predicate) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Chunk> loadChunk(int x, int y) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Chunk> loadChunkAt(int x, int y) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Chunk> unloadChunk(int x, int y) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Chunk> unloadChunkAt(int x, int y) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Entity> getEntity(int id) {
        return null;
    }
}
