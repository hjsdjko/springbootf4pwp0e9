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

import com.entity.TushujuanzengEntity;
import com.entity.view.TushujuanzengView;

import com.service.TushujuanzengService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.service.StoreupService;
import com.entity.StoreupEntity;

/**
 * 图书捐赠
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-15 09:51:19
 */
@RestController
@RequestMapping("/tushujuanzeng")
public class TushujuanzengController {
    @Autowired
    private TushujuanzengService tushujuanzengService;

    @Autowired
    private StoreupService storeupService;



    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TushujuanzengEntity tushujuanzeng,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			tushujuanzeng.setYonghuzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TushujuanzengEntity> ew = new EntityWrapper<TushujuanzengEntity>();

		PageUtils page = tushujuanzengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tushujuanzeng), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TushujuanzengEntity tushujuanzeng, 
		HttpServletRequest request){
        EntityWrapper<TushujuanzengEntity> ew = new EntityWrapper<TushujuanzengEntity>();

		PageUtils page = tushujuanzengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tushujuanzeng), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TushujuanzengEntity tushujuanzeng){
       	EntityWrapper<TushujuanzengEntity> ew = new EntityWrapper<TushujuanzengEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tushujuanzeng, "tushujuanzeng")); 
        return R.ok().put("data", tushujuanzengService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TushujuanzengEntity tushujuanzeng){
        EntityWrapper< TushujuanzengEntity> ew = new EntityWrapper< TushujuanzengEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tushujuanzeng, "tushujuanzeng")); 
		TushujuanzengView tushujuanzengView =  tushujuanzengService.selectView(ew);
		return R.ok("查询图书捐赠成功").put("data", tushujuanzengView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TushujuanzengEntity tushujuanzeng = tushujuanzengService.selectById(id);
		tushujuanzeng.setClicktime(new Date());
		tushujuanzengService.updateById(tushujuanzeng);
        tushujuanzeng = tushujuanzengService.selectView(new EntityWrapper<TushujuanzengEntity>().eq("id", id));
        return R.ok().put("data", tushujuanzeng);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TushujuanzengEntity tushujuanzeng = tushujuanzengService.selectById(id);
		tushujuanzeng.setClicktime(new Date());
		tushujuanzengService.updateById(tushujuanzeng);
        tushujuanzeng = tushujuanzengService.selectView(new EntityWrapper<TushujuanzengEntity>().eq("id", id));
        return R.ok().put("data", tushujuanzeng);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TushujuanzengEntity tushujuanzeng, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(tushujuanzeng);
        tushujuanzengService.insert(tushujuanzeng);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TushujuanzengEntity tushujuanzeng, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(tushujuanzeng);
        tushujuanzengService.insert(tushujuanzeng);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody TushujuanzengEntity tushujuanzeng, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tushujuanzeng);
        tushujuanzengService.updateById(tushujuanzeng);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<TushujuanzengEntity> list = new ArrayList<TushujuanzengEntity>();
        for(Long id : ids) {
            TushujuanzengEntity tushujuanzeng = tushujuanzengService.selectById(id);
            tushujuanzeng.setSfsh(sfsh);
            tushujuanzeng.setShhf(shhf);
            list.add(tushujuanzeng);
        }
        tushujuanzengService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tushujuanzengService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前台智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,TushujuanzengEntity tushujuanzeng, HttpServletRequest request,String pre){
        EntityWrapper<TushujuanzengEntity> ew = new EntityWrapper<TushujuanzengEntity>();
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
		PageUtils page = tushujuanzengService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tushujuanzeng), params), params));
        return R.ok().put("data", page);
    }










}
