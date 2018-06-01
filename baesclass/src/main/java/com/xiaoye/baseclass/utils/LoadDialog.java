package com.xiaoye.baseclass.utils;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.annotation.NonNull;

import com.xiaoye.baseclass.R;

public class LoadDialog extends Dialog{

    public LoadDialog(@NonNull Context context) {
        super(context, R.style.Dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.load_dialog);
        setCanceledOnTouchOutside(false);
    }

}
