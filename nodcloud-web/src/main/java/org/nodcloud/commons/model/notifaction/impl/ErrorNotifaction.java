package org.nodcloud.commons.model.notifaction.impl;

import org.nodcloud.commons.model.notifaction.AbstratcNotifactionMessage;

public class ErrorNotifaction extends AbstratcNotifactionMessage {

    public ErrorNotifaction(String message) {
        super(message);
    }

    @Override
    public boolean isError() {
        return true;
    }

}
