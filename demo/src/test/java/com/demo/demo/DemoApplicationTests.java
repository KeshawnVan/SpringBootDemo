package com.demo.demo;

import com.demo.demo.domain.Status;
import com.demo.demo.domain.User;
import com.demo.demo.repository.UserRepository;
import com.demo.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private UserRepository userRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testUserService(){
		System.out.println(userService.findAll());
	}

	@Test
	public void testRepository(){
		User user = new User();
		user.setId(123L);
		user.setName("liuna");
		user.setAge(18);
		user.setBirthday(new Date());
		user.setStatus(Status.VALID);
		System.out.println(userRepository.save(user));
	}

}
