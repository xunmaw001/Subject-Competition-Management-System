package com.entity.vo;

import com.entity.JingsaiTijiaoEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 竞赛项目
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jingsai_tijiao")
public class JingsaiTijiaoVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 报名唯一编号
     */

    @TableField(value = "jingsai_tijiao_uuid_number")
    private String jingsaiTijiaoUuidNumber;


    /**
     * jingsai
     */

    @TableField(value = "jingsai_id")
    private Integer jingsaiId;


    /**
     * 老师
     */

    @TableField(value = "laoshi_id")
    private Integer laoshiId;


    /**
     * 竞赛报名
     */

    @TableField(value = "jingsai_yuyue_id")
    private Integer jingsaiYuyueId;


    /**
     * 用户
     */

    @TableField(value = "yonghu_id")
    private Integer yonghuId;


    /**
     * 内容
     */

    @TableField(value = "jingsai_tijiao_text")
    private String jingsaiTijiaoText;


    /**
     * 竞赛项目上传
     */

    @TableField(value = "jingsai_shangchuan_file")
    private String jingsaiShangchuanFile;


    /**
     * 提交状态
     */

    @TableField(value = "jingsai_tijiao_yesno_types")
    private Integer jingsaiTijiaoYesnoTypes;


    /**
     * 竞赛项目评分
     */

    @TableField(value = "jingsai_tijiao_pigai")
    private Integer jingsaiTijiaoPigai;


    /**
     * 竞赛项目提交时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间 show3 listShow
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
    public String getJingsaiTijiaoUuidNumber() {
        return jingsaiTijiaoUuidNumber;
    }


    /**
	 * 获取：报名唯一编号
	 */

    public void setJingsaiTijiaoUuidNumber(String jingsaiTijiaoUuidNumber) {
        this.jingsaiTijiaoUuidNumber = jingsaiTijiaoUuidNumber;
    }
    /**
	 * 设置：jingsai
	 */
    public Integer getJingsaiId() {
        return jingsaiId;
    }


    /**
	 * 获取：jingsai
	 */

    public void setJingsaiId(Integer jingsaiId) {
        this.jingsaiId = jingsaiId;
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
	 * 设置：竞赛报名
	 */
    public Integer getJingsaiYuyueId() {
        return jingsaiYuyueId;
    }


    /**
	 * 获取：竞赛报名
	 */

    public void setJingsaiYuyueId(Integer jingsaiYuyueId) {
        this.jingsaiYuyueId = jingsaiYuyueId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：内容
	 */
    public String getJingsaiTijiaoText() {
        return jingsaiTijiaoText;
    }


    /**
	 * 获取：内容
	 */

    public void setJingsaiTijiaoText(String jingsaiTijiaoText) {
        this.jingsaiTijiaoText = jingsaiTijiaoText;
    }
    /**
	 * 设置：竞赛项目上传
	 */
    public String getJingsaiShangchuanFile() {
        return jingsaiShangchuanFile;
    }


    /**
	 * 获取：竞赛项目上传
	 */

    public void setJingsaiShangchuanFile(String jingsaiShangchuanFile) {
        this.jingsaiShangchuanFile = jingsaiShangchuanFile;
    }
    /**
	 * 设置：提交状态
	 */
    public Integer getJingsaiTijiaoYesnoTypes() {
        return jingsaiTijiaoYesnoTypes;
    }


    /**
	 * 获取：提交状态
	 */

    public void setJingsaiTijiaoYesnoTypes(Integer jingsaiTijiaoYesnoTypes) {
        this.jingsaiTijiaoYesnoTypes = jingsaiTijiaoYesnoTypes;
    }
    /**
	 * 设置：竞赛项目评分
	 */
    public Integer getJingsaiTijiaoPigai() {
        return jingsaiTijiaoPigai;
    }


    /**
	 * 获取：竞赛项目评分
	 */

    public void setJingsaiTijiaoPigai(Integer jingsaiTijiaoPigai) {
        this.jingsaiTijiaoPigai = jingsaiTijiaoPigai;
    }
    /**
	 * 设置：竞赛项目提交时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：竞赛项目提交时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间 show3 listShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间 show3 listShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
