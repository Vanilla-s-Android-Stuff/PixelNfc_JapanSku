package me.vergedx.pixelnfc_japansku

import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodReplacement
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage

@Suppress("unused")
class MyModule : IXposedHookLoadPackage {
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        XposedHelpers.findAndHookMethod(
            "com.google.android.pixelnfc.provider.DeviceInfoContentProvider",
            lpparam.classLoader, "isDeviceJapanSku", String::class.java,

            object : XC_MethodReplacement() {
                override fun replaceHookedMethod(param: MethodHookParam?): Any {
                    return true
                }
            })
    }
}
