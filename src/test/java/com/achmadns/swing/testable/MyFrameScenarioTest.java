package com.achmadns.swing.testable;

import org.assertj.swing.core.GenericTypeMatcher;
import org.assertj.swing.finder.WindowFinder;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.launcher.ApplicationLauncher;
import org.assertj.swing.testng.testcase.AssertJSwingTestngTestCase;
import org.testng.annotations.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

public class MyFrameScenarioTest extends AssertJSwingTestngTestCase {
    @Override
    protected void onSetUp() {
        ApplicationLauncher.application(MyFrame.class).start();
    }

    @Test
    public void show() throws InterruptedException {
        final FrameFixture frame = WindowFinder.findFrame(new GenericTypeMatcher<MyFrame>(MyFrame.class) {
            @Override
            protected boolean isMatching(MyFrame frame) {
                return true;
            }
        }).using(robot());
        frame.textBox("txtName").setText("Achmad");
        frame.comboBox("cmbCombo").selectItem(0);
        final MyFrame form = (MyFrame) frame.target();
        assertThat(form.getSelected()).isEqualTo("One");
        new CountDownLatch(1).await(3, TimeUnit.SECONDS);
    }

    @Test
    public void another() throws InterruptedException {
        final FrameFixture frame = WindowFinder.findFrame(new GenericTypeMatcher<MyFrame>(MyFrame.class) {
            @Override
            protected boolean isMatching(MyFrame frame) {
                return true;
            }
        }).using(robot());
        frame.textBox("txtName").setText("Sandi");
        frame.comboBox("cmbCombo").selectItem(2);
        final MyFrame form = (MyFrame) frame.target();
        assertThat(form.getSelected()).isEqualTo("Three");
        new CountDownLatch(1).await(3, TimeUnit.SECONDS);
    }
}

