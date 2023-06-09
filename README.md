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



![API_1](https://github.com/Hongseohyun/mobile_coffee/assets/96035605/e47ee66c-7e35-4443-99c2-af1869a66f75)
![API_2](https://github.com/Hongseohyun/mobile_coffee/assets/96035605/fd62b3d6-8984-41c6-9275-4b4414000480)
![API_3](https://github.com/Hongseohyun/mobile_coffee/assets/96035605/0921d1d5-3055-4ad2-9ca9-860430805fa2)
![API_4](https://github.com/Hongseohyun/mobile_coffee/assets/96035605/a12ce1b2-62e5-46e5-82c0-877253a4d82b)
![API_5](https://github.com/Hongseohyun/mobile_coffee/assets/96035605/819926c2-554b-4e58-9da8-07186283729b)
![API_6](https://github.com/Hongseohyun/mobile_coffee/assets/96035605/db415b8a-92e6-4190-9db3-927fecb4933b)
![API_7](https://github.com/Hongseohyun/mobile_coffee/assets/96035605/4a8923b8-98b4-4c5b-a4a6-16453cda36b8)
![API_8](https://github.com/Hongseohyun/mobile_coffee/assets/96035605/6b83390d-b500-41fa-9581-18a36c7c5961)

https://github.com/Hongseohyun/mobile_coffee/assets/96035605/8a2ae948-c0b1-4603-b9a1-84b88fb93927


