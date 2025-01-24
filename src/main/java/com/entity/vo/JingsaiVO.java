package com.entity.vo;

import com.entity.JingsaiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 竞赛项目信息
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("jingsai")
public class JingsaiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 竞赛名称
     */

    @TableField(value = "jingsai_name")
    private String jingsaiName;


    /**
     * 竞赛编号
     */

    @TableField(value = "jingsai_uuid_number")
    private String jingsaiUuidNumber;


    /**
     * 竞赛照片
     */

    @TableField(value = "jingsai_photo")
    private String jingsaiPhoto;


    /**
     * 竞赛类型
     */

    @TableField(value = "jingsai_types")
    private Integer jingsaiTypes;


    /**
     * 竞赛信息
     */

    @TableField(value = "jingsai_content")
    private String jingsaiContent;


    /**
     * 逻辑删除
     */

    @TableField(value = "jingsai_delete")
    private Integer jingsaiDelete;


    /**
     * 录入时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "insert_time")
    private Date insertTime;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 设置：竞赛名称
	 */
    public String getJingsaiName() {
        return jingsaiName;
    }


    /**
	 * 获取：竞赛名称
	 */

    public void setJingsaiName(String jingsaiName) {
        this.jingsaiName = jingsaiName;
    }
    /**
	 * 设置：竞赛编号
	 */
    public String getJingsaiUuidNumber() {
        return jingsaiUuidNumber;
    }


    /**
	 * 获取：竞赛编号
	 */

    public void setJingsaiUuidNumber(String jingsaiUuidNumber) {
        this.jingsaiUuidNumber = jingsaiUuidNumber;
    }
    /**
	 * 设置：竞赛照片
	 */
    public String getJingsaiPhoto() {
        return jingsaiPhoto;
    }


    /**
	 * 获取：竞赛照片
	 */

    public void setJingsaiPhoto(String jingsaiPhoto) {
        this.jingsaiPhoto = jingsaiPhoto;
    }
    /**
	 * 设置：竞赛类型
	 */
    public Integer getJingsaiTypes() {
        return jingsaiTypes;
    }


    /**
	 * 获取：竞赛类型
	 */

    public void setJingsaiTypes(Integer jingsaiTypes) {
        this.jingsaiTypes = jingsaiTypes;
    }
    /**
	 * 设置：竞赛信息
	 */
    public String getJingsaiContent() {
        return jingsaiContent;
    }


    /**
	 * 获取：竞赛信息
	 */

    public void setJingsaiContent(String jingsaiContent) {
        this.jingsaiContent = jingsaiContent;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getJingsaiDelete() {
        return jingsaiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setJingsaiDelete(Integer jingsaiDelete) {
        this.jingsaiDelete = jingsaiDelete;
    }
    /**
	 * 设置：录入时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：录入时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
