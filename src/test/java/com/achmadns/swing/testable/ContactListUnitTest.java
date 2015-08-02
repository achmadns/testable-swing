package com.achmadns.swing.testable;

import static com.achmadns.swing.testable.TestLoader.load;
import static org.testng.Assert.assertEquals;

import javax.swing.JTextField;

import org.javabuilders.BuildResult;
import org.testng.annotations.Test;

public class ContactListUnitTest {

	@Test(groups = "unit", expectedExceptions = RuntimeException.class)
	public void loadAndCallCertainMethodThatThrowsException() {
		load(ContactList.class).getForm().error();
	}

	// still unable to delegate worker exception
	@Test(groups = "unit", expectedExceptions = RuntimeException.class, enabled = false)
	public void loadAndCallErrorMethod() {
		TestLoader<ContactList> loader = load(ContactList.class);
		loader.getForm().delegate();
	}

	@Test(groups = "unit")
	public void bindingTest() {
		TestLoader<ContactList> loader = load(ContactList.class);
		PersonBean person = loader.getForm().getPerson();
		person.setFirstName("Achmad");
		person.setLastName("Nasirudin");
		BuildResult buildResult = loader.getForm().getBuildResult();
		JTextField txtFirstName = (JTextField) buildResult.get("txtFirstName");
		JTextField txtLastName = (JTextField) buildResult.get("txtLastName");
		assertEquals("Achmad", txtFirstName.getText());
		assertEquals("Nasirudin", txtLastName.getText());
	}
}
