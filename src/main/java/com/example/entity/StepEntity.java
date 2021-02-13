package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**   
 * @Description:TODO(步骤实体类)
 * 
 * @version: V1.2.3
 * @author: shenbinbin
 * @date: 2020年12月28日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("step")
public class StepEntity {
	@TableId(value = "id", type = IdType.INPUT)
    //id
	private String id;
    
    //请求url
	private String requestUrl;
    
    //请求json串,当请求字段依赖于其他步骤时.书写格式"请求字段":"依赖步骤id,依赖字段名称"
	private String requestJson;
    
    //返回json串
	private String responseJson;
    
    //错误描述
	private String errorMsg;
    
}
