<template>
	<view>
		<view class="title">
			{{forum.title}}
		</view>
		<view class="username">
			发布人：{{forum.username}}
		</view>
		<view class="operateView">
			<view class="like_box" :class="likeType?'likeActive':''" @click="likeClick">
				<view class="cuIcon-appreciate icon"></view>
				{{likeType?'已':''}}赞
			</view>
		</view>
		<view class="content" style="border-bottom: 1px #eee solid;">
			<rich-text :nodes="forum.content"></rich-text>
		</view>
		<view class="uni-article__comment">
			<view class="uni-article__comment-box" v-for="comment in commentData" :key="comment.id">
				<view class="article-meta">
					<view class="article-header-image">
						<image class="image" :src="baseUrl+comment.avatarurl" mode="widthFix"></image>
					</view>
					<view class="article-header-content">
						<view class="article-header-title">
							<text>{{comment.username}}</text>
						</view>
						<view class="article-header-info"> {{comment.addtime||''}}</view>
					</view>
				</view>
				<view class="uni-article__comment-centent">
                    <rich-text style="width: 100%;"  :nodes="comment.content"></rich-text>
					<view class="btn-replay">
						<text @tap="onReplyTap(comment.id)" style="padding: 0 6px">回复</text>
						<text @tap="delClick(comment.id)" v-if="userid==comment.userid">删除</text>
					</view>
				</view>
				<view style="width: 100%;padding: 0 0 0 60px;box-sizing: border-box;" v-if="comment.childs">
					<view class="uni-article__comment-box" v-for="item in comment.childs" :key="item.id">
						<view class="article-meta">
							<view class="article-header-image">
								<image class="image" :src="baseUrl+item.avatarurl" mode="widthFix"></image>
							</view>
							<view class="article-header-content">
								<view class="article-header-title">
									<text>{{item.username}}</text>
								</view>
								<view class="article-header-info"> {{item.addtime||''}}</view>
							</view>
						</view>
						<view class="uni-article__comment-centent">
							<rich-text style="width: 100%;" :nodes="item.content"></rich-text>
							<text class="btn-replay" @tap="delClick(item.id)" v-if="userid==item.userid">删除</text>
						</view>
					</view>
				</view>
			</view>
            <view class="kong"></view>
			
			<view class="bottom-content">
				<button @tap="onReplyTap(forum.id)" class="bg-red margin-tb-sm">评论</button>
			</view>
		</view>
	</view>
</template>
<script>
	import userReply from '@/components/forum-reply/forum-reply.vue'
	export default {
		components: {
			userReply
		},
		data() {
			return {
				commentData: [],
				forum: {},
				id: '',
				likeType: false,
				likeForm: {},
			}
		},
        computed: {
            baseUrl() {
                return this.$base.url;
            },
			userid(){
				return uni.getStorageSync('appUserid')
			}
        },
		async onLoad(options) {
			this.id = options.id;
			let res = await this.$api.forumDetail(options.id)
            res.data.childs = this.changeContent(res.data.childs)
			this.commentData = res.data.childs;
            res.data.content = res.data.content.replace(/img src/gi,"img style=\"width:100%;\" src");
			this.forum = res.data;
			this.getLike()
		},
		async onShow() {
			let res = await this.$api.forumDetail(this.id)
            res.data.childs = this.changeContent(res.data.childs)
			this.commentData = res.data.childs;
			this.forum = res.data;
            res.data.content = res.data.content.replace(/img src/gi,"img style=\"width:100%;\" src");
		},
		methods: {
			// 获取点赞状态
			async getLike() {
				let res = await this.$api.list('storeup', {
					page: 1,
					limit: 1,
					type: 21,
					userid: uni.getStorageSync('appUserid'),
					refid: this.id,
					tablename: 'forum'
				})
				if (res.data.list.length) {
					this.likeType = true
					this.likeForm = res.data.list[0]
				} else {
					this.likeType = false
				}
			},
			// 点赞按钮
			async likeClick() {
				let that = this
				if (this.likeType) {
					uni.showModal({
						title: '提示',
						content: '是否取消点赞？',
						async success(res) {
							if (res.confirm) {
								await that.$api.del('storeup', JSON.stringify([that.likeForm.id]))
								that.$utils.msg('取消成功')
								that.getLike()
							}
						}
					})
				} else {
					await that.$api.add('storeup', {
						userid: uni.getStorageSync('appUserid'),
						refid: this.id,
						type: 21,
						name: this.forum.title,
						picture: '',
						tablename: 'forum',
					})
					this.$utils.msg('点赞成功')
					this.getLike()
				}
			},
            changeContent(childs){
                if(childs){
                    childs = change(childs)
                }
                return childs
                function change(childs){
                    for(let x in childs){
                        childs[x].content = childs[x].content.replace(/img src/gi,"img style=\"width:100%;\" src");
                        if(childs[x].childs){
                            childs[x].childs = change(childs[x].childs)
                        }
                    }
                    return childs
                }
            },
			onReplyTap(pid) {
				this.$utils.jump(`../forum-reply/forum-reply?pid=${pid}`);
			},
			// 删除当前评论
			delClick(id) {
				let that = this
				uni.showModal({
					title: '提示',
					content: '是否删除此评论？',
					async success(res) {
						if (res.confirm) {
							await that.$api.del('forum', JSON.stringify([id]))
							that.$utils.msg('删除成功')
							setTimeout(async () => {
								let obj = await that.$api.forumDetail(that.id)
								obj.data.childs = that.changeContent(obj.data.childs)
								that.commentData = obj.data.childs;
							}, 1500)
						}
					}
				})
			},
		}
	}
