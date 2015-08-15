package com.achmadns.swing.testable;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;
import org.fest.reflect.core.Reflection;
import org.javabuilders.swing.SwingJavaBuilder;


import static com.achmadns.swing.testable.Reactor.BUS;

public class TestFrame<T extends AppForm> extends javax.swing.JFrame implements Wrapper<T> {
    private static final long serialVersionUID = 8672261379191968734L;
    public static final String WINDOW_CLOSED = "window-closed";
    private final org.fest.reflect.type.Type type;
    private JScrollPane container;

    public TestFrame(org.fest.reflect.type.Type type) throws InstantiationException, IllegalAccessException {
        this.type = type;
        SwingJavaBuilder.build(this);
        container.setViewportView(build());
    }

    private T build() throws IllegalAccessException, InstantiationException {
        final AppForm form = type.loadAs(AppForm.class).newInstance();
        form.buildResult(SwingJavaBuilder.build(form));
        form.wrapper((Wrapper<AppForm>) this);
        return (T) form;
    }

    @Override
    public T form() {
        return (T) container.getViewport().getComponent(0);
    }

    public static TestFrame<AppForm> load(String className) {
        try {
            final org.fest.reflect.type.Type type = Reflection.type(className);
            return new TestFrame<>(type);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void reload() throws InstantiationException, IllegalAccessException {
        container.setViewportView(build());
        invalidate();
        pack();
    }

    public TestFrame<T> view() {
        pack();
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                close();
            }
        });
        return this;
    }

    public TestFrame<T> title(String title) {
        setTitle(title);
        return this;
    }

    @Override
    public void close() {
        BUS.notify(WINDOW_CLOSED);
    }
}
