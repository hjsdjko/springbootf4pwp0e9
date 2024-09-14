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


import com.dao.ShenqingjiaohuanDao;
import com.entity.ShenqingjiaohuanEntity;
import com.service.ShenqingjiaohuanService;
import com.entity.vo.ShenqingjiaohuanVO;
import com.entity.view.ShenqingjiaohuanView;

@Service("shenqingjiaohuanService")
public class ShenqingjiaohuanServiceImpl extends ServiceImpl<ShenqingjiaohuanDao, ShenqingjiaohuanEntity> implements ShenqingjiaohuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ShenqingjiaohuanEntity> page = this.selectPage(
                new Query<ShenqingjiaohuanEntity>(params).getPage(),
                new EntityWrapper<ShenqingjiaohuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<ShenqingjiaohuanEntity> wrapper) {
		  Page<ShenqingjiaohuanView> page =new Query<ShenqingjiaohuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<ShenqingjiaohuanVO> selectListVO(Wrapper<ShenqingjiaohuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public ShenqingjiaohuanVO selectVO(Wrapper<ShenqingjiaohuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<ShenqingjiaohuanView> selectListView(Wrapper<ShenqingjiaohuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public ShenqingjiaohuanView selectView(Wrapper<ShenqingjiaohuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
