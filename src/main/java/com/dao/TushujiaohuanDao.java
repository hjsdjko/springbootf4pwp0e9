package com.dao;

import com.entity.TushujiaohuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TushujiaohuanVO;
import com.entity.view.TushujiaohuanView;


/**
 * 图书交换
 * 
 * @author 
 * @email 
 * @date 2024-04-15 09:51:19
 */
public interface TushujiaohuanDao extends BaseMapper<TushujiaohuanEntity> {
	
	List<TushujiaohuanVO> selectListVO(@Param("ew") Wrapper<TushujiaohuanEntity> wrapper);
	
	TushujiaohuanVO selectVO(@Param("ew") Wrapper<TushujiaohuanEntity> wrapper);
	
	List<TushujiaohuanView> selectListView(@Param("ew") Wrapper<TushujiaohuanEntity> wrapper);

	List<TushujiaohuanView> selectListView(Pagination page,@Param("ew") Wrapper<TushujiaohuanEntity> wrapper);

	
	TushujiaohuanView selectView(@Param("ew") Wrapper<TushujiaohuanEntity> wrapper);
	

}
