package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussshenqingjiaohuanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussshenqingjiaohuanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussshenqingjiaohuanView;


/**
 * 申请交换评论表
 *
 * @author 
 * @email 
 * @date 2024-04-15 09:51:20
 */
public interface DiscussshenqingjiaohuanService extends IService<DiscussshenqingjiaohuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussshenqingjiaohuanVO> selectListVO(Wrapper<DiscussshenqingjiaohuanEntity> wrapper);
   	
   	DiscussshenqingjiaohuanVO selectVO(@Param("ew") Wrapper<DiscussshenqingjiaohuanEntity> wrapper);
   	
   	List<DiscussshenqingjiaohuanView> selectListView(Wrapper<DiscussshenqingjiaohuanEntity> wrapper);
   	
   	DiscussshenqingjiaohuanView selectView(@Param("ew") Wrapper<DiscussshenqingjiaohuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussshenqingjiaohuanEntity> wrapper);

   	

}

