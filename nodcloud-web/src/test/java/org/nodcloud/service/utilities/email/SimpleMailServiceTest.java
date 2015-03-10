package org.nodcloud.service.utilities.email;


import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nodcloud.commons.utilites.email.MimeMailService;
import org.nodcloud.commons.utilites.email.SimpleMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Ignore
@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:email/applicationContext-email-test.xml"})
public class SimpleMailServiceTest {

    @Autowired
    private SimpleMailService simpleMailService;

    @Autowired
    private MimeMailService mimeMailService;

    @Test
    @Ignore
    public void shouldSendSimpleEmail() {
        simpleMailService.sendNotificationMail("");
    }

    @Test
    @Ignore
    public void shouldSendMimeEmail() {
        mimeMailService.sendNotificationMail("hello");

    }

}
