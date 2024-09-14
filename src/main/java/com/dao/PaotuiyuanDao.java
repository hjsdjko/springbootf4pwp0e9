package com.dao;

import com.entity.PaotuiyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PaotuiyuanVO;
import com.entity.view.PaotuiyuanView;


/**
 * 跑腿员
 * 
 * @author 
 * @email 
 * @date 2024-04-15 09:51:18
 */
public interface PaotuiyuanDao extends BaseMapper<PaotuiyuanEntity> {
	
	List<PaotuiyuanVO> selectListVO(@Param("ew") Wrapper<PaotuiyuanEntity> wrapper);
	
	PaotuiyuanVO selectVO(@Param("ew") Wrapper<PaotuiyuanEntity> wrapper);
	
	List<PaotuiyuanView> selectListView(@Param("ew") Wrapper<PaotuiyuanEntity> wrapper);

	List<PaotuiyuanView> selectListView(Pagination page,@Param("ew") Wrapper<PaotuiyuanEntity> wrapper);

	
	PaotuiyuanView selectView(@Param("ew") Wrapper<PaotuiyuanEntity> wrapper);
	

}
