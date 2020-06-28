package com.zzht.fitapp2;

import java.math.RoundingMode;
import java.text.DecimalFormat;

class Utils {

    private static DecimalFormat dfs = null;
    public static DecimalFormat format(String pattern) {
        if (dfs == null) {
            dfs = new DecimalFormat();
        }
        dfs.setRoundingMode(RoundingMode.FLOOR);
        dfs.applyPattern(pattern);
        return dfs;
    }
}
