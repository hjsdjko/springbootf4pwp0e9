package com.dao;

import com.entity.PaotuipeisongEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PaotuipeisongVO;
import com.entity.view.PaotuipeisongView;


/**
 * 跑腿配送
 * 
 * @author 
 * @email 
 * @date 2024-04-15 09:51:18
 */
public interface PaotuipeisongDao extends BaseMapper<PaotuipeisongEntity> {
	
	List<PaotuipeisongVO> selectListVO(@Param("ew") Wrapper<PaotuipeisongEntity> wrapper);
	
	PaotuipeisongVO selectVO(@Param("ew") Wrapper<PaotuipeisongEntity> wrapper);
	
	List<PaotuipeisongView> selectListView(@Param("ew") Wrapper<PaotuipeisongEntity> wrapper);

	List<PaotuipeisongView> selectListView(Pagination page,@Param("ew") Wrapper<PaotuipeisongEntity> wrapper);

	
	PaotuipeisongView selectView(@Param("ew") Wrapper<PaotuipeisongEntity> wrapper);
	

}
