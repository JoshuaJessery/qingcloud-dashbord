package org.nodcloud.persistent.repository;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.nodcloud.persistent.entity.Image;
import org.nodcloud.persistent.entity.Instance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:nodcloud-persisten-test.xml"})
public class InstanceDaoTest {

    @Autowired
    private InstanceDao instanceDao;

    @Autowired
    private ImageDao imageDao;

    private Instance instance;

    private Image image;

    @Before
    public void setUp() {
        instance = new Instance();
        image = new Image();
        instance.setName("test instance");
        instance.setCup(1);
        instance.setLoginMode(1);

        image.setImageSize(20);
        image.setName("test image");

    }

    @Test
    public void shouldSaveInstanceWhenWithAExistImage() {

        // given
        imageDao.save(image);
        instance.setImage(image);

        // when
        instanceDao.save(instance);
        // then
        assertThat(instance.getId(), is(notNullValue()));
        assertThat(instance.getCreateAt(), is(notNullValue()));
        assertThat(instance.getImage(), is(image));

    }

    @Test(expected = InvalidDataAccessApiUsageException.class)
    @Rollback
    @Ignore
    public void shouldThrowExceptionWhenSaveInstanceWithANotExistImage() {

        // given
        instance.setImage(image);

        // when
        instanceDao.save(instance);
        // then
        assertThat(instance.getId(), is(notNullValue()));
        assertThat(instance.getCreateAt(), is(notNullValue()));
        assertThat(instance.getImage(), is(image));

    }

    @After
    public void tearDown() {
        instanceDao.delete(instance);
        imageDao.delete(image);
    }

}
