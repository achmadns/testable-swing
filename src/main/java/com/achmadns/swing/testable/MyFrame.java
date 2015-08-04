package com.achmadns.swing.testable;

import ca.odell.glazedlists.GlazedLists;
import org.javabuilders.swing.SwingJavaBuilder;

import javax.swing.*;
import java.util.List;

import static javax.swing.SwingUtilities.invokeLater;
import static javax.swing.UIManager.getSystemLookAndFeelClassName;
import static javax.swing.UIManager.setLookAndFeel;

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
        invokeLater(() -> {
            try {
                setLookAndFeel(getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
            System.out.println("showing...");
            final MyFrame frame = new MyFrame();
            frame.pack();
            frame.setVisible(true);
        });
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
