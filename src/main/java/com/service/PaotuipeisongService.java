package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PaotuipeisongEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PaotuipeisongVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PaotuipeisongView;


/**
 * 跑腿配送
 *
 * @author 
 * @email 
 * @date 2024-04-15 09:51:18
 */
public interface PaotuipeisongService extends IService<PaotuipeisongEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PaotuipeisongVO> selectListVO(Wrapper<PaotuipeisongEntity> wrapper);
   	
   	PaotuipeisongVO selectVO(@Param("ew") Wrapper<PaotuipeisongEntity> wrapper);
   	
   	List<PaotuipeisongView> selectListView(Wrapper<PaotuipeisongEntity> wrapper);
   	
   	PaotuipeisongView selectView(@Param("ew") Wrapper<PaotuipeisongEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PaotuipeisongEntity> wrapper);

   	

}

