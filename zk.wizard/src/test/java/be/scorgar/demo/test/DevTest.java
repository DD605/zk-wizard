package be.scorgar.demo.test;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import be.scorgar.config.HsqlDataConfigiuration;
import be.scorgar.config.JpaConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
    loader=AnnotationConfigContextLoader.class,
    classes={HsqlDataConfigiuration.class,JpaConfiguration.class})
@ActiveProfiles("develop")
public abstract class DevTest {

}
