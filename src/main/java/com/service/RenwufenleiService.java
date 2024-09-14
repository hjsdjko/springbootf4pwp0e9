package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.RenwufenleiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.RenwufenleiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.RenwufenleiView;


/**
 * 任务分类
 *
 * @author 
 * @email 
 * @date 2024-04-15 09:51:18
 */
public interface RenwufenleiService extends IService<RenwufenleiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<RenwufenleiVO> selectListVO(Wrapper<RenwufenleiEntity> wrapper);
   	
   	RenwufenleiVO selectVO(@Param("ew") Wrapper<RenwufenleiEntity> wrapper);
   	
   	List<RenwufenleiView> selectListView(Wrapper<RenwufenleiEntity> wrapper);
   	
   	RenwufenleiView selectView(@Param("ew") Wrapper<RenwufenleiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<RenwufenleiEntity> wrapper);

   	

}

