package com.ll.exam.qsl;

import com.ll.exam.qsl.user.entity.SiteUser;
import com.ll.exam.qsl.user.repository.UserRepository;
import org.apache.catalina.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

@SpringBootTest
class UserRepositoryTests {
@Autowired
private UserRepository userRepository;

    @Test
	@DisplayName("회원생성")
	void SiteUser(){
		SiteUser s1 = new SiteUser(null,"user1","{noop}1234","user1@test.com");
		SiteUser s2 = new SiteUser(null,"user2","{noop}1234","user22@test.com");

		userRepository.saveAll(Arrays.asList(s1,s2));

	}

}
