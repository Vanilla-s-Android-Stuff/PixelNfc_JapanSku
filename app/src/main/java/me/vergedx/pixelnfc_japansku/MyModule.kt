package me.vergedx.pixelnfc_japansku

import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage

class MyModule : IXposedHookLoadPackage {
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        XposedBridge.log("Loaded app: " + lpparam.packageName)

        XposedHelpers.findAndHookMethod(
            "com.google.android.pixelnfc.provider.DeviceInfoContentProvider",
            lpparam.classLoader, "isDeviceJapanSku", String::class.java,

            object : XC_MethodHook() {
                override fun beforeHookedMethod(param: MethodHookParam?) {
                    XposedBridge.log("beforeHookedMethod")
                    super.beforeHookedMethod(param)
                }

                override fun afterHookedMethod(param: MethodHookParam?) {
                    XposedBridge.log("afterHookedMethod")
                    super.afterHookedMethod(param)
                }
            })
    }
}
