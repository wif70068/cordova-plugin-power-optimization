package cordova.plugin.PowerOptimization;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Constants {

    private Context context;

    // Check regularly with https://stackoverflow.com/questions/48166206/how-to-start-power-manager-of-all-android-manufactures-to-enable-background-and

    // MIUI
    private static final String MIUI_ACTION_POWER_SAVE_EXTRA_NAME = "package_name";
    private static final String MIUI_ACTION_POWER_SAVE_EXTRA_LABEL = "package_label";
    private static final String[] MIUI_ACTION_POWERSAVE = {"com.miui.powerkeeper", "com.miui.powerkeeper.ui.HiddenAppsConfigActivity"};
    private static final String[] MIUI_ACTION_AUTOSTART = {"com.miui.securitycenter", "com.miui.permcenter.autostart.AutoStartManagementActivity"};

    // SAMSUNG crash "com.samsung.android.lool","com.samsung.android.sm.ui.battery.AppSleepListActivity"
    private static final String SAMSUNG_SYSTEMMANAGER_POWERSAVING_ACTION = "com.samsung.android.sm.ACTION_BATTERY";
    private static final String SAMSUNG_SYSTEMMANAGER_NOTIFICATION_ACTION = "com.samsung.android.sm.ACTION_SM_NOTIFICATION_SETTING";
    // SAMSUNG ANDROID 7.0
    private static final String SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V3 = "com.samsung.android.lool";
    private static final String SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V3_ACTIVITY = "com.samsung.android.sm.ui.battery.BatteryActivity";
    private static final String SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V4 = "com.samsung.android.lool";
    private static final String SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V4_ACTIVITY = "com.samsung.android.sm.battery.ui.BatteryActivity";
    
    // SAMSUNG ANDROID 6.0
    private static final String SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V2 = "com.samsung.android.sm_cn";
    private static final String SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V2_ACTIVITY = "com.samsung.android.sm.ui.battery.BatteryActivity";

    // SAMSUNG ANDROID 5.0/5.1
    private static final String SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V1 = "com.samsung.android.sm";
    private static final String SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V1_ACTIVITY = "com.samsung.android.sm.ui.battery.BatteryActivity";

    // HUAWEI
    private static final String HUAWEI_ACTION_POWERSAVING = "huawei.intent.action.HSM_PROTECTED_APPS";
    private static final String HUAWEI_COMPONENT_POWERSAVING_PKG = "com.huawei.systemmanager";
    private static final String HUAWEI_COMPONENT_POWERSAVING_CLS = "com.huawei.systemmanager.appcontrol.activity.StartupAppControlActivity";
    private static final String HUAWEI_COMPONENT_POWERSAVING2_CLS = "com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity";
    private static final String HUAWEI_COMPONENT_POWERSAVING3_CLS = "com.huawei.systemmanager.optimize.process.ProtectActivity";


    // LETV
    private static final String LETV_ACTION_POWERSAVING_PKG = "com.letv.android.letvsafe";
    private static final String LETV_ACTION_POWERSAVING_CLS = "com.letv.android.letvsafe.BackgroundAppManageActivity";
    private static final String LETV_ACTION_AUTOBOOT_CLS = "com.letv.android.letvsafe.AutobootManageActivity";

    // MEIZU
    private static final String MEIZU_POWERSAVING_ACTION = "com.meizu.power.PowerAppKilledNotification";
    private static final String MEIZU_DEFAULT_PACKAGE = "com.meizu.safe";
    private static final String MEIZU_POWERSAVING_ACTIVITY_V2_2 = "com.meizu.safe.cleaner.RubbishCleanMainActivity";
    private static final String MEIZU_POWERSAVING_ACTIVITY_V3_4 = "com.meizu.safe.powerui.AppPowerManagerActivity";
    private static final String MEIZU_POWERSAVING_ACTIVITY_V3_7 = "com.meizu.safe.powerui.PowerAppPermissionActivity";

    // ColorOS
    private static final String COLOROS_ACTION_POWERSAVING_PKG = "com.coloros.safecenter";
    private static final String COLOROS_ACTION_AUTOBOOT1_CLS = "com.coloros.safecenter.permission.startup.StartupAppListActivity";
    private static final String COLOROS_ACTION_AUTOBOOT2_CLS = "com.coloros.safecenter.startupapp.StartupAppListActivity";

    // OPPO
    private static final String OPPO_ACTION_POWERSAVING_PKG = "com.oppo.safe";
    private static final String OPPO_ACTION_POWERSAVING_CLS = "com.oppo.safe.permission.startup.StartupAppListActivity";

    // IQOO
    private static final String IQOO_ACTION_POWERSAVING_PKG = "com.iqoo.secure";
    private static final String IQOO_ACTION_POWERSAVING1_CLS = "com.iqoo.secure.ui.phoneoptimize.AddWhiteListActivity";
    private static final String IQOO_ACTION_POWERSAVING2_CLS = "com.iqoo.secure.ui.phoneoptimize.BgStartUpManager";

    // VIVO
    private static final String VIVO_ACTION_POWERSAVING_PKG = "com.vivo.permissionmanager";
    private static final String VIVO_ACTION_POWERSAVING_CLS = "com.vivo.permissionmanager.activity.BgStartUpManagerActivity";

    // HTC
    private static final String HTC_ACTION_POWERSAVING_PKG = "com.htc.pitroad";
    private static final String HTC_ACTION_POWERSAVING_CLS = "com.htc.pitroad.landingpage.activity.LandingPageActivity";

    //ASUS
    private static final String ASUS_ACTION_POWERSAVING_PKG = "com.asus.mobilemanager";
    private static final String ASUS_ACTION_POWERSAVING_CLS = "com.asus.mobilemanager.MainActivity";

    //TRANSSION
    private static final String TRANSSION_ACTION_POWERSAVING_PKG = "com.transsion.phonemanager";
    private static final String TRANSSION_ACTION_POWERSAVING_CLS = "com.itel.autobootmanager.activity.AutoBootMgrActivity";

    public ArrayList<Intent> powerManagerIntents;

    public Constants(Context context){
        this.context = context;
        populateList();
    }


    private void populateList(){

        // Xiaomi intents
        Intent xiomi_1 = new Intent();
        xiomi_1.setComponent(new ComponentName(MIUI_ACTION_AUTOSTART[0], MIUI_ACTION_AUTOSTART[1]));
        xiomi_1.putExtra(MIUI_ACTION_POWER_SAVE_EXTRA_NAME, context.getPackageName());
        xiomi_1.putExtra(MIUI_ACTION_POWER_SAVE_EXTRA_LABEL, getApplicationName());
        xiomi_1.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Intent xiomi_2 = new Intent();
        xiomi_2.setComponent(new ComponentName(MIUI_ACTION_POWERSAVE[0], MIUI_ACTION_POWERSAVE[1]));
        xiomi_2.putExtra(MIUI_ACTION_POWER_SAVE_EXTRA_NAME, context.getPackageName());
        xiomi_2.putExtra(MIUI_ACTION_POWER_SAVE_EXTRA_LABEL, getApplicationName());
        xiomi_2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Samsung intents
        Intent samsung_1 = new Intent();
        samsung_1.setAction(SAMSUNG_SYSTEMMANAGER_POWERSAVING_ACTION);
        samsung_1.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Intent samsung_2 = new Intent();
        samsung_2.setComponent(new ComponentName(SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V3, SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V3_ACTIVITY));
        samsung_2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Intent samsung_3 = new Intent();
        samsung_3.setComponent(new ComponentName(SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V2, SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V2_ACTIVITY));
        samsung_3.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Intent samsung_4 = new Intent();
        samsung_4.setComponent(new ComponentName(SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V1, SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V1_ACTIVITY));
        samsung_4.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        Intent samsung_5 = new Intent();
        samsung_5.setComponent(new ComponentName(SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V4, SAMSUNG_SYSTEMMANAGER_POWERSAVING_PACKAGE_V4_ACTIVITY));
        samsung_5.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Huawei
        Intent huawei_1 = new Intent();
        huawei_1.setAction(HUAWEI_ACTION_POWERSAVING);
        Intent huawei_2 = new Intent();
        huawei_2.setComponent(new ComponentName(HUAWEI_COMPONENT_POWERSAVING_PKG, HUAWEI_COMPONENT_POWERSAVING_CLS));
        Intent huawei_3 = new Intent();
        huawei_3.setComponent(new ComponentName(HUAWEI_COMPONENT_POWERSAVING_PKG, HUAWEI_COMPONENT_POWERSAVING2_CLS));
        Intent huawei_4 = new Intent();
        huawei_4.setComponent(new ComponentName(HUAWEI_COMPONENT_POWERSAVING_PKG, HUAWEI_COMPONENT_POWERSAVING3_CLS));

        // LeTV
        // TODO Test it
        Intent letv_1 = new Intent();
        letv_1.setComponent(new ComponentName(LETV_ACTION_POWERSAVING_PKG, LETV_ACTION_POWERSAVING_CLS));
        Intent letv_2 = new Intent();
        letv_2.setComponent(new ComponentName(LETV_ACTION_POWERSAVING_PKG, LETV_ACTION_AUTOBOOT_CLS));

        // Meizu
        // TODO Test it
        Intent meizu_1 = new Intent();
        meizu_1.setAction(MEIZU_POWERSAVING_ACTION);
        Intent meizu_2 = new Intent();
        meizu_2.setClassName(MEIZU_DEFAULT_PACKAGE, MEIZU_POWERSAVING_ACTIVITY_V2_2);
        Intent meizu_3 = new Intent();
        meizu_3.setClassName(MEIZU_DEFAULT_PACKAGE, MEIZU_POWERSAVING_ACTIVITY_V3_4);
        Intent meizu_4 = new Intent();
        meizu_4.setClassName(MEIZU_DEFAULT_PACKAGE, MEIZU_POWERSAVING_ACTIVITY_V3_7);

        // ColorOS
        // TODO Test it
        Intent coloros_1 = new Intent();
        coloros_1.setComponent(new ComponentName(COLOROS_ACTION_POWERSAVING_PKG, COLOROS_ACTION_AUTOBOOT1_CLS));
        Intent coloros_2 = new Intent();
        coloros_2.setComponent(new ComponentName(COLOROS_ACTION_POWERSAVING_PKG, COLOROS_ACTION_AUTOBOOT2_CLS));

        // OPPO
        // TODO Test it
        Intent oppo_1 = new Intent();
        oppo_1.setComponent(new ComponentName(OPPO_ACTION_POWERSAVING_PKG, OPPO_ACTION_POWERSAVING_CLS));

        // IQOO
        // TODO Test it
        Intent iqoo_1 = new Intent();
        iqoo_1.setComponent(new ComponentName(IQOO_ACTION_POWERSAVING_PKG, IQOO_ACTION_POWERSAVING1_CLS));
        Intent iqoo_2 = new Intent();
        iqoo_2.setComponent(new ComponentName(IQOO_ACTION_POWERSAVING_PKG, IQOO_ACTION_POWERSAVING2_CLS));

        // VIVO
        // TODO Test it
        Intent vivo_1 = new Intent();
        vivo_1.setComponent(new ComponentName(VIVO_ACTION_POWERSAVING_PKG, VIVO_ACTION_POWERSAVING_CLS));

        // HTC
        // TODO Test it
        Intent htc_1 = new Intent();
        htc_1.setComponent(new ComponentName(HTC_ACTION_POWERSAVING_PKG, HTC_ACTION_POWERSAVING_CLS));

        // ASUS
        // TODO Test it
        Intent asus_1 = new Intent();
        asus_1.setComponent(new ComponentName(ASUS_ACTION_POWERSAVING_PKG, ASUS_ACTION_POWERSAVING_CLS));

        // TRANSSION
        // TODO Test it
        Intent transsion_1 = new Intent();
        transsion_1.setComponent(new ComponentName(TRANSSION_ACTION_POWERSAVING_PKG, TRANSSION_ACTION_POWERSAVING_CLS));

        // TODO ASUS, Elephone, Sony STAMINA, Huawei Phone manager (EMUI 5)

        powerManagerIntents = new ArrayList<Intent>(Arrays.asList(
                xiomi_1,
                xiomi_2,
                //samsung_1,
                samsung_2,
                samsung_3,
                samsung_4,
                samsung_5,
                //huawei_1,
                huawei_3,
                huawei_4,
                huawei_2,
                letv_1,
                letv_2,
                //meizu_1,
                meizu_2,
                meizu_3,
                meizu_4,
                coloros_1,
                coloros_2,
                oppo_1,
                iqoo_1,
                iqoo_2,
                vivo_1,
                htc_1,
                asus_1,
                transsion_1
        ));
    }

    public ArrayList<Intent> getPowermanagerIntents(){
        return powerManagerIntents;
    }


    public String getApplicationName() {
        PackageManager packageManager = context.getPackageManager();
        ApplicationInfo applicationInfo = null;
        try {
            applicationInfo = packageManager.getApplicationInfo(context.getApplicationInfo().packageName, 0);
        } catch (final PackageManager.NameNotFoundException e) {
        }
        return (String) (applicationInfo != null ? packageManager.getApplicationLabel(applicationInfo) : "Unknown");
    }

}
