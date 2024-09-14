package com.entity.view;

import com.entity.DiscusstushujuanzengEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 图书捐赠评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-15 09:51:20
 */
@TableName("discusstushujuanzeng")
public class DiscusstushujuanzengView  extends DiscusstushujuanzengEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscusstushujuanzengView(){
	}
 
 	public DiscusstushujuanzengView(DiscusstushujuanzengEntity discusstushujuanzengEntity){
 	try {
			BeanUtils.copyProperties(this, discusstushujuanzengEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
