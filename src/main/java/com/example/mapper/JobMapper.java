package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.JobEntity;
import org.apache.ibatis.annotations.Param;

/**
 * @Description:TODO(任务mapper层)
 *
 * @version: V1.2.3
 * @author: shenbinbin
 * @date: 2020年12月28日
 */

public interface JobMapper extends BaseMapper<JobEntity> {
	public void prepareForTest(@Param("sqlStr") String sqlStr);
}
