package com.achmadns.swing.testable;

import reactor.Environment;
import reactor.bus.EventBus;

public final class Reactor {
    static {
        Environment.initializeIfEmpty();
    }

    public static final EventBus BUS = EventBus.create(Environment.get());

    private Reactor() {
    }
}
