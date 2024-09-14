package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TushujiaohuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TushujiaohuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TushujiaohuanView;


/**
 * 图书交换
 *
 * @author 
 * @email 
 * @date 2024-04-15 09:51:19
 */
public interface TushujiaohuanService extends IService<TushujiaohuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TushujiaohuanVO> selectListVO(Wrapper<TushujiaohuanEntity> wrapper);
   	
   	TushujiaohuanVO selectVO(@Param("ew") Wrapper<TushujiaohuanEntity> wrapper);
   	
   	List<TushujiaohuanView> selectListView(Wrapper<TushujiaohuanEntity> wrapper);
   	
   	TushujiaohuanView selectView(@Param("ew") Wrapper<TushujiaohuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TushujiaohuanEntity> wrapper);

   	

}

