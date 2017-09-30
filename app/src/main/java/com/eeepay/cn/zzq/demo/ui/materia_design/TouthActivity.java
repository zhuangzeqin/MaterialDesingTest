package com.eeepay.cn.zzq.demo.ui.materia_design;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TouthActivity extends AppCompatActivity {

    private android.widget.Button button;
    private android.widget.TextView textView;
    float startX,startY;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touth);
        ConstraintLayout constraintLayout = (ConstraintLayout) findViewById(R.id.ctl);
        this.textView = (TextView) findViewById(R.id.textView);
        this.button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                if (textView.getVisibility()==View.GONE)
                {
                    textView.setVisibility(View.VISIBLE);
                }
                else
                {
                    textView.setVisibility(View.GONE);
                }
            }
        });


        constraintLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN://按下
                        startX=event.getRawX();//获得按下时的X坐标
                        startY=event.getRawY();//获得按下时的Y坐标
                        boolean zone = isInChangeTextViewZone(textView, (int) startX, (int) startY);
                        if (!zone)
                        {
                            textView.setVisibility(View.GONE);
                        }
                        break;
                    case MotionEvent.ACTION_MOVE://移动
                        startX=event.getRawX();//获得按下时的X坐标
                        startY=event.getRawY();//获得按下时的Y坐标
                        break;
                    case MotionEvent.ACTION_UP://释放
                        startX=event.getRawX();//获得按下时的X坐标
                        startY=event.getRawY();//获得按下时的Y坐标

                        break;
                }
                return false;
            }
        });
    }

    /**
     * 判断touch事件点是否在view范围内
     * @param view 是要判断的view
     * @param x
     * @param y
     * @return
     */
    private Rect mChangeTextViewBackgroundRect = null;
    private boolean isInChangeTextViewZone(View view, int x, int y) {
        if (null == mChangeTextViewBackgroundRect) {
            mChangeTextViewBackgroundRect = new Rect();//矩形
        }
        view.getDrawingRect(mChangeTextViewBackgroundRect);
        //getLeft , getTop, getBottom, getRight, 这一组是获取相对在它父亲里的坐标
        view.getTop();
        view.getLeft();
        view.getRight();
        view.getBottom();
        mChangeTextViewBackgroundRect.left = view.getLeft();
        mChangeTextViewBackgroundRect.top = view.getTop();
        mChangeTextViewBackgroundRect.right = mChangeTextViewBackgroundRect.right +  view.getRight();
        mChangeTextViewBackgroundRect.bottom = mChangeTextViewBackgroundRect.bottom +  view.getBottom();
        return mChangeTextViewBackgroundRect.contains(x, y);
    }
}
