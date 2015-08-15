package com.achmadns.swing.testable;

import com.alee.laf.WebLookAndFeel;
import org.javabuilders.swing.SwingJavaBuilder;
import org.javabuilders.swing.SwingJavaBuilderConfig;
import org.javabuilders.swing.plugin.glazedlists.SwingGlazedListsConfig;

import javax.swing.*;

public class TestContainer {

    /**
     * Our GUI test main point.
     *
     * @param args class name (mandatory) and title (optional) as array
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    public static void main(final String[] args) throws IllegalAccessException, InstantiationException {
        SwingUtilities.invokeLater(() -> {
            WebLookAndFeel.install();
            SwingJavaBuilderConfig config = SwingJavaBuilder.getConfig();
            SwingGlazedListsConfig.init(config);
            CustomControlRegistry.register(config);
            TestFrame.load(args[0]).title(args.length > 1 ? args[1] : "Test").view();
        });
    }
}
