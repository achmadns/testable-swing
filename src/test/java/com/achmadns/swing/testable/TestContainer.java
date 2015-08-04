package com.achmadns.swing.testable;

import org.javabuilders.swing.SwingJavaBuilder;
import org.javabuilders.swing.SwingJavaBuilderConfig;
import org.javabuilders.swing.plugin.glazedlists.SwingGlazedListsConfig;

import javax.swing.*;

public class TestContainer {

    public static void main(final String[] args) throws IllegalAccessException, InstantiationException {
        SwingUtilities.invokeLater(() -> {
            SwingJavaBuilderConfig config = SwingJavaBuilder.getConfig();
            SwingGlazedListsConfig.init(config);
            CustomControlRegistry.register(config);
            TestFrame.load(args[0]).view();
        });
    }
}
