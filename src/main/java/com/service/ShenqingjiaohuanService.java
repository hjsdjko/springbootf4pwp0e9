package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.ShenqingjiaohuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.ShenqingjiaohuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.ShenqingjiaohuanView;


/**
 * 申请交换
 *
 * @author 
 * @email 
 * @date 2024-04-15 09:51:19
 */
public interface ShenqingjiaohuanService extends IService<ShenqingjiaohuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShenqingjiaohuanVO> selectListVO(Wrapper<ShenqingjiaohuanEntity> wrapper);
   	
   	ShenqingjiaohuanVO selectVO(@Param("ew") Wrapper<ShenqingjiaohuanEntity> wrapper);
   	
   	List<ShenqingjiaohuanView> selectListView(Wrapper<ShenqingjiaohuanEntity> wrapper);
   	
   	ShenqingjiaohuanView selectView(@Param("ew") Wrapper<ShenqingjiaohuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShenqingjiaohuanEntity> wrapper);

   	

}

