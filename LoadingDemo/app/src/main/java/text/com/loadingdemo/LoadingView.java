package text.com.loadingdemo;


import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by zzz40500 on 15/4/6.
 */
public class LoadingView extends RelativeLayout {

    private AnimationDrawable animationDrawable;

    private TextView loadText;

    ImageView img;

    public LoadingView(Context context) {
        super(context);
    }

    public LoadingView(Context context, AttributeSet attrs) {
        super(context, attrs, 0);
        init(context, attrs);

    }

    private void init(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.load_img_layout, this, true);
        img = (ImageView) findViewById(R.id.img);
        loadText = (TextView) findViewById(R.id.loadText);
        img.setImageResource(R.drawable.load_anim);
        animationDrawable = (AnimationDrawable) img.getDrawable();

    }


    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public LoadingView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    public int dip2px(float dipValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }


    public void start() {

        if (animationDrawable == null) {
            animationDrawable = (AnimationDrawable) img.getDrawable();
        }
        if (animationDrawable != null)
            animationDrawable.start();
    }

    public void close() {
        if (animationDrawable != null) {
            animationDrawable.stop();
        }
    }

    public void setLoadingText(CharSequence loadingText) {
        if (!TextUtils.isEmpty(loadingText)) {
            loadText.setText(loadingText);
        }
    }
}
