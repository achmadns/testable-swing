package com.achmadns.swing.testable;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.beans.VetoableChangeSupport;

public class Bean {
	private PropertyChangeSupport propertyChangeSupport;
	private VetoableChangeSupport vetoableChangeSupport;

	public Bean() {
		propertyChangeSupport = new PropertyChangeSupport(this);
		vetoableChangeSupport = new VetoableChangeSupport(this);
	}

	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}

	public void addPropertyChangeListener(String fieldName,
			PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(fieldName, listener);
	}

	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	public void removePropertyChangeListener(String fieldName,
			PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(fieldName, listener);
	}

	protected void firePropertyChange(String fieldName, Object old,
			Object newVal) {
		propertyChangeSupport.firePropertyChange(fieldName, old, newVal);
	}

	public PropertyChangeSupport getPropertyChangeSupport() {
		return propertyChangeSupport;
	}

	public VetoableChangeSupport getVetoableChangeSupport() {
		return vetoableChangeSupport;
	}
}
