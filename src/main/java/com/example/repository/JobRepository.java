package com.example.repository;

import com.example.entity.JobEntity;
import com.example.mapper.JobMapper;
import com.example.utils.SqlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:TODO(任务Dao层)
 *
 * @version: V1.2.3
 * @author: shenbinbin
 * @date: 2020年12月28日
 */
@Repository
public class JobRepository {

    @Autowired
    private JobMapper jobMapper;

    public JobEntity selectById(Integer id) {

        return jobMapper.selectById(id);
    }


    public void initDataBase() {
        SqlUtils.run("1");
    }


    public void updateById(JobEntity jobEntity) {
        jobMapper.updateById(jobEntity);
    }

    public List<JobEntity> selectList() {
        return jobMapper.selectList(null);
    }

}
