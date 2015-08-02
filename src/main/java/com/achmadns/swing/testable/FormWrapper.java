package com.achmadns.swing.testable;

import java.awt.Container;

import javax.swing.JDialog;

public class FormWrapper<T extends AppForm, C extends Container> implements
		Wrapper<T> {
	protected T form;
	protected C container;

	public FormWrapper(T form, C container) {
		super();
		this.form = form;
		this.container = container;
	}

	public <F extends AppForm> FormWrapper<F, JDialog> asDialog(F form) {
		return new FormWrapper<F, JDialog>(form, new JDialog());
	}

	@Override
	public void close() {
	}

	@Override
	public void setForm(T form) {
		this.form = form;
	}

	@Override
	public T getForm() {
		return form;
	}

	public C show() {
		container.add(form);
		return container;
	}

}
