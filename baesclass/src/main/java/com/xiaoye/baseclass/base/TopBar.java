package com.xiaoye.baseclass.base;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.xiaoye.baseclass.R;

public class TopBar extends LinearLayout {
    private Context context;
    private TextView tv_title;
    private LinearLayout back;

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setWillNotDraw(false);
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        assert layoutInflater != null;
        layoutInflater.inflate(R.layout.topbar, this);
        initView();
        initAttrs(attrs);
        initEvent();
    }

    public void initView() {
        tv_title = findViewById(R.id.tv_title);
        back = findViewById(R.id.back);
    }

    private void initAttrs(AttributeSet attrs) {
        TypedArray a = null;
        try {
            a = context.obtainStyledAttributes(attrs, R.styleable.TopBar);
            int n = a.getIndexCount();
            for (int i = 0; i < n; i++) {
                int attr = a.getIndex(i);
                if (attr == R.styleable.TopBar_titleText) {
                    setText(a.getString(attr));
                }else if (attr == R.styleable.TopBar_titleTextSize) {
                    setTextSize(a.getInteger(attr, 14));
                }else if (attr == R.styleable.TopBar_backVisibility) {
                    setVisibility(a.getInt(attr, 0));
                }
            }
        } finally {
            if (null != a) {
                a.recycle();
            }
        }
    }

    public void initEvent() {
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((Activity) context).finish();
            }
        });
    }

    public void setText(CharSequence text){
        tv_title.setText(text);
    }

    public void setTextSize(float size){
        tv_title.setTextSize(size);
    }

    public void setVisibility(int visibility) {
        switch (visibility) {
            case 0:
                back.setVisibility(View.VISIBLE);
                break;
            case 1:
                back.setVisibility(View.INVISIBLE);
                break;
            case 2:
                back.setVisibility(View.GONE);
                break;
        }
    }
}