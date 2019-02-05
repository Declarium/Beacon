package com.declarium.beacon.gson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * A static utility supplier for default Gson instances.
 *
 * @author Jay Carr
 * @version 1.0
 */
public final class GsonSupplier {

    private static final Gson NORMAL = new GsonBuilder()
            .serializeNulls()
            .create();
    private static final Gson PRETTY = new GsonBuilder()
            .serializeNulls()
            .setPrettyPrinting()
            .create();

    private GsonSupplier() {
        throw new AssertionError("Cannot instantiate this class.");
    }

    /**
     * Provides a default {@link Gson} instance
     * with null serializing.
     *
     * @return the gson instance
     */
    public static Gson normal() {
        return NORMAL;
    }

    /**
     * Provides a default {@link Gson} instance
     * with null serializing and pretty printing.
     *
     * @return the gson instance
     */
    public static Gson pretty() {
        return PRETTY;
    }
}