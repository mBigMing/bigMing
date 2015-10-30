package com.flowerfat.utiltool.Utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * Created by Bigflower on 2015/10/30.
 */
public class Util {

    /**
     * close the systemSoftInput
     * @param context usually, the activity
     * @param focusingView egg: the editText
     */
    public static void closeSoftInput(Context context, View focusingView) {
        InputMethodManager imm=(InputMethodManager)context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(focusingView.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);
    }

}
