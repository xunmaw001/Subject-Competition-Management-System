
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
 * 竞赛项目
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/jingsaiTijiao")
public class JingsaiTijiaoController {
    private static final Logger logger = LoggerFactory.getLogger(JingsaiTijiaoController.class);

    private static final String TABLE_NAME = "jingsaiTijiao";

    @Autowired
    private JingsaiTijiaoService jingsaiTijiaoService;


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
        CommonUtil.checkMap(params);
        PageUtils page = jingsaiTijiaoService.queryPage(params);

        //字典表数据转换
        List<JingsaiTijiaoView> list =(List<JingsaiTijiaoView>)page.getList();
        for(JingsaiTijiaoView c:list){
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
        JingsaiTijiaoEntity jingsaiTijiao = jingsaiTijiaoService.selectById(id);
        if(jingsaiTijiao !=null){
            //entity转view
            JingsaiTijiaoView view = new JingsaiTijiaoView();
            BeanUtils.copyProperties( jingsaiTijiao , view );//把实体数据重构到view中
            //级联表 竞赛项目信息
            //级联表
            JingsaiEntity jingsai = jingsaiService.selectById(jingsaiTijiao.getJingsaiId());
            if(jingsai != null){
            BeanUtils.copyProperties( jingsai , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "laoshiId"
, "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJingsaiId(jingsai.getId());
            }
            //级联表 用户
            //级联表
            YonghuEntity yonghu = yonghuService.selectById(jingsaiTijiao.getYonghuId());
            if(yonghu != null){
            BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "laoshiId"
, "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setYonghuId(yonghu.getId());
            }
            //级联表 竞赛报名
            //级联表
            JingsaiYuyueEntity jingsaiYuyue = jingsaiYuyueService.selectById(jingsaiTijiao.getJingsaiYuyueId());
            if(jingsaiYuyue != null){
            BeanUtils.copyProperties( jingsaiYuyue , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "laoshiId"
, "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
            view.setJingsaiYuyueId(jingsaiYuyue.getId());
            }
            //级联表 老师
            //级联表
            LaoshiEntity laoshi = laoshiService.selectById(jingsaiTijiao.getLaoshiId());
            if(laoshi != null){
            BeanUtils.copyProperties( laoshi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "laoshiId"
, "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段,当前表的级联注册表
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
    public R save(@RequestBody JingsaiTijiaoEntity jingsaiTijiao, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,jingsaiTijiao:{}",this.getClass().getName(),jingsaiTijiao.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("老师".equals(role))
            jingsaiTijiao.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        else if("用户".equals(role))
            jingsaiTijiao.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JingsaiTijiaoEntity> queryWrapper = new EntityWrapper<JingsaiTijiaoEntity>()
            .eq("jingsai_id", jingsaiTijiao.getJingsaiId())
            .eq("laoshi_id", jingsaiTijiao.getLaoshiId())
            .eq("jingsai_yuyue_id", jingsaiTijiao.getJingsaiYuyueId())
            .eq("yonghu_id", jingsaiTijiao.getYonghuId())
            .in("jingsai_tijiao_yesno_types", new Integer[]{1,2})
            .eq("jingsai_tijiao_pigai", jingsaiTijiao.getJingsaiTijiaoPigai())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JingsaiTijiaoEntity jingsaiTijiaoEntity = jingsaiTijiaoService.selectOne(queryWrapper);
        if(jingsaiTijiaoEntity==null){
            jingsaiTijiao.setJingsaiTijiaoYesnoTypes(1);
            jingsaiTijiao.setInsertTime(new Date());
            jingsaiTijiao.setCreateTime(new Date());
            jingsaiTijiaoService.insert(jingsaiTijiao);
            return R.ok();
        }else {
            if(jingsaiTijiaoEntity.getJingsaiTijiaoYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(jingsaiTijiaoEntity.getJingsaiTijiaoYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JingsaiTijiaoEntity jingsaiTijiao, HttpServletRequest request) throws NoSuchFieldException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        logger.debug("update方法:,,Controller:{},,jingsaiTijiao:{}",this.getClass().getName(),jingsaiTijiao.toString());
        JingsaiTijiaoEntity oldJingsaiTijiaoEntity = jingsaiTijiaoService.selectById(jingsaiTijiao.getId());//查询原先数据

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("老师".equals(role))
//            jingsaiTijiao.setLaoshiId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
//        else if("用户".equals(role))
//            jingsaiTijiao.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        if("".equals(jingsaiTijiao.getJingsaiShangchuanFile()) || "null".equals(jingsaiTijiao.getJingsaiShangchuanFile())){
                jingsaiTijiao.setJingsaiShangchuanFile(null);
        }

            jingsaiTijiaoService.updateById(jingsaiTijiao);//根据id更新
            return R.ok();
    }


    /**
    * 审核
    */
    @RequestMapping("/shenhe")
    public R shenhe(@RequestBody JingsaiTijiaoEntity jingsaiTijiaoEntity, HttpServletRequest request){
        logger.debug("shenhe方法:,,Controller:{},,jingsaiTijiaoEntity:{}",this.getClass().getName(),jingsaiTijiaoEntity.toString());

        JingsaiTijiaoEntity oldJingsaiTijiao = jingsaiTijiaoService.selectById(jingsaiTijiaoEntity.getId());//查询原先数据

//        if(jingsaiTijiaoEntity.getJingsaiTijiaoYesnoTypes() == 2){//通过
//            jingsaiTijiaoEntity.setJingsaiTijiaoTypes();
//        }else if(jingsaiTijiaoEntity.getJingsaiTijiaoYesnoTypes() == 3){//拒绝
//            jingsaiTijiaoEntity.setJingsaiTijiaoTypes();
//        }
        jingsaiTijiaoService.updateById(jingsaiTijiaoEntity);//审核

        return R.ok();
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids, HttpServletRequest request){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        List<JingsaiTijiaoEntity> oldJingsaiTijiaoList =jingsaiTijiaoService.selectBatchIds(Arrays.asList(ids));//要删除的数据
        jingsaiTijiaoService.deleteBatchIds(Arrays.asList(ids));

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
            List<JingsaiTijiaoEntity> jingsaiTijiaoList = new ArrayList<>();//上传的东西
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
                            JingsaiTijiaoEntity jingsaiTijiaoEntity = new JingsaiTijiaoEntity();
//                            jingsaiTijiaoEntity.setJingsaiTijiaoUuidNumber(data.get(0));                    //报名唯一编号 要改的
//                            jingsaiTijiaoEntity.setJingsaiId(Integer.valueOf(data.get(0)));   //jingsai 要改的
//                            jingsaiTijiaoEntity.setLaoshiId(Integer.valueOf(data.get(0)));   //老师 要改的
//                            jingsaiTijiaoEntity.setJingsaiYuyueId(Integer.valueOf(data.get(0)));   //竞赛报名 要改的
//                            jingsaiTijiaoEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            jingsaiTijiaoEntity.setJingsaiTijiaoText(data.get(0));                    //内容 要改的
//                            jingsaiTijiaoEntity.setJingsaiShangchuanFile(data.get(0));                    //竞赛项目上传 要改的
//                            jingsaiTijiaoEntity.setJingsaiTijiaoYesnoTypes(Integer.valueOf(data.get(0)));   //提交状态 要改的
//                            jingsaiTijiaoEntity.setJingsaiTijiaoPigai(Integer.valueOf(data.get(0)));   //竞赛项目评分 要改的
//                            jingsaiTijiaoEntity.setInsertTime(date);//时间
//                            jingsaiTijiaoEntity.setCreateTime(date);//时间
                            jingsaiTijiaoList.add(jingsaiTijiaoEntity);


                            //把要查询是否重复的字段放入map中
                                //报名唯一编号
                                if(seachFields.containsKey("jingsaiTijiaoUuidNumber")){
                                    List<String> jingsaiTijiaoUuidNumber = seachFields.get("jingsaiTijiaoUuidNumber");
                                    jingsaiTijiaoUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> jingsaiTijiaoUuidNumber = new ArrayList<>();
                                    jingsaiTijiaoUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("jingsaiTijiaoUuidNumber",jingsaiTijiaoUuidNumber);
                                }
                        }

                        //查询是否重复
                         //报名唯一编号
                        List<JingsaiTijiaoEntity> jingsaiTijiaoEntities_jingsaiTijiaoUuidNumber = jingsaiTijiaoService.selectList(new EntityWrapper<JingsaiTijiaoEntity>().in("jingsai_tijiao_uuid_number", seachFields.get("jingsaiTijiaoUuidNumber")));
                        if(jingsaiTijiaoEntities_jingsaiTijiaoUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(JingsaiTijiaoEntity s:jingsaiTijiaoEntities_jingsaiTijiaoUuidNumber){
                                repeatFields.add(s.getJingsaiTijiaoUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [报名唯一编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        jingsaiTijiaoService.insertBatch(jingsaiTijiaoList);
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
        PageUtils page = jingsaiTijiaoService.queryPage(params);

        //字典表数据转换
        List<JingsaiTijiaoView> list =(List<JingsaiTijiaoView>)page.getList();
        for(JingsaiTijiaoView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段

        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JingsaiTijiaoEntity jingsaiTijiao = jingsaiTijiaoService.selectById(id);
            if(jingsaiTijiao !=null){


                //entity转view
                JingsaiTijiaoView view = new JingsaiTijiaoView();
                BeanUtils.copyProperties( jingsaiTijiao , view );//把实体数据重构到view中

                //级联表
                    JingsaiEntity jingsai = jingsaiService.selectById(jingsaiTijiao.getJingsaiId());
                if(jingsai != null){
                    BeanUtils.copyProperties( jingsai , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJingsaiId(jingsai.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(jingsaiTijiao.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
                //级联表
                    JingsaiYuyueEntity jingsaiYuyue = jingsaiYuyueService.selectById(jingsaiTijiao.getJingsaiYuyueId());
                if(jingsaiYuyue != null){
                    BeanUtils.copyProperties( jingsaiYuyue , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setJingsaiYuyueId(jingsaiYuyue.getId());
                }
                //级联表
                    LaoshiEntity laoshi = laoshiService.selectById(jingsaiTijiao.getLaoshiId());
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
    public R add(@RequestBody JingsaiTijiaoEntity jingsaiTijiao, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,jingsaiTijiao:{}",this.getClass().getName(),jingsaiTijiao.toString());
        Wrapper<JingsaiTijiaoEntity> queryWrapper = new EntityWrapper<JingsaiTijiaoEntity>()
            .eq("jingsai_tijiao_uuid_number", jingsaiTijiao.getJingsaiTijiaoUuidNumber())
            .eq("jingsai_id", jingsaiTijiao.getJingsaiId())
            .eq("laoshi_id", jingsaiTijiao.getLaoshiId())
            .eq("jingsai_yuyue_id", jingsaiTijiao.getJingsaiYuyueId())
            .eq("yonghu_id", jingsaiTijiao.getYonghuId())
            .eq("jingsai_tijiao_text", jingsaiTijiao.getJingsaiTijiaoText())
            .in("jingsai_tijiao_yesno_types", new Integer[]{1,2})
            .eq("jingsai_tijiao_pigai", jingsaiTijiao.getJingsaiTijiaoPigai())
//            .notIn("jingsai_tijiao_types", new Integer[]{102})
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JingsaiTijiaoEntity jingsaiTijiaoEntity = jingsaiTijiaoService.selectOne(queryWrapper);
        if(jingsaiTijiaoEntity==null){
            jingsaiTijiao.setJingsaiTijiaoYesnoTypes(1);
            jingsaiTijiao.setInsertTime(new Date());
            jingsaiTijiao.setCreateTime(new Date());
        jingsaiTijiaoService.insert(jingsaiTijiao);

            return R.ok();
        }else {
            if(jingsaiTijiaoEntity.getJingsaiTijiaoYesnoTypes()==1)
                return R.error(511,"有相同的待审核的数据");
            else if(jingsaiTijiaoEntity.getJingsaiTijiaoYesnoTypes()==2)
                return R.error(511,"有相同的审核通过的数据");
            else
                return R.error(511,"表中有相同数据");
        }
    }

}

