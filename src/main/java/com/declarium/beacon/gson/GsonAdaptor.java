package com.declarium.beacon.gson;

import com.google.gson.JsonDeserializer;
import com.google.gson.JsonSerializer;

/**
 * A type adaptor providing both serialization and
 * deserialization for Gson.
 *
 * @param <T> the adaptor type
 * @author Jay Carr
 * @version 1.0
 */
public interface GsonAdaptor<T> extends JsonSerializer<T>, JsonDeserializer<T> {
}