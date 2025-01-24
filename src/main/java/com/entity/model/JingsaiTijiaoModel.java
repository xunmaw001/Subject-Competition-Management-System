package com.entity.model;

import com.entity.JingsaiTijiaoEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 竞赛项目
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JingsaiTijiaoModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 报名唯一编号
     */
    private String jingsaiTijiaoUuidNumber;


    /**
     * jingsai
     */
    private Integer jingsaiId;


    /**
     * 老师
     */
    private Integer laoshiId;


    /**
     * 竞赛报名
     */
    private Integer jingsaiYuyueId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 内容
     */
    private String jingsaiTijiaoText;


    /**
     * 竞赛项目上传
     */
    private String jingsaiShangchuanFile;


    /**
     * 提交状态
     */
    private Integer jingsaiTijiaoYesnoTypes;


    /**
     * 竞赛项目评分
     */
    private Integer jingsaiTijiaoPigai;


    /**
     * 竞赛项目提交时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：报名唯一编号
	 */
    public String getJingsaiTijiaoUuidNumber() {
        return jingsaiTijiaoUuidNumber;
    }


    /**
	 * 设置：报名唯一编号
	 */
    public void setJingsaiTijiaoUuidNumber(String jingsaiTijiaoUuidNumber) {
        this.jingsaiTijiaoUuidNumber = jingsaiTijiaoUuidNumber;
    }
    /**
	 * 获取：jingsai
	 */
    public Integer getJingsaiId() {
        return jingsaiId;
    }


    /**
	 * 设置：jingsai
	 */
    public void setJingsaiId(Integer jingsaiId) {
        this.jingsaiId = jingsaiId;
    }
    /**
	 * 获取：老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }


    /**
	 * 设置：老师
	 */
    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 获取：竞赛报名
	 */
    public Integer getJingsaiYuyueId() {
        return jingsaiYuyueId;
    }


    /**
	 * 设置：竞赛报名
	 */
    public void setJingsaiYuyueId(Integer jingsaiYuyueId) {
        this.jingsaiYuyueId = jingsaiYuyueId;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：内容
	 */
    public String getJingsaiTijiaoText() {
        return jingsaiTijiaoText;
    }


    /**
	 * 设置：内容
	 */
    public void setJingsaiTijiaoText(String jingsaiTijiaoText) {
        this.jingsaiTijiaoText = jingsaiTijiaoText;
    }
    /**
	 * 获取：竞赛项目上传
	 */
    public String getJingsaiShangchuanFile() {
        return jingsaiShangchuanFile;
    }


    /**
	 * 设置：竞赛项目上传
	 */
    public void setJingsaiShangchuanFile(String jingsaiShangchuanFile) {
        this.jingsaiShangchuanFile = jingsaiShangchuanFile;
    }
    /**
	 * 获取：提交状态
	 */
    public Integer getJingsaiTijiaoYesnoTypes() {
        return jingsaiTijiaoYesnoTypes;
    }


    /**
	 * 设置：提交状态
	 */
    public void setJingsaiTijiaoYesnoTypes(Integer jingsaiTijiaoYesnoTypes) {
        this.jingsaiTijiaoYesnoTypes = jingsaiTijiaoYesnoTypes;
    }
    /**
	 * 获取：竞赛项目评分
	 */
    public Integer getJingsaiTijiaoPigai() {
        return jingsaiTijiaoPigai;
    }


    /**
	 * 设置：竞赛项目评分
	 */
    public void setJingsaiTijiaoPigai(Integer jingsaiTijiaoPigai) {
        this.jingsaiTijiaoPigai = jingsaiTijiaoPigai;
    }
    /**
	 * 获取：竞赛项目提交时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：竞赛项目提交时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间 show3 listShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
