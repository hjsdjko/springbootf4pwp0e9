package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 图书交换
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-15 09:51:19
 */
@TableName("tushujiaohuan")
public class TushujiaohuanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public TushujiaohuanEntity() {
		
	}
	
	public TushujiaohuanEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
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
	 * 库存数量
	 */
					
	private Integer kucunshuliang;
	
	/**
	 * 出版社
	 */
					
	private String chubanshe;
	
	/**
	 * 作者
	 */
					
	private String zuozhe;
	
	/**
	 * 用户账号
	 */
					
	private String yonghuzhanghao;
	
	/**
	 * 用户姓名
	 */
					
	private String yonghuxingming;
	
	/**
	 * 交易账号
	 */
					
	private String jiaoyizhanghao;
	
	/**
	 * 交易姓名
	 */
					
	private String jiaoyixingming;
	
	/**
	 * 交换时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
	@DateTimeFormat 		
	private Date jiaohuanshijian;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
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
	 * 设置：库存数量
	 */
	public void setKucunshuliang(Integer kucunshuliang) {
		this.kucunshuliang = kucunshuliang;
	}
	/**
	 * 获取：库存数量
	 */
	public Integer getKucunshuliang() {
		return kucunshuliang;
	}
	/**
	 * 设置：出版社
	 */
	public void setChubanshe(String chubanshe) {
		this.chubanshe = chubanshe;
	}
	/**
	 * 获取：出版社
	 */
	public String getChubanshe() {
		return chubanshe;
	}
	/**
	 * 设置：作者
	 */
	public void setZuozhe(String zuozhe) {
		this.zuozhe = zuozhe;
	}
	/**
	 * 获取：作者
	 */
	public String getZuozhe() {
		return zuozhe;
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
	 * 设置：交换时间
	 */
	public void setJiaohuanshijian(Date jiaohuanshijian) {
		this.jiaohuanshijian = jiaohuanshijian;
	}
	/**
	 * 获取：交换时间
	 */
	public Date getJiaohuanshijian() {
		return jiaohuanshijian;
	}

}
