package org.nodcloud.service.utilities.datetime;

import java.sql.Timestamp;

import org.junit.Test;
import org.nodcloud.commons.utilites.datetime.DateTimeUtils;

public class DateTimeUtilsTest {

    @Test
    public void shouldCovertToDatetime() {

        // when
        Timestamp dateTime = DateTimeUtils.fromQingCloudDateTime("2014-04-09T02:15:41Z");

    }
}
