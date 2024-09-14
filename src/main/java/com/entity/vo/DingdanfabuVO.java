package com.entity.vo;

import com.entity.DingdanfabuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 订单发布
 * @author 
 * @email 
 * @date 2024-04-15 09:51:18
 */
public class DingdanfabuVO  implements Serializable {
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
	 * 价格
	 */
	
	private Double jiage;
		
	/**
	 * 交易数量
	 */
	
	private Integer shuliang;
		
	/**
	 * 金额
	 */
	
	private Double jine;
		
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
	 * 接单状态
	 */
	
	private String jiedanzhuangtai;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
				
	
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
	 * 设置：价格
	 */
	 
	public void setJiage(Double jiage) {
		this.jiage = jiage;
	}
	
	/**
	 * 获取：价格
	 */
	public Double getJiage() {
		return jiage;
	}
				
	
	/**
	 * 设置：交易数量
	 */
	 
	public void setShuliang(Integer shuliang) {
		this.shuliang = shuliang;
	}
	
	/**
	 * 获取：交易数量
	 */
	public Integer getShuliang() {
		return shuliang;
	}
				
	
	/**
	 * 设置：金额
	 */
	 
	public void setJine(Double jine) {
		this.jine = jine;
	}
	
	/**
	 * 获取：金额
	 */
	public Double getJine() {
		return jine;
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
	 * 设置：接单状态
	 */
	 
	public void setJiedanzhuangtai(String jiedanzhuangtai) {
		this.jiedanzhuangtai = jiedanzhuangtai;
	}
	
	/**
	 * 获取：接单状态
	 */
	public String getJiedanzhuangtai() {
		return jiedanzhuangtai;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
			
}
