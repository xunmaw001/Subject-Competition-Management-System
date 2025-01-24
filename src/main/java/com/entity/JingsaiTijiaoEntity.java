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
 * 竞赛项目
 *
 * @author 
 * @email
 */
@TableName("jingsai_tijiao")
public class JingsaiTijiaoEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JingsaiTijiaoEntity() {

	}

	public JingsaiTijiaoEntity(T t) {
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
    @TableField(value = "jingsai_tijiao_uuid_number")

    private String jingsaiTijiaoUuidNumber;


    /**
     * jingsai
     */
    @ColumnInfo(comment="jingsai",type="int(11)")
    @TableField(value = "jingsai_id")

    private Integer jingsaiId;


    /**
     * 老师
     */
    @ColumnInfo(comment="老师",type="int(11)")
    @TableField(value = "laoshi_id")

    private Integer laoshiId;


    /**
     * 竞赛报名
     */
    @ColumnInfo(comment="竞赛报名",type="int(11)")
    @TableField(value = "jingsai_yuyue_id")

    private Integer jingsaiYuyueId;


    /**
     * 用户
     */
    @ColumnInfo(comment="用户",type="int(11)")
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 内容
     */
    @ColumnInfo(comment="内容",type="text")
    @TableField(value = "jingsai_tijiao_text")

    private String jingsaiTijiaoText;


    /**
     * 竞赛项目上传
     */
    @ColumnInfo(comment="竞赛项目上传",type="varchar(200)")
    @TableField(value = "jingsai_shangchuan_file")

    private String jingsaiShangchuanFile;


    /**
     * 提交状态
     */
    @ColumnInfo(comment="提交状态",type="int(11)")
    @TableField(value = "jingsai_tijiao_yesno_types")

    private Integer jingsaiTijiaoYesnoTypes;


    /**
     * 竞赛项目评分
     */
    @ColumnInfo(comment="竞赛项目评分",type="int(11)")
    @TableField(value = "jingsai_tijiao_pigai")

    private Integer jingsaiTijiaoPigai;


    /**
     * 竞赛项目提交时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @ColumnInfo(comment="竞赛项目提交时间",type="timestamp")
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间  listShow
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
	 * 获取：创建时间  listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }
    /**
	 * 设置：创建时间  listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "JingsaiTijiao{" +
            ", id=" + id +
            ", jingsaiTijiaoUuidNumber=" + jingsaiTijiaoUuidNumber +
            ", jingsaiId=" + jingsaiId +
            ", laoshiId=" + laoshiId +
            ", jingsaiYuyueId=" + jingsaiYuyueId +
            ", yonghuId=" + yonghuId +
            ", jingsaiTijiaoText=" + jingsaiTijiaoText +
            ", jingsaiShangchuanFile=" + jingsaiShangchuanFile +
            ", jingsaiTijiaoYesnoTypes=" + jingsaiTijiaoYesnoTypes +
            ", jingsaiTijiaoPigai=" + jingsaiTijiaoPigai +
            ", insertTime=" + DateUtil.convertString(insertTime,"yyyy-MM-dd") +
            ", createTime=" + DateUtil.convertString(createTime,"yyyy-MM-dd") +
        "}";
    }
}
