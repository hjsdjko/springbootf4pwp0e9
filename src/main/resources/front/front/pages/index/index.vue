<template>
<view class="content">
	<view :style='{"minHeight":"100vh","padding":"0 24rpx","overflow":"hidden","alignItems":"flex-start","flexWrap":"wrap","background":"linear-gradient(0deg, rgba(244,244,244,1) 0%, rgba(244,244,244,1) 90%, rgba(165,204,196,1) 100%),#f4f4f4","flexDirection":"row","display":"flex","width":"100%","height":"auto"}'>
		<view class="list-swiper-4" :style='{"width":"100%","margin":"0 0 40rpx","position":"relative","height":"360rpx"}' @touchstart="touchStart" @touchmove="touchMove" @touchend="touchEnd">
			<view :style='{"overflow":"hidden","top":"0%","borderRadius":"16rpx","left":"0%","background":"#fff","width":"100%","position":"absolute","height":"360rpx"}' class="item animate__animated" :class="prevNumList4 == index  ? 'animate__fadeOutRight' : (numList4 == index  ? 'animate__fadeInLeft' : '')" v-for="(swiper,index) in swiperList" :key="index" v-if="numList4 == index || prevNumList4 == index">
				<image :style='{"width":"100%","objectFit":"cover","borderRadius":"16rpx","display":"block","height":"360rpx"}' mode="aspectFill" :src="baseUrl+swiper.img" @tap="onSwiperTap(swiper)"></image>
				<view :style='{"padding":"8rpx 20rpx 80rpx","margin":"-20rpx 0 0 0","transform":"translate3d(-50%, -50%, 0)","top":"100%","color":"#fff","left":"50%","textAlign":"center","background":"rgba(255, 255, 255, 0.3)","width":"100%","lineHeight":"1.5","fontSize":"28rpx","position":"absolute"}'>{{ swiper.title }}</view>
			</view>
			<view class="animate__navigation" :style='{"alignItems":"center","left":"0%","bottom":"0%","background":"rgba(0,0,0,.0)","display":"flex","width":"100%","position":"absolute","justifyContent":"center","height":"40rpx"}'>
				<block v-for="(swiper,index) in swiperList" :key="index">
					<text class="navigation-item" v-if="numList4 == index" :style='{"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#a5ccc4","height":"16rpx"}'></text>
					<text class="navigation-item" v-if="numList4 != index" :style='{"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#fff","height":"16rpx"}'></text>
				</block>
			</view>
		</view>
		<!-- menu -->
        <view style="width: 100%" v-if="swiperMenuList.length">
            <swiper :style='{"padding":"0","margin":"0","borderRadius":"16rpx","flexWrap":"wrap","background":"#ffffff","display":"flex","width":"100%","justifyContent":"space-between"}' class="swiper">
                <swiper-item v-for="(swiper,index) in (new Array(Number(Math.ceil(swiperMenuList.length / (rows * column)))).fill('').map((val, i) => i+1))" :key="index">
                    <view v-for="(row, index1) in (new Array(Number(rows)).fill('').map((val, i) => i+1))" :key="index1" style="display: flex;flex-wrap: wrap;">
                        <view v-for="(col, index2) in (new Array(Number(column)).fill('').map((val, i) => i+1))" :key="index2" v-if="(((row+rows*(swiper-1) -1)*column + col -1)<swiperMenuList.length)" :style='{"width":"25%","padding":"12rpx 0","margin":"10rpx 0","height":"auto"}' class="menu-list">
                            <view :class="swiperMenuList[(row+rows*(swiper-1) -1)*column + col -1].child[0].appFrontIcon" @tap="onPageTap2(swiperMenuList[(row+rows*(swiper-1) -1)*column + col -1].child[0].tableName)" :style='{"padding":"0","margin":"0px auto","color":"#8fcad3","borderRadius":"100%","background":"#fff","display":"block","width":"64rpx","lineHeight":"64rpx","fontSize":"64rpx","height":"64rpx"}'>
                            </view>
                            <view :style='{"padding":"0","margin":"12rpx auto 0","color":"#333","textAlign":"center","width":"100%","lineHeight":"28rpx","fontSize":"28rpx"}'>{{swiperMenuList[(row+rows*(swiper-1) -1)*column + col -1].child[0].menu.split("列表")[0]}} </view>
                        </view>
                    </view>
                </swiper-item>
            </swiper>
        </view>
		<!-- menu -->
		<!-- 关于我们 -->
		<view :style='{"padding":"0px","margin":"40rpx 0","borderRadius":"16rpx","flexWrap":"wrap","background":"#a5ccc4","display":"flex","width":"100%","height":"auto"}'>
			<view :style='{"width":"100%","margin":"32rpx 0 0","lineHeight":"1.5","fontSize":"48rpx","color":"#fff","textAlign":"center"}'>{{aboutUsDetail.title}}</view>
			<view :style='{"width":"100%","margin":"0 0 20rpx","lineHeight":"1.5","fontSize":"32rpx","color":"#fff","textAlign":"center"}'>{{aboutUsDetail.subtitle}}</view>
			<view :style='{"padding":"10rpx 10rpx 40rpx","borderRadius":"0 0 16rpx 16rpx","flexWrap":"wrap","background":"#d2e6e2","display":"flex","width":"100%","height":"auto","order":"2"}'>
				<img :style='{"margin":"0 10rpx","objectFit":"cover","borderRadius":"16rpx","flex":1,"display":"block","height":"160rpx"}' v-if="aboutUsDetail.picture1" :src="baseUrl+aboutUsDetail.picture1">
				<img :style='{"margin":"0 10rpx","objectFit":"cover","borderRadius":"16rpx","flex":1,"display":"block","height":"160rpx"}' v-if="aboutUsDetail.picture2" :src="baseUrl+aboutUsDetail.picture2">
				<img :style='{"margin":"0 10rpx","objectFit":"cover","borderRadius":"16rpx","flex":1,"display":"block","height":"160rpx"}' v-if="aboutUsDetail.picture3" :src="baseUrl+aboutUsDetail.picture3">
			</view>
			<view :style='{"padding":"24rpx","margin":"0 0 0px 0","color":"rgb(102, 102, 102)","borderRadius":"16rpx 16rpx 0 0","background":"#d2e6e2","width":"100%","lineHeight":"2","fontSize":"28rpx"}' v-html="aboutUsDetail.content"></view>
			<view :style='{"border":"0","padding":"0 30rpx","margin":"40rpx auto 20rpx","borderRadius":"8rpx","textAlign":"center","background":"#a5ccc4","display":"none","width":"auto","lineHeight":"56rpx","order":"3"}'>
			  <text :style='{"color":"#f5f5f5","fontSize":"24rpx"}'>更多</text>
			  <text class="icon iconfont icon-gengduo1" :style='{"color":"#f5f5f5","fontSize":"24rpx"}'></text>
			</view>
			<view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
			<view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
		</view>
		<!-- 系统简介 -->
		<view :style='{"padding":"0px","margin":"40rpx 0","borderRadius":"16rpx","flexWrap":"wrap","background":"#a5ccc4","display":"flex","width":"100%","height":"auto","order":"10"}'>
			<view :style='{"width":"100%","margin":"32rpx 0 0","lineHeight":"1.5","fontSize":"48rpx","color":"#fff","textAlign":"center"}'>{{systemIntroductionDetail.title}}</view>
			<view :style='{"width":"100%","margin":"0 0 20rpx","lineHeight":"1.5","fontSize":"32rpx","color":"#fff","textAlign":"center"}'>{{systemIntroductionDetail.subtitle}}</view>
			<view :style='{"padding":"10rpx 10rpx 40rpx","borderRadius":"0 0 16rpx 16rpx","flexWrap":"wrap","background":"#d2e6e2","display":"flex","width":"100%","justifyContent":"space-between","height":"auto","order":"2"}'>
				<img :style='{"width":"32%","margin":"0 0px","objectFit":"cover","borderRadius":"16rpx","display":"block","height":"160rpx"}' v-if="systemIntroductionDetail.picture1" :src="baseUrl+systemIntroductionDetail.picture1">
				<img :style='{"width":"32%","margin":"0 0px","objectFit":"cover","borderRadius":"16rpx","display":"block","height":"160rpx"}' v-if="systemIntroductionDetail.picture2" :src="baseUrl+systemIntroductionDetail.picture2">
				<img :style='{"width":"32%","margin":"0 0px","objectFit":"cover","borderRadius":"16rpx","display":"block","height":"160rpx"}' v-if="systemIntroductionDetail.picture3" :src="baseUrl+systemIntroductionDetail.picture3">
			</view>
			<view :style='{"padding":"24rpx","margin":"0 0 0px 0","color":"#333","borderRadius":"16rpx 16rpx 0 0","background":"#d2e6e2","width":"100%","lineHeight":"2","fontSize":"28rpx"}' v-html="systemIntroductionDetail.content"></view>
			<view :style='{"border":"0","padding":"0 30rpx","margin":"0 auto","textAlign":"center","background":"#409EFF","display":"none","width":"auto","lineHeight":"56rpx","order":"3"}'>
			  <text :style='{"color":"#f5f5f5","fontSize":"24rpx"}'>更多</text>
			  <text class="icon iconfont icon-gengduo1" :style='{"color":"#f5f5f5","fontSize":"24rpx"}'></text>
			</view>
			<view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
			<view :style='{"width":"50%","background":"url(http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg) 0% 0% / cover no-repeat","display":"none","height":"160rpx"}' />
		</view>
		<!-- 商品推荐 -->
		<view class="listBox recommend" :style='{"width":"100%","padding":"0","margin":"40rpx 0 40rpx","background":"none"}'>
			<view class="title" :style='{"padding":"0 24rpx","margin":"0","textAlign":"center","background":"url(http://codegen.caihongy.cn/20231204/49b83cc7fd7b40fb9326fa241504d403.png) no-repeat center top / 100% 100%","width":"100%","lineHeight":"276rpx","height":"176rpx"}'>
				<view :style='{"color":"#fff","fontSize":"32rpx"}'>图书信息推荐</view>
			</view>
			<!-- 样式8 -->
			<view class="list-box style8" :style='{"width":"100%","padding":"12rpx 12rpx","margin":"0","background":"#fff","height":"auto"}'>
				<view v-if="tushuxinxilist.length > 0" @tap="onDetailTap('tushuxinxi',tushuxinxilist[0].id)" class="box box1"  :style='{"width":"100%","padding":"0","margin":"0 0 40rpx","position":"relative","height":"auto"}'>
					<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"400rpx"}' class="list-item-image" mode="aspectFill" v-if="tushuxinxilist[0].fengmian.substring(0,4)=='http'" :src="tushuxinxilist[0].fengmian"></image>
					<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"400rpx"}' class="list-item-image" mode="aspectFill" v-else :src="tushuxinxilist[0].fengmian?baseUrl+tushuxinxilist[0].fengmian.split(',')[0]:''"></image>
					<view :style='{"width":"100%","padding":"8rpx 20rpx","position":"absolute","left":"0","bottom":"0","background":"rgba(0,0,0,.3)"}'>
						<view :style='{"padding":"0 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.2","fontSize":"24rpx","textOverflow":"ellipsis"}' class="title ">{{tushuxinxilist[0].tushumingcheng}}</view>
						<view :style='{"padding":"0 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.2","fontSize":"24rpx","textOverflow":"ellipsis"}' class="title ">{{tushuxinxilist[0].tushuleixing}}</view>
						<view :style='{"padding":"0 0px"}'>
						  <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
						  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushuxinxilist[0].addtime}}</text>
						</view>
						<view :style='{"padding":"0 0px"}'>
						  <text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
						  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushuxinxilist[0].yonghuzhanghao}}</text>
						</view>
						<view :style='{"padding":"0 0px","display":"inline-block"}'>
						  <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
						  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushuxinxilist[0].storeupnum}}</text>
						</view>
						<view :style='{"padding":"0 0px","display":"inline-block"}'>
						  <text class="icon iconfont icon-chakan2" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
						  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushuxinxilist[0].clicknum}}</text>
						</view>
					</view>
				</view>
				<view class="list-item" :style='{"width":"100%","padding":"0","margin":"0 0 40rpx","justifyContent":"space-between","display":"flex","height":"auto"}'>
					<view v-if="tushuxinxilist.length > 1" @tap="onDetailTap('tushuxinxi',tushuxinxilist[1].id)" class="box box2" :style='{"width":"32%","padding":"0","margin":"0","position":"relative","height":"auto"}'>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' class="list-item-image" mode="aspectFill" v-if="tushuxinxilist[1].fengmian.substring(0,4)=='http'" :src="tushuxinxilist[1].fengmian"></image>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' class="list-item-image" mode="aspectFill" v-else :src="tushuxinxilist[1].fengmian?baseUrl+tushuxinxilist[1].fengmian.split(',')[0]:''"></image>
						<view :style='{"width":"100%","padding":"8rpx 4rpx","position":"absolute","left":"0","bottom":"0","background":"rgba(0,0,0,.3)"}'>
							<view :style='{"padding":"0 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.2","fontSize":"24rpx","textOverflow":"ellipsis"}' class="title ">{{tushuxinxilist[1].tushumingcheng}}</view>
							<view :style='{"padding":"0 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.2","fontSize":"24rpx","textOverflow":"ellipsis"}' class="title ">{{tushuxinxilist[1].tushuleixing}}</view>
							<view :style='{"padding":"0 0px"}'>
							  <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushuxinxilist[1].addtime}}</text>
							</view>
							<view :style='{"padding":"0 0px"}'>
							  <text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushuxinxilist[1].yonghuzhanghao}}</text>
							</view>
							<view :style='{"padding":"0 0px","display":"inline-block"}'>
							  <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushuxinxilist[1].storeupnum}}</text>
							</view>
							<view :style='{"padding":"0 0px","display":"inline-block"}'>
							  <text class="icon iconfont icon-chakan2" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushuxinxilist[1].clicknum}}</text>
							</view>
						</view>
					</view>
					<view v-if="tushuxinxilist.length > 2" @tap="onDetailTap('tushuxinxi',tushuxinxilist[2].id)" class="box box3" :style='{"width":"32%","padding":"0","margin":"0","position":"relative","height":"auto"}'>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' class="list-item-image" mode="aspectFill" v-if="tushuxinxilist[2].fengmian.substring(0,4)=='http'" :src="tushuxinxilist[2].fengmian"></image>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' class="list-item-image" mode="aspectFill" v-else :src="tushuxinxilist[2].fengmian?baseUrl+tushuxinxilist[2].fengmian.split(',')[0]:''"></image>
						<view :style='{"width":"100%","padding":"8rpx 4rpx","position":"absolute","left":"0","bottom":"0","background":"rgba(0,0,0,.3)"}'>
							<view :style='{"padding":"0 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.2","fontSize":"24rpx","textOverflow":"ellipsis"}' class="title ">{{tushuxinxilist[2].tushumingcheng}}</view>
							<view :style='{"padding":"0 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.2","fontSize":"24rpx","textOverflow":"ellipsis"}' class="title ">{{tushuxinxilist[2].tushuleixing}}</view>
							<view :style='{"padding":"0 0px"}'>
							  <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushuxinxilist[2].addtime}}</text>
							</view>
							<view :style='{"padding":"0 0px"}'>
							  <text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushuxinxilist[2].yonghuzhanghao}}</text>
							</view>
							<view :style='{"padding":"0 0px","display":"inline-block"}'>
							  <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushuxinxilist[2].storeupnum}}</text>
							</view>
							<view :style='{"padding":"0 0px","display":"inline-block"}'>
							  <text class="icon iconfont icon-chakan2" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushuxinxilist[2].clicknum}}</text>
							</view>
						</view>
					</view>
					<view v-if="tushuxinxilist.length > 3" @tap="onDetailTap('tushuxinxi',tushuxinxilist[3].id)" class="box box4" :style='{"width":"32%","padding":"0","margin":"0","position":"relative","height":"auto"}'>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' class="list-item-image" mode="aspectFill" v-if="tushuxinxilist[3].fengmian.substring(0,4)=='http'" :src="tushuxinxilist[3].fengmian"></image>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' class="list-item-image" mode="aspectFill" v-else :src="tushuxinxilist[3].fengmian?baseUrl+tushuxinxilist[3].fengmian.split(',')[0]:''"></image>
						<view :style='{"width":"100%","padding":"8rpx 4rpx","position":"absolute","left":"0","bottom":"0","background":"rgba(0,0,0,.3)"}'>
						<view :style='{"padding":"0 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.2","fontSize":"24rpx","textOverflow":"ellipsis"}' class="title ">{{tushuxinxilist[3].tushumingcheng}}</view>
						<view :style='{"padding":"0 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.2","fontSize":"24rpx","textOverflow":"ellipsis"}' class="title ">{{tushuxinxilist[3].tushuleixing}}</view>
							<view :style='{"padding":"0 0px"}'>
							  <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushuxinxilist[3].addtime}}</text>
							</view>
							<view :style='{"padding":"0 0px"}'>
							  <text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushuxinxilist[3].yonghuzhanghao}}</text>
							</view>
							<view :style='{"padding":"0 0px","display":"inline-block"}'>
							  <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushuxinxilist[3].storeupnum}}</text>
							</view>
							<view :style='{"padding":"0 0px","display":"inline-block"}'>
							  <text class="icon iconfont icon-chakan2" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushuxinxilist[3].clicknum}}</text>
							</view>
						</view>
					</view>
				</view>
				<view class="list-item" :style='{"width":"100%","padding":"0","margin":"0","justifyContent":"space-between","display":"flex","height":"auto"}'>
					<view v-if="tushuxinxilist.length > 4" @tap="onDetailTap('tushuxinxi',tushuxinxilist[4].id)" class="box box5" :style='{"width":"48%","padding":"0","margin":"0","position":"relative","height":"auto"}'>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' class="list-item-image" mode="aspectFill" v-if="tushuxinxilist[4].fengmian.substring(0,4)=='http'" :src="tushuxinxilist[4].fengmian"></image>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' class="list-item-image" mode="aspectFill" v-else :src="tushuxinxilist[4].fengmian?baseUrl+tushuxinxilist[4].fengmian.split(',')[0]:''"></image>
						<view :style='{"width":"100%","padding":"8rpx 8rpx","position":"absolute","left":"0","bottom":"0","background":"rgba(0,0,0,.3)"}'>
							<view :style='{"padding":"0 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.2","fontSize":"24rpx","textOverflow":"ellipsis"}' class="title ">{{tushuxinxilist[4].tushumingcheng}}</view>
							<view :style='{"padding":"0 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.2","fontSize":"24rpx","textOverflow":"ellipsis"}' class="title ">{{tushuxinxilist[4].tushuleixing}}</view>
							<view :style='{"padding":"0 0px"}'>
							  <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushuxinxilist[4].addtime}}</text>
							</view>
							<view :style='{"padding":"0 0px"}'>
							  <text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushuxinxilist[4].yonghuzhanghao}}</text>
							</view>
							<view :style='{"padding":"0 0px","display":"inline-block"}'>
							  <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushuxinxilist[4].storeupnum}}</text>
							</view>
							<view :style='{"padding":"0 0px","display":"inline-block"}'>
							  <text class="icon iconfont icon-chakan2" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushuxinxilist[4].clicknum}}</text>
							</view>
						</view>
					</view>
					<view v-if="tushuxinxilist.length > 5" @tap="onDetailTap('tushuxinxi',tushuxinxilist[5].id)" class="box box6" :style='{"width":"48%","padding":"0","margin":"0","position":"relative","height":"auto"}'>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' class="list-item-image" mode="aspectFill" v-if="tushuxinxilist[5].fengmian.substring(0,4)=='http'" :src="tushuxinxilist[5].fengmian"></image>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' class="list-item-image" mode="aspectFill" v-else :src="tushuxinxilist[5].fengmian?baseUrl+tushuxinxilist[5].fengmian.split(',')[0]:''"></image>
						<view :style='{"width":"100%","padding":"8rpx 8rpx","position":"absolute","left":"0","bottom":"0","background":"rgba(0,0,0,.3)"}'>
							<view :style='{"padding":"0 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.2","fontSize":"24rpx","textOverflow":"ellipsis"}' class="title ">{{tushuxinxilist[5].tushumingcheng}}</view>
							<view :style='{"padding":"0 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.2","fontSize":"24rpx","textOverflow":"ellipsis"}' class="title ">{{tushuxinxilist[5].tushuleixing}}</view>
							<view :style='{"padding":"0 0px"}'>
							  <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushuxinxilist[5].addtime}}</text>
							</view>
							<view :style='{"padding":"0 0px"}'>
							  <text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushuxinxilist[5].yonghuzhanghao}}</text>
							</view>
							<view :style='{"padding":"0 0px","display":"inline-block"}'>
							  <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushuxinxilist[5].storeupnum}}</text>
							</view>
							<view :style='{"padding":"0 0px","display":"inline-block"}'>
							  <text class="icon iconfont icon-chakan9" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushuxinxilist[5].clicknum}}</text>
							</view>
						</view>
					</view>
				</view>
			</view>
		</view>
		<view class="listBox recommend" :style='{"width":"100%","padding":"0","margin":"40rpx 0 40rpx","background":"none"}'>
			<view class="title" :style='{"padding":"0 24rpx","margin":"0","textAlign":"center","background":"url(http://codegen.caihongy.cn/20231204/49b83cc7fd7b40fb9326fa241504d403.png) no-repeat center top / 100% 100%","width":"100%","lineHeight":"276rpx","height":"176rpx"}'>
				<view :style='{"color":"#fff","fontSize":"32rpx"}'>图书捐赠推荐</view>
			</view>
			<!-- 样式8 -->
			<view class="list-box style8" :style='{"width":"100%","padding":"12rpx 12rpx","margin":"0","background":"#fff","height":"auto"}'>
				<view v-if="tushujuanzenglist.length > 0" @tap="onDetailTap('tushujuanzeng',tushujuanzenglist[0].id)" class="box box1"  :style='{"width":"100%","padding":"0","margin":"0 0 40rpx","position":"relative","height":"auto"}'>
					<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"400rpx"}' class="list-item-image" mode="aspectFill" v-if="tushujuanzenglist[0].fengmian.substring(0,4)=='http'" :src="tushujuanzenglist[0].fengmian"></image>
					<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"400rpx"}' class="list-item-image" mode="aspectFill" v-else :src="tushujuanzenglist[0].fengmian?baseUrl+tushujuanzenglist[0].fengmian.split(',')[0]:''"></image>
					<view :style='{"width":"100%","padding":"8rpx 20rpx","position":"absolute","left":"0","bottom":"0","background":"rgba(0,0,0,.3)"}'>
						<view :style='{"padding":"0 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.2","fontSize":"24rpx","textOverflow":"ellipsis"}' class="title ">{{tushujuanzenglist[0].tushumingcheng}}</view>
						<view :style='{"padding":"0 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.2","fontSize":"24rpx","textOverflow":"ellipsis"}' class="title ">{{tushujuanzenglist[0].tushuleixing}}</view>
						<view :style='{"padding":"0 0px"}'>
						  <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
						  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushujuanzenglist[0].addtime}}</text>
						</view>
						<view :style='{"padding":"0 0px"}'>
						  <text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
						  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushujuanzenglist[0].yonghuzhanghao}}</text>
						</view>
						<view :style='{"padding":"0 0px","display":"inline-block"}'>
						  <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
						  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushujuanzenglist[0].storeupnum}}</text>
						</view>
					</view>
				</view>
				<view class="list-item" :style='{"width":"100%","padding":"0","margin":"0 0 40rpx","justifyContent":"space-between","display":"flex","height":"auto"}'>
					<view v-if="tushujuanzenglist.length > 1" @tap="onDetailTap('tushujuanzeng',tushujuanzenglist[1].id)" class="box box2" :style='{"width":"32%","padding":"0","margin":"0","position":"relative","height":"auto"}'>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' class="list-item-image" mode="aspectFill" v-if="tushujuanzenglist[1].fengmian.substring(0,4)=='http'" :src="tushujuanzenglist[1].fengmian"></image>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' class="list-item-image" mode="aspectFill" v-else :src="tushujuanzenglist[1].fengmian?baseUrl+tushujuanzenglist[1].fengmian.split(',')[0]:''"></image>
						<view :style='{"width":"100%","padding":"8rpx 4rpx","position":"absolute","left":"0","bottom":"0","background":"rgba(0,0,0,.3)"}'>
							<view :style='{"padding":"0 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.2","fontSize":"24rpx","textOverflow":"ellipsis"}' class="title ">{{tushujuanzenglist[1].tushumingcheng}}</view>
							<view :style='{"padding":"0 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.2","fontSize":"24rpx","textOverflow":"ellipsis"}' class="title ">{{tushujuanzenglist[1].tushuleixing}}</view>
							<view :style='{"padding":"0 0px"}'>
							  <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushujuanzenglist[1].addtime}}</text>
							</view>
							<view :style='{"padding":"0 0px"}'>
							  <text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushujuanzenglist[1].yonghuzhanghao}}</text>
							</view>
							<view :style='{"padding":"0 0px","display":"inline-block"}'>
							  <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushujuanzenglist[1].storeupnum}}</text>
							</view>
						</view>
					</view>
					<view v-if="tushujuanzenglist.length > 2" @tap="onDetailTap('tushujuanzeng',tushujuanzenglist[2].id)" class="box box3" :style='{"width":"32%","padding":"0","margin":"0","position":"relative","height":"auto"}'>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' class="list-item-image" mode="aspectFill" v-if="tushujuanzenglist[2].fengmian.substring(0,4)=='http'" :src="tushujuanzenglist[2].fengmian"></image>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' class="list-item-image" mode="aspectFill" v-else :src="tushujuanzenglist[2].fengmian?baseUrl+tushujuanzenglist[2].fengmian.split(',')[0]:''"></image>
						<view :style='{"width":"100%","padding":"8rpx 4rpx","position":"absolute","left":"0","bottom":"0","background":"rgba(0,0,0,.3)"}'>
							<view :style='{"padding":"0 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.2","fontSize":"24rpx","textOverflow":"ellipsis"}' class="title ">{{tushujuanzenglist[2].tushumingcheng}}</view>
							<view :style='{"padding":"0 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.2","fontSize":"24rpx","textOverflow":"ellipsis"}' class="title ">{{tushujuanzenglist[2].tushuleixing}}</view>
							<view :style='{"padding":"0 0px"}'>
							  <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushujuanzenglist[2].addtime}}</text>
							</view>
							<view :style='{"padding":"0 0px"}'>
							  <text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushujuanzenglist[2].yonghuzhanghao}}</text>
							</view>
							<view :style='{"padding":"0 0px","display":"inline-block"}'>
							  <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushujuanzenglist[2].storeupnum}}</text>
							</view>
						</view>
					</view>
					<view v-if="tushujuanzenglist.length > 3" @tap="onDetailTap('tushujuanzeng',tushujuanzenglist[3].id)" class="box box4" :style='{"width":"32%","padding":"0","margin":"0","position":"relative","height":"auto"}'>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' class="list-item-image" mode="aspectFill" v-if="tushujuanzenglist[3].fengmian.substring(0,4)=='http'" :src="tushujuanzenglist[3].fengmian"></image>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' class="list-item-image" mode="aspectFill" v-else :src="tushujuanzenglist[3].fengmian?baseUrl+tushujuanzenglist[3].fengmian.split(',')[0]:''"></image>
						<view :style='{"width":"100%","padding":"8rpx 4rpx","position":"absolute","left":"0","bottom":"0","background":"rgba(0,0,0,.3)"}'>
						<view :style='{"padding":"0 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.2","fontSize":"24rpx","textOverflow":"ellipsis"}' class="title ">{{tushujuanzenglist[3].tushumingcheng}}</view>
						<view :style='{"padding":"0 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.2","fontSize":"24rpx","textOverflow":"ellipsis"}' class="title ">{{tushujuanzenglist[3].tushuleixing}}</view>
							<view :style='{"padding":"0 0px"}'>
							  <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushujuanzenglist[3].addtime}}</text>
							</view>
							<view :style='{"padding":"0 0px"}'>
							  <text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushujuanzenglist[3].yonghuzhanghao}}</text>
							</view>
							<view :style='{"padding":"0 0px","display":"inline-block"}'>
							  <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushujuanzenglist[3].storeupnum}}</text>
							</view>
						</view>
					</view>
				</view>
				<view class="list-item" :style='{"width":"100%","padding":"0","margin":"0","justifyContent":"space-between","display":"flex","height":"auto"}'>
					<view v-if="tushujuanzenglist.length > 4" @tap="onDetailTap('tushujuanzeng',tushujuanzenglist[4].id)" class="box box5" :style='{"width":"48%","padding":"0","margin":"0","position":"relative","height":"auto"}'>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' class="list-item-image" mode="aspectFill" v-if="tushujuanzenglist[4].fengmian.substring(0,4)=='http'" :src="tushujuanzenglist[4].fengmian"></image>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' class="list-item-image" mode="aspectFill" v-else :src="tushujuanzenglist[4].fengmian?baseUrl+tushujuanzenglist[4].fengmian.split(',')[0]:''"></image>
						<view :style='{"width":"100%","padding":"8rpx 8rpx","position":"absolute","left":"0","bottom":"0","background":"rgba(0,0,0,.3)"}'>
							<view :style='{"padding":"0 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.2","fontSize":"24rpx","textOverflow":"ellipsis"}' class="title ">{{tushujuanzenglist[4].tushumingcheng}}</view>
							<view :style='{"padding":"0 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.2","fontSize":"24rpx","textOverflow":"ellipsis"}' class="title ">{{tushujuanzenglist[4].tushuleixing}}</view>
							<view :style='{"padding":"0 0px"}'>
							  <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushujuanzenglist[4].addtime}}</text>
							</view>
							<view :style='{"padding":"0 0px"}'>
							  <text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushujuanzenglist[4].yonghuzhanghao}}</text>
							</view>
							<view :style='{"padding":"0 0px","display":"inline-block"}'>
							  <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushujuanzenglist[4].storeupnum}}</text>
							</view>
						</view>
					</view>
					<view v-if="tushujuanzenglist.length > 5" @tap="onDetailTap('tushujuanzeng',tushujuanzenglist[5].id)" class="box box6" :style='{"width":"48%","padding":"0","margin":"0","position":"relative","height":"auto"}'>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' class="list-item-image" mode="aspectFill" v-if="tushujuanzenglist[5].fengmian.substring(0,4)=='http'" :src="tushujuanzenglist[5].fengmian"></image>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"360rpx"}' class="list-item-image" mode="aspectFill" v-else :src="tushujuanzenglist[5].fengmian?baseUrl+tushujuanzenglist[5].fengmian.split(',')[0]:''"></image>
						<view :style='{"width":"100%","padding":"8rpx 8rpx","position":"absolute","left":"0","bottom":"0","background":"rgba(0,0,0,.3)"}'>
							<view :style='{"padding":"0 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.2","fontSize":"24rpx","textOverflow":"ellipsis"}' class="title ">{{tushujuanzenglist[5].tushumingcheng}}</view>
							<view :style='{"padding":"0 0px","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.2","fontSize":"24rpx","textOverflow":"ellipsis"}' class="title ">{{tushujuanzenglist[5].tushuleixing}}</view>
							<view :style='{"padding":"0 0px"}'>
							  <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushujuanzenglist[5].addtime}}</text>
							</view>
							<view :style='{"padding":"0 0px"}'>
							  <text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushujuanzenglist[5].yonghuzhanghao}}</text>
							</view>
							<view :style='{"padding":"0 0px","display":"inline-block"}'>
							  <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.2","fontSize":"24rpx","color":"#fff"}'></text>
							  <text :style='{"color":"#fff","lineHeight":"1.2","fontSize":"24rpx"}'>{{tushujuanzenglist[5].storeupnum}}</text>
							</view>
						</view>
					</view>
				</view>
			</view>
		</view>
		<!-- 商品推荐 -->
		
		<!-- 商品列表 -->
		<view class="listBox list" :style='{"width":"100%","margin":"0 0 20rpx","background":"none","order":"9"}'>
			<view class="title" :style='{"padding":"0 24rpx","margin":"0","textAlign":"center","background":"url(http://codegen.caihongy.cn/20231204/95a8019e4c124905a4d8312108d54eea.png) no-repeat center top / 100% 100%","display":"block","width":"100%","lineHeight":"276rpx","position":"relative","justifyContent":"space-between","height":"176rpx"}'>
				<view :style='{"color":"#fff","fontSize":"32rpx"}'>订单发布</view>
				<view :style='{"position":"absolute","right":"40rpx","top":"10rpx","display":"block"}' @tap="onPageTap('dingdanfabu')">
				  <text :style='{"color":"#eee","fontSize":"28rpx"}'>更多</text>
				  <text class="icon iconfont icon-gengduo1" :style='{"color":"#eee","fontSize":"28rpx"}'></text>
				</view>
			</view>
			<view id="list-list-10" class="list-box10 waterfall-body" :style='{"padding":"20rpx 24rpx 0","alignItems":"flex-start","borderRadius":"0 0 16rpx 16rpx","background":"#fff","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
				<view id="waterfall-left-column-list-10dingdanfabu" class="waterfall-column-list-10" :style='{"width":"48%","margin":"0 0px 0 0","flexDirection":"column","display":"flex","order":"2"}'>
					<view @tap="onDetailTap('dingdanfabu',product.id)" :style='{"boxShadow":"0 2rpx 16rpx rgba(0,0,0,.3)","margin":"0 0 20rpx 0","overflow":"hidden","position":"relative","borderRadius":"12rpx"}' v-for="product in leftListList10dingdanfabu" :key="product.id" class="left-content">
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"auto"}' mode="widthFix" v-if="product.fengmian.substring(0,4)=='http'" :src="product.fengmian"></image>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"auto"}' mode="widthFix" v-else :src="product.fengmian?baseUrl+product.fengmian.split(',')[0]:''"></image>
						<view :style='{"width":"100%","position":"absolute","left":"0","background":"rgba(0,0,0,.3)","bottom":"0"}'>
							<view :style='{"padding":"0 20rpx","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.5","fontSize":"24rpx","textOverflow":"ellipsis"}' class="list-item-title">{{product.tushumingcheng}}</view>
							<view :style='{"padding":"0 20rpx","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.5","fontSize":"24rpx","textOverflow":"ellipsis"}' class="list-item-title">{{product.tushuleixing}}</view>
							<view :style='{"padding":"0 20rpx"}'>
								<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#fff"}'></text>
								<text :style='{"color":"#fff","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.addtime}}</text>
							</view>
							<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
								<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#fff"}'></text>
								<text :style='{"color":"#fff","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.yonghuzhanghao}}</text>
							</view>
						</view>
					</view>
				</view>
				
				<view id="waterfall-right-column-list-10dingdanfabu" class="waterfall-column-list-10" :style='{"width":"48%","margin":"0 0 0 0px","flexDirection":"column","display":"flex"}'>
					<view @tap="onDetailTap('dingdanfabu',product.id)" :style='{"boxShadow":"0 2rpx 16rpx rgba(0,0,0,.3)","margin":"0 0 20rpx 0","overflow":"hidden","position":"relative","borderRadius":"12rpx"}' v-for="product in rightListList10dingdanfabu" :key="product.id" class="right-content">
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"auto"}' mode="widthFix" v-if="product.fengmian.substring(0,4)=='http'" :src="product.fengmian"></image>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"auto"}' mode="widthFix" v-else :src="product.fengmian?baseUrl+product.fengmian.split(',')[0]:''"></image>
						<view :style='{"width":"100%","position":"absolute","left":"0","background":"rgba(0,0,0,.3)","bottom":"0"}'>
							<view :style='{"padding":"0 20rpx","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.5","fontSize":"24rpx","textOverflow":"ellipsis"}' class="list-item-title">{{product.tushumingcheng}}</view>
							<view :style='{"padding":"0 20rpx","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.5","fontSize":"24rpx","textOverflow":"ellipsis"}' class="list-item-title">{{product.tushuleixing}}</view>
							<view :style='{"padding":"0 20rpx"}'>
								<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#fff"}'></text>
								<text :style='{"color":"#fff","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.addtime}}</text>
							</view>
							<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
								<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#fff"}'></text>
								<text :style='{"color":"#fff","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.yonghuzhanghao}}</text>
							</view>
						</view>
					</view>
				</view>
			</view>
		</view>
		<view class="listBox list" :style='{"width":"100%","margin":"0 0 20rpx","background":"none","order":"9"}'>
			<view class="title" :style='{"padding":"0 24rpx","margin":"0","textAlign":"center","background":"url(http://codegen.caihongy.cn/20231204/95a8019e4c124905a4d8312108d54eea.png) no-repeat center top / 100% 100%","display":"block","width":"100%","lineHeight":"276rpx","position":"relative","justifyContent":"space-between","height":"176rpx"}'>
				<view :style='{"color":"#fff","fontSize":"32rpx"}'>申请交换</view>
				<view :style='{"position":"absolute","right":"40rpx","top":"10rpx","display":"block"}' @tap="onPageTap('shenqingjiaohuan')">
				  <text :style='{"color":"#eee","fontSize":"28rpx"}'>更多</text>
				  <text class="icon iconfont icon-gengduo1" :style='{"color":"#eee","fontSize":"28rpx"}'></text>
				</view>
			</view>
			<view id="list-list-10" class="list-box10 waterfall-body" :style='{"padding":"20rpx 24rpx 0","alignItems":"flex-start","borderRadius":"0 0 16rpx 16rpx","background":"#fff","display":"flex","width":"100%","justifyContent":"space-between","height":"auto"}'>
				<view id="waterfall-left-column-list-10shenqingjiaohuan" class="waterfall-column-list-10" :style='{"width":"48%","margin":"0 0px 0 0","flexDirection":"column","display":"flex","order":"2"}'>
					<view @tap="onDetailTap('shenqingjiaohuan',product.id)" :style='{"boxShadow":"0 2rpx 16rpx rgba(0,0,0,.3)","margin":"0 0 20rpx 0","overflow":"hidden","position":"relative","borderRadius":"12rpx"}' v-for="product in leftListList10shenqingjiaohuan" :key="product.id" class="left-content">
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"auto"}' mode="widthFix" v-if="product.fengmian.substring(0,4)=='http'" :src="product.fengmian"></image>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"auto"}' mode="widthFix" v-else :src="product.fengmian?baseUrl+product.fengmian.split(',')[0]:''"></image>
						<view :style='{"width":"100%","position":"absolute","left":"0","background":"rgba(0,0,0,.3)","bottom":"0"}'>
							<view :style='{"padding":"0 20rpx","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.5","fontSize":"24rpx","textOverflow":"ellipsis"}' class="list-item-title">{{product.tushumingcheng}}</view>
							<view :style='{"padding":"0 20rpx","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.5","fontSize":"24rpx","textOverflow":"ellipsis"}' class="list-item-title">{{product.tushuleixing}}</view>
							<view :style='{"padding":"0 20rpx"}'>
								<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#fff"}'></text>
								<text :style='{"color":"#fff","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.addtime}}</text>
							</view>
							<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
								<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#fff"}'></text>
								<text :style='{"color":"#fff","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.yonghuzhanghao}}</text>
							</view>
						</view>
					</view>
				</view>
				
				<view id="waterfall-right-column-list-10shenqingjiaohuan" class="waterfall-column-list-10" :style='{"width":"48%","margin":"0 0 0 0px","flexDirection":"column","display":"flex"}'>
					<view @tap="onDetailTap('shenqingjiaohuan',product.id)" :style='{"boxShadow":"0 2rpx 16rpx rgba(0,0,0,.3)","margin":"0 0 20rpx 0","overflow":"hidden","position":"relative","borderRadius":"12rpx"}' v-for="product in rightListList10shenqingjiaohuan" :key="product.id" class="right-content">
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"auto"}' mode="widthFix" v-if="product.fengmian.substring(0,4)=='http'" :src="product.fengmian"></image>
						<image :style='{"width":"100%","objectFit":"cover","display":"block","height":"auto"}' mode="widthFix" v-else :src="product.fengmian?baseUrl+product.fengmian.split(',')[0]:''"></image>
						<view :style='{"width":"100%","position":"absolute","left":"0","background":"rgba(0,0,0,.3)","bottom":"0"}'>
							<view :style='{"padding":"0 20rpx","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.5","fontSize":"24rpx","textOverflow":"ellipsis"}' class="list-item-title">{{product.tushumingcheng}}</view>
							<view :style='{"padding":"0 20rpx","overflow":"hidden","whiteSpace":"nowrap","color":"#fff","lineHeight":"1.5","fontSize":"24rpx","textOverflow":"ellipsis"}' class="list-item-title">{{product.tushuleixing}}</view>
							<view :style='{"padding":"0 20rpx"}'>
								<text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#fff"}'></text>
								<text :style='{"color":"#fff","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.addtime}}</text>
							</view>
							<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
								<text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"#fff"}'></text>
								<text :style='{"color":"#fff","lineHeight":"1.5","fontSize":"24rpx"}'>{{product.yonghuzhanghao}}</text>
							</view>
						</view>
					</view>
				</view>
			</view>
		</view>
		<!-- 商品列表 -->
		<!-- 新闻资讯 -->
		<view class="listBox news" :style='{"width":"100%","margin":"40rpx 0 40rpx","background":"none"}'>
			<view class="title" :style='{"padding":"0 24rpx","margin":"0","textAlign":"center","background":"url(http://codegen.caihongy.cn/20231204/f6d3f6cf595a4e8a9e4100a1de1b3881.png) no-repeat center top / 100% 100%","display":"block","width":"100%","lineHeight":"276rpx","position":"relative","justifyContent":"space-between","height":"176rpx"}'>
				<view :style='{"color":"#fff","fontSize":"32rpx"}'>公告资讯</view>
				<view :style='{"position":"absolute","right":"40rpx","alignItems":"center","top":"0","justifyContent":"center","display":"flex"}' @tap="onPageTap('news')">
				  <text :style='{"color":"#eee","fontSize":"28rpx"}'>更多</text>
				  <text class="icon iconfont icon-gengduo1" :style='{"color":"#eee","fontSize":"28rpx"}'></text>
				</view>
			</view>
		  <!-- 样式9 -->
		  <view class="news-box6" :style='{"width":"100%","padding":"24rpx","margin":"0","color":"#999","background":"#fff","height":"auto"}'>
			<view @tap="onNewsDetailTap(item.id)" v-for="(item,index) in news" :key="index" class="list-item" :style='{"width":"100%","padding":"8rpx 24rpx 8rpx 100rpx","margin":"0 0 20rpx","position":"relative","background":"#f4f4f4","height":"auto"}'>
			  <view :style='{"padding":"0","margin":"-36rpx 0 0 20rpx","borderColor":"#a5ccc4","color":"#a5ccc4","textAlign":"center","borderRadius":"100%","top":"50%","left":"0","borderWidth":"2rpx","width":"72rpx","lineHeight":"68rpx","fontSize":"28rpx","position":"absolute","borderStyle":"solid","height":"72rpx"}' class="num">
			    <view style="width: 100%;height: 100%;position: absolute;left: 0;top: 0;" :style="{transform: 'rotate('+(-index*60)+'deg)'}" class="dian">
			      <view :style='{"transform":"translateX(-50%)","borderRadius":"100%","top":"-8rpx","left":"50%","background":"#a5ccc4","width":"16rpx","position":"absolute","height":"16rpx"}'></view>
			    </view>{{ index + 1 < 10 ? '0'+(index+1) : index+1 }}
			  </view>
			  <view class="item-list-body" :style='{"width":"100%","margin":"0","height":"auto"}'>
				<view :style='{"padding":"0 20rpx","overflow":"hidden","whiteSpace":"nowrap","color":"#000","width":"100%","lineHeight":"1.5","fontSize":"28rpx","textOverflow":"ellipsis"}' class="title ">{{item.title}}</view>
				<view :style='{"padding":"0 20rpx","margin":"0","overflow":"hidden","whiteSpace":"nowrap","color":"#999","width":"100%","lineHeight":"1.5","fontSize":"28rpx","textOverflow":"ellipsis"}' class="text">{{item.introduction}}</view>
				<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
				  <text class="icon iconfont icon-shijian21" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"inherit"}'></text>
				  <text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.addtime}}</text>
				</view>
				<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
				  <text class="icon iconfont icon-geren16" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"inherit"}'></text>
				  <text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.name}}</text>
				</view>
				<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
				  <text class="icon iconfont icon-zan10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"inherit"}'></text>
				  <text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.thumbsupnum}}</text>
				</view>
				<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
				  <text class="icon iconfont icon-shoucang10" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"inherit"}'></text>
				  <text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.storeupnum}}</text>
				</view>
				<view :style='{"padding":"0 20rpx","display":"inline-block"}'>
				  <text class="icon iconfont icon-chakan2" :style='{"margin":"0 4rpx 0 0","lineHeight":"1.5","fontSize":"24rpx","color":"inherit"}'></text>
				  <text :style='{"color":"inherit","lineHeight":"1.5","fontSize":"24rpx"}'>{{item.clicknum}}</text>
				</view>
			  </view>
			</view>
		  </view>
		</view>
		<!-- 新闻资讯 -->
	</view>
