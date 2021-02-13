package com.example.demo;

import com.example.service.JobService;
import com.example.service.StepService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private StepService stepService;

	@Autowired
	private JobService jobService;

	@Value("${jobIds}")
	private String jobs;

	@Test
	void contextLoads() throws FileNotFoundException {
//		jobService.handleJob(jobId);
		System.out.println(ResourceUtils.CLASSPATH_URL_PREFIX);
		File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "sql/1.sql");
		System.out.println(file.getAbsolutePath());
	}

}
