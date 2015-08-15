package com.achmadns.swing.testable;

import ca.odell.glazedlists.BasicEventList;
import ca.odell.glazedlists.EventList;
import ca.odell.glazedlists.swing.EventSelectionModel;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.SwingUtilities;
import org.javabuilders.swing.SwingJavaBuilder;
import org.javabuilders.swing.SwingJavaBuilderConfig;
import org.javabuilders.swing.plugin.glazedlists.SwingGlazedListsConfig;


import static com.achmadns.swing.testable.PropertyChangeEventInterpreter.interpret;
import static com.achmadns.swing.testable.WorkerUtils.execute;

public class ContactList extends AppForm<ContactList> {

    private static final long serialVersionUID = 5987100354306640704L;
    private PersonBean person = new PersonBean();
    private final EventList<PersonBean> persons = new BasicEventList<>();
    private final EventSelectionModel<PersonBean> selectionModel;
    @SuppressWarnings("unused")
    private JList personList;

    public ContactList() {
        super();
        selectionModel = new EventSelectionModel<>(persons);
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

        }, evt -> {
            System.out.println(interpret(evt) + "\n\n");
        });
    }

    public void error() {
        throw new RuntimeException("try an error...");
    }

    @SuppressWarnings("unused")
    public void doNew() {
        setPerson(new PersonBean());
    }

    @SuppressWarnings("unused")
    public void delete() {
        if (personList.getSelectedValue() != null) {
            persons.remove(selectionModel.getSelected().get(0));
        }
    }

    @SuppressWarnings("unused")
    public void edit() {
        if (personList.getSelectedValue() != null)
            setPerson(selectionModel.getSelected().get(0));
    }

    @SuppressWarnings("unused")
    public void save() {
        persons.add(person);
        setPerson(new PersonBean());
    }

    @SuppressWarnings("unused")
    public void cancel() {
        System.out.println("btnCancel clicked");
    }

    @SuppressWarnings("unused")
    public List<PersonBean> getPersons() {
        return persons;
    }

    @SuppressWarnings("unused")
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            SwingJavaBuilderConfig config = SwingJavaBuilder.getConfig();
            SwingGlazedListsConfig.init(config);
            CustomControlRegistry.register(config);
            final JFrame frame = new JFrame();
            final ContactList contactList = new ContactList();
            SwingJavaBuilder.build(contactList);
            frame.add(contactList);
            frame.pack();
            frame.setVisible(true);
        });
    }
}
