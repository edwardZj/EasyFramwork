-keep @com.xuexiang.xaop.annotation.* class * {*;}
-keep @org.aspectj.lang.annotation.* class * {*;}
-keep class * {
    @com.xuexiang.xaop.annotation.* <fields>;
    @org.aspectj.lang.annotation.* <fields>;
}
-keepclassmembers class * {
    @com.xuexiang.xaop.annotation.* <methods>;
    @org.aspectj.lang.annotation.* <methods>;
}