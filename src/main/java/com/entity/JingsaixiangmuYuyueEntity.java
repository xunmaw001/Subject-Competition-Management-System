package com.entity;

import com.annotation.ColumnInfo;
import javax.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;
import java.io.Serializable;
import java.util.*;
import org.apache.tools.ant.util.DateUtils;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.utils.DateUtil;


/**
 * 竞赛项目审核
 *
 * @author 
 * @email
 */
@TableName("jingsaixiangmu_yuyue")
public class JingsaixiangmuYuyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JingsaixiangmuYuyueEntity() {

	}

	public JingsaixiangmuYuyueEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @ColumnInfo(comment="主键",type="int(11)")
    @TableField(value = "id")

    private Integer id;


    /**
     * 报名唯一编号
     */
    @ColumnInfo(comment="报名唯一编号",type="varchar(200)")
    @TableField(value = "jingsaixiangmu_yuyue_uuid_number")

    private String jingsaixiangmuYuyueUuidNumber;


    /**
     * 竞赛项目名称
     */
    @ColumnInfo(comment="竞赛项目名称",type="varchar(200)")
    @TableField(value = "jingsaixiangmu_name")

    private String jingsaixiangmuName;


    /**
     * 老师
     */
    @ColumnInfo(comment="老师",type="int(11)")
    @TableField(value = "laoshi_id")

    private Integer laoshiId;


    /**
     * 竞赛项目类型
     */
    @ColumnInfo(comment="竞赛项目类型",type="int(11)")
    @TableField(value = "jingsaixiangmu_types")

    private Integer jingsaixiangmuTypes;


    /**
     * 竞赛项目信息
     */
    @ColumnInfo(comment="竞赛项目信息",type="text")
    @TableField(value = "jingsaixiangmu_content")

    private String jingsaixiangmuContent;


    /**
     * 报名理由
     */
    @ColumnInfo(comment="报名理由",type="text")
    @TableField(value = "jingsaixiangmu_yuyue_text")

    private String jingsaixiangmuYuyueText;


    /**
     * 报名状态
     */
    @ColumnInfo(comment="报名状态",type="int(11)")
    @TableField(value = "jingsaixiangmu_yuyue_yesno_types")

    private Integer jingsaixiangmuYuyueYesnoTypes;


    /**
     * 审核回复
     */
    @ColumnInfo(comment="审核回复",type="text")
    @TableField(value = "jingsaixiangmu_yuyue_yesno_text")

    private String jingsaixiangmuYuyueYesnoText;


    /**
     * 审核时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="审核时间",type="timestamp")
    @TableField(value = "jingsaixiangmu_yuyue_shenhe_time")

    private Date jingsaixiangmuYuyueShenheTime;


    /**
     * 竞赛报名时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="竞赛报名时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="创建时间",type="timestamp")
    @TableField(value = "create_time",fill = FieldFill.INSERT)

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

    @Override
    public String toString() {
        return "JingsaixiangmuYuyue{" +
            ", id=" + id +
            ", jingsaixiangmuYuyueUuidNumber=" + jingsaixiangmuYuyueUuidNumber +
            ", jingsaixiangmuName=" + jingsaixiangmuName +
            ", laoshiId=" + laoshiId +
            ", jingsaixiangmuTypes=" + jingsaixiangmuTypes +
            ", jingsaixiangmuContent=" + jingsaixiangmuContent +
            ", jingsaixiangmuYuyueText=" + jingsaixiangmuYuyueText +
            ", jingsaixiangmuYuyueYesnoTypes=" + jingsaixiangmuYuyueYesnoTypes +
            ", jingsaixiangmuYuyueYesnoText=" + jingsaixiangmuYuyueYesnoText +
            ", jingsaixiangmuYuyueShenheTime=" + DateUtil.convertString(jingsaixiangmuYuyueShenheTime,"yyyy-MM-dd") +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
