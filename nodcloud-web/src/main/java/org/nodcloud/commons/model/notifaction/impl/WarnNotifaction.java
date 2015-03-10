package org.nodcloud.commons.model.notifaction.impl;

import org.nodcloud.commons.model.notifaction.AbstratcNotifactionMessage;

public class WarnNotifaction extends AbstratcNotifactionMessage {

    public WarnNotifaction(String message) {
        super(message);
    }

    @Override
    public boolean isWarn() {
        return true;
    }

}
