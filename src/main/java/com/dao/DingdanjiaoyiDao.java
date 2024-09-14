package com.dao;

import com.entity.DingdanjiaoyiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DingdanjiaoyiVO;
import com.entity.view.DingdanjiaoyiView;


/**
 * 订单交易
 * 
 * @author 
 * @email 
 * @date 2024-04-15 09:51:18
 */
public interface DingdanjiaoyiDao extends BaseMapper<DingdanjiaoyiEntity> {
	
	List<DingdanjiaoyiVO> selectListVO(@Param("ew") Wrapper<DingdanjiaoyiEntity> wrapper);
	
	DingdanjiaoyiVO selectVO(@Param("ew") Wrapper<DingdanjiaoyiEntity> wrapper);
	
	List<DingdanjiaoyiView> selectListView(@Param("ew") Wrapper<DingdanjiaoyiEntity> wrapper);

	List<DingdanjiaoyiView> selectListView(Pagination page,@Param("ew") Wrapper<DingdanjiaoyiEntity> wrapper);

	
	DingdanjiaoyiView selectView(@Param("ew") Wrapper<DingdanjiaoyiEntity> wrapper);
	

}
