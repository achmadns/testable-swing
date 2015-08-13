package com.achmadns.swing.testable;

import org.fest.reflect.core.Reflection;
import org.javabuilders.swing.SwingJavaBuilder;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import static com.achmadns.swing.testable.TestContainer.EVENT_BUS;

public class TestFrame<T extends AppForm> extends javax.swing.JFrame {
    private static final long serialVersionUID = 8672261379191968734L;
    public static final String WINDOW_CLOSED = "window-closed";
    private final org.fest.reflect.type.Type type;
    private JScrollPane container;

    public TestFrame(org.fest.reflect.type.Type type) throws InstantiationException, IllegalAccessException {
        super("Test");
        this.type = type;
        SwingJavaBuilder.build(this);
        container.setViewportView(build());
    }

    private T build() throws IllegalAccessException, InstantiationException {
        final AppForm form = type.loadAs(AppForm.class).newInstance();
        form.setBuildResult(SwingJavaBuilder.build(form));
        return (T) form;
    }

    public T form() {
        return (T) container.getViewport().getComponent(0);
    }

    public static TestFrame<AppForm> load(String arg) {
        try {
            final org.fest.reflect.type.Type type = Reflection.type(arg);
            return new TestFrame<>(type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void reload() throws InstantiationException, IllegalAccessException {
        container.setViewportView(build());
    }

    public TestFrame<T> view() {
        pack();
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                EVENT_BUS.notify(WINDOW_CLOSED);
            }
        });
        return this;
    }
}
