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


import com.dao.DiscussdingdanfabuDao;
import com.entity.DiscussdingdanfabuEntity;
import com.service.DiscussdingdanfabuService;
import com.entity.vo.DiscussdingdanfabuVO;
import com.entity.view.DiscussdingdanfabuView;

@Service("discussdingdanfabuService")
public class DiscussdingdanfabuServiceImpl extends ServiceImpl<DiscussdingdanfabuDao, DiscussdingdanfabuEntity> implements DiscussdingdanfabuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussdingdanfabuEntity> page = this.selectPage(
                new Query<DiscussdingdanfabuEntity>(params).getPage(),
                new EntityWrapper<DiscussdingdanfabuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussdingdanfabuEntity> wrapper) {
		  Page<DiscussdingdanfabuView> page =new Query<DiscussdingdanfabuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussdingdanfabuVO> selectListVO(Wrapper<DiscussdingdanfabuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussdingdanfabuVO selectVO(Wrapper<DiscussdingdanfabuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussdingdanfabuView> selectListView(Wrapper<DiscussdingdanfabuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussdingdanfabuView selectView(Wrapper<DiscussdingdanfabuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
