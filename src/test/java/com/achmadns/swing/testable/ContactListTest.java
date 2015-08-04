package com.achmadns.swing.testable;

import static com.achmadns.swing.testable.TestLoader.load;
import static com.achmadns.swing.testable.TestLoader.loadAndShow;
import static org.testng.Assert.assertEquals;

import javax.swing.JTextField;

import org.javabuilders.BuildResult;
import org.testng.annotations.Test;

public class ContactListTest {

	@Test(groups = "look")
	public void show() {
		loadAndShow(ContactList.class, "Look test only");
	}

	@Test(groups = "look")
	public void showFilledPersonBean() {
		TestLoader<ContactList> loader = load(ContactList.class);
		PersonBean person = loader.getForm().getPerson();
		person.setFirstName("Achmad");
		person.setLastName("Nasirudin");
		person.setPhone("1234456");
		person.setEmail("achmad@nasirudin.sandi");
		person.setAddress1("Kalibata");
		person.setAddress2("Tlogowaru");
		person.setCity("Jakarta");
		person.setState("South Jakarta");
		person.setZipCode("12770");
		person.setCountry("Indonesia");
		loader.show("Person bean filled");
		BuildResult buildResult = loader.getForm().getBuildResult();
		JTextField txtFirstName = (JTextField) buildResult.get("txtFirstName");
		JTextField txtLastName = (JTextField) buildResult.get("txtLastName");
		assertEquals("Achmad", txtFirstName.getText());
		assertEquals("Nasirudin", txtLastName.getText());
	}

	@Test(groups = "look", expectedExceptions = RuntimeException.class)
	public void showAndClickError() {
		loadAndShow(ContactList.class, "Click the error button!");
	}

	@Test(groups = "look", expectedExceptions = RuntimeException.class)
	public void showAndClickDelegate() {
		loadAndShow(ContactList.class, "Click the delegate button!");
	}
}
