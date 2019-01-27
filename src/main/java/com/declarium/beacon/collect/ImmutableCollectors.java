package com.declarium.beacon.collect;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.util.function.Function;
import java.util.stream.Collector;

/**
 * Provides immutable variants of {@link Collector}
 * instances.
 *
 * @author Jay Carr
 * @version 1.0
 */
public final class ImmutableCollectors {

    private ImmutableCollectors() {
        throw new AssertionError("Cannot instantiate this class.");
    }

    public static <T> Collector<T, ?, ImmutableList<T>> toList() {
        return Collector.of(
                ImmutableList.Builder::new,
                ImmutableList.Builder::add,
                (r, t) -> r.addAll(t.build()),
                (Function<ImmutableList.Builder<T>, ImmutableList<T>>) ImmutableList.Builder::build);

    }

    public static <T> Collector<T, ?, ImmutableSet<T>> toSet() {
        return Collector.of(
                ImmutableSet.Builder::new,
                ImmutableSet.Builder::add,
                (r, t) -> r.addAll(t.build()),
                (Function<ImmutableSet.Builder<T>, ImmutableSet<T>>) ImmutableSet.Builder::build);
    }
}