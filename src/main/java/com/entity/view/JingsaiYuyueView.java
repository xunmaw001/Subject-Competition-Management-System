package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JingsaiYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 竞赛报名
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jingsai_yuyue")
public class JingsaiYuyueView extends JingsaiYuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 报名状态的值
	*/
	@ColumnInfo(comment="报名状态的字典表值",type="varchar(200)")
	private String jingsaiYuyueYesnoValue;

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



	public JingsaiYuyueView() {

	}

	public JingsaiYuyueView(JingsaiYuyueEntity jingsaiYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, jingsaiYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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


	@Override
	public String toString() {
		return "JingsaiYuyueView{" +
			", jingsaiYuyueYesnoValue=" + jingsaiYuyueYesnoValue +
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
			"} " + super.toString();
	}
}
