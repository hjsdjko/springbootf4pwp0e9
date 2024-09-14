package com.entity.view;

import com.entity.TushujiaohuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 图书交换
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-15 09:51:19
 */
@TableName("tushujiaohuan")
public class TushujiaohuanView  extends TushujiaohuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TushujiaohuanView(){
	}
 
 	public TushujiaohuanView(TushujiaohuanEntity tushujiaohuanEntity){
 	try {
			BeanUtils.copyProperties(this, tushujiaohuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
