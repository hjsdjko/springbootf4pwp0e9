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


import com.dao.DingdanfabuDao;
import com.entity.DingdanfabuEntity;
import com.service.DingdanfabuService;
import com.entity.vo.DingdanfabuVO;
import com.entity.view.DingdanfabuView;

@Service("dingdanfabuService")
public class DingdanfabuServiceImpl extends ServiceImpl<DingdanfabuDao, DingdanfabuEntity> implements DingdanfabuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DingdanfabuEntity> page = this.selectPage(
                new Query<DingdanfabuEntity>(params).getPage(),
                new EntityWrapper<DingdanfabuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DingdanfabuEntity> wrapper) {
		  Page<DingdanfabuView> page =new Query<DingdanfabuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DingdanfabuVO> selectListVO(Wrapper<DingdanfabuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DingdanfabuVO selectVO(Wrapper<DingdanfabuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DingdanfabuView> selectListView(Wrapper<DingdanfabuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DingdanfabuView selectView(Wrapper<DingdanfabuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
