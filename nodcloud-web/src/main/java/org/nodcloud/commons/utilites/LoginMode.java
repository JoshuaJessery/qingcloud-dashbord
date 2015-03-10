package org.nodcloud.commons.utilites;

import java.util.Hashtable;

public enum LoginMode {

    KEYPAIR(1, "keypair"),
    PASSWD(2, "passwd");

    private static Hashtable<Integer, LoginMode> LOGMODES = new Hashtable<Integer, LoginMode>();

    static {
        for (LoginMode mode : LoginMode.values()) {
            LOGMODES.put(mode.code, mode);
        }
    }

    private int code;

    private String value;

    private LoginMode(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public static LoginMode valueOf(int code) {
        return LOGMODES.get(code);
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
