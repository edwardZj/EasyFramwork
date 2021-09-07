EasyFramwork是一个Android快速开发框架,集成了很多成熟好用的工具,做好了各种配置,组件化的结构
TemplateGradle.gradle是模板配置代码,组件引用之后,自己的grade里要做的事情基本很少了
settings.gradle使用CATALOG做好了仓库配置和版本统一管理
组件化框架使用Arouter,最小的代码侵入

//app是整个app的壳,主要是一些打包相关等的app全局的内容,初始化逻辑
include ':app'
//启动页,广告页组件
include ':Splash'
//首页组件
include ':MainPage'
//demo测试组件,不会打进正式包里
include ':Demo'
//基础UI库(基于XUI)
include ':UI:BaseUI'
//公共数据bean类库
include ':Module:BaseData'
//基础事件分发库(基于LiveEventBus)
include ':Tools:BaseEvent'
//debug工具类相关库,不会打进正式包里(leakcanary)
include ':Tools:Debuger'
//网络请求库(基于RxHttp)
include ':Tools:Net'
//图片相关库,图片加载,变换(基于Gradle)
include ':Tools:Image'
//通用工具库(很多实用的kotlin扩展方法)
include ':Tools:Utils'