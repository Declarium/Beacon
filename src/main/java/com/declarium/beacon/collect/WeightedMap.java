package com.declarium.beacon.collect;

import java.util.Map;

/**
 * A mapped collection whereby values can be retrieved
 * at random based on a weighted chance.
 *
 * @param <V> the type of values to hold
 *
 * @author Jay Carr
 * @version 1.0
 */
public interface WeightedMap<V> extends Map<Double, V> {

    /**
     * Returns a random value from the internal map based
     * on weighting, removing it in the process.
     *
     * @return the random value
     */
    V poll();

    /**
     * Returns a random value from the internal map based
     * on weighting without removing it.
     *
     * @return the random value
     */
    V peek();

    /**
     * Creates a new, empty {@link WeightedMap}.
     *
     * @param <V> the value type
     * @return the new weighted map
     */
    static <V> WeightedMap<V> create() {
        return new WeightedMapImpl<>();
    }
}