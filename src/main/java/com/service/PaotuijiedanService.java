package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PaotuijiedanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PaotuijiedanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PaotuijiedanView;


/**
 * 跑腿接单
 *
 * @author 
 * @email 
 * @date 2024-04-15 09:51:18
 */
public interface PaotuijiedanService extends IService<PaotuijiedanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PaotuijiedanVO> selectListVO(Wrapper<PaotuijiedanEntity> wrapper);
   	
   	PaotuijiedanVO selectVO(@Param("ew") Wrapper<PaotuijiedanEntity> wrapper);
   	
   	List<PaotuijiedanView> selectListView(Wrapper<PaotuijiedanEntity> wrapper);
   	
   	PaotuijiedanView selectView(@Param("ew") Wrapper<PaotuijiedanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PaotuijiedanEntity> wrapper);

   	

}

