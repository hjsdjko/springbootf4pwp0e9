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


import com.dao.DiscusstushujuanzengDao;
import com.entity.DiscusstushujuanzengEntity;
import com.service.DiscusstushujuanzengService;
import com.entity.vo.DiscusstushujuanzengVO;
import com.entity.view.DiscusstushujuanzengView;

@Service("discusstushujuanzengService")
public class DiscusstushujuanzengServiceImpl extends ServiceImpl<DiscusstushujuanzengDao, DiscusstushujuanzengEntity> implements DiscusstushujuanzengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusstushujuanzengEntity> page = this.selectPage(
                new Query<DiscusstushujuanzengEntity>(params).getPage(),
                new EntityWrapper<DiscusstushujuanzengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusstushujuanzengEntity> wrapper) {
		  Page<DiscusstushujuanzengView> page =new Query<DiscusstushujuanzengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscusstushujuanzengVO> selectListVO(Wrapper<DiscusstushujuanzengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusstushujuanzengVO selectVO(Wrapper<DiscusstushujuanzengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusstushujuanzengView> selectListView(Wrapper<DiscusstushujuanzengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusstushujuanzengView selectView(Wrapper<DiscusstushujuanzengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
