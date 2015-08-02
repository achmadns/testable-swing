package com.achmadns.swing.testable;

public interface Wrapper<T extends AppForm> {

	void close();

	void setForm(T form);

	T getForm();
}
