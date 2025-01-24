import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
    // 解决多次点击左侧菜单报错问题
    const VueRouterPush = VueRouter.prototype.push
    VueRouter.prototype.push = function push (to) {
    return VueRouterPush.call(this, to).catch(err => err)
    }
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
import beifen from '@/views/modules/databaseBackup/beifen'
import huanyuan from '@/views/modules/databaseBackup/huanyuan'

     import users from '@/views/modules/users/list'
    import dictionary from '@/views/modules/dictionary/list'
    import forum from '@/views/modules/forum/list'
    import gonggao from '@/views/modules/gonggao/list'
    import jingsai from '@/views/modules/jingsai/list'
    import jingsaiTijiao from '@/views/modules/jingsaiTijiao/list'
    import jingsaiYuyue from '@/views/modules/jingsaiYuyue/list'
    import jingsaixiangmuYuyue from '@/views/modules/jingsaixiangmuYuyue/list'
    import laoshi from '@/views/modules/laoshi/list'
    import yonghu from '@/views/modules/yonghu/list'
    import config from '@/views/modules/config/list'
    import dictionaryForumState from '@/views/modules/dictionaryForumState/list'
    import dictionaryGonggao from '@/views/modules/dictionaryGonggao/list'
    import dictionaryJingsai from '@/views/modules/dictionaryJingsai/list'
    import dictionaryJingsaiTijiaoYesno from '@/views/modules/dictionaryJingsaiTijiaoYesno/list'
    import dictionaryJingsaiYuyueYesno from '@/views/modules/dictionaryJingsaiYuyueYesno/list'
    import dictionaryJingsaixiangmu from '@/views/modules/dictionaryJingsaixiangmu/list'
    import dictionaryJingsaixiangmuYuyueYesno from '@/views/modules/dictionaryJingsaixiangmuYuyueYesno/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    }, {
        path: '/huanyuan',
        name: '数据还原',
        component: huanyuan
    }, {
        path: '/beifen',
        name: '数据备份',
        component: beifen
    }, {
        path: '/users',
        name: '管理信息',
        component: users
    }
    ,{
        path: '/dictionaryForumState',
        name: '帖子状态',
        component: dictionaryForumState
    }
    ,{
        path: '/dictionaryGonggao',
        name: '公告类型',
        component: dictionaryGonggao
    }
    ,{
        path: '/dictionaryJingsai',
        name: '竞赛类型',
        component: dictionaryJingsai
    }
    ,{
        path: '/dictionaryJingsaiTijiaoYesno',
        name: '提交状态',
        component: dictionaryJingsaiTijiaoYesno
    }
    ,{
        path: '/dictionaryJingsaiYuyueYesno',
        name: '报名状态',
        component: dictionaryJingsaiYuyueYesno
    }
    ,{
        path: '/dictionaryJingsaixiangmu',
        name: '竞赛项目类型',
        component: dictionaryJingsaixiangmu
    }
    ,{
        path: '/dictionaryJingsaixiangmuYuyueYesno',
        name: '报名状态',
        component: dictionaryJingsaixiangmuYuyueYesno
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型',
        component: dictionarySex
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/dictionary',
        name: '字典',
        component: dictionary
      }
    ,{
        path: '/forum',
        name: '论坛',
        component: forum
      }
    ,{
        path: '/gonggao',
        name: '公告',
        component: gonggao
      }
    ,{
        path: '/jingsai',
        name: '竞赛项目信息',
        component: jingsai
      }
    ,{
        path: '/jingsaiTijiao',
        name: '竞赛项目',
        component: jingsaiTijiao
      }
    ,{
        path: '/jingsaiYuyue',
        name: '竞赛报名',
        component: jingsaiYuyue
      }
    ,{
        path: '/jingsaixiangmuYuyue',
        name: '竞赛项目审核',
        component: jingsaixiangmuYuyue
      }
    ,{
        path: '/laoshi',
        name: '老师',
        component: laoshi
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
