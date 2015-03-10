package org.nodcloud.commons.model.notifaction.impl;

import org.nodcloud.commons.model.notifaction.AbstratcNotifactionMessage;

public class SuccessNotifaction extends AbstratcNotifactionMessage {

    public SuccessNotifaction(String message) {
        super(message);
    }

    @Override
    public boolean isSuccess() {
        return true;
    }

}
