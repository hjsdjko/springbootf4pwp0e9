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

import com.entity.DingdanfabuEntity;
import com.entity.view.DingdanfabuView;

import com.service.DingdanfabuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 订单发布
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-15 09:51:18
 */
@RestController
@RequestMapping("/dingdanfabu")
public class DingdanfabuController {
    @Autowired
    private DingdanfabuService dingdanfabuService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DingdanfabuEntity dingdanfabu,
		HttpServletRequest request){
        EntityWrapper<DingdanfabuEntity> ew = new EntityWrapper<DingdanfabuEntity>();

        String tableName = request.getSession().getAttribute("tableName").toString();
        ew.andNew();
        if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            ew.or();
            ew.eq("jiaoyizhanghao", (String)request.getSession().getAttribute("username"));
        }
        ew.andNew("1=1");
		PageUtils page = dingdanfabuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingdanfabu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DingdanfabuEntity dingdanfabu, 
		HttpServletRequest request){
        EntityWrapper<DingdanfabuEntity> ew = new EntityWrapper<DingdanfabuEntity>();

		PageUtils page = dingdanfabuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, dingdanfabu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DingdanfabuEntity dingdanfabu){
       	EntityWrapper<DingdanfabuEntity> ew = new EntityWrapper<DingdanfabuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( dingdanfabu, "dingdanfabu")); 
        return R.ok().put("data", dingdanfabuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DingdanfabuEntity dingdanfabu){
        EntityWrapper< DingdanfabuEntity> ew = new EntityWrapper< DingdanfabuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( dingdanfabu, "dingdanfabu")); 
		DingdanfabuView dingdanfabuView =  dingdanfabuService.selectView(ew);
		return R.ok("查询订单发布成功").put("data", dingdanfabuView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DingdanfabuEntity dingdanfabu = dingdanfabuService.selectById(id);
        return R.ok().put("data", dingdanfabu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DingdanfabuEntity dingdanfabu = dingdanfabuService.selectById(id);
        return R.ok().put("data", dingdanfabu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DingdanfabuEntity dingdanfabu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(dingdanfabu);
        dingdanfabuService.insert(dingdanfabu);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DingdanfabuEntity dingdanfabu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(dingdanfabu);
        dingdanfabuService.insert(dingdanfabu);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody DingdanfabuEntity dingdanfabu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(dingdanfabu);
        dingdanfabuService.updateById(dingdanfabu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        dingdanfabuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
