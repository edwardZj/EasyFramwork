#glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
-dontwarn com.bumptech.glide.load.resource.bitmap.VideoDecoder
# for DexGuard only
#-keepresourcexmlelements manifest/application/meta-data@value=GlideModule
#最后，你应该在你的 proguard.cfg 中 keep 住你的 AppGlideModule 实现：
#-keep public class * extends com.bumptech.glide.module.AppGlideModule
#-keep class com.bumptech.glide.GeneratedAppGlideModuleImpl