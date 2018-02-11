package text.com.loadingdemo;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button start ,end;
    private LoadingView mLoadingView;


    public void showLoadView() {
        if (findViewById(R.id.mLoadingView) != null) {
            mLoadingView = (LoadingView) findViewById(R.id.mLoadingView);
            mLoadingView.setVisibility(View.VISIBLE);
            mLoadingView.start();
        }
    }


    /**
     * 关闭加载框
     */
    public void hideLoadView() {
        if (mLoadingView != null) {
            mLoadingView.setVisibility(View.GONE);
            mLoadingView.close();
        } else {
            if (findViewById(R.id.mLoadingView) != null) {
                mLoadingView = (LoadingView) findViewById(R.id.mLoadingView);
                mLoadingView.setVisibility(View.GONE);
                mLoadingView.close();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.start);
        end = findViewById(R.id.end);
        start.setOnClickListener(this);
        end.setOnClickListener(this);




    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.start:
                showLoadView();


                break;
            case R.id.end:
                hideLoadView();
                break;
        }
    }





}
