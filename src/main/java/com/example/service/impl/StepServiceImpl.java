package com.example.service.impl;

import com.example.entity.StepEntity;
import com.example.repository.StepRepository;
import com.example.service.StepService;
import com.example.utils.HttpUtils;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StepServiceImpl implements StepService {
    @Autowired
    private StepRepository stepRepository;

    @Override
    public void handleStep(String id) {
        HttpUtils httpUtil = HttpUtils.getInstance();
        StepEntity stepEntity = stepRepository.selectById(id);
        //先清空数据
        stepEntity.setErrorMsg("");
        stepRepository.updateById(stepEntity);
        HttpPost httpPost = new HttpPost(stepEntity.getRequestUrl());
        String requestJson = stepEntity.getRequestJson();
        if (requestJson != null) {
            httpPost.setEntity(new StringEntity(requestJson, "UTF-8"));
        }
        //Cookie设置在Header里
        //httpPost.addHeader("Cookie", "socialSupervisionSession=BBEAA8702D5B62898691871DB4E20A46");
        String resultJson = httpUtil.sendHttpPost(httpPost);
        String responseJson = stepEntity.getResponseJson();
        if (responseJson.equals(resultJson)) {
            stepEntity.setErrorMsg("正常");
        } else {
            stepEntity.setErrorMsg("错误");
        }
        stepRepository.updateById(stepEntity);
    }

    @Override
    public Boolean hasError() {
        List<StepEntity> stepEntityList = stepRepository.selectErrorList();
        if (stepEntityList != null && stepEntityList.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
}
