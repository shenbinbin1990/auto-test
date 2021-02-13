package com.example.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**   
 * @Description:TODO(任务实体类)
 * 
 * @version: V1.2.3
 * @author: shenbinbin
 * @date: 2020年12月28日
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName("job")
public class JobEntity {
	@TableId(value = "id", type = IdType.AUTO)
    //
	private Integer id;
    
    //步骤id序列
	private String stepIdSequence;
    
    //任务运行结果
	private String jobResult;
    
    //
	private Date createTime;
    
    //
	private Date updateTime;
	//初始化sql
	private String initSql;
    
}
