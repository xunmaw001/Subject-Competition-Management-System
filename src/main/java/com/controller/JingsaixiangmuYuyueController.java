
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
 * 竞赛项目审核
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jingsaixiangmuYuyue")
public class JingsaixiangmuYuyueController {
    private static final Logger logger = LoggerFactory.getLogger(JingsaixiangmuYuyueController.class);

    private static final String TABLE_NAME = "jingsaixiangmuYuyue";

    @Autowired
    private JingsaixiangmuYuyueService jingsaixiangmuYuyueService;


    @Autowired
    private TokenService tokenService;

    @Autowired
    private DictionaryService dictionaryService;//字典
    @Autowired
    private ForumService forumService;//论坛
    @Autowired
    private GonggaoService gonggaoService;//公告
    @Autowired
    private JingsaiService jingsaiService;//竞赛项目信息
    @Autowired
    private JingsaiTijiaoService jingsaiTijiaoService;//竞赛项目
    @Autowired
    private JingsaiYuyueService jingsaiYuyueService;//竞赛报名
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
        CommonUtil.checkMap(params);
        PageUtils page = jingsaixiangmuYuyueService.queryPage(params);

        //字典表数据转换
        List<JingsaixiangmuYuyueView> list =(List<JingsaixiangmuYuyueView>)page.getList();
        for(JingsaixiangmuYuyueView c:list){
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
        JingsaixiangmuYuyueEntity jingsaixiangmuYuyue = jingsaixiangmuYuyueService.selectById(id);
        if(jingsaixiangmuYuyue !=null){
            //entity转view
            JingsaixiangmuYuyueView view = new JingsaixiangmuYuyueView();
            BeanUtils.copyProperties( jingsaixiangmuYuyue , view );//把实体数据重构到view中
            //级联表 老师
            //级联表
            LaoshiEntity laoshi = laoshiService.selectById(jingsaixiangmuYuyue.getLaoshiId());
            if(laoshi != null){
            BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "laoshiId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setLaoshiId(laoshi.getId());
            }
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
    public R save(@RequestBody JingsaixiangmuYuyueEntity jingsaixiangmuYuyue, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jingsaixiangmuYuyue:{}",this.getClass().getName(),jingsaixiangmuYuyue.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("老师".equals(role))
            jingsaixiangmuYuyue.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JingsaixiangmuYuyueEntity> queryWrapper = new EntityWrapper<JingsaixiangmuYuyueEntity>()
            .eq("jingsaixiangmu_name", jingsaixiangmuYuyue.getJingsaixiangmuName())
            .eq("laoshi_id", jingsaixiangmuYuyue.getLaoshiId())
            .eq("jingsaixiangmu_types", jingsaixiangmuYuyue.getJingsaixiangmuTypes())
            .in("jingsaixiangmu_yuyue_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JingsaixiangmuYuyueEntity jingsaixiangmuYuyueEntity = jingsaixiangmuYuyueService.selectOne(queryWrapper);
        if(jingsaixiangmuYuyueEntity==null){
            jingsaixiangmuYuyue.setJingsaixiangmuYuyueYesnoTypes(1);
            jingsaixiangmuYuyue.setInsertTime(new Date());
            jingsaixiangmuYuyue.setCreateTime(new Date());
            jingsaixiangmuYuyueService.insert(jingsaixiangmuYuyue);
            return R.ok();
        }else {
            if(jingsaixiangmuYuyueEntity.getJingsaixiangmuYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(jingsaixiangmuYuyueEntity.getJingsaixiangmuYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JingsaixiangmuYuyueEntity jingsaixiangmuYuyue, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jingsaixiangmuYuyue:{}",this.getClass().getName(),jingsaixiangmuYuyue.toString());
        JingsaixiangmuYuyueEntity oldJingsaixiangmuYuyueEntity = jingsaixiangmuYuyueService.selectById(jingsaixiangmuYuyue.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("老师".equals(role))
//            jingsaixiangmuYuyue.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

            jingsaixiangmuYuyueService.updateById(jingsaixiangmuYuyue);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody JingsaixiangmuYuyueEntity jingsaixiangmuYuyueEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,jingsaixiangmuYuyueEntity:{}",this.getClass().getName(),jingsaixiangmuYuyueEntity.toString());

        JingsaixiangmuYuyueEntity oldJingsaixiangmuYuyue = jingsaixiangmuYuyueService.selectById(jingsaixiangmuYuyueEntity.getId());//查询原先数据

//        if(jingsaixiangmuYuyueEntity.getJingsaixiangmuYuyueYesnoTypes() == 2){//通过
//            jingsaixiangmuYuyueEntity.setJingsaixiangmuYuyueTypes();
//        }else if(jingsaixiangmuYuyueEntity.getJingsaixiangmuYuyueYesnoTypes() == 3){//拒绝
//            jingsaixiangmuYuyueEntity.setJingsaixiangmuYuyueTypes();
//        }
        jingsaixiangmuYuyueEntity.setJingsaixiangmuYuyueShenheTime(new Date());//审核时间
        jingsaixiangmuYuyueService.updateById(jingsaixiangmuYuyueEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JingsaixiangmuYuyueEntity> oldJingsaixiangmuYuyueList =jingsaixiangmuYuyueService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jingsaixiangmuYuyueService.deleteBatchIds(Arrays.asList(ids));

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
            List<JingsaixiangmuYuyueEntity> jingsaixiangmuYuyueList = new ArrayList<>();//上传的东西
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
                            JingsaixiangmuYuyueEntity jingsaixiangmuYuyueEntity = new JingsaixiangmuYuyueEntity();
//                            jingsaixiangmuYuyueEntity.setJingsaixiangmuYuyueUuidNumber(data.get(0));                    //报名唯一编号 要改的
//                            jingsaixiangmuYuyueEntity.setJingsaixiangmuName(data.get(0));                    //竞赛项目名称 要改的
//                            jingsaixiangmuYuyueEntity.setLaoshiId(Integer.valueOf(data.get(0)));   //老师 要改的
//                            jingsaixiangmuYuyueEntity.setJingsaixiangmuTypes(Integer.valueOf(data.get(0)));   //竞赛项目类型 要改的
//                            jingsaixiangmuYuyueEntity.setJingsaixiangmuContent("");//详情和图片
//                            jingsaixiangmuYuyueEntity.setJingsaixiangmuYuyueText(data.get(0));                    //报名理由 要改的
//                            jingsaixiangmuYuyueEntity.setJingsaixiangmuYuyueYesnoTypes(Integer.valueOf(data.get(0)));   //报名状态 要改的
//                            jingsaixiangmuYuyueEntity.setJingsaixiangmuYuyueYesnoText(data.get(0));                    //审核回复 要改的
//                            jingsaixiangmuYuyueEntity.setJingsaixiangmuYuyueShenheTime(sdf.parse(data.get(0)));          //审核时间 要改的
//                            jingsaixiangmuYuyueEntity.setInsertTime(date);//时间
//                            jingsaixiangmuYuyueEntity.setCreateTime(date);//时间
                            jingsaixiangmuYuyueList.add(jingsaixiangmuYuyueEntity);


                            //把要查询是否重复的字段放入map中
                                //报名唯一编号
                                if(seachFields.containsKey("jingsaixiangmuYuyueUuidNumber")){
                                    List<String> jingsaixiangmuYuyueUuidNumber = seachFields.get("jingsaixiangmuYuyueUuidNumber");
                                    jingsaixiangmuYuyueUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jingsaixiangmuYuyueUuidNumber = new ArrayList<>();
                                    jingsaixiangmuYuyueUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jingsaixiangmuYuyueUuidNumber",jingsaixiangmuYuyueUuidNumber);
                                }
                        }

                        //查询是否重复
                         //报名唯一编号
                        List<JingsaixiangmuYuyueEntity> jingsaixiangmuYuyueEntities_jingsaixiangmuYuyueUuidNumber = jingsaixiangmuYuyueService.selectList(new EntityWrapper<JingsaixiangmuYuyueEntity>().in("jingsaixiangmu_yuyue_uuid_number", seachFields.get("jingsaixiangmuYuyueUuidNumber")));
                        if(jingsaixiangmuYuyueEntities_jingsaixiangmuYuyueUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JingsaixiangmuYuyueEntity s:jingsaixiangmuYuyueEntities_jingsaixiangmuYuyueUuidNumber){
                                repeatFields.add(s.getJingsaixiangmuYuyueUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [报名唯一编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jingsaixiangmuYuyueService.insertBatch(jingsaixiangmuYuyueList);
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
        PageUtils page = jingsaixiangmuYuyueService.queryPage(params);

        //字典表数据转换
        List<JingsaixiangmuYuyueView> list =(List<JingsaixiangmuYuyueView>)page.getList();
        for(JingsaixiangmuYuyueView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JingsaixiangmuYuyueEntity jingsaixiangmuYuyue = jingsaixiangmuYuyueService.selectById(id);
            if(jingsaixiangmuYuyue !=null){


                //entity转view
                JingsaixiangmuYuyueView view = new JingsaixiangmuYuyueView();
                BeanUtils.copyProperties( jingsaixiangmuYuyue , view );//把实体数据重构到view中

                //级联表
                    LaoshiEntity laoshi = laoshiService.selectById(jingsaixiangmuYuyue.getLaoshiId());
                if(laoshi != null){
                    BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setLaoshiId(laoshi.getId());
                }
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
    public R add(@RequestBody JingsaixiangmuYuyueEntity jingsaixiangmuYuyue, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jingsaixiangmuYuyue:{}",this.getClass().getName(),jingsaixiangmuYuyue.toString());
        Wrapper<JingsaixiangmuYuyueEntity> queryWrapper = new EntityWrapper<JingsaixiangmuYuyueEntity>()
            .eq("jingsaixiangmu_yuyue_uuid_number", jingsaixiangmuYuyue.getJingsaixiangmuYuyueUuidNumber())
            .eq("jingsaixiangmu_name", jingsaixiangmuYuyue.getJingsaixiangmuName())
            .eq("laoshi_id", jingsaixiangmuYuyue.getLaoshiId())
            .eq("jingsaixiangmu_types", jingsaixiangmuYuyue.getJingsaixiangmuTypes())
            .eq("jingsaixiangmu_yuyue_text", jingsaixiangmuYuyue.getJingsaixiangmuYuyueText())
            .in("jingsaixiangmu_yuyue_yesno_types", new Integer[]{1,2})
            .eq("jingsaixiangmu_yuyue_yesno_text", jingsaixiangmuYuyue.getJingsaixiangmuYuyueYesnoText())
//            .notIn("jingsaixiangmu_yuyue_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JingsaixiangmuYuyueEntity jingsaixiangmuYuyueEntity = jingsaixiangmuYuyueService.selectOne(queryWrapper);
        if(jingsaixiangmuYuyueEntity==null){
            jingsaixiangmuYuyue.setJingsaixiangmuYuyueYesnoTypes(1);
            jingsaixiangmuYuyue.setInsertTime(new Date());
            jingsaixiangmuYuyue.setCreateTime(new Date());
        jingsaixiangmuYuyueService.insert(jingsaixiangmuYuyue);

            return R.ok();
        }else {
            if(jingsaixiangmuYuyueEntity.getJingsaixiangmuYuyueYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(jingsaixiangmuYuyueEntity.getJingsaixiangmuYuyueYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

