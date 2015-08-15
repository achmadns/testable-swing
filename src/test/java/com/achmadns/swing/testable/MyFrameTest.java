package com.achmadns.swing.testable;

import net.miginfocom.swing.MigLayout;
import org.jdesktop.swingx.JXFrame;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import javax.swing.*;

public class MyFrameTest {
	private static final Logger LOG = LoggerFactory
			.getLogger(MyFrameTest.class);

	@Test
	public void justShow() throws InterruptedException {
		WindowTester.show(new MyFrame());
	}

	@Test(enabled = false)
	public void showStill() throws InterruptedException,
			ClassNotFoundException, InstantiationException,
			IllegalAccessException, UnsupportedLookAndFeelException {
		LOG.info("Showing my panel.");
		// UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		MyFrame frame = new MyFrame();
		// panel.pack();
		// frame.setVisible(true);
		frame.show();
		Thread.sleep(50000);
		// JDesktopPane pane = new JDesktopPane();
		// pane.add(frame);
		// pane.setVisible(true);
	}

	@Test(enabled = false)
	public void showPanel() throws InterruptedException,
			UnsupportedLookAndFeelException {
		JPanel panel = new JPanel();
		panel.setLayout(new MigLayout());
		panel.add(new JButton("Clik!"), "grow");
		// panel.revalidate();
		// panel.setVisible(true);
		JFrame frame = new JFrame();
		frame.setLayout(new MigLayout());
		frame.setContentPane(panel);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Thread.sleep(50000);
		System.out.println("");
	}

	@Test(enabled = false)
	public void showFrame() {
		JXFrame frame = new JXFrame("test", true);
		frame.setVisible(true);
	}
}
