package com.dao;

import com.entity.PaotuijiedanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PaotuijiedanVO;
import com.entity.view.PaotuijiedanView;


/**
 * 跑腿接单
 * 
 * @author 
 * @email 
 * @date 2024-04-15 09:51:18
 */
public interface PaotuijiedanDao extends BaseMapper<PaotuijiedanEntity> {
	
	List<PaotuijiedanVO> selectListVO(@Param("ew") Wrapper<PaotuijiedanEntity> wrapper);
	
	PaotuijiedanVO selectVO(@Param("ew") Wrapper<PaotuijiedanEntity> wrapper);
	
	List<PaotuijiedanView> selectListView(@Param("ew") Wrapper<PaotuijiedanEntity> wrapper);

	List<PaotuijiedanView> selectListView(Pagination page,@Param("ew") Wrapper<PaotuijiedanEntity> wrapper);

	
	PaotuijiedanView selectView(@Param("ew") Wrapper<PaotuijiedanEntity> wrapper);
	

}
