package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DingdanfabuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DingdanfabuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DingdanfabuView;


/**
 * 订单发布
 *
 * @author 
 * @email 
 * @date 2024-04-15 09:51:18
 */
public interface DingdanfabuService extends IService<DingdanfabuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DingdanfabuVO> selectListVO(Wrapper<DingdanfabuEntity> wrapper);
   	
   	DingdanfabuVO selectVO(@Param("ew") Wrapper<DingdanfabuEntity> wrapper);
   	
   	List<DingdanfabuView> selectListView(Wrapper<DingdanfabuEntity> wrapper);
   	
   	DingdanfabuView selectView(@Param("ew") Wrapper<DingdanfabuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DingdanfabuEntity> wrapper);

   	

}

