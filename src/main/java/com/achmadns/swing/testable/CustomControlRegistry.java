package com.achmadns.swing.testable;

import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;

import org.javabuilders.swing.SwingJavaBuilderConfig;

import ca.odell.glazedlists.swing.EventListModel;

public class CustomControlRegistry {
	public static void register(SwingJavaBuilderConfig config) {
		config.addType(PersonBeanListCellRenderer.class);
		config.forType(JList.class)
				.children(PersonBeanListCellRenderer.class, 0, 1)
				.typeAsMethod(ListCellRenderer.class, "setCellRenderer");
		config.forType(JList.class).children(EventListModel.class, 0, 1)
				.typeAsMethod(ListModel.class, "setModel");
//		config.forType(JList.class).children(EventSelectionModel.class, 0, 1)
//				.typeAsMethod(ListSelectionModel.class, "setSelectionModel");
	}
}
