package be.scorgar.demo.test;

import javax.inject.Inject;

import org.junit.Assert;
import org.junit.Test;

import be.scorgar.demo.domain.User;
import be.scorgar.demo.repository.UserRepository;

public class UserTest extends DevTest{
	
	@Inject private UserRepository userRepository;
	
	@Test
	public void testFindUserByAccount() throws Exception {
		User dirk = userRepository.findOne(1l);
		User dd605 = userRepository.findByAccount("dd605");
		Assert.assertNotNull(dirk);
		Assert.assertTrue(dirk.equals(dd605));
	}
}
