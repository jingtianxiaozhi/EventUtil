# EventUtil
EventUtil是EventBus的辅助工具类库，免去了反复的registe/unregister以及编写onEventMainThread方法。

#Get It
```java  
compile 'com.jingtianxiaozhi.eventutil:eventutil-core:1.0.2'
```

#How To Use(Too Simple)
1.让需要接受事件的Activity/Fragment继承EventActivity/EventFragment。或者你也可以将对应的方法拷贝到你的BaseActivity中。
在oncreate方法中通过控制布尔变量isRegiste的值来控制是否注册事件。
```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    isRegiste = true;
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
    initEvent();
}
```
2.增加事件，第一个参数是当前Activity/Fragment，第二个参数是事件Id，第三个参数是事件回调也就是发生事件所需要执行的方法。
```java  
EventBusUtil.get().addConstantCallback(context, 10000, new EventBusCallback() {
    @Override
    public void operate(CareEvent careEvent) {
        //careEvent.paramObj就是你传递的对象，取出传递的对象进行对应的操作。
        if (careEvent.paramObj != null && careEvent.paramObj instanceof String) {
            Toast.makeText(context, (String) careEvent.paramObj, Toast.LENGTH_SHORT).show();
        }
    }
});
```

3.在需要发送事件的Activity(Fragment)中发送事件,第二个参数是任意你想传递的对象。
```java
EventBusUtil.post(10000, eventObject);
```
4.没有第4步了，是不是很简单，如果还有什么不明白的地方，可以下载源码查看demo。
#Tanks for
https://github.com/greenrobot/EventBus
