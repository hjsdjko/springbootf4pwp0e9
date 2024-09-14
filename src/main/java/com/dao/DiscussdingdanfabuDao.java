package com.dao;

import com.entity.DiscussdingdanfabuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussdingdanfabuVO;
import com.entity.view.DiscussdingdanfabuView;


/**
 * 订单发布评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-15 09:51:19
 */
public interface DiscussdingdanfabuDao extends BaseMapper<DiscussdingdanfabuEntity> {
	
	List<DiscussdingdanfabuVO> selectListVO(@Param("ew") Wrapper<DiscussdingdanfabuEntity> wrapper);
	
	DiscussdingdanfabuVO selectVO(@Param("ew") Wrapper<DiscussdingdanfabuEntity> wrapper);
	
	List<DiscussdingdanfabuView> selectListView(@Param("ew") Wrapper<DiscussdingdanfabuEntity> wrapper);

	List<DiscussdingdanfabuView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussdingdanfabuEntity> wrapper);

	
	DiscussdingdanfabuView selectView(@Param("ew") Wrapper<DiscussdingdanfabuEntity> wrapper);
	

}
