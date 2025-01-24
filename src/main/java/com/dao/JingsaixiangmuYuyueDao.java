package com.dao;

import com.entity.JingsaixiangmuYuyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JingsaixiangmuYuyueView;

/**
 * 竞赛项目审核 Dao 接口
 *
 * @author 
 */
public interface JingsaixiangmuYuyueDao extends BaseMapper<JingsaixiangmuYuyueEntity> {

   List<JingsaixiangmuYuyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
