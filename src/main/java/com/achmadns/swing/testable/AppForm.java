package com.achmadns.swing.testable;

import javax.swing.JPanel;

import org.javabuilders.BuildResult;

public class AppForm extends JPanel {
	private static final long serialVersionUID = 5738946067567517085L;
	protected BuildResult buildResult;
	protected AccessLevel accessLevel;
	protected boolean visible;
	protected Wrapper<AppForm> wrapper;

	public void initialize() {
	}

	public BuildResult getBuildResult() {
		return buildResult;
	}

	public void setBuildResult(BuildResult buildResult) {
		this.buildResult = buildResult;
	}

	public AccessLevel getAccessLevel() {
		return accessLevel;
	}

	public void setAccessLevel(AccessLevel accessLevel) {
		this.accessLevel = accessLevel;
	}

	@Override
	public void setVisible(boolean visible) {
		super.setVisible(visible);
		boolean old = this.visible;
		this.visible = visible;
		firePropertyChange("visible", old, visible);
	}

	public Wrapper<AppForm> getWrapper() {
		return wrapper;
	}

	public void setWrapper(Wrapper<AppForm> wrapper) {
		this.wrapper = wrapper;
	}
}