</view>
</template>

<script>
    import menu from '@/utils/menu'
	import '@/assets/css/global-restaurant.css'
	import uniIcons from "@/components/uni-ui/lib/uni-icons/uni-icons.vue"
	export default {
		components: {
			uniIcons
		},
		data() {
			return {
				startX: 0,
				prevNumList4: '',
				numList4: 0,
				timerList4: null,
				flagList4: false,
				navigationActive: {"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#a5ccc4","height":"16rpx"},
				navigationDefault: {"width":"16rpx","margin":"0 4rpx","borderRadius":"100%","background":"#fff","height":"16rpx"},
				options2: {
					effect: 'flip',
					loop : true
				},
				options3: {
					effect: 'cube',
					loop : true,
					cubeEffect: {
						shadow: true,
						slideShadows: true,
						shadowOffset: 20,
						shadowScale: 0.94,
					}
				},
				rows: 2,
				column: 4,
				iconArr: [
				  'cuIcon-same',
				  'cuIcon-deliver',
				  'cuIcon-evaluate',
				  'cuIcon-shop',
				  'cuIcon-ticket',
				  'cuIcon-cascades',
				  'cuIcon-discover',
				  'cuIcon-question',
				  'cuIcon-pic',
				  'cuIcon-filter',
				  'cuIcon-footprint',
				  'cuIcon-pulldown',
				  'cuIcon-pullup',
				  'cuIcon-moreandroid',
				  'cuIcon-refund',
				  'cuIcon-qrcode',
				  'cuIcon-remind',
				  'cuIcon-profile',
				  'cuIcon-home',
				  'cuIcon-message',
				  'cuIcon-link',
				  'cuIcon-lock',
				  'cuIcon-unlock',
				  'cuIcon-vip',
				  'cuIcon-weibo',
				  'cuIcon-activity',
				  'cuIcon-friendadd',
				  'cuIcon-friendfamous',
				  'cuIcon-friend',
				  'cuIcon-goods',
				  'cuIcon-selection'
				],
                role : '',
                aboutUsDetail: {},
                systemIntroductionDetail: {},
                menuList: [],
                swiperMenuList:[],
                user: {},
                tableName:'',

				//轮播
				swiperList: [],
				tushuxinxilist: [],
				tushujuanzenglist: [],
				homedingdanfabulist: [],
				homeshenqingjiaohuanlist: [],
				news: [],
				leftListList10dingdanfabu: [],
				rightListList10dingdanfabu: [],
				tempListList10dingdanfabu: [],
				leftListList10shenqingjiaohuan: [],
				rightListList10shenqingjiaohuan: [],
				tempListList10shenqingjiaohuan: [],
			}
		},
		watch: {
			copyFlowListList10dingdanfabu(nVal, oVal) {
				this.tempListList10dingdanfabu = this.cloneData(this.copyFlowListList10dingdanfabu);
				this.splitDataList10dingdanfabu();
			},
			copyFlowListList10shenqingjiaohuan(nVal, oVal) {
				this.tempListList10shenqingjiaohuan = this.cloneData(this.copyFlowListList10shenqingjiaohuan);
				this.splitDataList10shenqingjiaohuan();
			},
		},
		mounted() {
			this.tempListList10dingdanfabu = this.cloneData(this.copyFlowListList10dingdanfabu);
			this.splitDataList10dingdanfabu();
			this.tempListList10shenqingjiaohuan = this.cloneData(this.copyFlowListList10shenqingjiaohuan);
			this.splitDataList10shenqingjiaohuan();
		},
		computed: {
			baseUrl() {
				return this.$base.url;
			},
			copyFlowListList10dingdanfabu() {
				return this.cloneData(this.homedingdanfabulist);
			},
			copyFlowListList10shenqingjiaohuan() {
				return this.cloneData(this.homeshenqingjiaohuanlist);
			},
		},
        async onLoad(){
            
        },
		async onShow() {
			this.swiperMenuList = []
			this.role = uni.getStorageSync("appRole");
			let table = uni.getStorageSync("nowTable");
			let res = await this.$api.session(table);
			this.user = res.data;
			this.tableName = table;
			let menus = menu.list();
			this.menuList = menus;
			this.menuList.forEach((item,key) => {
			    if(key==0) {
			        item.frontMenu.forEach((item2,key2) => {
			            if(item2.child[0].buttons.indexOf("查看")>-1) {
			                this.swiperMenuList.push(item2);
			            }
			        })
			    }
			})
            // let res;
			// 轮播图
			let swiperList = []
			res = await this.$api.list('config', {
				page: 1,
				limit: 5
			});
			for (let item of res.data.list) {
				if (item.name.indexOf('picture') >= 0 && item.value && item.value!="" && item.value!=null ) {
					swiperList.push({
						img: item.value,
                        title: item.name,
						url: item.url
					});
				}
			}
			if (swiperList) {
				this.swiperList = swiperList;
			}
			
			this.prevNumList4 = this.swiperList.length - 1
			this.timerList4 = setInterval(this.autoPlayList4, 6000)

            this.getAboutUs();
            this.getSystemIntroduction();
			// 推荐信息
			this.leftListList10dingdanfabu = []
			this.rightListList10dingdanfabu = []
			this.tempListList10dingdanfabu = []
			this.leftListList10shenqingjiaohuan = []
			this.rightListList10shenqingjiaohuan = []
			this.tempListList10shenqingjiaohuan = []
			// 推荐信息
			this.getRecommendList()
			this.getHomeList()
			this.getNewsList()
		},
		methods: {
			async splitDataList10dingdanfabu() {
				if (!this.tempListList10dingdanfabu.length) return;
				let leftRect = await this.uGetRect('#waterfall-left-column-list-10dingdanfabu');
				let rightRect = await this.uGetRect('#waterfall-right-column-list-10dingdanfabu');
				// 如果左边小于或等于右边，就添加到左边，否则添加到右边
				let item = this.tempListList10dingdanfabu[0];
				// 解决多次快速上拉后，可能数据会乱的问题，因为经过上面的两个await节点查询阻塞一定时间，加上后面的定时器干扰
				// 数组可能变成[]，导致此item值可能为undefined
				if (!item) return;
				
				if (leftRect.height < rightRect.height) {
					this.leftListList10dingdanfabu.push(item);
				} else if (leftRect.height > rightRect.height) {
					this.rightListList10dingdanfabu.push(item);
				} else {
					// 这里是为了保证第一和第二张添加时，左右都能有内容
					// 因为添加第一张，实际队列的高度可能还是0，这时需要根据队列元素长度判断下一个该放哪边
					if (this.leftListList10dingdanfabu.length <= this.rightListList10dingdanfabu.length) {
						this.leftListList10dingdanfabu.push(item);
					} else {
						this.rightListList10dingdanfabu.push(item);
					}
				}
				// 移除临时列表的第一项
				this.tempListList10dingdanfabu.splice(0, 1);
				// 如果临时数组还有数据，继续循环
				if (this.tempListList10dingdanfabu.length) {
					setTimeout(()=>{
						this.splitDataList10dingdanfabu();
					}, 150)
					return
				}
			},
			async splitDataList10shenqingjiaohuan() {
				if (!this.tempListList10shenqingjiaohuan.length) return;
				let leftRect = await this.uGetRect('#waterfall-left-column-list-10shenqingjiaohuan');
				let rightRect = await this.uGetRect('#waterfall-right-column-list-10shenqingjiaohuan');
				// 如果左边小于或等于右边，就添加到左边，否则添加到右边
				let item = this.tempListList10shenqingjiaohuan[0];
				// 解决多次快速上拉后，可能数据会乱的问题，因为经过上面的两个await节点查询阻塞一定时间，加上后面的定时器干扰
				// 数组可能变成[]，导致此item值可能为undefined
				if (!item) return;
				
				if (leftRect.height < rightRect.height) {
					this.leftListList10shenqingjiaohuan.push(item);
				} else if (leftRect.height > rightRect.height) {
					this.rightListList10shenqingjiaohuan.push(item);
				} else {
					// 这里是为了保证第一和第二张添加时，左右都能有内容
					// 因为添加第一张，实际队列的高度可能还是0，这时需要根据队列元素长度判断下一个该放哪边
					if (this.leftListList10shenqingjiaohuan.length <= this.rightListList10shenqingjiaohuan.length) {
						this.leftListList10shenqingjiaohuan.push(item);
					} else {
						this.rightListList10shenqingjiaohuan.push(item);
					}
				}
				// 移除临时列表的第一项
				this.tempListList10shenqingjiaohuan.splice(0, 1);
				// 如果临时数组还有数据，继续循环
				if (this.tempListList10shenqingjiaohuan.length) {
					setTimeout(()=>{
						this.splitDataList10shenqingjiaohuan();
					}, 150)
					return
				}
			},
			uGetRect(selector, all) {
				return new Promise(resolve => {
					uni.createSelectorQuery()
					.in(this)
					[all ? 'selectAll' : 'select'](selector)
					.boundingClientRect(rect => {
						if (all && Array.isArray(rect) && rect.length) {
							resolve(rect);
						}
						if (!all && rect) {
							resolve(rect);
						}
					})
					.exec();
				});
			},
			cloneData(data) {
				return JSON.parse(JSON.stringify(data));
			},
			newsTabClick2(index){
				this.newsIndex2 = index
				this.getNewsList()
			},
			async getNewsList(){
				let res;
				let params = {
					page: 1,
					limit: 6,
					sort: 'id',
					order: 'desc',
				}
				// 公告资讯
				res = await this.$api.list('news', params)
				this.news = res.data.list
			},
			homeTabClick2(index,name){
				this['home' + name + 'Index2'] = index
				this.getHomeList()
			},
			async getHomeList(){
				let res;
				let params;
				params = {
					page:1,
					limit: 8,
				}
				res = await this.$api.list('dingdanfabu', params);
				this.homedingdanfabulist = res.data.list
				this.tempListList10dingdanfabu = this.copyFlowListList10dingdanfabu;
				this.splitDataList10dingdanfabu();
				params = {
					page:1,
					limit: 8,
				}
				res = await this.$api.list('shenqingjiaohuan', params);
				this.homeshenqingjiaohuanlist = res.data.list
				this.tempListList10shenqingjiaohuan = this.copyFlowListList10shenqingjiaohuan;
				this.splitDataList10shenqingjiaohuan();
			},
			recommendTabClick2(index,name){
				this[name + 'Index2'] = index
				this.getRecommendList()
			},
			async getRecommendList(){
				let res;
				let params;
				// 推荐信息
				params = {
					page: 1,
					limit: 6,
				}
				if(uni.getStorageSync("appUserid")) {
					res = await this.$api.recommend2('tushuxinxi', params);
				} else {
					res = await this.$api.recommend('tushuxinxi', params);
				}
				this.tushuxinxilist = res.data.list
				

				// 推荐信息
				params = {
					page: 1,
					limit: 6,
                    sfsh: '是',
				}
				res = await this.$api.recommend('tushujuanzeng', params);
				this.tushujuanzenglist = res.data.list
				

			},
			autoPlayList4() {
				this.prevNumList4 = this.numList4
			
				this.numList4++
				if (this.numList4 == this.swiperList.length) this.numList4 = 0
			},
			touchStart(event) {
				this.startX = event.touches[0].clientX
				
				clearInterval(this.timerList4)
				this.flagList4 = true
			},
			touchMove(event) {
				const currentX = event.touches[0].clientX;
				const deltaX = currentX - this.startX;
				
				if (deltaX > 50) {
					// 向右滑动逻辑
					if (this.flagList4) {
						this.flagList4 = false
						
						this.prevNumList4 = this.numList4
						this.numList4++
						if (this.numList4 == this.swiperList.length) this.numList4 = 0
					}
					
				} else if (deltaX < -50) {
					// 向左滑动逻辑
					if (this.flagList4) {
						this.flagList4 = false
						
						this.prevNumList4 = this.numList4
						this.numList4--
						if (this.numList4 < 0) this.numList4 = this.swiperList.length - 1
					}
				}
			},
			touchEnd() {
				this.startX = 0
				this.timerList4 = setInterval(this.autoPlayList4, 6000)
				this.flagList4 = false
			},
			//轮播图跳转
			onSwiperTap(e) {
				if(e.url) {
					if (e.url.indexOf('https') != -1) {
						// #ifdef MP-WEIXIN
						uni.navigateTo({
						    url: '../../common/linkOthers/linkOthers?url=' + encodeURIComponent(e.url),
						});
						return false
						// #endif
						window.open(e.url)
					} else {
						this.$utils.jump(e.url)
					}
				}
			},
            async getAboutUs() {
                let res = await this.$api.info('aboutus', 1)
                this.aboutUsDetail = res.data;
            },
            async getSystemIntroduction() {
                let res = await this.$api.info('systemintro', 1)
                this.systemIntroductionDetail = res.data;
            },
			// 新闻详情
			onNewsDetailTap(id) {
				this.$utils.jump(`../news-detail/news-detail?id=${id}`)
			},
			// 推荐列表点击详情
			onDetailTap(tableName, id) {
				this.$utils.jump(`../${tableName}/detail?id=${id}`)
			},
			onPageTap(tableName){

				uni.navigateTo({
					url: `../${tableName}/list`,
					fail: function(){
						uni.switchTab({
							url: `../${tableName}/list`
						});
					}
				});
				// this.$utils.jump(`../${tableName}/list`)
			},
            onPageTap2(index) {
				let url = '../' + index + '/list'
				if(index=='forum'){
					url = '../forum-index/forum-index'
				}
                uni.setStorageSync("useridTag",0);
                uni.navigateTo({
                    url: url,
                    fail: function() {
                        uni.switchTab({
                            url: url
                        });
                    }
                });
            }
		}
	}
</script>

<style lang="scss" scoped>
	.content {
		min-height: calc(100vh - 44px);
		box-sizing: border-box;
	}
	.list-swiper-4 .animate__animated {
		--animate-delay: 300ms;
	}

</style>
