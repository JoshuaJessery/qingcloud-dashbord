package org.nodcloud.commons.model.notifaction.impl;

import org.nodcloud.commons.model.notifaction.AbstratcNotifactionMessage;

public class InfoNotifaction extends AbstratcNotifactionMessage {

    public InfoNotifaction(String message) {
        super(message);
    }

    @Override
    public boolean isInfo() {
        return true;
    }

}
