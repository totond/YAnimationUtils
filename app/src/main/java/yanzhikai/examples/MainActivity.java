package yanzhikai.examples;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;

import yanzhikai.animationutils.YAnimationUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_startAnim,btn_startRotate,btn_startScale,btn_startTranslate,btn_set;
    private View view_test;
    private Animation alphaAnimation,rotateAnimation,scaleAnimation,translateAnimation,setAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_startAnim = (Button) findViewById(R.id.btn_startAlpha);
        btn_startRotate = (Button) findViewById(R.id.btn_startRotate);
        btn_startScale = (Button) findViewById(R.id.btn_startScale);
        btn_startTranslate = (Button) findViewById(R.id.btn_startTranslate);
        btn_set = (Button) findViewById(R.id.btn_startSet);

        view_test = findViewById(R.id.view_test);

        btn_startAnim.setOnClickListener(this);
        btn_startRotate.setOnClickListener(this);
        btn_startScale.setOnClickListener(this);
        btn_startTranslate.setOnClickListener(this);
        btn_set.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_startAlpha:
//                Animation alphaAnimation = new AlphaAnimation(1,0);
//                alphaAnimation.setDuration(1000);

                alphaAnimation = AnimationUtils.loadAnimation(this, R.anim.alpha);
                alphaAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        view_test.startAnimation(YAnimationUtils.reverseAnimation(alphaAnimation));
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                view_test.startAnimation(alphaAnimation);
                break;
            case R.id.btn_startRotate:
//                Animation rotateAnimation = new RotateAnimation(0,270,Animation.RELATIVE_TO_SELF,0.5f,Animation.ABSOLUTE,0);
//                rotateAnimation.setDuration(1000);

                rotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate);
                rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        //动画开始时执行
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        //动画结束时执行
                        view_test.startAnimation(YAnimationUtils.reverseAnimation(rotateAnimation));
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        //动画重复时执行
                    }
                });
                view_test.startAnimation(rotateAnimation);
                break;
            case R.id.btn_startScale:
//                Animation scaleAnimation = new ScaleAnimation(0,2,0,2,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//                scaleAnimation.setDuration(1000);
                scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale);
                scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        view_test.startAnimation(YAnimationUtils.reverseAnimation(animation));
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                view_test.startAnimation(scaleAnimation);
                break;
            case R.id.btn_startTranslate:

//                Animation translateAnimation = new TranslateAnimation(TranslateAnimation.RELATIVE_TO_SELF,0,
//                        TranslateAnimation.RELATIVE_TO_SELF,1,
//                        TranslateAnimation.RELATIVE_TO_SELF,0
//                        ,TranslateAnimation.RELATIVE_TO_SELF,1);
//                translateAnimation.setDuration(1000);
//                translateAnimation.setInterpolator(TweenActivity.this,anticipate_interpolator);

                translateAnimation = AnimationUtils.loadAnimation(this, R.anim.translate);
                translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        view_test.startAnimation(YAnimationUtils.reverseAnimation(animation));
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                view_test.startAnimation(translateAnimation);
                break;
            case R.id.btn_startSet:
//                AnimationSet setAnimation = new AnimationSet(true);
//
//                Animation alpha = new AlphaAnimation(1,0);
//                alpha.setDuration(3000);
//                alpha.setStartOffset(7000);
//
//                Animation rotate = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//                rotate.setDuration(1000);
//                rotate.setRepeatMode(Animation.RESTART);
//                rotate.setRepeatCount(Animation.INFINITE);
//
//                Animation translate = new TranslateAnimation(TranslateAnimation.RELATIVE_TO_PARENT,-0.5f,
//                        TranslateAnimation.RELATIVE_TO_PARENT,0.5f,
//                        TranslateAnimation.RELATIVE_TO_SELF,0
//                        ,TranslateAnimation.RELATIVE_TO_SELF,0);
//                translate.setDuration(10000);
//
//                Animation scale1 = new ScaleAnimation(1,0.5f,1,0.5f,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//                scale1.setDuration(1000);
//                scale1.setStartOffset(4000);
//                Animation scale2 = new ScaleAnimation(1,2,1,2,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
//                scale2.setDuration(1000);
//                scale2.setStartOffset(5000);
//
//                setAnimation.addAnimation(alpha);
//                setAnimation.addAnimation(rotate);
//                setAnimation.addAnimation(translate);
//                setAnimation.addAnimation(scale1);
//                setAnimation.addAnimation(scale2);
//                //因为在Rotate那里设置了RepeatCount为INFINITE，所以动画还不会结束，不会重复播放一次
//                // 所以下面两行的设置可以说是无效的，在这里纠结了一下，做下笔记
//                setAnimation.setRepeatMode(Animation.RESTART);
//                setAnimation.setRepeatCount(1);


                setAnimation = AnimationUtils.loadAnimation(this,R.anim.set);
                setAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        view_test.startAnimation(YAnimationUtils.reverseAnimation(setAnimation));
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                view_test.startAnimation(setAnimation);
        }
    }
}
