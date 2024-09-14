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


import com.dao.TushujiaohuanDao;
import com.entity.TushujiaohuanEntity;
import com.service.TushujiaohuanService;
import com.entity.vo.TushujiaohuanVO;
import com.entity.view.TushujiaohuanView;

@Service("tushujiaohuanService")
public class TushujiaohuanServiceImpl extends ServiceImpl<TushujiaohuanDao, TushujiaohuanEntity> implements TushujiaohuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TushujiaohuanEntity> page = this.selectPage(
                new Query<TushujiaohuanEntity>(params).getPage(),
                new EntityWrapper<TushujiaohuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TushujiaohuanEntity> wrapper) {
		  Page<TushujiaohuanView> page =new Query<TushujiaohuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<TushujiaohuanVO> selectListVO(Wrapper<TushujiaohuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TushujiaohuanVO selectVO(Wrapper<TushujiaohuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TushujiaohuanView> selectListView(Wrapper<TushujiaohuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TushujiaohuanView selectView(Wrapper<TushujiaohuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
