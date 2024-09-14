package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.PaotuipeisongDao;
import com.entity.PaotuipeisongEntity;
import com.service.PaotuipeisongService;
import com.entity.vo.PaotuipeisongVO;
import com.entity.view.PaotuipeisongView;

@Service("paotuipeisongService")
public class PaotuipeisongServiceImpl extends ServiceImpl<PaotuipeisongDao, PaotuipeisongEntity> implements PaotuipeisongService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PaotuipeisongEntity> page = this.selectPage(
                new Query<PaotuipeisongEntity>(params).getPage(),
                new EntityWrapper<PaotuipeisongEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PaotuipeisongEntity> wrapper) {
		  Page<PaotuipeisongView> page =new Query<PaotuipeisongView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<PaotuipeisongVO> selectListVO(Wrapper<PaotuipeisongEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PaotuipeisongVO selectVO(Wrapper<PaotuipeisongEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PaotuipeisongView> selectListView(Wrapper<PaotuipeisongEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PaotuipeisongView selectView(Wrapper<PaotuipeisongEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
