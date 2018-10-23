package com.lesnyg.edu.mytouchevent;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

class MyView extends View{
    int key;
    String str;
    int x=100,y=100;
    public MyView(Context context){
        super(context);
        setBackgroundColor(Color.YELLOW);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        x=(int)event.getX();
        y=(int)event.getY();
        if(event.getAction()==MotionEvent.ACTION_DOWN)
            str="액션다운";
        if(event.getAction()==MotionEvent.ACTION_MOVE)
            str="액션무브";
        if(event.getAction()==MotionEvent.ACTION_UP)
            str="액션업";
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setTextSize(40);
        canvas.drawCircle(x,y,70,paint);
        canvas.drawText("("+x+","+y+")액션종류:"+str,2,100,paint);
        super.onDraw(canvas);
    }
}
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyView myView=new MyView(this);
        setContentView(myView);
    }
}
