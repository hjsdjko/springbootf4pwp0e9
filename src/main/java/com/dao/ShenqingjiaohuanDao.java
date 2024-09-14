package com.dao;

import com.entity.ShenqingjiaohuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.ShenqingjiaohuanVO;
import com.entity.view.ShenqingjiaohuanView;


/**
 * 申请交换
 * 
 * @author 
 * @email 
 * @date 2024-04-15 09:51:19
 */
public interface ShenqingjiaohuanDao extends BaseMapper<ShenqingjiaohuanEntity> {
	
	List<ShenqingjiaohuanVO> selectListVO(@Param("ew") Wrapper<ShenqingjiaohuanEntity> wrapper);
	
	ShenqingjiaohuanVO selectVO(@Param("ew") Wrapper<ShenqingjiaohuanEntity> wrapper);
	
	List<ShenqingjiaohuanView> selectListView(@Param("ew") Wrapper<ShenqingjiaohuanEntity> wrapper);

	List<ShenqingjiaohuanView> selectListView(Pagination page,@Param("ew") Wrapper<ShenqingjiaohuanEntity> wrapper);

	
	ShenqingjiaohuanView selectView(@Param("ew") Wrapper<ShenqingjiaohuanEntity> wrapper);
	

}
