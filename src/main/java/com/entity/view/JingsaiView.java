package com.entity.view;

import org.apache.tools.ant.util.DateUtils;
import com.annotation.ColumnInfo;
import com.entity.JingsaiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;
import com.utils.DateUtil;

/**
* 竞赛项目信息
* 后端返回视图实体辅助类
* （通常后端关联的表或者自定义的字段需要返回使用）
*/
@TableName("jingsai")
public class JingsaiView extends JingsaiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	//当前表
	/**
	* 竞赛类型的值
	*/
	@ColumnInfo(comment="竞赛类型的字典表值",type="varchar(200)")
	private String jingsaiValue;




	public JingsaiView() {

	}

	public JingsaiView(JingsaiEntity jingsaiEntity) {
		try {
			BeanUtils.copyProperties(this, jingsaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



	//当前表的
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




	@Override
	public String toString() {
		return "JingsaiView{" +
			", jingsaiValue=" + jingsaiValue +
			"} " + super.toString();
	}
}
