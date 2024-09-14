package com.dao;

import com.entity.DiscussshenqingjiaohuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussshenqingjiaohuanVO;
import com.entity.view.DiscussshenqingjiaohuanView;


/**
 * 申请交换评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-15 09:51:20
 */
public interface DiscussshenqingjiaohuanDao extends BaseMapper<DiscussshenqingjiaohuanEntity> {
	
	List<DiscussshenqingjiaohuanVO> selectListVO(@Param("ew") Wrapper<DiscussshenqingjiaohuanEntity> wrapper);
	
	DiscussshenqingjiaohuanVO selectVO(@Param("ew") Wrapper<DiscussshenqingjiaohuanEntity> wrapper);
	
	List<DiscussshenqingjiaohuanView> selectListView(@Param("ew") Wrapper<DiscussshenqingjiaohuanEntity> wrapper);

	List<DiscussshenqingjiaohuanView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussshenqingjiaohuanEntity> wrapper);

	
	DiscussshenqingjiaohuanView selectView(@Param("ew") Wrapper<DiscussshenqingjiaohuanEntity> wrapper);
	

}
