- 使用Material Design设计模式,使用导航栏
- 使用MultiType框架，简化recyclerView的复杂列表视图
- 使用butterknife注解,图片加载使用Glide
- 解析豆瓣书和电影的api
- 整体框架:
- MVP(使用适配器模式)+Retrofit(2.0)+Rxjava
- 加入一些小功能(计算器,二维码)

###### TODO
转场过渡
添加搜索功能
丰富详细页....

参考大触的项目 [banya](https://github.com/forezp/banya "banya")
[MultiTypeDemo](https://github.com/WanLiLi/MultiTypeDemo "MultiTypeDemo")
[Meizhi](https://github.com/drakeet/Meizhi "Meizhi")

##### 学艺不精,时间比较短整个项目还有很多问题也有很多待改进的地方,日后逐渐完善...:cry:


###### 其他一些东西
在设置侧边栏时
android:layout_gravity=""  start为左侧end为右侧

在BaseActivity里写过渡动画

MainActivitys设置3个fragment 每个fragment使用Tablayout + viewPager再添加布局

让MainActivity继承RefrsherActivity
MainActivity布局
ButterKnife申请加入BaseActivity
MainActivity设置3个fragment
MainActivity加ViewPage
添加一个基础Basefragmnet里面写viewpager

RefrsherActivity要让BaseActivity继承不能写在MianActivity
BaseFragment写fragment出现的过渡
当 SwipeRefreshLayout 中放置了 ViewPager 控件,两者的滑动会相互冲突.
viewPager滑动冲突
coordinary这个控件的问题没有解决
Tablayout暂时使用需要改进
瀑布流手机适配暂时没想办法
试试加载drawer用动画感觉会蛮有趣的
下拉加载功能
无网情况下在一段时间之后出现timeout但onResfresh没有停止
加搜索功能???
功能小程序 指南针,计算器
