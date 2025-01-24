
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 竞赛项目信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jingsai")
public class JingsaiController {
    private static final Logger logger = LoggerFactory.getLogger(JingsaiController.class);

    private static final String TABLE_NAME = "jingsai";

    @Autowired
    private JingsaiService jingsaiService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private JingsaiTijiaoService jingsaiTijiaoService;//竞赛项目
    @Autowired
    private JingsaiYuyueService jingsaiYuyueService;//竞赛报名
    @Autowired
    private JingsaixiangmuYuyueService jingsaixiangmuYuyueService;//竞赛项目审核
    @Autowired
    private LaoshiService laoshiService;//老师
    @Autowired
    private YonghuService yonghuService;//用户
    @Autowired
    private UsersService usersService;//管理员


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        else if("老师".equals(role))
            params.put("laoshiId",request.getSession().getAttribute("userId"));
        params.put("jingsaiDeleteStart",1);params.put("jingsaiDeleteEnd",1);
        CommonUtil.checkMap(params);
        PageUtils page = jingsaiService.queryPage(params);

        //字典表数据转换
        List<JingsaiView> list =(List<JingsaiView>)page.getList();
        for(JingsaiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JingsaiEntity jingsai = jingsaiService.selectById(id);
        if(jingsai !=null){
            //entity转view
            JingsaiView view = new JingsaiView();
            BeanUtils.copyProperties( jingsai , view );//把实体数据重构到view中
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JingsaiEntity jingsai, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jingsai:{}",this.getClass().getName(),jingsai.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<JingsaiEntity> queryWrapper = new EntityWrapper<JingsaiEntity>()
            .eq("jingsai_name", jingsai.getJingsaiName())
            .eq("jingsai_types", jingsai.getJingsaiTypes())
            .eq("jingsai_delete", jingsai.getJingsaiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JingsaiEntity jingsaiEntity = jingsaiService.selectOne(queryWrapper);
        if(jingsaiEntity==null){
            jingsai.setJingsaiDelete(1);
            jingsai.setInsertTime(new Date());
            jingsai.setCreateTime(new Date());
            jingsaiService.insert(jingsai);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JingsaiEntity jingsai, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jingsai:{}",this.getClass().getName(),jingsai.toString());
        JingsaiEntity oldJingsaiEntity = jingsaiService.selectById(jingsai.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        if("".equals(jingsai.getJingsaiPhoto()) || "null".equals(jingsai.getJingsaiPhoto())){
                jingsai.setJingsaiPhoto(null);
        }

            jingsaiService.updateById(jingsai);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JingsaiEntity> oldJingsaiList =jingsaiService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        ArrayList<JingsaiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            JingsaiEntity jingsaiEntity = new JingsaiEntity();
            jingsaiEntity.setId(id);
            jingsaiEntity.setJingsaiDelete(2);
            list.add(jingsaiEntity);
        }
        if(list != null && list.size() >0){
            jingsaiService.updateBatchById(list);
        }

        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<JingsaiEntity> jingsaiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            JingsaiEntity jingsaiEntity = new JingsaiEntity();
//                            jingsaiEntity.setJingsaiName(data.get(0));                    //竞赛名称 要改的
//                            jingsaiEntity.setJingsaiUuidNumber(data.get(0));                    //竞赛编号 要改的
//                            jingsaiEntity.setJingsaiPhoto("");//详情和图片
//                            jingsaiEntity.setJingsaiTypes(Integer.valueOf(data.get(0)));   //竞赛类型 要改的
//                            jingsaiEntity.setJingsaiContent("");//详情和图片
//                            jingsaiEntity.setJingsaiDelete(1);//逻辑删除字段
//                            jingsaiEntity.setInsertTime(date);//时间
//                            jingsaiEntity.setCreateTime(date);//时间
                            jingsaiList.add(jingsaiEntity);


                            //把要查询是否重复的字段放入map中
                                //竞赛编号
                                if(seachFields.containsKey("jingsaiUuidNumber")){
                                    List<String> jingsaiUuidNumber = seachFields.get("jingsaiUuidNumber");
                                    jingsaiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jingsaiUuidNumber = new ArrayList<>();
                                    jingsaiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jingsaiUuidNumber",jingsaiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //竞赛编号
                        List<JingsaiEntity> jingsaiEntities_jingsaiUuidNumber = jingsaiService.selectList(new EntityWrapper<JingsaiEntity>().in("jingsai_uuid_number", seachFields.get("jingsaiUuidNumber")).eq("jingsai_delete", 1));
                        if(jingsaiEntities_jingsaiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JingsaiEntity s:jingsaiEntities_jingsaiUuidNumber){
                                repeatFields.add(s.getJingsaiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [竞赛编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jingsaiService.insertBatch(jingsaiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }




    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        CommonUtil.checkMap(params);
        PageUtils page = jingsaiService.queryPage(params);

        //字典表数据转换
        List<JingsaiView> list =(List<JingsaiView>)page.getList();
        for(JingsaiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JingsaiEntity jingsai = jingsaiService.selectById(id);
            if(jingsai !=null){


                //entity转view
                JingsaiView view = new JingsaiView();
                BeanUtils.copyProperties( jingsai , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody JingsaiEntity jingsai, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jingsai:{}",this.getClass().getName(),jingsai.toString());
        Wrapper<JingsaiEntity> queryWrapper = new EntityWrapper<JingsaiEntity>()
            .eq("jingsai_name", jingsai.getJingsaiName())
            .eq("jingsai_uuid_number", jingsai.getJingsaiUuidNumber())
            .eq("jingsai_types", jingsai.getJingsaiTypes())
            .eq("jingsai_delete", jingsai.getJingsaiDelete())
//            .notIn("jingsai_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JingsaiEntity jingsaiEntity = jingsaiService.selectOne(queryWrapper);
        if(jingsaiEntity==null){
            jingsai.setJingsaiDelete(1);
            jingsai.setInsertTime(new Date());
            jingsai.setCreateTime(new Date());
        jingsaiService.insert(jingsai);

            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

}

