package com.achmadns.swing.testable;

import org.javabuilders.swing.SwingJavaBuilder;
import org.javabuilders.swing.SwingJavaBuilderConfig;
import org.javabuilders.swing.plugin.glazedlists.SwingGlazedListsConfig;
import reactor.Environment;
import reactor.bus.EventBus;

import javax.swing.*;

public class TestContainer {
    static {
        Environment.initializeIfEmpty();
    }
    public static final EventBus EVENT_BUS = EventBus.create(Environment.get());

    public static void main(final String[] args) throws IllegalAccessException, InstantiationException {
        SwingUtilities.invokeLater(() -> {
            SwingJavaBuilderConfig config = SwingJavaBuilder.getConfig();
            SwingGlazedListsConfig.init(config);
            CustomControlRegistry.register(config);
            TestFrame.load(args[0]).view();
        });
    }
}
