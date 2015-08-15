package com.achmadns.swing.testable;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;
import org.fest.reflect.core.Reflection;
import org.javabuilders.swing.SwingJavaBuilder;
import reactor.Environment;
import reactor.bus.Event;
import reactor.bus.EventBus;


import static reactor.bus.selector.Selectors.$;

public class TestFrame<T extends AppForm> extends javax.swing.JFrame implements Wrapper<T> {
    private static final long serialVersionUID = 8672261379191968734L;
    public static final String WINDOW_CLOSED = "window-closed";
    private final org.fest.reflect.type.Type type;
    @SuppressWarnings("unused")
    private JScrollPane container;
    private final EventBus bus = EventBus.create(Environment.get());

    public TestFrame(org.fest.reflect.type.Type type) throws InstantiationException, IllegalAccessException {
        this.type = type;
        SwingJavaBuilder.build(this);
        container.setViewportView(build());
    }

    @SuppressWarnings({"unchecked"})
    private T build() throws IllegalAccessException, InstantiationException {
        final AppForm form = type.loadAs(AppForm.class).newInstance();
        form.buildResult(SwingJavaBuilder.build(form));
        form.wrapper(this);
        form.bus().on($("form-closed"), (Event<?> e) -> close());
        return (T) form;
    }

    @Override
    @SuppressWarnings({"unchecked"})
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

    @SuppressWarnings("unused")
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

    private void close() {
        bus.notify(WINDOW_CLOSED);
    }

    public TestFrame<T> title(String title) {
        setTitle(title);
        return this;
    }

    public EventBus bus(){
        return bus;
    }

}
