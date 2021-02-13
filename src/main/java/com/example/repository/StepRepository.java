package com.example.repository;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.entity.StepEntity;
import com.example.mapper.StepMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Description:TODO(步骤Dao层)
 *
 * @version: V1.2.3
 * @author: shenbinbin
 * @date: 2020年12月28日
 */
@Repository
public class StepRepository {
    @Autowired
    private StepMapper stepMapper;

    public StepEntity selectById(String i) {
        return stepMapper.selectById(i);
    }

    public void updateById(StepEntity stepEntity) {
        stepMapper.updateById(stepEntity);
    }


    public List<StepEntity> selectErrorList() {
        QueryWrapper<StepEntity> wrapper = new QueryWrapper<>();
        return stepMapper.selectList(wrapper.lambda().eq(StepEntity::getErrorMsg ,"错误"));
    }
}
