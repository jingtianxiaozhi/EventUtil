package com.xiaozhi.eventutil.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.xiaozhi.eventutil.event.EventConstant;
import com.xiaozhi.eventutil.bean.Person;
import com.xiaozhi.eventutil.R;
import com.xiaozhi.eventutil_core.CareEvent;
import com.xiaozhi.eventutil_core.EventBusCallback;
import com.xiaozhi.eventutil_core.EventBusUtil;
import com.xiaozhi.eventutil_core.controller.EventActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends EventActivity {

    @Bind(R.id.btn_send_str)
    Button btnSendStr;
    @Bind(R.id.btn_send_person)
    Button btnSendPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        isRegiste = false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
        initEvent();
    }

    public void initEvent(){
        EventBusUtil.get().addConstantCallback(SecondActivity.this, EventConstant.E_SEND_STRING_MSG_TO_FIRST, new EventBusCallback() {
            @Override
            public void operate(CareEvent careEvent) {
                if (careEvent.paramObj != null && careEvent.paramObj instanceof String) {
                    Toast.makeText(SecondActivity.this, "SecondActivity" + (String) careEvent.paramObj, Toast.LENGTH_SHORT).show();
                }
            }
        });

        EventBusUtil.get().addConstantCallback(SecondActivity.this, EventConstant.E_SEND_PERSON_MSG_TO_FIRST, new EventBusCallback() {
            @Override
            public void operate(CareEvent careEvent) {
                if (careEvent.paramObj != null && careEvent.paramObj instanceof Person) {
                    Person person = (Person) careEvent.paramObj;
                    Toast.makeText(SecondActivity.this, "SecondActivity" + person.getName() + "," + person.getAge(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @OnClick({R.id.btn_send_str, R.id.btn_send_person})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_send_str:
                EventBusUtil.post(EventConstant.E_SEND_STRING_MSG_TO_FIRST, "哈哈哈我是文字");
                break;
            case R.id.btn_send_person:
                Person person = new Person();
                person.setName("Android爱好者");
                person.setAge(24);
                EventBusUtil.post(EventConstant.E_SEND_PERSON_MSG_TO_FIRST, person);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
