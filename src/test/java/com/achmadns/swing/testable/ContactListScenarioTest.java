package com.achmadns.swing.testable;

import java.util.concurrent.CountDownLatch;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.testng.testcase.AssertJSwingTestngTestCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;
import reactor.bus.Event;


import static com.achmadns.swing.testable.TestFrame.WINDOW_CLOSED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.swing.finder.WindowFinder.findFrame;
import static org.assertj.swing.launcher.ApplicationLauncher.application;
import static reactor.bus.selector.Selectors.$;

public class ContactListScenarioTest extends AssertJSwingTestngTestCase {
    private final Logger log = LoggerFactory.getLogger(getClass());

    @Override
    protected void onSetUp() {
        application(TestContainer.class).withArgs(ContactList.class.getName(), "Contact List Demo").start();
    }

    @Test
    public void show() throws InterruptedException {
        final FrameFixture frame = findFrame(TestFrame.class).using(robot());
        frame.textBox("txtFirstName").setText("Achmad");
        final TestFrame<ContactList> target = (TestFrame<ContactList>) frame.target();
        assertThat(target.form().getPerson().getFirstName()).isEqualTo("Achmad");
        final CountDownLatch counter = new CountDownLatch(1);
        target.bus().on($(WINDOW_CLOSED), (Event<?> e) -> counter.countDown());
        frame.button("btnClose").click();
        counter.await();
    }

}
