package com.dao;

import com.entity.RenwufenleiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.RenwufenleiVO;
import com.entity.view.RenwufenleiView;


/**
 * 任务分类
 * 
 * @author 
 * @email 
 * @date 2024-04-15 09:51:18
 */
public interface RenwufenleiDao extends BaseMapper<RenwufenleiEntity> {
	
	List<RenwufenleiVO> selectListVO(@Param("ew") Wrapper<RenwufenleiEntity> wrapper);
	
	RenwufenleiVO selectVO(@Param("ew") Wrapper<RenwufenleiEntity> wrapper);
	
	List<RenwufenleiView> selectListView(@Param("ew") Wrapper<RenwufenleiEntity> wrapper);

	List<RenwufenleiView> selectListView(Pagination page,@Param("ew") Wrapper<RenwufenleiEntity> wrapper);

	
	RenwufenleiView selectView(@Param("ew") Wrapper<RenwufenleiEntity> wrapper);
	

}
