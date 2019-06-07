package jp.ac.titech.itpro.sdl.startservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private final static String TAG = MainActivity.class.getSimpleName();
    public final static String ACTION_ANSWER = "MYACT";
    public final static String EXTRA_ANSWER = "MYEX";
    public MyBroadcastReceiver receiver;
    public IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate in " + Thread.currentThread());
        setContentView(R.layout.activity_main);

        receiver = new MyBroadcastReceiver();
        intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_ANSWER);
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(receiver, intentFilter);
    }

    public void onClickTest1(View v) {
        Log.d(TAG, "onClickTest1 in " + Thread.currentThread());
        Intent intent = new Intent(this, Service1.class);
        intent.putExtra(Service1.EXTRA_MYARG, "Hello, Service1");
        startService(intent);
    }

    public void onClickTest2(View v) {
        Log.d(TAG, "onClickTest2 in " + Thread.currentThread());
        Intent intent = new Intent(this, Service2.class);
        intent.putExtra(Service2.EXTRA_MYARG, "Hello, Service2");
        startService(intent);
    }

    public void onClickTest3(View v) {
        Log.d(TAG, "onClickTest3 in " + Thread.currentThread());
        Intent intent = new Intent(this, Service3.class);
        intent.putExtra(Service3.EXTRA_MYARG, "Hello, Service3");
        startService(intent);
    }

    public class MyBroadcastReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d(TAG, intent.getStringExtra(EXTRA_ANSWER));
        }
    }
}
