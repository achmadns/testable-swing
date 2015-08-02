package com.achmadns.swing.testable;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.SwingWorker;

public class WorkerUtils {
	public static void execute(SwingWorker<?, ?> worker,
			PropertyChangeListener listener) {
		worker.addPropertyChangeListener(listener);
		worker.execute();
	}

	public static void execute(SwingWorker<?, ?> worker,
			final Runnable actionWhenDone) {
		execute(worker, new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if ("state".equals(evt.getPropertyName())
						&& SwingWorker.StateValue.DONE.equals(evt.getNewValue())) {
					// System.out.println(Thread.currentThread());
					actionWhenDone.run();
				}
			}
		});
	}

	public static void execute(SwingWorker<?, ?> worker) {
		execute(worker, (PropertyChangeListener) null);
	}
}
