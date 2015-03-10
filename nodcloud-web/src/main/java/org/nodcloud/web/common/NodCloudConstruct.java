package org.nodcloud.web.common;

public class NodCloudConstruct {

    public static final String URL_ROOT = "/";
    public static final String SUFFIX_JSON = ".json";


    // model and view
    public static final String MODEL_AND_VIEW_INDEX = "index";
    public static final String MODEL_AND_VIEW_LOGIN = "login";
    public static final String MODEL_AND_VIEW_PROFLE = "profile";
    public static final String MODEL_AND_VIEW_REGISTER = "register";
    public static final String MODEL_AND_VIEW_RGGC = "rggc";
    public static final String MODEL_AND_VIEW_RGFBH = "rgfbh";


    // front url mapping
    public static final String URL_MAP_INDEX = URL_ROOT + MODEL_AND_VIEW_INDEX;
    public static final String URL_MAP_LOGIN = URL_ROOT + MODEL_AND_VIEW_LOGIN;
    public static final String URL_MAP_REGISTER = URL_ROOT + MODEL_AND_VIEW_REGISTER;
    public static final String URL_MAP_RGGC = URL_ROOT + MODEL_AND_VIEW_RGGC;
    public static final String URL_MAP_RGFBH = URL_ROOT + MODEL_AND_VIEW_RGFBH;

    // dashbord model and view
    public static final String DASHBORD = "dashbord";
    public static final String DASHBORD_ROOT = DASHBORD + "/";

    public static final String DASHBORD_URL_MAP = URL_ROOT + DASHBORD;
    public static final String DASHBORD_URL_MAP_ROOT = URL_ROOT + DASHBORD_ROOT;
    public static final String DASHBORD_URL_MAP_REST_ROOT = URL_ROOT + DASHBORD_ROOT + "api/";

    public static final String URL_MAP_DASHBORD_OVERVIEW = DASHBORD_URL_MAP_ROOT + "overview";

    public static final String URL_MAP_DASHBORD_IMAGE = DASHBORD_URL_MAP_ROOT + "images";
    public static final String URL_MAP_DASHBORD_EIP = DASHBORD_URL_MAP_ROOT + "eips";
    public static final String URL_MAP_DASHBORD_PROFILE = DASHBORD_URL_MAP_ROOT + MODEL_AND_VIEW_PROFLE;


    public static final String MODEL_AND_VIEW_DASHBORD_OVERVIEW = DASHBORD_ROOT + "overview";
    public static final String MODEL_AND_VIEW_DASHBORD_INSTANCES = DASHBORD_ROOT + "instances";
    public static final String MODEL_AND_VIEW_DASHBORD_IMAGES = DASHBORD_ROOT + "images";
    public static final String MODEL_AND_VIEW_DASHBORD_VOLUME = DASHBORD_ROOT + "volumes";
    public static final String MODEL_AND_VIEW_DASHBORD_EIP = DASHBORD_ROOT + "eips";
    public static final String MODEL_AND_VIEW_DASHBORD_PROFILE = DASHBORD_ROOT + "profile";

    // RESOURCES
    public static final String NOTIFICATION__MESSAGE = "notification";


}
