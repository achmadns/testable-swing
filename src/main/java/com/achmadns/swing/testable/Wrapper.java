package com.achmadns.swing.testable;

/**
 * Wrap a form to be freely presented as dialog or another. I first found this idea from Mr. Fredy.
 *
 * @param <T>
 */
public interface Wrapper<T extends AppForm> {

    /**
     * Get form contained
     *
     * @return form instance
     */
    T form();
}
