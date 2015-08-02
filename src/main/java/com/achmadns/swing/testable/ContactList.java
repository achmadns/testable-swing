package com.achmadns.swing.testable;

import static com.achmadns.swing.testable.PropertyChangeEventInterpreter.interpret;
import static com.achmadns.swing.testable.WorkerUtils.execute;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.JList;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.swing.EventSelectionModel;

public class ContactList extends AppForm {

	private static final long serialVersionUID = 5987100354306640704L;
	private PersonBean person = new PersonBean();
	private EventList<PersonBean> persons = new BasicEventList<PersonBean>();
	private EventSelectionModel<PersonBean> selectionModel;
	private JList personList;

	public ContactList() {
		super();
		selectionModel = new EventSelectionModel<PersonBean>(persons);
	}

	public void close() {
		wrapper.close();
	}

	public void delegate() {
		System.out
				.println("Doing something in background thread that will throw an exception...\n");
		execute(new Worker<String, Void>() {

			@Override
			protected String doInBackground() {
				error();
				return "";
			}

			@Override
			protected void done(String value) {
				System.out.println(value);
			}

		}, new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				System.out.println(interpret(evt) + "\n\n");
			}
		});
	}

	public void error() {
		throw new RuntimeException("try an error...");
	}

	public void doNew() {
		setPerson(new PersonBean());
	}

	public void delete() {
		if (personList.getSelectedValue() != null) {
			persons.remove(selectionModel.getSelected().get(0));
		}
	}

	public void edit() {
		if (personList.getSelectedValue() != null)
			setPerson(selectionModel.getSelected().get(0));
	}

	public void save() {
		persons.add(person);
		setPerson(new PersonBean());
	}

	public void cancel() {
		System.out.println("btnCancel clicked");
	}

	public List<PersonBean> getPersons() {
		return persons;
	}

	public EventSelectionModel<PersonBean> getSelectionModel() {
		return selectionModel;
	}

	public PersonBean getPerson() {
		return person;
	}

	public void setPerson(PersonBean person) {
		PersonBean old = this.person;
		this.person = person;
		firePropertyChange("person", old, person);
	}
}
