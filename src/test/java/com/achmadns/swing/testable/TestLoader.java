package com.achmadns.swing.testable;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.lang.Thread.UncaughtExceptionHandler;

import javax.swing.JDialog;

import org.javabuilders.swing.SwingJavaBuilder;
import org.javabuilders.swing.SwingJavaBuilderConfig;
import org.javabuilders.swing.plugin.glazedlists.SwingGlazedListsConfig;
import org.jdesktop.swingx.JXFrame;

/**
 * Loader that used to test an AppForm.
 * 
 * @author sandi
 * 
 * @param <T>
 */
public class TestLoader<T extends AppForm> extends JDialog implements
		Wrapper<T> {

	private static final long serialVersionUID = -8104929680776638736L;
	private Thread testerThread;
	private T form;

	@SuppressWarnings("unchecked")
	public TestLoader(T form) {
		super((JDialog) null, true);
		// access the tester thread so that our form test won't be immediately
		// closed after showing it.
		testerThread = Thread.currentThread();
		Thread.setDefaultUncaughtExceptionHandler(new UncaughtExceptionHandler() {

			@SuppressWarnings("deprecation")
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				synchronized (testerThread) {
					System.out
							.println("There was an accident Bro! Here are the details:\n");
					e.printStackTrace();
					// Pass the exception into tester thread.
					testerThread.stop(e);
				}
			}
		});
		form.wrapper((Wrapper<AppForm>) this);
		build();
	}

	/**
	 * Load form using its class.
	 * 
	 * @param <T>
	 * @param clazz
	 * @return
	 */
	public static <T extends AppForm> TestLoader<T> load(Class<T> clazz) {
		try {
			return new TestLoader<T>(clazz.newInstance());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	private void build() {
//		try {
//			UIManager.setLookAndFeel(new SeaGlassLookAndFeel());
//		} catch (UnsupportedLookAndFeelException e) {
//			e.printStackTrace();
//		}
		SwingJavaBuilderConfig config = SwingJavaBuilder.getConfig();
		// register glazed list lib
		SwingGlazedListsConfig.init(config);
		// register custom components
		CustomControlRegistry.register(config);
		form.buildResult(SwingJavaBuilder.build(form));
		form.initialize();
	}

	/**
	 * Show the form we wanna test.
	 * 
	 * @param title
	 *            title of test form
	 * @return
	 */
	public TestLoader<T> show(final String title) {
		final JXFrame frame = new JXFrame(null != title ? title
				: "Test of ".concat(form.getClass().getName()), true);
		frame.addWindowListener(new WindowAdapter() {
			//
			@Override
			public void windowClosing(WindowEvent e) {
				continueTesterThread();
			}
		});
		frame.add(form);
		frame.pack();
		frame.setVisible(true);
		pauseTesterThread();

		// setVisible(true);
		// SwingUtilities.invokeLater(new Runnable() {
		//
		// @Override
		// public void run() {
		// testerThread = Thread.currentThread();
		// add(form);
		// setTitle(title);
		// pack();
		// }
		// });
		return this;
	}

	/**
	 * Pause the tester thread so that we can test the form.
	 */
	private void pauseTesterThread() {
		synchronized (testerThread) {
			try {
				testerThread.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static <T extends AppForm> TestLoader<T> loadAndShow(Class<T> clazz,
			String title) {
		return load(clazz).show(title);
	}

	@Override
	public void close() {
		continueTesterThread();
	}

	/**
	 * Notify tester thread that we finished testing the form.
	 */
	private void continueTesterThread() {
		synchronized (testerThread) {
			testerThread.notify();
		}
	}

	@Override
	public T form() {
		return form;
	}

}
