package com.entity.model;

import com.entity.PaotuijiedanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 跑腿接单
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-04-15 09:51:18
 */
public class PaotuijiedanModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 图书名称
	 */
	
	private String tushumingcheng;
		
	/**
	 * 图书类型
	 */
	
	private String tushuleixing;
		
	/**
	 * 封面
	 */
	
	private String fengmian;
		
	/**
	 * 用户账号
	 */
	
	private String yonghuzhanghao;
		
	/**
	 * 用户姓名
	 */
	
	private String yonghuxingming;
		
	/**
	 * 发布地址
	 */
	
	private String dizhi;
		
	/**
	 * 交易账号
	 */
	
	private String jiaoyizhanghao;
		
	/**
	 * 交易姓名
	 */
	
	private String jiaoyixingming;
		
	/**
	 * 收货地址
	 */
	
	private String shouhuodizhi;
		
	/**
	 * 跑腿账号
	 */
	
	private String paotuizhanghao;
		
	/**
	 * 跑腿姓名
	 */
	
	private String paotuixingming;
		
	/**
	 * 接单时间
	 */
		
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 
	private Date jiedanshijian;
		
	/**
	 * 配送状态
	 */
	
	private String peisongzhuangtai;
				
	
	/**
	 * 设置：图书名称
	 */
	 
	public void setTushumingcheng(String tushumingcheng) {
		this.tushumingcheng = tushumingcheng;
	}
	
	/**
	 * 获取：图书名称
	 */
	public String getTushumingcheng() {
		return tushumingcheng;
	}
				
	
	/**
	 * 设置：图书类型
	 */
	 
	public void setTushuleixing(String tushuleixing) {
		this.tushuleixing = tushuleixing;
	}
	
	/**
	 * 获取：图书类型
	 */
	public String getTushuleixing() {
		return tushuleixing;
	}
				
	
	/**
	 * 设置：封面
	 */
	 
	public void setFengmian(String fengmian) {
		this.fengmian = fengmian;
	}
	
	/**
	 * 获取：封面
	 */
	public String getFengmian() {
		return fengmian;
	}
				
	
	/**
	 * 设置：用户账号
	 */
	 
	public void setYonghuzhanghao(String yonghuzhanghao) {
		this.yonghuzhanghao = yonghuzhanghao;
	}
	
	/**
	 * 获取：用户账号
	 */
	public String getYonghuzhanghao() {
		return yonghuzhanghao;
	}
				
	
	/**
	 * 设置：用户姓名
	 */
	 
	public void setYonghuxingming(String yonghuxingming) {
		this.yonghuxingming = yonghuxingming;
	}
	
	/**
	 * 获取：用户姓名
	 */
	public String getYonghuxingming() {
		return yonghuxingming;
	}
				
	
	/**
	 * 设置：发布地址
	 */
	 
	public void setDizhi(String dizhi) {
		this.dizhi = dizhi;
	}
	
	/**
	 * 获取：发布地址
	 */
	public String getDizhi() {
		return dizhi;
	}
				
	
	/**
	 * 设置：交易账号
	 */
	 
	public void setJiaoyizhanghao(String jiaoyizhanghao) {
		this.jiaoyizhanghao = jiaoyizhanghao;
	}
	
	/**
	 * 获取：交易账号
	 */
	public String getJiaoyizhanghao() {
		return jiaoyizhanghao;
	}
				
	
	/**
	 * 设置：交易姓名
	 */
	 
	public void setJiaoyixingming(String jiaoyixingming) {
		this.jiaoyixingming = jiaoyixingming;
	}
	
	/**
	 * 获取：交易姓名
	 */
	public String getJiaoyixingming() {
		return jiaoyixingming;
	}
				
	
	/**
	 * 设置：收货地址
	 */
	 
	public void setShouhuodizhi(String shouhuodizhi) {
		this.shouhuodizhi = shouhuodizhi;
	}
	
	/**
	 * 获取：收货地址
	 */
	public String getShouhuodizhi() {
		return shouhuodizhi;
	}
				
	
	/**
	 * 设置：跑腿账号
	 */
	 
	public void setPaotuizhanghao(String paotuizhanghao) {
		this.paotuizhanghao = paotuizhanghao;
	}
	
	/**
	 * 获取：跑腿账号
	 */
	public String getPaotuizhanghao() {
		return paotuizhanghao;
	}
				
	
	/**
	 * 设置：跑腿姓名
	 */
	 
	public void setPaotuixingming(String paotuixingming) {
		this.paotuixingming = paotuixingming;
	}
	
	/**
	 * 获取：跑腿姓名
	 */
	public String getPaotuixingming() {
		return paotuixingming;
	}
				
	
	/**
	 * 设置：接单时间
	 */
	 
	public void setJiedanshijian(Date jiedanshijian) {
		this.jiedanshijian = jiedanshijian;
	}
	
	/**
	 * 获取：接单时间
	 */
	public Date getJiedanshijian() {
		return jiedanshijian;
	}
				
	
	/**
	 * 设置：配送状态
	 */
	 
	public void setPeisongzhuangtai(String peisongzhuangtai) {
		this.peisongzhuangtai = peisongzhuangtai;
	}
	
	/**
	 * 获取：配送状态
	 */
	public String getPeisongzhuangtai() {
		return peisongzhuangtai;
	}
			
}
