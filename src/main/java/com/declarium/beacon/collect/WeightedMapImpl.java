package com.declarium.beacon.collect;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * A default implementation of a {@link WeightedMap} using an
 * internal {@link TreeMap}.
 *
 * @param <V> the type of values to hold
 *
 * @author Jay Carr
 * @version 1.0
 */
public final class WeightedMapImpl<V> implements WeightedMap<V> {

    private final NavigableMap<Double, V> delegate = new TreeMap<>();
    private double totalChance;

    @Override
    public V poll() {
        Entry<Double, V> entry = this.delegate.ceilingEntry(this.nextChance());
        return this.delegate.remove(entry.getKey());
    }

    @Override
    public V peek() {
        return this.delegate.ceilingEntry(this.nextChance()).getValue();
    }

    /**
     * Return a random double based on a maximum of the total key
     * weight of the map.
     *
     * @return the random chance
     */
    private double nextChance() {
        return ThreadLocalRandom.current().nextDouble(this.totalChance);
    }

    @Override
    public int size() {
        return this.delegate.size();
    }

    @Override
    public boolean isEmpty() {
        return this.delegate.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.delegate.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.delegate.containsValue(value);
    }

    @Override
    public V get(Object chance) {
        return this.delegate.get(chance);
    }

    @Override
    public V put(Double chance, V value) {
        return this.delegate.put(this.totalChance += chance, value);
    }

    @Override
    public V remove(Object key) {
        if (key instanceof Double) {
            this.totalChance -= (Double) key;
        }
        return this.delegate.remove(key);
    }

    @Override
    public void putAll(Map<? extends Double, ? extends V> all) {
        this.delegate.putAll(all);
    }

    @Override
    public void clear() {
        this.delegate.clear();
    }

    @Override
    public Set<Double> keySet() {
        return this.delegate.keySet();
    }

    @Override
    public Collection<V> values() {
        return this.delegate.values();
    }

    @Override
    public Set<Entry<Double, V>> entrySet() {
        return this.delegate.entrySet();
    }
}