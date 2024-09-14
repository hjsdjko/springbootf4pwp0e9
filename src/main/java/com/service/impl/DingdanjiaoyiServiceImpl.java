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


import com.dao.DingdanjiaoyiDao;
import com.entity.DingdanjiaoyiEntity;
import com.service.DingdanjiaoyiService;
import com.entity.vo.DingdanjiaoyiVO;
import com.entity.view.DingdanjiaoyiView;

@Service("dingdanjiaoyiService")
public class DingdanjiaoyiServiceImpl extends ServiceImpl<DingdanjiaoyiDao, DingdanjiaoyiEntity> implements DingdanjiaoyiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DingdanjiaoyiEntity> page = this.selectPage(
                new Query<DingdanjiaoyiEntity>(params).getPage(),
                new EntityWrapper<DingdanjiaoyiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DingdanjiaoyiEntity> wrapper) {
		  Page<DingdanjiaoyiView> page =new Query<DingdanjiaoyiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DingdanjiaoyiVO> selectListVO(Wrapper<DingdanjiaoyiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DingdanjiaoyiVO selectVO(Wrapper<DingdanjiaoyiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DingdanjiaoyiView> selectListView(Wrapper<DingdanjiaoyiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DingdanjiaoyiView selectView(Wrapper<DingdanjiaoyiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
