package com.dao;

import com.entity.TushujuanzengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.TushujuanzengVO;
import com.entity.view.TushujuanzengView;


/**
 * 图书捐赠
 * 
 * @author 
 * @email 
 * @date 2024-04-15 09:51:19
 */
public interface TushujuanzengDao extends BaseMapper<TushujuanzengEntity> {
	
	List<TushujuanzengVO> selectListVO(@Param("ew") Wrapper<TushujuanzengEntity> wrapper);
	
	TushujuanzengVO selectVO(@Param("ew") Wrapper<TushujuanzengEntity> wrapper);
	
	List<TushujuanzengView> selectListView(@Param("ew") Wrapper<TushujuanzengEntity> wrapper);

	List<TushujuanzengView> selectListView(Pagination page,@Param("ew") Wrapper<TushujuanzengEntity> wrapper);

	
	TushujuanzengView selectView(@Param("ew") Wrapper<TushujuanzengEntity> wrapper);
	

}