</script>

<style scoped lang="scss">
	page {
		background: #FFFFFF;
	}

	.title {
		text-align: center;
		font-size: 40upx;
		font-weight: bold;
		margin: 20upx;
	}
	
	.username{
		text-align: center;
		font-size: 20upx;
		font-weight: bold;
		color: #888888;
		margin: 20upx;
	}
	
	.content {
		margin: 40upx;
		font-size: 30upx;
		line-height: 50upx;
		letter-spacing: 5upx;
	}

	.article-meta {
		padding: 20rpx 20rpx;
		display: flex;
		align-items: center;
		flex-direction: row;
		justify-content: flex-start;
		color: gray;
	}

	.article-header-image {
		width: 60rpx;
		height: 60rpx;
		flex-shrink: 0;
		/* border-radius: 50%; */
		overflow: hidden;
	}

	.article-header-image .image {
		width: 100%;
		height: 100%;
	}

	.article-header-content {
		display: flex;
		flex-direction: column;
		justify-content: center;
		padding-left: 10px;
		font-size: 24rpx;
		line-height: 1;
		width: 100%;
		/* height: 60rpx; */
	}

	.article-header-title {
		display: flex;
		justify-content: space-between;
		align-items: center;
		font-size: 26rpx;
		line-height: 2;
		color: #000;
	}

	.article-header-info {
		font-size: 24rpx;
		line-height: 1;
	}

	.article-top {
		display: flex;
		align-items: flex-end;
		font-size: 26rpx;
		line-height: 1;
		color: #999;
	}

	.article-top .image {
		width: 30rpx;
		margin-left: 5rpx;
	}

	.uni-article__comment {
		margin-bottom: 160upx;
	}

	.uni-article__comment-title {
		width: 100%;
		line-height: 3;
		font-size: 28rpx;
		color: #666;
		background: #f5f5f5;
		padding-left: 20rpx;
	}

	.uni-article__comment-centent {
		border-bottom: 1px #eee solid;
		padding: 0 20rpx;
		padding-left: 95rpx;
		padding-bottom: 20rpx;
		font-size: 14px;
		color: #333;
	}

	.btn-replay {
		color: red;
		width: 100%;
		display: flex;
		align-items: center;
		justify-content: flex-end;
	}
	
	.bottom-content{
		position: fixed;
		bottom: 0;
		padding: 20upx;
		width: 100%;
	}

    .kong {
        width: 100%;
        height: 180rpx;
    }
	.operateView {
		width: 100%;
		display: flex;
		align-items: center;
		justify-content: center;
	
		.like_box {
			width: 40%;
			display: flex;
			align-items: center;
			justify-content: center;
			font-size: 32rpx;
	
			.icon {
				font-size: 36rpx;
				padding: 0 6rpx;
			}
		}
	
		.likeActive {
			color: #f00;
		}
	}
</style>
