package com.mga.jcenterdemo;

import android.content.Context;

import com.ebupt.jlog.JLog;
import com.ebupt.jlog.constant.LogLevel;
import com.ebupt.jlog.constant.LogSegment;
import com.ebupt.jlog.constant.ZoneOffset;
import com.mobile.auth.gatewayauth.PhoneNumberAuthHelper;
import com.mobile.auth.gatewayauth.TokenResultListener;
import com.mobile.auth.gatewayauth.model.InitResult;

import java.util.ArrayList;
import java.util.List;

public class TestInc {
    public static final String TAG = "TestInc";

    public static void jlogTest(Context mContext) {
        List<LogLevel> logLevels = new ArrayList<>();
        logLevels.add(LogLevel.DEBUG);
        logLevels.add(LogLevel.WARN);
        logLevels.add(LogLevel.ERROR);
        logLevels.add(LogLevel.INFO);
        JLog.init(mContext)
                .setDebug(true)
                .setLogLevelsForFile(logLevels)
                .setLogSegment(LogSegment.TWENTY_FOUR_HOURS)
                .setCharset("UTF-8")
                .setTimeFormat("yyyy年MM月dd日 HH时mm分ss秒")
                .setZoneOffset(ZoneOffset.P0800);

        JLog.i(TAG, "invoking jlogTest()");
    }

    public static void aliTest(Context mContext) {

        TokenResultListener aListern = new TokenResultListener() {
            @Override
            public void onTokenSuccess(String s) {
                JLog.i(TAG, "获取token成功 onTokenSuccess, return::" + s);

            }

            @Override
            public void onTokenFailed(String s) {
                JLog.i(TAG, "获取token失败 " + s);

            }
        };

        PhoneNumberAuthHelper aHelper = PhoneNumberAuthHelper.getInstance(mContext, aListern);
        JLog.i(TAG, "ali ahelper=" + aHelper);
        InitResult autInitResult = aHelper.checkAuthEnvEnable();
        aHelper.setDebugMode(true);
        JLog.i(TAG, "invoking aliTest() ");
    }
}
