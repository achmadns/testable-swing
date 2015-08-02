package com.achmadns.swing.testable;

import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowTester {
	public static <T extends Window> void show(T window) {
		final Thread testerThread = Thread.currentThread();
		window.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				synchronized (testerThread) {
					testerThread.notify();
				}
			}
		});
		window.pack();
		window.setVisible(true);
		synchronized (testerThread) {
			try {
				testerThread.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
