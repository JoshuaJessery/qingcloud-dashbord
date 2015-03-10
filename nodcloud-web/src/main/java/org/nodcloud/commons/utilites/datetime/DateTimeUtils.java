package org.nodcloud.commons.utilites.datetime;

import java.sql.Timestamp;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class DateTimeUtils {

    public static Timestamp fromQingCloudDateTime(String qingCloudDatetime) {

        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd'T'hh:mm:ssZ");
        return new Timestamp(formatter.parseDateTime(qingCloudDatetime).getMillis());


    }

}
