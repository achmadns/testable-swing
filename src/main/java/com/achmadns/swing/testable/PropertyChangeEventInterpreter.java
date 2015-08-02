package com.achmadns.swing.testable;

import java.beans.PropertyChangeEvent;
import java.text.MessageFormat;

public class PropertyChangeEventInterpreter {

	public static String interpret(PropertyChangeEvent evt) {
		return MessageFormat.format("{0} changes from {1} into {2}",
				evt.getPropertyName(), evt.getOldValue(), evt.getNewValue());
	}

}
