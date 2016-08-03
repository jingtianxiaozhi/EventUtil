package com.xiaozhi.eventutil.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import com.xiaozhi.eventutil.R;
import com.xiaozhi.eventutil.bean.Person;
import com.xiaozhi.eventutil.event.EventConstant;
import com.xiaozhi.eventutil.tool.ActivityManagers;
import com.xiaozhi.eventutil_core.CareEvent;
import com.xiaozhi.eventutil_core.EventBusUtil;

import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FirstActivity extends AppCompatActivity {

    @Bind(R.id.btn_go_to_sencond)
    Button btnGoToSencond;
    private ArrayList<Integer> eventConstants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBusUtil.register(this);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
//        eventConstants = new ArrayList<>();
//        eventConstants.add(EventConstant.E_SEND_STRING_MSG_TO_FIRST);
//        eventConstants.add(EventConstant.E_SEND_PERSON_MSG_TO_FIRST);
    }


//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onEventMainThread2(CareEvent<Person> careEvent) {
//        switch (careEvent.what) {
//            case EventConstant.E_SEND_STRING_MSG_TO_FIRST: {
//                if (careEvent.paramObj != null) {
//                    Toast.makeText(FirstActivity.this, careEvent.paramObj.getName() + "," + careEvent.paramObj.getAge(), Toast.LENGTH_SHORT).show();
//                }
//                break;
//            }
//        }
//    }
//
//
//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onEventMainThread1(CareEvent<String> careEvent) {
//        switch (careEvent.what) {
//            case EventConstant.E_SEND_STRING_MSG_TO_FIRST: {
//                if (careEvent.paramObj != null) {
//                    Toast.makeText(FirstActivity.this, careEvent.paramObj, Toast.LENGTH_SHORT).show();
//                }
//                break;
//            }
//
//        }
//    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(CareEvent careEvent) {
        switch (careEvent.what) {
            case EventConstant.E_SEND_STRING_MSG_TO_FIRST: {
                if (careEvent.paramObj != null && careEvent.paramObj instanceof String) {
                    Toast.makeText(FirstActivity.this, (String) careEvent.paramObj, Toast.LENGTH_SHORT).show();
                }
                break;
            }
            case EventConstant.E_SEND_PERSON_MSG_TO_FIRST: {
                if (careEvent.paramObj != null && careEvent.paramObj instanceof Person) {
                    Person person = (Person) careEvent.paramObj;
                    Toast.makeText(FirstActivity.this, person.getName() + "," + person.getAge(), Toast.LENGTH_SHORT).show();
                }
                break;
            }
        }
    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    public void onEventMainThread4(CareEvent careEvent) {
//        for (int i = 0; i < eventConstants.size(); i++) {
//            if (careEvent.what == eventConstants.get(i)) {
//                if (careEvent.paramObj != null && careEvent.paramObj instanceof String) {
//                    Toast.makeText(FirstActivity.this, (String) careEvent.paramObj, Toast.LENGTH_SHORT).show();
//                }
//                if (careEvent.paramObj != null && careEvent.paramObj instanceof Person) {
//                    Person person = (Person) careEvent.paramObj;
//                    Toast.makeText(FirstActivity.this, person.getName() + "," + person.getAge(), Toast.LENGTH_SHORT).show();
//                }
//            }
//        }
//    }

    @OnClick(R.id.btn_go_to_sencond)
    public void onClick() {
        ActivityManagers.startActivity(FirstActivity.this, SecondActivity.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBusUtil.unregister(this);
    }
}
