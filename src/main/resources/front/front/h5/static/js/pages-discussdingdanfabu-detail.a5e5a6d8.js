(window["webpackJsonp"]=window["webpackJsonp"]||[]).push([["pages-discussdingdanfabu-detail"],{"0b6f":function(t,e,i){"use strict";var n=i("8995"),a=i.n(n);a.a},"35fe":function(t,e,i){"use strict";i.r(e);var n=i("923e"),a=i.n(n);for(var r in n)"default"!==r&&function(t){i.d(e,t,(function(){return n[t]}))}(r);e["default"]=a.a},8995:function(t,e,i){var n=i("b8c7");"string"===typeof n&&(n=[[t.i,n,""]]),n.locals&&(t.exports=n.locals);var a=i("4f06").default;a("0272ae55",n,!0,{sourceMap:!1,shadowMode:!1})},"923e":function(t,e,i){"use strict";var n=i("4ea4");Object.defineProperty(e,"__esModule",{value:!0}),e.default=void 0,i("a481"),i("c5f6"),i("ac6a"),i("f559"),i("55dd"),i("96cf");var a=n(i("3b8d")),r={data:function(){return{btnColor:["#409eff","#67c23a","#909399","#e6a23c","#f56c6c","#356c6c","#351c6c","#f093a9","#a7c23a","#104eff","#10441f","#a21233","#503319"],id:"",userid:"",detail:{},swiperList:[],commentList:[],mescroll:null,downOption:{auto:!1},upOption:{noMoreSize:3,textNoMore:"~ 没有更多了 ~"},hasNext:!0,user:{},count:0,timer:null,title:""}},components:{},computed:{baseUrl:function(){return this.$base.url}},onLoad:function(){var t=(0,a.default)(regeneratorRuntime.mark((function t(e){var i,n;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return i=uni.getStorageSync("nowTable"),t.next=3,this.$api.session(i);case 3:n=t.sent,this.user=n.data,this.id=e.id,e.userid&&(this.userid=e.userid),this.init(),this.hasNext=!0,this.mescroll&&this.mescroll.resetUpScroll();case 10:case"end":return t.stop()}}),t,this)})));function e(e){return t.apply(this,arguments)}return e}(),onUnload:function(){this.timer&&clearInterval(this.timer)},onShow:function(){var t=(0,a.default)(regeneratorRuntime.mark((function t(e){var i,n,a,r;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return i=uni.getStorageSync("nowTable"),t.next=3,this.$api.session(i);case 3:if(n=t.sent,this.user=n.data,this.btnColor=this.btnColor.sort((function(){return.5-Math.random()})),a=uni.getStorageSync("discussdiscussdingdanfabuCleanType"),a&&(uni.removeStorageSync("discussdiscussdingdanfabuCleanType"),this.mescroll.num=1,this.upCallback(this.mescroll),this.init(2)),r=uni.getStorageSync("crossCleanType"),!r){t.next=15;break}return uni.removeStorageSync("crossCleanType"),t.next=13,this.$api.info("discussdingdanfabu",this.id);case 13:n=t.sent,this.detail=n.data;case 15:case"end":return t.stop()}}),t,this)})));function e(e){return t.apply(this,arguments)}return e}(),destroyed:function(){},methods:{callClick:function(t){uni.makePhoneCall({phoneNumber:t})},onPayTap:function(){var t=this;if(!this.user)return this.$utils.msg("请先登录"),setTimeout((function(){t.$utils.jump("../login/login")}),1500),!1;uni.setStorageSync("paytable","discussdingdanfabu"),uni.setStorageSync("payObject",this.detail),this.$utils.jump("../pay-confirm/pay-confirm?type=1")},onDetailTap:function(t){uni.setStorageSync("useridTag",this.userid),this.$utils.jump("./detail?id=".concat(t.id,"&userid=")+this.userid)},onAcrossTap:function(){var t=(0,a.default)(regeneratorRuntime.mark((function t(e,i,n,a,r,s){var o,u,c,l=arguments;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(l.length>6&&void 0!==l[6]?l[6]:1,o=this,this.user){t.next=6;break}return this.$utils.msg("请先登录"),setTimeout((function(){o.$utils.jump("../login/login")}),1500),t.abrupt("return",!1);case 6:if(uni.setStorageSync("crossTable","discussdingdanfabu"),uni.setStorageSync("crossObj",this.detail),uni.setStorageSync("statusColumnName",a),uni.setStorageSync("statusColumnValue",s),uni.setStorageSync("tips",r),""==a||a.startsWith("[")){t.next=21;break}u=uni.getStorageSync("crossObj"),t.t0=regeneratorRuntime.keys(u);case 14:if((t.t1=t.t0()).done){t.next=21;break}if(c=t.t1.value,c!=a||u[c]!=s){t.next=19;break}return this.$utils.msg(r),t.abrupt("return");case 19:t.next=14;break;case 21:this.$utils.jump("../".concat(e,"/add-or-update?cross=true"));case 22:case"end":return t.stop()}}),t,this)})));function e(e,i,n,a,r,s){return t.apply(this,arguments)}return e}(),init:function(){var t=(0,a.default)(regeneratorRuntime.mark((function t(){var e,i,n=arguments;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:return e=n.length>0&&void 0!==n[0]?n[0]:1,this.timer&&clearInterval(this.timer),t.next=4,this.$api.info("discussdingdanfabu",this.id);case 4:if(i=t.sent,this.detail=i.data,2!=e){t.next=10;break}return this.detail.discussnum++,t.next=10,this.$api.update("discussdingdanfabu",this.detail);case 10:case"end":return t.stop()}}),t,this)})));function e(){return t.apply(this,arguments)}return e}(),mescrollInit:function(t){this.mescroll=t},downCallback:function(t){this.hasNext=!0,t.resetUpScroll()},upCallback:function(){var t=(0,a.default)(regeneratorRuntime.mark((function t(e){var i,n;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(!uni.getStorageSync("appUserid")){t.next=8;break}return t.next=3,this.$api.list("discussdiscussdingdanfabu",{page:e.num,limit:10,refid:Number(this.id)});case 3:for(n in i=t.sent,1==e.num&&(this.commentList=[]),i.data.list)i.data.list[n].content&&(i.data.list[n].content=i.data.list[n].content.replace(/img src/gi,'img style="width:100%;" src'));this.commentList=this.commentList.concat(i.data.list),0==i.data.list.length&&(this.hasNext=!1);case 8:e.endSuccess(e.size,this.hasNext);case 9:case"end":return t.stop()}}),t,this)})));function e(e){return t.apply(this,arguments)}return e}(),onChatTap:function(){this.$utils.jump("../chat/chat")},download:function(t){var e=this;t=e.$base.url+t,uni.downloadFile({url:t,success:function(i){200===i.statusCode&&(e.$utils.msg("下载成功"),window.open(t))}})},onCartTabTap:function(){this.$utils.tab("../shop-cart/shop-cart")},onCommentTap:function(){var t=(0,a.default)(regeneratorRuntime.mark((function t(){var e;return regeneratorRuntime.wrap((function(t){while(1)switch(t.prev=t.next){case 0:if(e=this,this.user){t.next=5;break}return this.$utils.msg("请先登录"),setTimeout((function(){e.$utils.jump("../login/login")}),1500),t.abrupt("return",!1);case 5:this.$utils.jump("../discussdiscussdingdanfabu/add-or-update?refid=".concat(this.id));case 6:case"end":return t.stop()}}),t,this)})));function e(){return t.apply(this,arguments)}return e}(),delClick:function(t){var e=this;uni.showModal({title:"提示",content:"是否删除此评论？",success:function(){var i=(0,a.default)(regeneratorRuntime.mark((function i(n){return regeneratorRuntime.wrap((function(i){while(1)switch(i.prev=i.next){case 0:if(!n.confirm){i.next=8;break}return i.next=3,e.$api.del("discussdiscussdingdanfabu",JSON.stringify([t]));case 3:return e.$utils.msg("删除成功"),e.detail.discussnum--,i.next=7,e.$api.update("discussdingdanfabu",e.detail);case 7:setTimeout((function(){e.upCallback(e.mescroll)}),1500);case 8:case"end":return i.stop()}}),i)})));function n(t){return i.apply(this,arguments)}return n}()})}}};e.default=r},b8c7:function(t,e,i){var n=i("24fb");e=n(!1),e.push([t.i,'@charset "UTF-8";\n/**\r\n * 这里是uni-app内置的常用样式变量\r\n *\r\n * uni-app 官方扩展插件及插件市场（https://ext.dcloud.net.cn）上很多三方插件均使用了这些样式变量\r\n * 如果你是插件开发者，建议你使用scss预处理，并在插件代码中直接使用这些变量（无需 import 这个文件），方便用户通过搭积木的方式开发整体风格一致的App\r\n *\r\n */\n/**\r\n * 如果你是App开发者（插件使用者），你可以通过修改这些变量来定制自己的插件主题，实现自定义主题功能\r\n *\r\n * 如果你的项目同样使用了scss预处理，你也可以直接在你的 scss 代码中使用如下变量，同时无需 import 这个文件\r\n */\n/* 颜色变量 */\n/* 行为相关颜色 */\n/* 文字基本颜色 */\n/* 背景颜色 */\n/* 边框颜色 */\n/* 尺寸变量 */\n/* 文字尺寸 */\n/* 图片尺寸 */\n/* Border Radius */\n/* 水平间距 */\n/* 垂直间距 */\n/* 透明度 */\n/* 文章场景相关 */uni-page-body[data-v-0c8a571b]{--animate-duration:1s;--animate-delay:1s;--animate-repeat:1}.content[data-v-0c8a571b]{min-height:calc(100vh - 44px);box-sizing:border-box}.seat-list[data-v-0c8a571b]{display:-webkit-box;display:-webkit-flex;display:flex;-webkit-box-align:center;-webkit-align-items:center;align-items:center;-webkit-flex-wrap:wrap;flex-wrap:wrap;background:#fff;margin:%?20?%;border-radius:%?20?%;padding:%?20?%;font-size:%?30?%}.seat-list .seat-item[data-v-0c8a571b]{width:33.33%;display:-webkit-box;display:-webkit-flex;display:flex;-webkit-box-align:center;-webkit-align-items:center;align-items:center;-webkit-box-orient:vertical;-webkit-box-direction:normal;-webkit-flex-direction:column;flex-direction:column;margin-bottom:%?20?%}.seat-list .seat-item .seat-icon[data-v-0c8a571b]{width:%?50?%;height:%?50?%;margin-bottom:%?10?%}uni-audio[data-v-0c8a571b]{display:-webkit-box;display:-webkit-flex;display:flex;-webkit-box-orient:vertical;-webkit-box-direction:normal;-webkit-flex-direction:column;flex-direction:column}.audio[data-v-0c8a571b] .uni-audio-default{width:inherit}',""]),t.exports=e},c4bd:function(t,e,i){"use strict";var n={"mescroll-uni":i("f05e").default},a=function(){var t=this,e=t.$createElement,i=t._self._c||e;return i("v-uni-view",[i("mescroll-uni",{attrs:{up:t.upOption,down:t.downOption},on:{init:function(e){arguments[0]=e=t.$handleEvent(e),t.mescrollInit.apply(void 0,arguments)},down:function(e){arguments[0]=e=t.$handleEvent(e),t.downCallback.apply(void 0,arguments)},up:function(e){arguments[0]=e=t.$handleEvent(e),t.upCallback.apply(void 0,arguments)}}},[i("v-uni-view",{staticClass:"content"},[i("v-uni-view",{staticClass:"container",style:{minHeight:"100vh",width:"100%",padding:"24rpx",position:"relative",background:"#f4f4f4",height:"auto"}},[i("v-uni-view",{staticClass:"detail-content",style:{padding:"0px",flexWrap:"wrap",background:"none",display:"flex",width:"100%",justifyContent:"space-between",height:"auto"}},[i("v-uni-view",{staticClass:"detail-list-item",style:{margin:"0 0 16rpx 0",borderColor:"#d8d8d8",borderWidth:"0 0 2rpx 0",display:"flex",width:"100%",borderStyle:"solid",height:"auto"}},[i("v-uni-view",{staticClass:"lable",style:{padding:"0 20rpx 0 0",color:"#333",textAlign:"right",width:"auto",lineHeight:"48rpx",fontSize:"28rpx",minWidth:"200rpx"}},[t._v("关联表id：")]),i("v-uni-view",{staticClass:"text",style:{padding:"0px",margin:"0px",lineHeight:"48rpx",fontSize:"28rpx",color:"#666",flex:"1"}},[t._v(t._s(t.detail.refid))])],1),i("v-uni-view",{staticClass:"detail-list-item",style:{margin:"0 0 16rpx 0",borderColor:"#d8d8d8",borderWidth:"0 0 2rpx 0",display:"flex",width:"100%",borderStyle:"solid",height:"auto"}},[i("v-uni-view",{staticClass:"lable",style:{padding:"0 20rpx 0 0",color:"#333",textAlign:"right",width:"auto",lineHeight:"48rpx",fontSize:"28rpx",minWidth:"200rpx"}},[t._v("评论内容：")]),i("v-uni-view",{staticClass:"text",style:{padding:"0px",margin:"0px",lineHeight:"48rpx",fontSize:"28rpx",color:"#666",flex:"1"}},[t._v(t._s(t.detail.content))])],1),i("v-uni-view",{staticClass:"detail-list-item",style:{margin:"0 0 16rpx 0",borderColor:"#d8d8d8",borderWidth:"0 0 2rpx 0",display:"flex",width:"100%",borderStyle:"solid",height:"auto"}},[i("v-uni-view",{staticClass:"lable",style:{padding:"0 20rpx 0 0",color:"#333",textAlign:"right",width:"auto",lineHeight:"48rpx",fontSize:"28rpx",minWidth:"200rpx"}},[t._v("回复内容：")]),i("v-uni-view",{staticClass:"text",style:{padding:"0px",margin:"0px",lineHeight:"48rpx",fontSize:"28rpx",color:"#666",flex:"1"}},[t._v(t._s(t.detail.reply))])],1),i("v-uni-view",{staticClass:"time-content",style:{padding:"24rpx",margin:"40rpx 0 24rpx 0",borderRadius:"16rpx",background:"#fff",width:"100%",height:"auto",order:"40"}},[i("v-uni-view",{staticClass:"comoment-header",style:{width:"100%",borderRadius:"60rpx",background:"#f6f6f6",justifyContent:"space-between",display:"flex",height:"auto"}},[i("v-uni-view",{style:{padding:"0 24rpx",lineHeight:"80rpx",fontSize:"28rpx",color:"#333"}},[t._v("评论")]),i("v-uni-view",{staticClass:"btn-comment-content",staticStyle:{display:"flex","align-items":"center"},style:{padding:"0 40rpx 0 20rpx",borderRadius:"0 60rpx 60rpx 0",background:"#a5ccc4",display:"flex"},on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.onCommentTap.apply(void 0,arguments)}}},[i("v-uni-view",{staticClass:"cuIcon-add",style:{margin:"0 8rpx 0 0",lineHeight:"80rpx",fontSize:"28rpx",color:"#fff"}}),i("v-uni-view",{style:{color:"#fff",lineHeight:"80rpx",fontSize:"28rpx"}},[t._v("添加评论")])],1)],1),t._l(t.commentList,(function(e,n){return i("v-uni-view",{key:n,staticClass:"cu-item comment-item",style:{width:"100%",padding:"24rpx",margin:"24rpx 0 0 0",borderRadius:"16rpx",background:"#f4f4f4",height:"auto"}},[i("v-uni-view",{style:{width:"100%",display:"flex",height:"auto"}},[e.avatarurl?i("v-uni-image",{style:{width:"60rpx",margin:"0 8rpx 0 0",borderRadius:"100%",display:"block",height:"60rpx"},attrs:{mode:"aspectFill",src:t.baseUrl+e.avatarurl}}):t._e(),i("v-uni-view",{staticClass:"text-grey",style:{color:"#333",lineHeight:"60rpx",fontSize:"28rpx"}},[t._v(t._s(e.nickname))])],1),i("v-uni-view",{staticClass:"text-gray text-content text-df",style:{margin:"8rpx 0",lineHeight:"1.5",fontSize:"28rpx",color:"#666",textIndent:"2em"}},[i("v-uni-rich-text",{attrs:{nodes:e.content}})],1),i("v-uni-view",{staticClass:"margin-top-sm text-gray text-df",style:{lineHeight:"48rpx",fontSize:"26rpx",color:"#999",textAlign:"right"}},[t._v(t._s(e.addtime))]),e.reply?i("v-uni-view",{staticClass:"text-gray text-content text-df",style:{margin:"8rpx 0",lineHeight:"1.5",fontSize:"28rpx",color:"#666",textIndent:"2em"}},[t._v("回复:"),i("v-uni-rich-text",{attrs:{nodes:e.reply}})],1):t._e(),t.user&&t.user.id==e.userid?i("v-uni-view",{staticStyle:{display:"flex","justify-content":"flex-end",padding:"6rpx 0"}},[i("v-uni-view",{staticStyle:{color:"#999","font-size":"16rpx"},on:{click:function(i){arguments[0]=i=t.$handleEvent(i),t.delClick(e.id)}}},[t._v("删除")])],1):t._e()],1)}))],2),i("v-uni-view",{staticClass:"bottom-content bg-white tabbar border shop",style:{padding:"24rpx 24rpx",margin:"40rpx 0 24rpx 0",borderRadius:"16rpx",flexWrap:"wrap",background:"none",display:"flex",width:"100%",height:"auto",order:"2"}},[t.userid&&t.isAuth("discussdingdanfabu","私聊")?i("v-uni-button",{style:{border:"0",padding:"0 20rpx",margin:"0 3% 20rpx 0",color:"rgb(255, 255, 255)",borderRadius:"60rpx",background:"#a5ccc4",width:"auto",fontSize:"28rpx",minWidth:"20%",lineHeight:"80rpx",height:"80rpx"},on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.chatClick.apply(void 0,arguments)}}},[t._v("联系TA")]):t._e(),!t.userid&&t.isAuthFront("discussdingdanfabu","私聊")?i("v-uni-button",{style:{border:"0",padding:"0 20rpx",margin:"0 3% 20rpx 0",color:"rgb(255, 255, 255)",borderRadius:"60rpx",background:"#a5ccc4",width:"auto",fontSize:"28rpx",minWidth:"20%",lineHeight:"80rpx",height:"80rpx"},on:{click:function(e){arguments[0]=e=t.$handleEvent(e),t.chatClick.apply(void 0,arguments)}}},[t._v("联系TA")]):t._e()],1)],1)],1)],1)],1)],1)},r=[];i.d(e,"b",(function(){return a})),i.d(e,"c",(function(){return r})),i.d(e,"a",(function(){return n}))},f941:function(t,e,i){"use strict";i.r(e);var n=i("c4bd"),a=i("35fe");for(var r in a)"default"!==r&&function(t){i.d(e,t,(function(){return a[t]}))}(r);i("0b6f");var s,o=i("f0c5"),u=Object(o["a"])(a["default"],n["b"],n["c"],!1,null,"0c8a571b",null,!1,n["a"],s);e["default"]=u.exports}}]);