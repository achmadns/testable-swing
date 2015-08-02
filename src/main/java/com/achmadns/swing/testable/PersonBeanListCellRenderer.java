package com.achmadns.swing.testable;

import java.awt.Component;

import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

public class PersonBeanListCellRenderer extends DefaultListCellRenderer {

	private static final long serialVersionUID = -1724459190999353454L;

	@Override
	public Component getListCellRendererComponent(JList list, Object value,
			int index, boolean isSelected, boolean cellHasFocus) {
		super.getListCellRendererComponent(list, value, index, isSelected,
				cellHasFocus);
		if (value instanceof PersonBean) {
			PersonBean person = (PersonBean) value;
			setText(String.format("%s %s, %s", person.getFirstName(),
					person.getLastName(), person.getCity()));
		}
		return this;
	}
}
