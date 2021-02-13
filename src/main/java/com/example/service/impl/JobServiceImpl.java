package com.example.service.impl;


import com.example.entity.JobEntity;
import com.example.repository.JobRepository;
import com.example.service.JobService;
import com.example.service.StepService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @Description:TODO(任务服务实现)
 * @version: V1.2.3
 * @author: shenbinbin
 * @date: 2020年12月28日
 */
@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobRepository jobRepository;
    @Autowired
    private StepService stepService;

    @Override
    public void handleJob(Integer id) {
        JobEntity jobEntity = jobRepository.selectById(id);
        //清空原任务结果,并更新数据表
        jobEntity.setJobResult("");
        jobRepository.updateById(jobEntity);
        String initSql = null;
        try {
            //获取sql脚本文件
            File file = ResourceUtils.getFile(ResourceUtils.CLASSPATH_URL_PREFIX + "sql/1.sql");
            FileOutputStream fos = new FileOutputStream(file);
            //需要判断一下是否为空
            initSql = jobEntity.getInitSql();
            if(StringUtils.isNotBlank(initSql)){
                byte[] data = jobEntity.getInitSql().getBytes();
                fos.write(data);
            }
            //关闭流资源。---shenbb为什么要记得关呢?因为最终去执行是os操作系统去做的,要释放资源还给OS
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //把String写入到文件里面.
        //初始化本地数据库
        if(StringUtils.isNotBlank(initSql)){
            jobRepository.initDataBase();
        }
        //获取执行序列
        String[] stepIdSeq = jobEntity.getStepIdSequence().split(",");
        for (String stepId : stepIdSeq) {
            stepService.handleStep(stepId);
        }

        Boolean result = stepService.hasError();
        if(result){
            jobEntity.setJobResult("失败");
        }else{
            jobEntity.setJobResult("成功");
        }

        jobRepository.updateById(jobEntity);
    }

    @Override
    public List<JobEntity> getList() {
        List<JobEntity> jobEntityList = jobRepository.selectList();
        return jobEntityList;
    }


}

