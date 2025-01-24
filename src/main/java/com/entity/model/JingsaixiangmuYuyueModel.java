package com.entity.model;

import com.entity.JingsaixiangmuYuyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 竞赛项目审核
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JingsaixiangmuYuyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 报名唯一编号
     */
    private String jingsaixiangmuYuyueUuidNumber;


    /**
     * 竞赛项目名称
     */
    private String jingsaixiangmuName;


    /**
     * 老师
     */
    private Integer laoshiId;


    /**
     * 竞赛项目类型
     */
    private Integer jingsaixiangmuTypes;


    /**
     * 竞赛项目信息
     */
    private String jingsaixiangmuContent;


    /**
     * 报名理由
     */
    private String jingsaixiangmuYuyueText;


    /**
     * 报名状态
     */
    private Integer jingsaixiangmuYuyueYesnoTypes;


    /**
     * 审核回复
     */
    private String jingsaixiangmuYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date jingsaixiangmuYuyueShenheTime;


    /**
     * 竞赛报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date insertTime;


    /**
     * 创建时间
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
    public String getJingsaixiangmuYuyueUuidNumber() {
        return jingsaixiangmuYuyueUuidNumber;
    }


    /**
	 * 设置：报名唯一编号
	 */
    public void setJingsaixiangmuYuyueUuidNumber(String jingsaixiangmuYuyueUuidNumber) {
        this.jingsaixiangmuYuyueUuidNumber = jingsaixiangmuYuyueUuidNumber;
    }
    /**
	 * 获取：竞赛项目名称
	 */
    public String getJingsaixiangmuName() {
        return jingsaixiangmuName;
    }


    /**
	 * 设置：竞赛项目名称
	 */
    public void setJingsaixiangmuName(String jingsaixiangmuName) {
        this.jingsaixiangmuName = jingsaixiangmuName;
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
	 * 获取：竞赛项目类型
	 */
    public Integer getJingsaixiangmuTypes() {
        return jingsaixiangmuTypes;
    }


    /**
	 * 设置：竞赛项目类型
	 */
    public void setJingsaixiangmuTypes(Integer jingsaixiangmuTypes) {
        this.jingsaixiangmuTypes = jingsaixiangmuTypes;
    }
    /**
	 * 获取：竞赛项目信息
	 */
    public String getJingsaixiangmuContent() {
        return jingsaixiangmuContent;
    }


    /**
	 * 设置：竞赛项目信息
	 */
    public void setJingsaixiangmuContent(String jingsaixiangmuContent) {
        this.jingsaixiangmuContent = jingsaixiangmuContent;
    }
    /**
	 * 获取：报名理由
	 */
    public String getJingsaixiangmuYuyueText() {
        return jingsaixiangmuYuyueText;
    }


    /**
	 * 设置：报名理由
	 */
    public void setJingsaixiangmuYuyueText(String jingsaixiangmuYuyueText) {
        this.jingsaixiangmuYuyueText = jingsaixiangmuYuyueText;
    }
    /**
	 * 获取：报名状态
	 */
    public Integer getJingsaixiangmuYuyueYesnoTypes() {
        return jingsaixiangmuYuyueYesnoTypes;
    }


    /**
	 * 设置：报名状态
	 */
    public void setJingsaixiangmuYuyueYesnoTypes(Integer jingsaixiangmuYuyueYesnoTypes) {
        this.jingsaixiangmuYuyueYesnoTypes = jingsaixiangmuYuyueYesnoTypes;
    }
    /**
	 * 获取：审核回复
	 */
    public String getJingsaixiangmuYuyueYesnoText() {
        return jingsaixiangmuYuyueYesnoText;
    }


    /**
	 * 设置：审核回复
	 */
    public void setJingsaixiangmuYuyueYesnoText(String jingsaixiangmuYuyueYesnoText) {
        this.jingsaixiangmuYuyueYesnoText = jingsaixiangmuYuyueYesnoText;
    }
    /**
	 * 获取：审核时间
	 */
    public Date getJingsaixiangmuYuyueShenheTime() {
        return jingsaixiangmuYuyueShenheTime;
    }


    /**
	 * 设置：审核时间
	 */
    public void setJingsaixiangmuYuyueShenheTime(Date jingsaixiangmuYuyueShenheTime) {
        this.jingsaixiangmuYuyueShenheTime = jingsaixiangmuYuyueShenheTime;
    }
    /**
	 * 获取：竞赛报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 设置：竞赛报名时间
	 */
    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
