package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.TushujuanzengEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.TushujuanzengVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.TushujuanzengView;


/**
 * 图书捐赠
 *
 * @author 
 * @email 
 * @date 2024-04-15 09:51:19
 */
public interface TushujuanzengService extends IService<TushujuanzengEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<TushujuanzengVO> selectListVO(Wrapper<TushujuanzengEntity> wrapper);
   	
   	TushujuanzengVO selectVO(@Param("ew") Wrapper<TushujuanzengEntity> wrapper);
   	
   	List<TushujuanzengView> selectListView(Wrapper<TushujuanzengEntity> wrapper);
   	
   	TushujuanzengView selectView(@Param("ew") Wrapper<TushujuanzengEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<TushujuanzengEntity> wrapper);

   	

}

