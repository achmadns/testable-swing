package com.achmadns.swing.testable;

import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.testng.testcase.AssertJSwingTestngTestCase;
import org.testng.annotations.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.swing.finder.WindowFinder.findFrame;
import static org.assertj.swing.launcher.ApplicationLauncher.application;

public class ContactListScenarioTest extends AssertJSwingTestngTestCase {
    @Override
    protected void onSetUp() {
        application(TestContainer.class).withArgs(ContactList.class.getName()).start();
    }

    @Test
    public void show() throws InterruptedException {
        final FrameFixture frame = findFrame(TestFrame.class).using(robot());
        frame.textBox("txtFirstName").setText("Achmad");
        final TestFrame<ContactList> target = (TestFrame<ContactList>) frame.target();
        assertThat(target.form().getPerson().getFirstName()).isEqualTo("Achmad");
        new CountDownLatch(1).await(3, TimeUnit.SECONDS);
    }

}
