package com.achmadns.swing.testable;

import javax.swing.JPanel;

import org.javabuilders.BuildResult;
import reactor.Environment;
import reactor.bus.EventBus;

/**
 * Our user interface container.
 */
public class AppForm<T extends AppForm> extends JPanel {
    private static final long serialVersionUID = 5738946067567517085L;
    protected BuildResult buildResult;
    protected AccessLevel accessLevel;
    protected boolean visible;
    protected Wrapper<T> wrapper;
    private final EventBus eventBus;

    public AppForm() {
        eventBus = EventBus.create(Environment.get());
    }

    public void initialize() {
    }

    public BuildResult buildResult() {
        return buildResult;
    }

    public void buildResult(BuildResult buildResult) {
        this.buildResult = buildResult;
    }

    public AccessLevel accessLevel() {
        return accessLevel;
    }

    public void accessLevel(AccessLevel accessLevel) {
        this.accessLevel = accessLevel;
    }

    @Override
    public void setVisible(boolean visible) {
        super.setVisible(visible);
        boolean old = this.visible;
        this.visible = visible;
        firePropertyChange("visible", old, visible);
    }

    public Wrapper<T> wrapper() {
        return wrapper;
    }

    public void wrapper(Wrapper<T> wrapper) {
        this.wrapper = wrapper;
    }

    public EventBus bus() {
        return eventBus;
    }

    public void close(){
        bus().notify("form-closed");
    }
}
