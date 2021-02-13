package com.example.service;

import com.example.entity.JobEntity;

import java.util.List;

/**
 * @Description:TODO(任务服务层)

 * @version: V1.2.3
 * @author: shenbinbin
 * @date: 2020年12月28日
 */
public interface JobService {
	public void handleJob(Integer id);
	public List<JobEntity> getList();
}