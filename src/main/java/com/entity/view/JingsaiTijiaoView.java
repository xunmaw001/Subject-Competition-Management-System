package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JingsaiTijiaoEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 竞赛项目
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jingsai_tijiao")
public class JingsaiTijiaoView extends JingsaiTijiaoEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 提交状态的值
	*/
	@ColumnInfo(comment="提交状态的字典表值",type="varchar(200)")
	private String jingsaiTijiaoYesnoValue;

	//级联表 竞赛项目信息
		/**
		* 竞赛名称
		*/

		@ColumnInfo(comment="竞赛名称",type="varchar(200)")
		private String jingsaiName;
		/**
		* 竞赛编号
		*/

		@ColumnInfo(comment="竞赛编号",type="varchar(200)")
		private String jingsaiUuidNumber;
		/**
		* 竞赛照片
		*/

		@ColumnInfo(comment="竞赛照片",type="varchar(200)")
		private String jingsaiPhoto;
		/**
		* 竞赛类型
		*/
		@ColumnInfo(comment="竞赛类型",type="int(11)")
		private Integer jingsaiTypes;
			/**
			* 竞赛类型的值
			*/
			@ColumnInfo(comment="竞赛类型的字典表值",type="varchar(200)")
			private String jingsaiValue;
		/**
		* 竞赛信息
		*/

		@ColumnInfo(comment="竞赛信息",type="text")
		private String jingsaiContent;
		/**
		* 逻辑删除
		*/

		@ColumnInfo(comment="逻辑删除",type="int(11)")
		private Integer jingsaiDelete;
	//级联表 竞赛报名
		/**
		* 报名唯一编号
		*/

		@ColumnInfo(comment="报名唯一编号",type="varchar(200)")
		private String jingsaiYuyueUuidNumber;
										 
		/**
		* 竞赛报名 的 用户
		*/
		@ColumnInfo(comment="用户",type="int(11)")
		private Integer jingsaiYuyueYonghuId;
		/**
		* 报名理由
		*/

		@ColumnInfo(comment="报名理由",type="text")
		private String jingsaiYuyueText;
		/**
		* 报名状态
		*/
		@ColumnInfo(comment="报名状态",type="int(11)")
		private Integer jingsaiYuyueYesnoTypes;
			/**
			* 报名状态的值
			*/
			@ColumnInfo(comment="报名状态的字典表值",type="varchar(200)")
			private String jingsaiYuyueYesnoValue;
		/**
		* 审核回复
		*/

		@ColumnInfo(comment="审核回复",type="text")
		private String jingsaiYuyueYesnoText;
		/**
		* 审核时间
		*/
		@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
		@DateTimeFormat
		@ColumnInfo(comment="审核时间",type="timestamp")
		private Date jingsaiYuyueShenheTime;
	//级联表 老师
		/**
		* 老师姓名
		*/

		@ColumnInfo(comment="老师姓名",type="varchar(200)")
		private String laoshiName;
		/**
		* 老师手机号
		*/

		@ColumnInfo(comment="老师手机号",type="varchar(200)")
		private String laoshiPhone;
		/**
		* 老师身份证号
		*/

		@ColumnInfo(comment="老师身份证号",type="varchar(200)")
		private String laoshiIdNumber;
		/**
		* 老师头像
		*/

		@ColumnInfo(comment="老师头像",type="varchar(200)")
		private String laoshiPhoto;
		/**
		* 老师邮箱
		*/

		@ColumnInfo(comment="老师邮箱",type="varchar(200)")
		private String laoshiEmail;
	//级联表 用户
		/**
		* 用户姓名
		*/

		@ColumnInfo(comment="用户姓名",type="varchar(200)")
		private String yonghuName;
		/**
		* 用户手机号
		*/

		@ColumnInfo(comment="用户手机号",type="varchar(200)")
		private String yonghuPhone;
		/**
		* 用户身份证号
		*/

		@ColumnInfo(comment="用户身份证号",type="varchar(200)")
		private String yonghuIdNumber;
		/**
		* 用户头像
		*/

		@ColumnInfo(comment="用户头像",type="varchar(200)")
		private String yonghuPhoto;
		/**
		* 用户邮箱
		*/

		@ColumnInfo(comment="用户邮箱",type="varchar(200)")
		private String yonghuEmail;

	//重复字段
			/**
			* 重复字段 的types
			*/
			@ColumnInfo(comment="重复字段 的types",type="Integer")
			private Integer sexTypes;
				@ColumnInfo(comment="重复字段 的值",type="varchar(200)")
				private String sexValue;


	public JingsaiTijiaoView() {

	}

	public JingsaiTijiaoView(JingsaiTijiaoEntity jingsaiTijiaoEntity) {
		try {
			BeanUtils.copyProperties(this, jingsaiTijiaoEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 提交状态的值
	*/
	public String getJingsaiTijiaoYesnoValue() {
		return jingsaiTijiaoYesnoValue;
	}
	/**
	* 设置： 提交状态的值
	*/
	public void setJingsaiTijiaoYesnoValue(String jingsaiTijiaoYesnoValue) {
		this.jingsaiTijiaoYesnoValue = jingsaiTijiaoYesnoValue;
	}


	//级联表的get和set 竞赛项目信息

		/**
		* 获取： 竞赛名称
		*/
		public String getJingsaiName() {
			return jingsaiName;
		}
		/**
		* 设置： 竞赛名称
		*/
		public void setJingsaiName(String jingsaiName) {
			this.jingsaiName = jingsaiName;
		}

		/**
		* 获取： 竞赛编号
		*/
		public String getJingsaiUuidNumber() {
			return jingsaiUuidNumber;
		}
		/**
		* 设置： 竞赛编号
		*/
		public void setJingsaiUuidNumber(String jingsaiUuidNumber) {
			this.jingsaiUuidNumber = jingsaiUuidNumber;
		}

		/**
		* 获取： 竞赛照片
		*/
		public String getJingsaiPhoto() {
			return jingsaiPhoto;
		}
		/**
		* 设置： 竞赛照片
		*/
		public void setJingsaiPhoto(String jingsaiPhoto) {
			this.jingsaiPhoto = jingsaiPhoto;
		}
		/**
		* 获取： 竞赛类型
		*/
		public Integer getJingsaiTypes() {
			return jingsaiTypes;
		}
		/**
		* 设置： 竞赛类型
		*/
		public void setJingsaiTypes(Integer jingsaiTypes) {
			this.jingsaiTypes = jingsaiTypes;
		}


			/**
			* 获取： 竞赛类型的值
			*/
			public String getJingsaiValue() {
				return jingsaiValue;
			}
			/**
			* 设置： 竞赛类型的值
			*/
			public void setJingsaiValue(String jingsaiValue) {
				this.jingsaiValue = jingsaiValue;
			}

		/**
		* 获取： 竞赛信息
		*/
		public String getJingsaiContent() {
			return jingsaiContent;
		}
		/**
		* 设置： 竞赛信息
		*/
		public void setJingsaiContent(String jingsaiContent) {
			this.jingsaiContent = jingsaiContent;
		}

		/**
		* 获取： 逻辑删除
		*/
		public Integer getJingsaiDelete() {
			return jingsaiDelete;
		}
		/**
		* 设置： 逻辑删除
		*/
		public void setJingsaiDelete(Integer jingsaiDelete) {
			this.jingsaiDelete = jingsaiDelete;
		}
	//级联表的get和set 竞赛报名

		/**
		* 获取： 报名唯一编号
		*/
		public String getJingsaiYuyueUuidNumber() {
			return jingsaiYuyueUuidNumber;
		}
		/**
		* 设置： 报名唯一编号
		*/
		public void setJingsaiYuyueUuidNumber(String jingsaiYuyueUuidNumber) {
			this.jingsaiYuyueUuidNumber = jingsaiYuyueUuidNumber;
		}
		/**
		* 获取：竞赛报名 的 用户
		*/
		public Integer getJingsaiYuyueYonghuId() {
			return jingsaiYuyueYonghuId;
		}
		/**
		* 设置：竞赛报名 的 用户
		*/
		public void setJingsaiYuyueYonghuId(Integer jingsaiYuyueYonghuId) {
			this.jingsaiYuyueYonghuId = jingsaiYuyueYonghuId;
		}

		/**
		* 获取： 报名理由
		*/
		public String getJingsaiYuyueText() {
			return jingsaiYuyueText;
		}
		/**
		* 设置： 报名理由
		*/
		public void setJingsaiYuyueText(String jingsaiYuyueText) {
			this.jingsaiYuyueText = jingsaiYuyueText;
		}
		/**
		* 获取： 报名状态
		*/
		public Integer getJingsaiYuyueYesnoTypes() {
			return jingsaiYuyueYesnoTypes;
		}
		/**
		* 设置： 报名状态
		*/
		public void setJingsaiYuyueYesnoTypes(Integer jingsaiYuyueYesnoTypes) {
			this.jingsaiYuyueYesnoTypes = jingsaiYuyueYesnoTypes;
		}


			/**
			* 获取： 报名状态的值
			*/
			public String getJingsaiYuyueYesnoValue() {
				return jingsaiYuyueYesnoValue;
			}
			/**
			* 设置： 报名状态的值
			*/
			public void setJingsaiYuyueYesnoValue(String jingsaiYuyueYesnoValue) {
				this.jingsaiYuyueYesnoValue = jingsaiYuyueYesnoValue;
			}

		/**
		* 获取： 审核回复
		*/
		public String getJingsaiYuyueYesnoText() {
			return jingsaiYuyueYesnoText;
		}
		/**
		* 设置： 审核回复
		*/
		public void setJingsaiYuyueYesnoText(String jingsaiYuyueYesnoText) {
			this.jingsaiYuyueYesnoText = jingsaiYuyueYesnoText;
		}

		/**
		* 获取： 审核时间
		*/
		public Date getJingsaiYuyueShenheTime() {
			return jingsaiYuyueShenheTime;
		}
		/**
		* 设置： 审核时间
		*/
		public void setJingsaiYuyueShenheTime(Date jingsaiYuyueShenheTime) {
			this.jingsaiYuyueShenheTime = jingsaiYuyueShenheTime;
		}
	//级联表的get和set 老师

		/**
		* 获取： 老师姓名
		*/
		public String getLaoshiName() {
			return laoshiName;
		}
		/**
		* 设置： 老师姓名
		*/
		public void setLaoshiName(String laoshiName) {
			this.laoshiName = laoshiName;
		}

		/**
		* 获取： 老师手机号
		*/
		public String getLaoshiPhone() {
			return laoshiPhone;
		}
		/**
		* 设置： 老师手机号
		*/
		public void setLaoshiPhone(String laoshiPhone) {
			this.laoshiPhone = laoshiPhone;
		}

		/**
		* 获取： 老师身份证号
		*/
		public String getLaoshiIdNumber() {
			return laoshiIdNumber;
		}
		/**
		* 设置： 老师身份证号
		*/
		public void setLaoshiIdNumber(String laoshiIdNumber) {
			this.laoshiIdNumber = laoshiIdNumber;
		}

		/**
		* 获取： 老师头像
		*/
		public String getLaoshiPhoto() {
			return laoshiPhoto;
		}
		/**
		* 设置： 老师头像
		*/
		public void setLaoshiPhoto(String laoshiPhoto) {
			this.laoshiPhoto = laoshiPhoto;
		}

		/**
		* 获取： 老师邮箱
		*/
		public String getLaoshiEmail() {
			return laoshiEmail;
		}
		/**
		* 设置： 老师邮箱
		*/
		public void setLaoshiEmail(String laoshiEmail) {
			this.laoshiEmail = laoshiEmail;
		}
	//级联表的get和set 用户

		/**
		* 获取： 用户姓名
		*/
		public String getYonghuName() {
			return yonghuName;
		}
		/**
		* 设置： 用户姓名
		*/
		public void setYonghuName(String yonghuName) {
			this.yonghuName = yonghuName;
		}

		/**
		* 获取： 用户手机号
		*/
		public String getYonghuPhone() {
			return yonghuPhone;
		}
		/**
		* 设置： 用户手机号
		*/
		public void setYonghuPhone(String yonghuPhone) {
			this.yonghuPhone = yonghuPhone;
		}

		/**
		* 获取： 用户身份证号
		*/
		public String getYonghuIdNumber() {
			return yonghuIdNumber;
		}
		/**
		* 设置： 用户身份证号
		*/
		public void setYonghuIdNumber(String yonghuIdNumber) {
			this.yonghuIdNumber = yonghuIdNumber;
		}

		/**
		* 获取： 用户头像
		*/
		public String getYonghuPhoto() {
			return yonghuPhoto;
		}
		/**
		* 设置： 用户头像
		*/
		public void setYonghuPhoto(String yonghuPhoto) {
			this.yonghuPhoto = yonghuPhoto;
		}

		/**
		* 获取： 用户邮箱
		*/
		public String getYonghuEmail() {
			return yonghuEmail;
		}
		/**
		* 设置： 用户邮箱
		*/
		public void setYonghuEmail(String yonghuEmail) {
			this.yonghuEmail = yonghuEmail;
		}

	//重复字段
			/**
			* 获取： 重复字段 的types
			*/
			public Integer getSexTypes() {
			return sexTypes;
			}
			/**
			* 设置： 重复字段 的types
			*/
			public void setSexTypes(Integer sexTypes) {
			this.sexTypes = sexTypes;
			}
				public String getSexValue() {
				return sexValue;
				}
				public void setSexValue(String sexValue) {
				this.sexValue = sexValue;
				}

	@Override
	public String toString() {
		return "JingsaiTijiaoView{" +
			", jingsaiTijiaoYesnoValue=" + jingsaiTijiaoYesnoValue +
			", jingsaiName=" + jingsaiName +
			", jingsaiUuidNumber=" + jingsaiUuidNumber +
			", jingsaiPhoto=" + jingsaiPhoto +
			", jingsaiContent=" + jingsaiContent +
			", jingsaiDelete=" + jingsaiDelete +
			", yonghuName=" + yonghuName +
			", yonghuPhone=" + yonghuPhone +
			", yonghuIdNumber=" + yonghuIdNumber +
			", yonghuPhoto=" + yonghuPhoto +
			", yonghuEmail=" + yonghuEmail +
			", jingsaiYuyueUuidNumber=" + jingsaiYuyueUuidNumber +
			", jingsaiYuyueText=" + jingsaiYuyueText +
			", jingsaiYuyueYesnoText=" + jingsaiYuyueYesnoText +
			", jingsaiYuyueShenheTime=" + DateUtil.convertString(jingsaiYuyueShenheTime,"yyyy-MM-dd") +
			", laoshiName=" + laoshiName +
			", laoshiPhone=" + laoshiPhone +
			", laoshiIdNumber=" + laoshiIdNumber +
			", laoshiPhoto=" + laoshiPhoto +
			", laoshiEmail=" + laoshiEmail +
			"} " + super.toString();
	}
}
