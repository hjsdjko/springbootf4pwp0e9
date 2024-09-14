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


import com.dao.TushujuanzengDao;
import com.entity.TushujuanzengEntity;
import com.service.TushujuanzengService;
import com.entity.vo.TushujuanzengVO;
import com.entity.view.TushujuanzengView;

@Service("tushujuanzengService")
public class TushujuanzengServiceImpl extends ServiceImpl<TushujuanzengDao, TushujuanzengEntity> implements TushujuanzengService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TushujuanzengEntity> page = this.selectPage(
                new Query<TushujuanzengEntity>(params).getPage(),
                new EntityWrapper<TushujuanzengEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TushujuanzengEntity> wrapper) {
		  Page<TushujuanzengView> page =new Query<TushujuanzengView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<TushujuanzengVO> selectListVO(Wrapper<TushujuanzengEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TushujuanzengVO selectVO(Wrapper<TushujuanzengEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TushujuanzengView> selectListView(Wrapper<TushujuanzengEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TushujuanzengView selectView(Wrapper<TushujuanzengEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
