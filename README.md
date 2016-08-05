# EventUtil
EventUtil是EventBus的辅助工具类.

#Get It
```java  
compile 'com.jingtianxiaozhi.eventutil:eventutil-core:1.0.1'
```

#How To Use(Too simple)
1.让需要接受事件的Activity(Fragment)继承EventActivity(EventFragment)

2.增加事件,第一个参数是当前Activity(Fragment),第二个参数是事件Id,第三个参数是事件回调也就是发生事件所需要执行的方法。
```java  
EventBusUtil.get().addConstantCallback(context, 10000, new EventBusCallback() {
    @Override
    public void operate(CareEvent careEvent) {
        if (careEvent.paramObj != null && careEvent.paramObj instanceof String) {
            Toast.makeText(FirstActivity.this, (String) careEvent.paramObj, Toast.LENGTH_SHORT).show();
        }
    }
});
```

3.在需要发送事件的Activity(Fragment)中发送事件,第二个参数是任意你想传递的对象。
```java
EventBusUtil.post(10000, eventObject);
```
