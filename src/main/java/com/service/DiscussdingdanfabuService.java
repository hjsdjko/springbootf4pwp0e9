package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussdingdanfabuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussdingdanfabuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussdingdanfabuView;


/**
 * 订单发布评论表
 *
 * @author 
 * @email 
 * @date 2024-04-15 09:51:19
 */
public interface DiscussdingdanfabuService extends IService<DiscussdingdanfabuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussdingdanfabuVO> selectListVO(Wrapper<DiscussdingdanfabuEntity> wrapper);
   	
   	DiscussdingdanfabuVO selectVO(@Param("ew") Wrapper<DiscussdingdanfabuEntity> wrapper);
   	
   	List<DiscussdingdanfabuView> selectListView(Wrapper<DiscussdingdanfabuEntity> wrapper);
   	
   	DiscussdingdanfabuView selectView(@Param("ew") Wrapper<DiscussdingdanfabuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussdingdanfabuEntity> wrapper);

   	

}

