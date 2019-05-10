package com.example.myviewgroup;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Author:          zhaopan <BR/>
 * CreatedTime:     2019/4/8 <BR/>
 * Desc:            TODO <BR/>
 * <p/>
 * ModifyTime:      <BR/>
 * ModifyItems:     <BR/>
 *
 * @author zhaopan <BR/>
 */
public class MyTextView extends View {
    //要绘制的文字
    private  String mText;
    //文字颜色
    private  int mTextColor;
    //文字大小
    private  int mTextSize;
    //绘制时控制文本绘制范围
    private  Rect mBound;
    private Paint mPaint;

    public MyTextView(Context context) {
        this(context,null);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //获取自定义属性的值
        TypedArray a=context.obtainStyledAttributes(attrs,R.styleable.MyTextView, defStyleAttr,0);
        mText     =a.getString(R.styleable.MyTextView_mText);
        mTextColor=a.getColor(R.styleable.MyTextView_mTextColor, Color.BLACK);
        mTextSize = (int) a.getDimension(R.styleable.MyTextView_mTextSize,100);
        a.recycle();
        init();
    }

    public void init(){
        //设置画笔的文字大小和颜色
        mPaint=new Paint();
        mPaint.setTextSize(mTextSize);
        mPaint.setColor(mTextColor);
        mPaint.setTypeface(Typeface.DEFAULT_BOLD);

        mBound=new Rect();
        mPaint.getTextBounds(mText,0,mText.length(),mBound);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float BaseX=getWidth()/2-mBound.width()/2;
        float BaseY=(getHeight()-mBound.height())/2;
        canvas.drawText(mText,BaseX,BaseY,mPaint);
    }
}
