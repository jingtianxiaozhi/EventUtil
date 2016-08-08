package com.xiaozhi.eventutil.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.xiaozhi.eventutil.R;
import com.xiaozhi.eventutil.bean.Person;
import com.xiaozhi.eventutil.event.EventConstant;
import com.xiaozhi.eventutil.tool.ActivityManagers;
import com.xiaozhi.eventutil_core.CareEvent;
import com.xiaozhi.eventutil_core.EventBusCallback;
import com.xiaozhi.eventutil_core.EventBusUtil;
import com.xiaozhi.eventutil_core.controller.EventActivity;


import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FirstActivity extends EventActivity {

    @Bind(R.id.btn_go_to_sencond)
    Button btnGoToSencond;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        isRegiste = true;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initEvent();
    }

    public void initEvent(){
        EventBusUtil.get().addConstantCallback(FirstActivity.this, EventConstant.E_SEND_STRING_MSG_TO_FIRST, new EventBusCallback() {
            @Override
            public void operate(CareEvent careEvent) {
                if (careEvent.paramObj != null && careEvent.paramObj instanceof String) {
                    Toast.makeText(FirstActivity.this, "FirstActivity:" + (String) careEvent.paramObj, Toast.LENGTH_SHORT).show();
                }
            }
        });

        EventBusUtil.get().addConstantCallback(FirstActivity.this, EventConstant.E_SEND_PERSON_MSG_TO_FIRST, new EventBusCallback() {
            @Override
            public void operate(CareEvent careEvent) {
                if (careEvent.paramObj != null && careEvent.paramObj instanceof Person) {
                    Person person = (Person) careEvent.paramObj;
                    Toast.makeText(FirstActivity.this, "FirstActivity:" + person.getName() + "," + person.getAge(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @OnClick(R.id.btn_go_to_sencond)
    public void onClick() {
        ActivityManagers.startActivity(FirstActivity.this, SecondActivity.class);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
