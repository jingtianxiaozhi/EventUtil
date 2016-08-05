# EventUtil
EventUtil是EventBus的辅助工具类

#Get It
```java  
compile 'com.jingtianxiaozhi.eventutil:eventutil-core:1.0.1'
```

#How To Use(Too simple)
1.让你的Activity(Fragment)继承EventActivity(EventFragment)

2.
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
