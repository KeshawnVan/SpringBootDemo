package com.demo.demo;

import com.demo.demo.domain.Status;
import com.demo.demo.domain.User;
import com.demo.demo.repository.UserRepository;
import com.demo.demo.service.UserService;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
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

	@Autowired
	private RedisTemplate<String,String> redisTemplate;

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
		user.setName("fkx");
		user.setAge(18);
		user.setBirthday(LocalDateTime.now());
		user.setStatus(Status.VALID);
		System.out.println(userRepository.save(user));
	}

	@Test
	public void testFindAll(){
		System.out.println(userRepository.findAll());
	}

	@Test
	public void testDebug(){
		Thread thread = new Thread(() -> System.out.println("debug"));
		thread.start();
	}

	@Test
	public void testRedis(){
		redisTemplate.boundValueOps("123").set("nana");
		String nana = redisTemplate.boundValueOps("123").get();
		System.out.println(nana);
	}

	@Test
	public void testUnirest() throws Exception{
		HttpResponse<String> stringHttpResponse = Unirest.get("http://www.baidu.com")
				.asString();
		System.out.println(stringHttpResponse.getBody());
	}

}
