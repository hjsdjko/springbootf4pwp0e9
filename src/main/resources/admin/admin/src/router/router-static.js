import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import tushujiaohuan from '@/views/modules/tushujiaohuan/list'
    import discusstushujuanzeng from '@/views/modules/discusstushujuanzeng/list'
    import news from '@/views/modules/news/list'
    import aboutus from '@/views/modules/aboutus/list'
    import tushuleixing from '@/views/modules/tushuleixing/list'
    import dingdanfabu from '@/views/modules/dingdanfabu/list'
    import discussshenqingjiaohuan from '@/views/modules/discussshenqingjiaohuan/list'
    import storeup from '@/views/modules/storeup/list'
    import discusstushuxinxi from '@/views/modules/discusstushuxinxi/list'
    import tushujuanzeng from '@/views/modules/tushujuanzeng/list'
    import forum from '@/views/modules/forum/list'
    import systemintro from '@/views/modules/systemintro/list'
    import renwufenlei from '@/views/modules/renwufenlei/list'
    import shenqingjiaohuan from '@/views/modules/shenqingjiaohuan/list'
    import yonghu from '@/views/modules/yonghu/list'
    import discussdingdanfabu from '@/views/modules/discussdingdanfabu/list'
    import paotuipeisong from '@/views/modules/paotuipeisong/list'
    import config from '@/views/modules/config/list'
    import dingdanjiaoyi from '@/views/modules/dingdanjiaoyi/list'
    import paotuiyuan from '@/views/modules/paotuiyuan/list'
    import tushuxinxi from '@/views/modules/tushuxinxi/list'
    import paotuijiedan from '@/views/modules/paotuijiedan/list'
    import newstype from '@/views/modules/newstype/list'


//2.配置路由   注意：名字
export const routes = [{
    path: '/',
    name: '系统首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '系统首页',
      component: Home,
      meta: {icon:'', title:'center', affix: true}
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
    }
      ,{
	path: '/tushujiaohuan',
        name: '图书交换',
        component: tushujiaohuan
      }
      ,{
	path: '/discusstushujuanzeng',
        name: '图书捐赠评论',
        component: discusstushujuanzeng
      }
      ,{
	path: '/news',
        name: '公告资讯',
        component: news
      }
      ,{
	path: '/aboutus',
        name: '关于我们',
        component: aboutus
      }
      ,{
	path: '/tushuleixing',
        name: '图书类型',
        component: tushuleixing
      }
      ,{
	path: '/dingdanfabu',
        name: '订单发布',
        component: dingdanfabu
      }
      ,{
	path: '/discussshenqingjiaohuan',
        name: '申请交换评论',
        component: discussshenqingjiaohuan
      }
      ,{
	path: '/storeup',
        name: '我的收藏',
        component: storeup
      }
      ,{
	path: '/discusstushuxinxi',
        name: '图书信息评论',
        component: discusstushuxinxi
      }
      ,{
	path: '/tushujuanzeng',
        name: '图书捐赠',
        component: tushujuanzeng
      }
      ,{
	path: '/forum',
        name: '网上社区',
        component: forum
      }
      ,{
	path: '/systemintro',
        name: '系统简介',
        component: systemintro
      }
      ,{
	path: '/renwufenlei',
        name: '任务分类',
        component: renwufenlei
      }
      ,{
	path: '/shenqingjiaohuan',
        name: '申请交换',
        component: shenqingjiaohuan
      }
      ,{
	path: '/yonghu',
        name: '用户',
        component: yonghu
      }
      ,{
	path: '/discussdingdanfabu',
        name: '订单发布评论',
        component: discussdingdanfabu
      }
      ,{
	path: '/paotuipeisong',
        name: '跑腿配送',
        component: paotuipeisong
      }
      ,{
	path: '/config',
        name: '轮播图管理',
        component: config
      }
      ,{
	path: '/dingdanjiaoyi',
        name: '订单交易',
        component: dingdanjiaoyi
      }
      ,{
	path: '/paotuiyuan',
        name: '跑腿员',
        component: paotuiyuan
      }
      ,{
	path: '/tushuxinxi',
        name: '图书信息',
        component: tushuxinxi
      }
      ,{
	path: '/paotuijiedan',
        name: '跑腿接单',
        component: paotuijiedan
      }
      ,{
	path: '/newstype',
        name: '公告资讯分类',
        component: newstype
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
const originalPush = VueRouter.prototype.push
//修改原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
