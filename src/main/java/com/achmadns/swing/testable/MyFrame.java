package com.achmadns.swing.testable;

import java.util.List;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import org.javabuilders.swing.SwingJavaBuilder;

import ca.odell.glazedlists.GlazedLists;

public class MyFrame extends JFrame {
	private static final long serialVersionUID = -141629436358443196L;
	private List<String> refList = GlazedLists.eventListOf("One", "Two",
			"Three");
	private String selected;

	public MyFrame() {
		super();
		SwingJavaBuilder.build(this);
	}

	public static void main(String... args) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		System.out.println("showing...");
		new MyFrame().setVisible(true);
		System.out.println("finished...");
	}

	public List<String> getRefList() {
		return refList;
	}

//	public void show() {
//		// JOptionPane.showMessageDialog(this,
//		// String.format("SelectedItem: %s", selected));
//	}

	public String getSelected() {
		return selected;
	}

	public void setSelected(String selected) {
		String old = this.selected;
		this.selected = selected;
		firePropertyChange("selected", old, selected);
	}
}
