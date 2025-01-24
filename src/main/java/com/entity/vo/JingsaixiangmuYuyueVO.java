package com.entity.vo;

import com.entity.JingsaixiangmuYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 竞赛项目审核
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jingsaixiangmu_yuyue")
public class JingsaixiangmuYuyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名唯一编号
     */

    @TableField(value = "jingsaixiangmu_yuyue_uuid_number")
    private String jingsaixiangmuYuyueUuidNumber;


    /**
     * 竞赛项目名称
     */

    @TableField(value = "jingsaixiangmu_name")
    private String jingsaixiangmuName;


    /**
     * 老师
     */

    @TableField(value = "laoshi_id")
    private Integer laoshiId;


    /**
     * 竞赛项目类型
     */

    @TableField(value = "jingsaixiangmu_types")
    private Integer jingsaixiangmuTypes;


    /**
     * 竞赛项目信息
     */

    @TableField(value = "jingsaixiangmu_content")
    private String jingsaixiangmuContent;


    /**
     * 报名理由
     */

    @TableField(value = "jingsaixiangmu_yuyue_text")
    private String jingsaixiangmuYuyueText;


    /**
     * 报名状态
     */

    @TableField(value = "jingsaixiangmu_yuyue_yesno_types")
    private Integer jingsaixiangmuYuyueYesnoTypes;


    /**
     * 审核回复
     */

    @TableField(value = "jingsaixiangmu_yuyue_yesno_text")
    private String jingsaixiangmuYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "jingsaixiangmu_yuyue_shenhe_time")
    private Date jingsaixiangmuYuyueShenheTime;


    /**
     * 竞赛报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：报名唯一编号
	 */
    public String getJingsaixiangmuYuyueUuidNumber() {
        return jingsaixiangmuYuyueUuidNumber;
    }


    /**
	 * 获取：报名唯一编号
	 */

    public void setJingsaixiangmuYuyueUuidNumber(String jingsaixiangmuYuyueUuidNumber) {
        this.jingsaixiangmuYuyueUuidNumber = jingsaixiangmuYuyueUuidNumber;
    }
    /**
	 * 设置：竞赛项目名称
	 */
    public String getJingsaixiangmuName() {
        return jingsaixiangmuName;
    }


    /**
	 * 获取：竞赛项目名称
	 */

    public void setJingsaixiangmuName(String jingsaixiangmuName) {
        this.jingsaixiangmuName = jingsaixiangmuName;
    }
    /**
	 * 设置：老师
	 */
    public Integer getLaoshiId() {
        return laoshiId;
    }


    /**
	 * 获取：老师
	 */

    public void setLaoshiId(Integer laoshiId) {
        this.laoshiId = laoshiId;
    }
    /**
	 * 设置：竞赛项目类型
	 */
    public Integer getJingsaixiangmuTypes() {
        return jingsaixiangmuTypes;
    }


    /**
	 * 获取：竞赛项目类型
	 */

    public void setJingsaixiangmuTypes(Integer jingsaixiangmuTypes) {
        this.jingsaixiangmuTypes = jingsaixiangmuTypes;
    }
    /**
	 * 设置：竞赛项目信息
	 */
    public String getJingsaixiangmuContent() {
        return jingsaixiangmuContent;
    }


    /**
	 * 获取：竞赛项目信息
	 */

    public void setJingsaixiangmuContent(String jingsaixiangmuContent) {
        this.jingsaixiangmuContent = jingsaixiangmuContent;
    }
    /**
	 * 设置：报名理由
	 */
    public String getJingsaixiangmuYuyueText() {
        return jingsaixiangmuYuyueText;
    }


    /**
	 * 获取：报名理由
	 */

    public void setJingsaixiangmuYuyueText(String jingsaixiangmuYuyueText) {
        this.jingsaixiangmuYuyueText = jingsaixiangmuYuyueText;
    }
    /**
	 * 设置：报名状态
	 */
    public Integer getJingsaixiangmuYuyueYesnoTypes() {
        return jingsaixiangmuYuyueYesnoTypes;
    }


    /**
	 * 获取：报名状态
	 */

    public void setJingsaixiangmuYuyueYesnoTypes(Integer jingsaixiangmuYuyueYesnoTypes) {
        this.jingsaixiangmuYuyueYesnoTypes = jingsaixiangmuYuyueYesnoTypes;
    }
    /**
	 * 设置：审核回复
	 */
    public String getJingsaixiangmuYuyueYesnoText() {
        return jingsaixiangmuYuyueYesnoText;
    }


    /**
	 * 获取：审核回复
	 */

    public void setJingsaixiangmuYuyueYesnoText(String jingsaixiangmuYuyueYesnoText) {
        this.jingsaixiangmuYuyueYesnoText = jingsaixiangmuYuyueYesnoText;
    }
    /**
	 * 设置：审核时间
	 */
    public Date getJingsaixiangmuYuyueShenheTime() {
        return jingsaixiangmuYuyueShenheTime;
    }


    /**
	 * 获取：审核时间
	 */

    public void setJingsaixiangmuYuyueShenheTime(Date jingsaixiangmuYuyueShenheTime) {
        this.jingsaixiangmuYuyueShenheTime = jingsaixiangmuYuyueShenheTime;
    }
    /**
	 * 设置：竞赛报名时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：竞赛报名时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
