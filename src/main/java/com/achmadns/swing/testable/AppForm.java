package com.achmadns.swing.testable;

import javax.swing.JPanel;

import org.javabuilders.BuildResult;

/**
 * Our user interface container
 */
public class AppForm extends JPanel {
    private static final long serialVersionUID = 5738946067567517085L;
    protected BuildResult buildResult;
    protected AccessLevel accessLevel;
    protected boolean visible;
    protected Wrapper<AppForm> wrapper;

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

    public Wrapper<AppForm> wrapper() {
        return wrapper;
    }

    public void wrapper(Wrapper<AppForm> wrapper) {
        this.wrapper = wrapper;
    }
}
