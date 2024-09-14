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

import com.entity.PaotuijiedanEntity;
import com.entity.view.PaotuijiedanView;

import com.service.PaotuijiedanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 跑腿接单
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-15 09:51:18
 */
@RestController
@RequestMapping("/paotuijiedan")
public class PaotuijiedanController {
    @Autowired
    private PaotuijiedanService paotuijiedanService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PaotuijiedanEntity paotuijiedan,
		HttpServletRequest request){
        EntityWrapper<PaotuijiedanEntity> ew = new EntityWrapper<PaotuijiedanEntity>();

        String tableName = request.getSession().getAttribute("tableName").toString();
        ew.andNew();
        if(tableName.equals("yonghu")) {
            ew.eq("yonghuzhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("yonghu")) {
            ew.or();
            ew.eq("jiaoyizhanghao", (String)request.getSession().getAttribute("username"));
        }
        if(tableName.equals("paotuiyuan")) {
            ew.or();
            ew.eq("paotuizhanghao", (String)request.getSession().getAttribute("username"));
        }
        ew.andNew("1=1");
		PageUtils page = paotuijiedanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, paotuijiedan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PaotuijiedanEntity paotuijiedan, 
		HttpServletRequest request){
        EntityWrapper<PaotuijiedanEntity> ew = new EntityWrapper<PaotuijiedanEntity>();

		PageUtils page = paotuijiedanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, paotuijiedan), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PaotuijiedanEntity paotuijiedan){
       	EntityWrapper<PaotuijiedanEntity> ew = new EntityWrapper<PaotuijiedanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( paotuijiedan, "paotuijiedan")); 
        return R.ok().put("data", paotuijiedanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PaotuijiedanEntity paotuijiedan){
        EntityWrapper< PaotuijiedanEntity> ew = new EntityWrapper< PaotuijiedanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( paotuijiedan, "paotuijiedan")); 
		PaotuijiedanView paotuijiedanView =  paotuijiedanService.selectView(ew);
		return R.ok("查询跑腿接单成功").put("data", paotuijiedanView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PaotuijiedanEntity paotuijiedan = paotuijiedanService.selectById(id);
        return R.ok().put("data", paotuijiedan);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PaotuijiedanEntity paotuijiedan = paotuijiedanService.selectById(id);
        return R.ok().put("data", paotuijiedan);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PaotuijiedanEntity paotuijiedan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(paotuijiedan);
        paotuijiedanService.insert(paotuijiedan);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PaotuijiedanEntity paotuijiedan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(paotuijiedan);
        paotuijiedanService.insert(paotuijiedan);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PaotuijiedanEntity paotuijiedan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(paotuijiedan);
        paotuijiedanService.updateById(paotuijiedan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        paotuijiedanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
