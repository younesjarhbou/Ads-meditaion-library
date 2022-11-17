
## how to use
copy all file into your android project


add those line into you gradle file
```gradle
 implementation project(':adslibrary')
```

host this json in any service you would like 

```json
 {
    "config" : {

    "activate_own_ads": "0",
    "open_app" : "open ads id",
    "admob_appid" : "admob app id",
    "admob_bn": ["admob banner id"],
    "admob_n": ["admob native id"],
    "admob_pub": "admob publisher id",
    "admob_r": ["admob reward id"],
    "admob_it": ["admob interstitial id"],
    "ironsrc_APP_KEY": "iron source app key",
    "fb_banner": ["facebook banner id"],
    "fb_inter_id": ["facebook interstitial id"],
    "fb_native": ["facebook native id"],
    "fb_reward": ["facebook reward id"],

      "apploving_reward_id" : "apploving reward id",
      "apploving_native" : "apploving native id",
      "apploving_banner" : "apploving banner id",
      "apploving_inter" : "apploving interstitial id",

      
      "ads" : [ "admob", "apploving", "admob","apploving","admob", "apploving", "admob", "apploving","admob", "apploving", "admob", "apploving","admob", "apploving", "admob", "apploving","admob", "apploving", "admob", "apploving","admob", "apploving", "admob", "apploving","admob", "apploving", "admob", "apploving","admob", "apploving", "admob", "apploving"],


      
      "ads_array_reward" : [  "admob", "apploving", "unity","admob", "apploving", "admob", "apploving","admob", "apploving", "admob", "apploving","admob", "apploving", "admob", "apploving","admob", "apploving", "admob", "apploving","admob", "apploving", "admob", "apploving"],
      "banner_ads" : [ "admob", "apploving", "admob", "apploving", "admob", "apploving", "admob", "apploving","admob", "apploving", "admob", "apploving","admob", "apploving", "admob", "apploving","admob", "apploving", "admob", "apploving"],

      
      "native_ads" : [ "apploving", "admob", "apploving", "admob","admob", "apploving", "admob", "apploving","admob", "apploving", "admob", "apploving","admob", "apploving", "admob", "apploving","admob", "apploving", "admob", "apploving","admob", "apploving", "admob", "apploving","admob", "apploving", "admob", "apploving"],
      "test" : "false",
      "unity_app_id" : "unity app id",

      "unity_bn_id" : "unity banner id",
      "unity_it_id" : "unity interstitial id",
      "unity_r_id" : "unity reward id",

      "you" : 1,

      "owninter_array" : [  
        
        {
      "own_inter_picture" : "https://i.ibb.co/80SDfmR/inter.png",
      "own_inter_link" : "https://play.google.com/store/apps/details?id=com.dailyspin.ffskintool"},
     {
          "own_inter_picture" : "https://i.ibb.co/8BhRXLg/inter.png",
          "own_inter_link" : "https://play.google.com/store/apps/details?id=com.dailyspin.coinspinmaster"}
      ],



      "ownbanner_array" : [  
        
        {
          "own_banner_picture" : "https://i.ibb.co/nRmrd9h/banner.png",
          "own_banner_link" : "https://play.google.com/store/apps/details?id=com.dailyspin.coinspinmaster"
    }
      ,
      {
        "own_banner_picture" : "https://i.ibb.co/Fg1Wc88/banner.png",
        "own_banner_link" : "https://play.google.com/store/apps/details?id=com.dailyspin.ffskintool"
      }
      ],

      "ownnative_array" : [  
        
        {
          "own_native_picture" : "https://i.ibb.co/mbK3njv/native.png",
          "own_native_link" : "https://play.google.com/store/apps/details?id=com.dailyspin.coinspinmaster"
    
    },
      {
        "own_native_picture" : "https://i.ibb.co/LCW4k9v/native.png",
        "own_native_link" : "https://play.google.com/store/apps/details?id=com.dailyspin.ffskintool"
      }
      ],

      "privacy" : "privacy policy link for admob"
     
    }
  }
  
```

in you splash screen add  this import 

```java
 import com.adslibrary.jarhbou.*;
```

after that add this line on your onCreate 
this line fetch data from json into our class model
```java
 config_ads.getdata(this, "jsonlink");
```

after the splash screen done you can this line to setup
all ads company at once with 
```java
my_own_ads.set_up_all(this);
```


all type of ads from inter, banner, native have array inside json you can choose wich one can be showen or not

look at this example to understand


```json
 "ads" : [ "admob", "apploving", "own", "ironsource", "untiy"],

```
in this example for interads
first call will show admob ads if its done successfully
second call will be apploving,
third one gonna be our own
and then go to ironsource
finally  unity ads and go back again to first choice
