package com.achmadns.swing.testable;

import org.fest.reflect.core.Reflection;
import org.javabuilders.swing.SwingJavaBuilder;

import javax.swing.*;

public class TestFrame<T extends AppForm> extends JFrame {
    private final T form;

    public TestFrame(T form) {
        super("Test");
        this.form = form;
    }

    public T form() {
        return form;
    }

    public static TestFrame<AppForm> load(String arg) {
        try {
            AppForm form = Reflection.type(arg).loadAs(AppForm.class).newInstance();
            SwingJavaBuilder.build(form);
            return new TestFrame<>(form);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public TestFrame<T> view() {
        add(form);
        pack();
        setVisible(true);
        return this;
    }
}
