package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DingdanjiaoyiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DingdanjiaoyiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DingdanjiaoyiView;


/**
 * 订单交易
 *
 * @author 
 * @email 
 * @date 2024-04-15 09:51:18
 */
public interface DingdanjiaoyiService extends IService<DingdanjiaoyiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DingdanjiaoyiVO> selectListVO(Wrapper<DingdanjiaoyiEntity> wrapper);
   	
   	DingdanjiaoyiVO selectVO(@Param("ew") Wrapper<DingdanjiaoyiEntity> wrapper);
   	
   	List<DingdanjiaoyiView> selectListView(Wrapper<DingdanjiaoyiEntity> wrapper);
   	
   	DingdanjiaoyiView selectView(@Param("ew") Wrapper<DingdanjiaoyiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DingdanjiaoyiEntity> wrapper);

   	

}

