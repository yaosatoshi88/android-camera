package com.eaglesakura.android.camera.log;

import com.eaglesakura.android.camera.BuildConfig;
import com.eaglesakura.log.Logger;
import com.eaglesakura.util.EnvironmentUtil;

import android.util.Log;

public class CameraLog {
    private static final Logger.Impl sAppLogger;

    static {
        if (EnvironmentUtil.isRunningRobolectric()) {
            sAppLogger = new Logger.RobolectricLogger() {
                @Override
                protected int getStackDepth() {
                    return super.getStackDepth() + 1;
                }
            };
        } else {
            sAppLogger = new Logger.AndroidLogger(Log.class) {
                @Override
                protected int getStackDepth() {
                    return super.getStackDepth() + 1;
                }
            }.setStackInfo(BuildConfig.DEBUG);
        }
    }


    public static void hardware(String fmt, Object... args) {
        String tag = "Camera.HW";
        Logger.out(Logger.LEVEL_DEBUG, tag, fmt, args);
    }
}
