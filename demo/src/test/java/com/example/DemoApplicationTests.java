package com.example;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringApplicationConfiguration(classes = DemoApplication.class)
@WebIntegrationTest(randomPort = true)

public class DemoApplicationTests {
	RestTemplate restTemplate = new TestRestTemplate();
	@Value("8080")
	int port;
	
	@Test
	public void testHello() {
		assertThat(restTemplate.getForObject("http://localhost:" + port, String.class),
				is("Hello World!"));
	}

}
