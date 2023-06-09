# 카카오 로그인 API

카카오 로그인 API를 사용하여 로그인/로그아웃을 구현한 프로젝트입니다.

카카오 개발자 사이트에서 애플리케이션 등록을 한 후에 네이티브 앱 키를 아래 부분에 수정을 한 후 실행하면 됩니다.

KakaoApplication.java
```
KakaoSdk.init(this, "key");
```
AndroidManifest.xml
```
<data android:host="oauth" android:scheme="kakaoa[key]" />
```

Log.i(TAG, "debug keyhash is " + Utility.INSTANCE.getKeyHash(this));
```


