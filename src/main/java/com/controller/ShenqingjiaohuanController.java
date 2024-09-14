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

import com.entity.ShenqingjiaohuanEntity;
import com.entity.view.ShenqingjiaohuanView;

import com.service.ShenqingjiaohuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 申请交换
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-15 09:51:19
 */
@RestController
@RequestMapping("/shenqingjiaohuan")
public class ShenqingjiaohuanController {
    @Autowired
    private ShenqingjiaohuanService shenqingjiaohuanService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShenqingjiaohuanEntity shenqingjiaohuan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			shenqingjiaohuan.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<ShenqingjiaohuanEntity> ew = new EntityWrapper<ShenqingjiaohuanEntity>();

		PageUtils page = shenqingjiaohuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenqingjiaohuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShenqingjiaohuanEntity shenqingjiaohuan, 
		HttpServletRequest request){
        EntityWrapper<ShenqingjiaohuanEntity> ew = new EntityWrapper<ShenqingjiaohuanEntity>();

		PageUtils page = shenqingjiaohuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shenqingjiaohuan), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShenqingjiaohuanEntity shenqingjiaohuan){
       	EntityWrapper<ShenqingjiaohuanEntity> ew = new EntityWrapper<ShenqingjiaohuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shenqingjiaohuan, "shenqingjiaohuan")); 
        return R.ok().put("data", shenqingjiaohuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShenqingjiaohuanEntity shenqingjiaohuan){
        EntityWrapper< ShenqingjiaohuanEntity> ew = new EntityWrapper< ShenqingjiaohuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shenqingjiaohuan, "shenqingjiaohuan")); 
		ShenqingjiaohuanView shenqingjiaohuanView =  shenqingjiaohuanService.selectView(ew);
		return R.ok("查询申请交换成功").put("data", shenqingjiaohuanView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShenqingjiaohuanEntity shenqingjiaohuan = shenqingjiaohuanService.selectById(id);
        return R.ok().put("data", shenqingjiaohuan);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShenqingjiaohuanEntity shenqingjiaohuan = shenqingjiaohuanService.selectById(id);
        return R.ok().put("data", shenqingjiaohuan);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShenqingjiaohuanEntity shenqingjiaohuan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shenqingjiaohuan);
        shenqingjiaohuanService.insert(shenqingjiaohuan);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShenqingjiaohuanEntity shenqingjiaohuan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(shenqingjiaohuan);
        shenqingjiaohuanService.insert(shenqingjiaohuan);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShenqingjiaohuanEntity shenqingjiaohuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shenqingjiaohuan);
        shenqingjiaohuanService.updateById(shenqingjiaohuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shenqingjiaohuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
