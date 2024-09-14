package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.DiscusstushuxinxiEntity;
import com.entity.view.DiscusstushuxinxiView;

import com.service.DiscusstushuxinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 图书信息评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-15 09:51:19
 */
@RestController
@RequestMapping("/discusstushuxinxi")
public class DiscusstushuxinxiController {
    @Autowired
    private DiscusstushuxinxiService discusstushuxinxiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscusstushuxinxiEntity discusstushuxinxi,
		HttpServletRequest request){
        EntityWrapper<DiscusstushuxinxiEntity> ew = new EntityWrapper<DiscusstushuxinxiEntity>();

		PageUtils page = discusstushuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusstushuxinxi), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscusstushuxinxiEntity discusstushuxinxi, 
		HttpServletRequest request){
        EntityWrapper<DiscusstushuxinxiEntity> ew = new EntityWrapper<DiscusstushuxinxiEntity>();

		PageUtils page = discusstushuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusstushuxinxi), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscusstushuxinxiEntity discusstushuxinxi){
       	EntityWrapper<DiscusstushuxinxiEntity> ew = new EntityWrapper<DiscusstushuxinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discusstushuxinxi, "discusstushuxinxi")); 
        return R.ok().put("data", discusstushuxinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscusstushuxinxiEntity discusstushuxinxi){
        EntityWrapper< DiscusstushuxinxiEntity> ew = new EntityWrapper< DiscusstushuxinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discusstushuxinxi, "discusstushuxinxi")); 
		DiscusstushuxinxiView discusstushuxinxiView =  discusstushuxinxiService.selectView(ew);
		return R.ok("查询图书信息评论表成功").put("data", discusstushuxinxiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscusstushuxinxiEntity discusstushuxinxi = discusstushuxinxiService.selectById(id);
        return R.ok().put("data", discusstushuxinxi);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscusstushuxinxiEntity discusstushuxinxi = discusstushuxinxiService.selectById(id);
        return R.ok().put("data", discusstushuxinxi);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscusstushuxinxiEntity discusstushuxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discusstushuxinxi);
        discusstushuxinxiService.insert(discusstushuxinxi);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscusstushuxinxiEntity discusstushuxinxi, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(discusstushuxinxi);
        discusstushuxinxiService.insert(discusstushuxinxi);
        return R.ok();
    }



     /**
     * 获取用户密保
     */
    @RequestMapping("/security")
    @IgnoreAuth
    public R security(@RequestParam String username){
        DiscusstushuxinxiEntity discusstushuxinxi = discusstushuxinxiService.selectOne(new EntityWrapper<DiscusstushuxinxiEntity>().eq("", username));
        return R.ok().put("data", discusstushuxinxi);
    }


    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscusstushuxinxiEntity discusstushuxinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discusstushuxinxi);
        discusstushuxinxiService.updateById(discusstushuxinxi);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discusstushuxinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscusstushuxinxiEntity discusstushuxinxi, HttpServletRequest request,String pre){
        EntityWrapper<DiscusstushuxinxiEntity> ew = new EntityWrapper<DiscusstushuxinxiEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discusstushuxinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discusstushuxinxi), params), params));
        return R.ok().put("data", page);
    }










}
