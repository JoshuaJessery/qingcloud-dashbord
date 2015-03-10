package org.nodcloud.commons.model.notifaction;

public abstract class AbstratcNotifactionMessage implements NotifactionMessage {

    private String message;

    public String getMessage() {
        return message;
    }


    public AbstratcNotifactionMessage(String message) {
        this.message = message;
    }

    @Override
    public boolean isSuccess() {
        return false;
    }

    @Override
    public boolean isWarn() {
        return false;
    }

    @Override
    public boolean isInfo() {
        return false;
    }

    @Override
    public boolean isError() {
        return false;
    }
}
