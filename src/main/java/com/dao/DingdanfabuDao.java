package com.dao;

import com.entity.DingdanfabuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DingdanfabuVO;
import com.entity.view.DingdanfabuView;


/**
 * 订单发布
 * 
 * @author 
 * @email 
 * @date 2024-04-15 09:51:18
 */
public interface DingdanfabuDao extends BaseMapper<DingdanfabuEntity> {
	
	List<DingdanfabuVO> selectListVO(@Param("ew") Wrapper<DingdanfabuEntity> wrapper);
	
	DingdanfabuVO selectVO(@Param("ew") Wrapper<DingdanfabuEntity> wrapper);
	
	List<DingdanfabuView> selectListView(@Param("ew") Wrapper<DingdanfabuEntity> wrapper);

	List<DingdanfabuView> selectListView(Pagination page,@Param("ew") Wrapper<DingdanfabuEntity> wrapper);

	
	DingdanfabuView selectView(@Param("ew") Wrapper<DingdanfabuEntity> wrapper);
	

}
