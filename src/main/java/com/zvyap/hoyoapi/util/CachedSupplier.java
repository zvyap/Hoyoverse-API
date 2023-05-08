package com.zvyap.hoyoapi.util;

import java.util.function.Supplier;

public class CachedSupplier<T> implements Supplier<T> {

    private T cached;
    private final Supplier<T> supplier;

    public CachedSupplier(Supplier<T> supplier) {
        this.supplier = supplier;
    }

    @Override
    public T get() {
        if(cached == null) {
            cached = supplier.get();
        }
        return cached;
    }
}
