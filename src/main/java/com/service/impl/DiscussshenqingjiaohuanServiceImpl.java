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


import com.dao.DiscussshenqingjiaohuanDao;
import com.entity.DiscussshenqingjiaohuanEntity;
import com.service.DiscussshenqingjiaohuanService;
import com.entity.vo.DiscussshenqingjiaohuanVO;
import com.entity.view.DiscussshenqingjiaohuanView;

@Service("discussshenqingjiaohuanService")
public class DiscussshenqingjiaohuanServiceImpl extends ServiceImpl<DiscussshenqingjiaohuanDao, DiscussshenqingjiaohuanEntity> implements DiscussshenqingjiaohuanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussshenqingjiaohuanEntity> page = this.selectPage(
                new Query<DiscussshenqingjiaohuanEntity>(params).getPage(),
                new EntityWrapper<DiscussshenqingjiaohuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussshenqingjiaohuanEntity> wrapper) {
		  Page<DiscussshenqingjiaohuanView> page =new Query<DiscussshenqingjiaohuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussshenqingjiaohuanVO> selectListVO(Wrapper<DiscussshenqingjiaohuanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussshenqingjiaohuanVO selectVO(Wrapper<DiscussshenqingjiaohuanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussshenqingjiaohuanView> selectListView(Wrapper<DiscussshenqingjiaohuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussshenqingjiaohuanView selectView(Wrapper<DiscussshenqingjiaohuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
