package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusstushujuanzengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusstushujuanzengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusstushujuanzengView;


/**
 * 图书捐赠评论表
 *
 * @author 
 * @email 
 * @date 2024-04-15 09:51:20
 */
public interface DiscusstushujuanzengService extends IService<DiscusstushujuanzengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusstushujuanzengVO> selectListVO(Wrapper<DiscusstushujuanzengEntity> wrapper);
   	
   	DiscusstushujuanzengVO selectVO(@Param("ew") Wrapper<DiscusstushujuanzengEntity> wrapper);
   	
   	List<DiscusstushujuanzengView> selectListView(Wrapper<DiscusstushujuanzengEntity> wrapper);
   	
   	DiscusstushujuanzengView selectView(@Param("ew") Wrapper<DiscusstushujuanzengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusstushujuanzengEntity> wrapper);

   	

}

