package com.example.demo;

import com.example.entity.JobEntity;
import com.example.service.JobService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@Configuration
@MapperScan("com.example.mapper")
@ComponentScan("com.example")
public class DemoApplication implements ApplicationRunner {
    @Value("${jobIds}")
    private String jobIds;
    @Autowired
    private JobService jobService;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //任务列表获取
        String[] jobIdlist = jobIds.split(",");
        //遍历处理相应的任务
        Arrays.stream(jobIdlist).forEach(jobId ->{
            jobService.handleJob(Integer.parseInt(jobId));
        });
        //执行完成之后打印结果
        List<JobEntity> jobEntityList = jobService.getList();
        Arrays.stream(jobIdlist).forEach(jobId ->{
            jobEntityList.stream().forEach(jobEntity -> {
                if(Integer.parseInt(jobId) == (jobEntity.getId())){
                    System.out.println("------任务"+jobId+"执行"+jobEntity.getJobResult()+"!!!------");
                }
            });
        });
    }
}
