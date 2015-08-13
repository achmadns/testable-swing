package com.achmadns.swing.testable;

import javax.swing.SwingWorker;

import org.testng.annotations.Test;

public class WorkerUtilTest {
	@Test
	public void executeAndAct() {
		WorkerUtils.execute(new SwingWorker<Void, Void>() {

			@Override
			protected Void doInBackground() throws Exception {
				return null;
			}
		}, () -> {
            System.out.println("Alhamduilllah, selesai...");
        });
	}
}
