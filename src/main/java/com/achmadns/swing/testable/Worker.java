package com.achmadns.swing.testable;

import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

public abstract class Worker<T, V> extends SwingWorker<T, V> {

	@Override
	protected void done() {
		try {
			done(get());
		} catch (InterruptedException e) {
			delegateException(e);
		} catch (ExecutionException e) {
			delegateException(e.getCause());
		}
	}

	protected void delegateException(Throwable t) {
		Thread.getDefaultUncaughtExceptionHandler().uncaughtException(
				Thread.currentThread(), t);
	}

	protected void done(T value) {

	}
}
