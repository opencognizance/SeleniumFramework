package org.framework.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GeneralUtility {
    public static String getTimeStamp(){
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("HH_mm_ss_yyyy_MM_dd");
        return formatter.format(date);
    }
}
