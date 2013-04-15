package org.inmeta.common.process;

/**
 * Action not found.
 *
 * @author Alexander Vaagan
 */
public class ActionNotFoundException extends RuntimeException {

    /**
     * Constructor.
     * @param actionName The name of the action
     */
    public ActionNotFoundException(final String actionName) {
        super(actionName);
    }
}
