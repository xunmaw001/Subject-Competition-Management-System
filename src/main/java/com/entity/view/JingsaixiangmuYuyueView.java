package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JingsaixiangmuYuyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 竞赛项目审核
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jingsaixiangmu_yuyue")
public class JingsaixiangmuYuyueView extends JingsaixiangmuYuyueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 竞赛项目类型的值
	*/
	@ColumnInfo(comment="竞赛项目类型的字典表值",type="varchar(200)")
	private String jingsaixiangmuValue;
	/**
	* 报名状态的值
	*/
	@ColumnInfo(comment="报名状态的字典表值",type="varchar(200)")
	private String jingsaixiangmuYuyueYesnoValue;

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



	public JingsaixiangmuYuyueView() {

	}

	public JingsaixiangmuYuyueView(JingsaixiangmuYuyueEntity jingsaixiangmuYuyueEntity) {
		try {
			BeanUtils.copyProperties(this, jingsaixiangmuYuyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
	/**
	* 获取： 竞赛项目类型的值
	*/
	public String getJingsaixiangmuValue() {
		return jingsaixiangmuValue;
	}
	/**
	* 设置： 竞赛项目类型的值
	*/
	public void setJingsaixiangmuValue(String jingsaixiangmuValue) {
		this.jingsaixiangmuValue = jingsaixiangmuValue;
	}
	//当前表的
	/**
	* 获取： 报名状态的值
	*/
	public String getJingsaixiangmuYuyueYesnoValue() {
		return jingsaixiangmuYuyueYesnoValue;
	}
	/**
	* 设置： 报名状态的值
	*/
	public void setJingsaixiangmuYuyueYesnoValue(String jingsaixiangmuYuyueYesnoValue) {
		this.jingsaixiangmuYuyueYesnoValue = jingsaixiangmuYuyueYesnoValue;
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


	@Override
	public String toString() {
		return "JingsaixiangmuYuyueView{" +
			", jingsaixiangmuValue=" + jingsaixiangmuValue +
			", jingsaixiangmuYuyueYesnoValue=" + jingsaixiangmuYuyueYesnoValue +
			", laoshiName=" + laoshiName +
			", laoshiPhone=" + laoshiPhone +
			", laoshiIdNumber=" + laoshiIdNumber +
			", laoshiPhoto=" + laoshiPhoto +
			", laoshiEmail=" + laoshiEmail +
			"} " + super.toString();
	}
}
