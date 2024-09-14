package com.entity.view;

import com.entity.ShenqingjiaohuanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 申请交换
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-15 09:51:19
 */
@TableName("shenqingjiaohuan")
public class ShenqingjiaohuanView  extends ShenqingjiaohuanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ShenqingjiaohuanView(){
	}
 
 	public ShenqingjiaohuanView(ShenqingjiaohuanEntity shenqingjiaohuanEntity){
 	try {
			BeanUtils.copyProperties(this, shenqingjiaohuanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
