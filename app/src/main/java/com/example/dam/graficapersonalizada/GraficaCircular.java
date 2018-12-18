package com.example.dam.graficapersonalizada;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class GraficaCircular extends View {

    private final int DEFAULT_SIZE = 50;
    private int width, height;
    private int graphColor = Color.YELLOW;
    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int percentage;

    public GraficaCircular(Context context) {
        super(context);
    }

    public GraficaCircular(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        TypedArray ta = this.getContext().obtainStyledAttributes(attrs,
                R.styleable.GraficaCircular);
        this.percentage = ta.getInt(R.styleable.GraficaCircular_percentage,
                0);
        ta.recycle();
    }

    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        paint.setColor(graphColor);
        paint.setStyle(Paint.Style.FILL);
        float radius = width / 2f;
        canvas.drawCircle(width / 2f, height / 2f, radius, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        /*width=DEFAULT_SIZE;
        height=DEFAULT_SIZE;
        //llamada obligatoria con el tamaño del componente
        setMeasuredDimension(width, height);*/
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        width = DEFAULT_SIZE;
        height = DEFAULT_SIZE;
        switch(widthMode) {
            case MeasureSpec.EXACTLY:// dp o match_constraint
                width=widthSize;
                break;
            case MeasureSpec.AT_MOST: //wrap_content
                if (width > widthSize) {
                    width = widthSize;
                }
                break;
        }
        switch(heightMode) {
            case MeasureSpec.EXACTLY:
                height=heightSize;
                break;
            case MeasureSpec.AT_MOST:
                if (height > heightSize) {
                    height = heightSize;
                }
                break;
        }
        this.setMeasuredDimension(width, height);
    }
}
