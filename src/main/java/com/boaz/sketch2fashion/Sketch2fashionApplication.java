package com.boaz.sketch2fashion;

import com.boaz.sketch2fashion.config.TestInitData;
import com.boaz.sketch2fashion.repository.member.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class Sketch2fashionApplication {

	public static void main(String[] args) {
		SpringApplication.run(Sketch2fashionApplication.class, args);
	}

	@Bean
	@Profile("local")
	public TestInitData testInitData(MemberRepository memberRepository) {
		return new TestInitData(memberRepository);
	}
}
