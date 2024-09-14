package com.dao;

import com.entity.DiscusstushujuanzengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusstushujuanzengVO;
import com.entity.view.DiscusstushujuanzengView;


/**
 * 图书捐赠评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-15 09:51:20
 */
public interface DiscusstushujuanzengDao extends BaseMapper<DiscusstushujuanzengEntity> {
	
	List<DiscusstushujuanzengVO> selectListVO(@Param("ew") Wrapper<DiscusstushujuanzengEntity> wrapper);
	
	DiscusstushujuanzengVO selectVO(@Param("ew") Wrapper<DiscusstushujuanzengEntity> wrapper);
	
	List<DiscusstushujuanzengView> selectListView(@Param("ew") Wrapper<DiscusstushujuanzengEntity> wrapper);

	List<DiscusstushujuanzengView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusstushujuanzengEntity> wrapper);

	
	DiscusstushujuanzengView selectView(@Param("ew") Wrapper<DiscusstushujuanzengEntity> wrapper);
	

}
