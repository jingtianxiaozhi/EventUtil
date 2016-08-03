package com.xiaozhi.eventutil.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.xiaozhi.eventutil.event.EventConstant;
import com.xiaozhi.eventutil.bean.Person;
import com.xiaozhi.eventutil.R;
import com.xiaozhi.eventutil_core.EventBusUtil;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity {

    @Bind(R.id.btn_send_str)
    Button btnSendStr;
    @Bind(R.id.btn_send_person)
    Button btnSendPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);
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
