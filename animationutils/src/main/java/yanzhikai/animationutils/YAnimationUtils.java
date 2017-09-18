package yanzhikai.animationutils;

import android.util.Log;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import java.lang.reflect.Field;
import java.util.ArrayList;

import static android.view.animation.Animation.ZORDER_BOTTOM;
import static android.view.animation.Animation.ZORDER_TOP;

/**
 * Created by yany on 2017/9/14.
 */

public class YAnimationUtils {
    public static final String TAG = "ymenuview";
    public static Animation reverseAnimation(Animation animation) {
        if (animation instanceof TranslateAnimation) {
            return reverseTranslateAnimation((TranslateAnimation) animation);
        }
        if (animation instanceof RotateAnimation){
            return reverseRotateAnimation((RotateAnimation) animation);
        }
        if (animation instanceof AlphaAnimation){
            return reverseAlphaAnimation((AlphaAnimation) animation);
        }
        if (animation instanceof ScaleAnimation){
            return reverseScaleAnimation((ScaleAnimation) animation);
        }
        if (animation instanceof AnimationSet){
            return reverseAnimationSet((AnimationSet) animation);
        }
        return null;
    }

    public static TranslateAnimation reverseTranslateAnimation(TranslateAnimation translateAnimation) {
        Class animationClass = translateAnimation.getClass();
        Field[] fields = animationClass.getDeclaredFields();
        float fromXValue = 0, toXValue = 0, fromYValue = 0, toYValue = 0;
        int fromXType = 0, toXType = 0, fromYType = 0, toYType =0;
        try {
            for (Field field : fields) {
                field.setAccessible(true);

                switch (field.getName()) {
                    case "mFromXValue":
                        fromXValue = (float) field.get(translateAnimation);
                        break;
                    case "mToXValue":
                        toXValue = (float) field.get(translateAnimation);
                        break;
                    case "mFromYValue":
                        fromYValue = (float) field.get(translateAnimation);
                        break;
                    case "mToYValue":
                        toYValue = (float) field.get(translateAnimation);
                        break;
                    case "mFromXType":
                        fromXType = (int) field.get(translateAnimation);
                        break;
                    case "mToXType":
                        toXType = (int) field.get(translateAnimation);
                        break;
                    case "mFromYType":
                        fromYType = (int) field.get(translateAnimation);
                        break;
                    case "mToYType":
                        toYType = (int) field.get(translateAnimation);
                        break;
                }

            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        TranslateAnimation newTranslateAnimation = new TranslateAnimation(
                 toXType,toXValue,fromXType,fromXValue
                ,toYType,toYValue,fromYType,fromYValue);
        Log.d("ymenuview", "reverseTranslateAnimation: fromYType " + fromYType + "fromYValue" + fromYValue);
//        newTranslateAnimation.setDuration(translateAnimation.getDuration());
        assimilate(translateAnimation,newTranslateAnimation);
        return newTranslateAnimation;
    }

    public static AlphaAnimation reverseAlphaAnimation(AlphaAnimation alphaAnimation) {
        Class animationClass = alphaAnimation.getClass();
        Field[] fields = animationClass.getDeclaredFields();
        float fromAlpha = 0, toAlpha = 0;
        try {
            for (Field field : fields) {
                field.setAccessible(true);

                switch (field.getName()) {
                    case "mFromAlpha":
                        fromAlpha = (float) field.get(alphaAnimation);
                        break;
                    case "mToAlpha":
                        toAlpha = (float) field.get(alphaAnimation);
                        break;
                }

                Log.d("ymenuview", "reverseAnimation: " + "name:" + field.getName() + "\t value = " + field.get(alphaAnimation));
//            String type = field.getType().toString();
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        AlphaAnimation newAlphaAnimation = new AlphaAnimation(toAlpha,fromAlpha);
        Log.d(TAG, "reverseAlphaAnimation: oldoffset " + alphaAnimation.getStartOffset());
//        newAlphaAnimation.setDuration(alphaAnimation.getDuration());
        assimilate(alphaAnimation,newAlphaAnimation);
        Log.d(TAG, "reverseAlphaAnimation: newOffset " + newAlphaAnimation.getStartOffset());
        return newAlphaAnimation;
    }

    public static Animation reverseRotateAnimation(RotateAnimation rotateAnimation){
        Class animationClass = rotateAnimation.getClass();
        Field[] fields = animationClass.getDeclaredFields();
        float fromDegrees = 0, toDegrees = 0, pivotXValue = 0, pivotYValue = 0;
        int pivotXType = 0, pivotYType = 0;
        try {
            for (Field field : fields) {
                field.setAccessible(true);

                switch (field.getName()) {
                    case "mFromDegrees":
                        fromDegrees = (float) field.get(rotateAnimation);
                        break;
                    case "mToDegrees":
                        toDegrees = (float) field.get(rotateAnimation);
                        break;
                    case "mPivotXValue":
                        pivotXValue = (float) field.get(rotateAnimation);
                        break;
                    case "mPivotYValue":
                        pivotYValue = (float) field.get(rotateAnimation);
                        break;
                    case "mPivotXType":
                        pivotXType = (int) field.get(rotateAnimation);
                        break;
                    case "mPivotYType":
                        pivotYType = (int) field.get(rotateAnimation);
                        break;
                }

            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        RotateAnimation newRotateAnimation = new RotateAnimation(
                toDegrees,fromDegrees
                ,pivotXType,pivotXValue
                ,pivotYType,pivotYValue);
//        newRotateAnimation.setDuration(rotateAnimation.getDuration());
        assimilate(rotateAnimation,newRotateAnimation);
        return newRotateAnimation;

    }

    public static Animation reverseScaleAnimation(ScaleAnimation scaleAnimation){
        Class animationClass = scaleAnimation.getClass();
        Field[] fields = animationClass.getDeclaredFields();
        float fromX = 0, toX = 0, fromY = 0, toY = 0, pivotXValue = 0, pivotYValue = 0;
        int pivotXType = 0, pivotYType = 0;
        try {
            for (Field field : fields) {
                field.setAccessible(true);

                switch (field.getName()) {
                    case "mFromX":
                        fromX = (float) field.get(scaleAnimation);
                        break;
                    case "mToX":
                        toX = (float) field.get(scaleAnimation);
                        break;
                    case "mFromY":
                        fromY = (float) field.get(scaleAnimation);
                        break;
                    case "mToY":
                        toY = (float) field.get(scaleAnimation);
                        break;
                    case "mPivotXValue":
                        pivotXValue = (float) field.get(scaleAnimation);
                        break;
                    case "mPivotYValue":
                        pivotYValue = (float) field.get(scaleAnimation);
                        break;
                    case "mPivotXType":
                        pivotXType = (int) field.get(scaleAnimation);
                        break;
                    case "mPivotYType":
                        pivotYType = (int) field.get(scaleAnimation);
                        break;
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        ScaleAnimation newScaleAnimation = new ScaleAnimation(toX,fromX,toY,fromY,pivotXType,pivotXValue,pivotYType,pivotYValue);
//        newScaleAnimation.setDuration(scaleAnimation.getDuration());
        assimilate(scaleAnimation,newScaleAnimation);
        return newScaleAnimation;
    }

    public static AnimationSet reverseAnimationSet(AnimationSet animationSet) {
        ArrayList<Animation> animations = (ArrayList<Animation>) animationSet.getAnimations();
        Class animationClass = animationSet.getClass();
        Field[] fields = animationClass.getDeclaredFields();
        //这里先手动设置true
        Log.d(TAG, "reverseAnimationSet: oldD" + animationSet.getStartOffset());
        AnimationSet newAnimationSet = new AnimationSet(true);
        for (Animation animation: animations){
            newAnimationSet.addAnimation(reverseAnimation(animation));
        }
//        newAnimationSet.setDuration(animationSet.getDuration());
//        assimilate(animationSet,newAnimationSet);
        Log.d(TAG, "reverseAnimationSet: newD" + newAnimationSet.getStartOffset());
        return newAnimationSet;
    }

    private static void assimilate(Animation oldOne, Animation newOne){
        Log.d(TAG, "assimilate: ");
        newOne.setDuration(oldOne.getDuration());
        newOne.setInterpolator(oldOne.getInterpolator());
        newOne.setStartOffset(oldOne.getStartOffset());
        newOne.setRepeatMode(oldOne.getRepeatMode());
        newOne.setRepeatCount(oldOne.getRepeatCount());
        newOne.setZAdjustment(oldOne.getZAdjustment());
        newOne.setDetachWallpaper(oldOne.getDetachWallpaper());
    }
}
