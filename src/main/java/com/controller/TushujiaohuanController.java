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

import com.entity.TushujiaohuanEntity;
import com.entity.view.TushujiaohuanView;

import com.service.TushujiaohuanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 图书交换
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-15 09:51:19
 */
@RestController
@RequestMapping("/tushujiaohuan")
public class TushujiaohuanController {
    @Autowired
    private TushujiaohuanService tushujiaohuanService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TushujiaohuanEntity tushujiaohuan,
		HttpServletRequest request){
        EntityWrapper<TushujiaohuanEntity> ew = new EntityWrapper<TushujiaohuanEntity>();

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
		PageUtils page = tushujiaohuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tushujiaohuan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TushujiaohuanEntity tushujiaohuan, 
		HttpServletRequest request){
        EntityWrapper<TushujiaohuanEntity> ew = new EntityWrapper<TushujiaohuanEntity>();

		PageUtils page = tushujiaohuanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tushujiaohuan), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TushujiaohuanEntity tushujiaohuan){
       	EntityWrapper<TushujiaohuanEntity> ew = new EntityWrapper<TushujiaohuanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tushujiaohuan, "tushujiaohuan")); 
        return R.ok().put("data", tushujiaohuanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TushujiaohuanEntity tushujiaohuan){
        EntityWrapper< TushujiaohuanEntity> ew = new EntityWrapper< TushujiaohuanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tushujiaohuan, "tushujiaohuan")); 
		TushujiaohuanView tushujiaohuanView =  tushujiaohuanService.selectView(ew);
		return R.ok("查询图书交换成功").put("data", tushujiaohuanView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TushujiaohuanEntity tushujiaohuan = tushujiaohuanService.selectById(id);
        return R.ok().put("data", tushujiaohuan);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TushujiaohuanEntity tushujiaohuan = tushujiaohuanService.selectById(id);
        return R.ok().put("data", tushujiaohuan);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TushujiaohuanEntity tushujiaohuan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(tushujiaohuan);
        tushujiaohuanService.insert(tushujiaohuan);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TushujiaohuanEntity tushujiaohuan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(tushujiaohuan);
        tushujiaohuanService.insert(tushujiaohuan);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TushujiaohuanEntity tushujiaohuan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tushujiaohuan);
        tushujiaohuanService.updateById(tushujiaohuan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tushujiaohuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
