package com.adslibrary.jarhbou;


import static com.ironsource.mediationsdk.IronSource.isInterstitialReady;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ProcessLifecycleOwner;

import com.applovin.mediation.MaxAd;
import com.applovin.mediation.MaxAdListener;
import com.applovin.mediation.MaxAdViewAdListener;
import com.applovin.mediation.MaxError;
import com.applovin.mediation.MaxReward;
import com.applovin.mediation.MaxRewardedAdListener;
import com.applovin.mediation.ads.MaxAdView;
import com.applovin.mediation.ads.MaxInterstitialAd;
import com.applovin.mediation.ads.MaxRewardedAd;
import com.applovin.mediation.nativeAds.MaxNativeAdListener;
import com.applovin.mediation.nativeAds.MaxNativeAdLoader;
import com.applovin.mediation.nativeAds.MaxNativeAdView;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import com.bumptech.glide.Glide;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdOptionsView;
import com.facebook.ads.MediaView;
import com.facebook.ads.NativeAd;
import com.facebook.ads.NativeAdListener;
import com.facebook.ads.RewardedVideoAd;
import com.google.ads.consent.ConsentForm;
import com.google.ads.consent.ConsentFormListener;
import com.google.ads.consent.ConsentInfoUpdateListener;
import com.google.ads.consent.ConsentInformation;
import com.google.ads.consent.ConsentStatus;
import com.google.android.ads.nativetemplates.NativeTemplateStyle;
import com.google.android.ads.nativetemplates.TemplateView;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.ironsource.mediationsdk.ISBannerSize;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.IronSourceBannerLayout;
import com.ironsource.mediationsdk.integration.IntegrationHelper;
import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.sdk.OfferwallListener;
import com.unity3d.ads.IUnityAdsListener;
import com.unity3d.ads.UnityAds;
import com.unity3d.services.banners.BannerErrorInfo;
import com.unity3d.services.banners.BannerView;
import com.unity3d.services.banners.UnityBannerSize;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

//import com.startapp.sdk.ads.banner.Banner;
//import com.startapp.sdk.ads.banner.BannerListener;
//import com.startapp.sdk.adsbase.StartAppAd;
//import com.startapp.sdk.adsbase.StartAppSDK;

public  class my_own_ads {

    public static final String TAG = "my_own_ads_2021";
    public static NativeAd nativeAd;
    public  static  View nativeview;
    public static InterstitialAd mInterstitialAd;
    public static com.facebook.ads.InterstitialAd interstitialAd;
    public static Handler mHandlerSleep = new Handler();
    public static int counter = 0;
    private static AdView mAdView;
    public static ConsentForm form;
    //  public  static Context context_;
    public static com.facebook.ads.NativeAdLayout nativeAdLayout;
    public static LinearLayout adView;
    public static com.facebook.ads.AdView adView_banner_fb;
    //   public AdView mAdView;
    public static int unity_startappcmp = 0;
    private static Runnable handlerTask;
    private static Handler handler;
    public static Context contextbanner;
    public static Context context_inter;
    public static AdView adView2;
    public static int ads_counter = 0;
    public static UnityBannerListener bannerListener = new UnityBannerListener();
    public static RelativeLayout bottomBannerView;
    public static BannerView bottomBanner;
    public static LinearLayout banner1;
    public static LinearLayout banner2;
    //public  static  String bannertype=
    public  static  int banner_index = 0;
    public  static int native_index = 0 ;
    public  static  Dialog dialog ;
    public static MaxRewardedAd rewardedAd;
    //    public static StartAppAd startAppAd;
//    public static void setup_inter_startapp(Context context){
//
//        StartAppSDK.init(context, "200622753", true);
//        StartAppSDK.enableReturnAds(false);
//        StartAppAd.disableSplash();
//        startAppAd = new StartAppAd(context);
//
//
//       // StartAppAd.showAd(context);
//
//    }
    public  static Context context_startapp_banner;
    //    public static void show_inter_startapp(Context context){
//context_startapp_banner=context;
//
//       // StartAppAd.disableSplash();
//         StartAppAd.showAd(context);
//
//    }
//    public static void
//    banner_start_app(Context context){
//        // Get the Main relative layout of the entire activity
//        Activity activity = (Activity) context;
//        LinearLayout mainLayout = (LinearLayout)activity.findViewById(R.id.banner_container);
//// Define StartApp Banner
//     //   Banner startAppBanner = new Banner(context);
//        RelativeLayout.LayoutParams bannerParameters =
//                new RelativeLayout.LayoutParams(
//                        RelativeLayout.LayoutParams.WRAP_CONTENT,
//                        RelativeLayout.LayoutParams.WRAP_CONTENT);
//        bannerParameters.addRule(RelativeLayout.CENTER_HORIZONTAL);
//        bannerParameters.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
//// Add to main Layout
//    //    mainLayout.addView(startAppBanner, bannerParameters);
//
//    }
//
//   // Banner startAppBanner = new Banner(context_startapp_banner, new BannerListener() {
//        @Override
//        public void onReceiveAd(View banner) {
//            // banner is ready. Add it to your view if needed
//        }
//        @Override
//        public void onFailedToReceiveAd(View banner) {
//        }
//
//        @Override
//        public void onImpression(View view) {
//
//        }
//
//        @Override
//        public void onClick(View banner) {
//        }
//    });

    public  static Context setupcontext;
    private static LinearLayout nativelayout;
    private static int nativetype=1;
    private static int ads_counter_reward=0;
    public static int admob_banner_p;

    public static void setup_inter(Context context) {
        MobileAds.initialize(context, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

                //  MediationTestSuite.launch(context);

                Map<String, AdapterStatus> statusMap = initializationStatus.getAdapterStatusMap();
                for (String adapterClass : statusMap.keySet()) {
                    AdapterStatus status = statusMap.get(adapterClass);
                    Log.e("MyApp", String.format(
                            "Adapter name: %s, Description: %s, Latency: %d",
                            adapterClass, status.getDescription(), status.getLatency()));
                }
            }
        });
//        mInterstitialAd= new InterstitialAd(context);
//
//        mInterstitialAd.setAdUnitId(config.admob_it);
//        mInterstitialAd.loadAd(new AdRequest.Builder().build());
////admobe gdpr
        ConsentInformation consentInformation = ConsentInformation.getInstance(context);
        String[] publisherIds = {config.admob_pub};
        List<String> testDeviceIds = Arrays.asList("46281ac0-899f-457f-a397-ce80967b626d");
        RequestConfiguration configuration =
                new RequestConfiguration.Builder().setTestDeviceIds(testDeviceIds).build();
        MobileAds.setRequestConfiguration(configuration);


        consentInformation.requestConsentInfoUpdate(publisherIds, new ConsentInfoUpdateListener() {


            @Override
            public void onConsentInfoUpdated(ConsentStatus consentStatus) {

            }

            @Override
            public void onFailedToUpdateConsentInfo(String errorDescription) {
                // User's consent status failed to update.
            }
        });

        URL privacyUrl = null;
        try {
            Activity activity = (Activity) context;
            // TODO: Replace with your app's privacy policy URL.
            privacyUrl = new URL(config.privacy);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            // Handle error.
        }
        form = new ConsentForm.Builder(context, privacyUrl
        )
                .withListener(new ConsentFormListener() {
                    @Override
                    public void onConsentFormLoaded() {
                        // Consent form loaded successfully.
                        form.show();
                    }

                    @Override
                    public void onConsentFormOpened() {
                        // Consent form was displayed.
                    }

                    @Override
                    public void onConsentFormClosed(
                            ConsentStatus consentStatus, Boolean userPrefersAdFree) {
                        // Consent form was closed.
                    }

                    @Override
                    public void onConsentFormError(String errorDescription) {
                        // Consent form error.
                    }
                })
                .withPersonalizedAdsOption()
                .withNonPersonalizedAdsOption()
                .withAdFreeOption()
                .build();

        form.load();


///3Dunity ilitialise
        // Declare a new listener:

    }
    static int setup_inter_fb_p = 0;
    public static void setup_inter_unity(Context context) {
        final UnityAdsListener myAdsListener = new UnityAdsListener();
        // Add the listener to the SDK:
        UnityAds.addListener((IUnityAdsListener) myAdsListener);
        // Initialize the SDK:
        Log.e( "setup_inter_unity: ", config.unity_app_id+"//"+ config.test );
//        boolean b = config.test;
        UnityAds.initialize((Activity) context, config.unity_app_id, config.test);
        UnityAds.load(config.unity_it_id);
        UnityAds.load(config.unity_bn_id);
        UnityAds.load(config.unity_r_id);

    }

    public static void set_up_all(Context context) {
        setupcontext=context;


        try{

            setup_inter(context);
            setup_inter_unity(context);
            setupapploving(context);
            setupironsrc(context);
        }catch (Exception E){
            Log.e( "set_up_all: ",E.getMessage());
        }
        ///**/  admob_banner();

        load_all(context);
    }
    public  static  void setupapploving(final Context context){

        // Please make sure to set the mediation provider value to "max" to ensure proper functionality
        AppLovinSdk.getInstance( context ).setMediationProvider( "max" );
        AppLovinSdk.initializeSdk( context, new AppLovinSdk.SdkInitializationListener() {
            @Override
            public void onSdkInitialized(final AppLovinSdkConfiguration configuration)
            {
                // AppLovin SDK is initialized, start loading ads
                apploving apploving = new apploving();
                apploving.createRewardedAd(context);

            }
        } );
        //  AppLovinSdk.getInstance(context).getSettings().setTestDeviceAdvertisingIds(Arrays.asList("YOUR_GAID_HERE"));
    }


    public static void load_all(Context context)
     {
        load_inter_admobe(context);
        load_applovinginter(context);
        loadironInter(true);
        load_reward_admob(context);
        load_reward_unity(context);
        load_apploving_reward(context);
        ironsrc_reward(context);
    }
    public static void load_applovinginter(Context context)
    {
        applovingadsclass = new applovingadsclass();
        applovingadsclass.createInterstitialAd(context);
    }
    public static void load_inter_admobe(final Context context) {


        if(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            AdRequest adRequest = new AdRequest.Builder().build();

            InterstitialAd.load(context, config.admob_it.get(inter_admobe_p), adRequest,
                    new InterstitialAdLoadCallback() {

                        @Override
                        public void onAdLoaded(@NonNull InterstitialAd interstitialAd) {
                            // The mInterstitialAd reference will be null until
                            // an ad is loaded.
                            mInterstitialAd = interstitialAd;
                            Log.i(TAG, "onAdLoaded");
                        }

                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            // Handle the error
                            Log.d(TAG, loadAdError.toString());
                            mInterstitialAd = null;


                        }

                    });


        }
    }
    public static void loadironInter(final boolean reload) {
        if(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            IronSource.setInterstitialListener(new com.ironsource.mediationsdk.sdk.InterstitialListener() {
                /**
                 * Invoked when Interstitial Ad is ready to be shown after load function was called.
                 */
                @Override
                public void onInterstitialAdReady() {
                    //showironInter(context_inter);
                }

                /**
                 * invoked when there is no Interstitial Ad available after calling load function.
                 */
                @Override
                public void onInterstitialAdLoadFailed(IronSourceError error) {
                    Log.e("faildironsrcinter: ", error.getErrorMessage() + error.getErrorCode());
                    //   tapdaqinter(context_inter);
                  //  inter_unity(context_inter);
                }

                /**
                 * Invoked when the Interstitial Ad Unit is opened
                 */
                @Override
                public void onInterstitialAdOpened() {
                }

                /*
                 * Invoked when the ad is closed and the user is about to return to the application.
                 */
                @Override
                public void onInterstitialAdClosed() {

                    if (reload) {

                    /*new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            // this code will be executed after 2 seconds
                        }
                    }, 5000);*/

                        loadironInter(true);
                    }
                }

                /**
                 * Invoked when Interstitial ad failed to show.
                 *
                 * @param error - An object which represents the reason of showInterstitial failure.
                 */
                @Override
                public void onInterstitialAdShowFailed(IronSourceError error) {
                }

                /*
                 * Invoked when the end user clicked on the interstitial ad, for supported networks only.
                 */
                @Override
                public void onInterstitialAdClicked() {
                }

                /**
                 * Invoked right before the Interstitial screen is about to open.
                 * NOTE - This event is available only for some of the networks.
                 * You should NOT treat this event as an interstitial impression, but rather use InterstitialAdOpenedEvent
                 */
                @Override
                public void onInterstitialAdShowSucceeded() {
                }
            });

            IronSource.loadInterstitial();
        }
    }




    public static void showironInter(Context context) {
        if(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            if (!isInterstitialReady()) {
                loadironInter(true);
                // IronSource.loadInterstitial();

//            return;
            }
            Activity activity = (Activity) context;
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    if (isInterstitialReady()) {
                        IronSource.showInterstitial("DefaultInterstitial");
                    } else {
                        inter_unity(context);
                    }
                }
            });
        }
    }

    public static void applovinginter(Context context)
    {
        applovingadsclass = new applovingadsclass();
        applovingadsclass.setInterstitialAd();
    }
    public static void inter_unity(Context context) {

        if(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            Log.e("inter_unity: ", "inter_unity");
            if (UnityAds.isReady(config.unity_it_id)) {
                Activity activity = (Activity) context;
                UnityAds.show(activity, config.unity_it_id);
                unity_startappcmp++;
                counter++;
            } else {
                UnityAds.load(config.unity_it_id);
                own_inter(context);
            }

        }
    }
    static  int inter_admobe_p = 0;
    public static void inter_admobe(final Context context) {


        if(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {

            try {
                if (mInterstitialAd != null) {
                    mInterstitialAd.show((Activity) context);
                } else {
                applovinginter(context);
                }
                mInterstitialAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                    @Override
                    public void onAdDismissedFullScreenContent() {
                        // Called when fullscreen content is dismissed.
                        load_inter_admobe(context);
                        Log.d("TAG", "The ad was dismissed.");
                    }


                    @Override
                    public void onAdShowedFullScreenContent() {
                        // Called when fullscreen content is shown.
                        // Make sure to set your reference to null so you don't
                        // show it a second time.
                        mInterstitialAd = null;
                        Log.d("TAG", "The ad was shown.");
                    }
                });
            } catch (Exception E) {
                Log.e("inter_admobe: ", E.getMessage());
            }
            inter_admobe_p++;

            if (inter_admobe_p >= config.admob_it.size()) {
                inter_admobe_p = 0;
            }

        }
    }
    public static void own_inter(final Context context ) {
        if(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            if (config.activate_own_ads.equals("1")) {
                final Dialog d = new Dialog(context, R.style.mydialog);
                d.setContentView(R.layout.owninter);

                ImageView dismiss = d.findViewById(R.id.dismissowninter);
                ImageView inter = d.findViewById(R.id.owninterimg);


                // function.loadpicture(context,dismiss,config.step1);
                //   int random = Random.nextInt(config.owninter_array.size());
                //   Log.e( "own_inter: ", random);
                Random r = new Random();
                int randomNumber = r.nextInt(config.owninter_array.size());
                Log.e("wiyha random: ", String.valueOf(randomNumber) + "//" + config.owninter_array.size());
                function.loadpicture(context, inter, config.owninter_array.get(randomNumber).getPicture());
                dismiss.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        d.dismiss();
                    }
                });

                inter.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        function.openlink(context,
                                config.owninter_array.get(randomNumber).getLink());
                    }
                });

                //  ratoremail.setEnabled(false);

                // win_img=d.findViewById(R.id.win_image);
                //  Drawable new_image= getResources().getDrawable(R.drawable.androidcanary);
                //  win_img.setBackgroundDrawable(new_image);
                d.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));

                Window win = d.getWindow();
                win.setGravity(Gravity.CENTER);

                win.getAttributes().windowAnimations = R.style.mydialog;

     /*   ((ViewGroup)d.getWindow().getDecorView())
                .getChildAt(0).startAnimation(AnimationUtils.loadAnimation(
                this,R.anim.bialogue_anim));   */

                //
                d.show();


            }
        }
    }
    public static void ads_methode(Context context)  {
        if(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            context_inter = context;
            Log.e("ads_methode: ", String.valueOf(ads_counter + "//" + config.ads_array.size()));
             if (config.ads_array.get(ads_counter).equals("admob")) {
                Log.e("ads_methode: ", config.ads_array.get(ads_counter));
                ads_counter++;
                inter_admobe(context);
            }
             else if (config.ads_array.get(ads_counter).equals("unity")) {
                Log.e("ads_methode: ", config.ads_array.get(ads_counter));
                ads_counter++;
                inter_unity(context);
            }
             else if (config.ads_array.get(ads_counter).equals("own")) {
                Log.e("ads_methode: ", config.ads_array.get(ads_counter));
                ads_counter++;
                own_inter(context);
            }
             else if (config.ads_array.get(ads_counter).equals("apploving")) {
                 Log.e("ads_methode: ", config.ads_array.get(ads_counter));
                 ads_counter++;
                 applovinginter(context);
             }
            else if (config.ads_array.get(ads_counter).equals("ironsrc")) {
                Log.e("ads_methode: ", config.ads_array.get(ads_counter));
                ads_counter++;
                showironInter(context);


            }
            else {
                ads_counter++;
            }


            if (ads_counter >= config.ads_array.size()) {
                ads_counter = 0;


            }

        } else {
            Log.d("AppInBackground", "App Is In Background Ad Is Not Going To Show");
        }


    }






    public static void admob_banner(Context context, LinearLayout relativeLayout) {
        if(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            Activity activity = (Activity) context;

            if (relativeLayout.getChildCount() != 0) {
                relativeLayout.removeAllViews();
            }

            adView2 = new AdView(context);
            //  Log.e( "admob_banner: ", adView2.getAdUnitId());
            if (adView2.getAdUnitId() != null) {
                adView2.setAdUnitId(config.admob_bn.get(admob_banner_p));

            }


            adView2.setAdSize(AdSize.BANNER);

            adView2.setAdUnitId(config.admob_bn.get(admob_banner_p));


            //mAdView = context_.findViewById(R.id.adView);
            AdRequest adRequest = new AdRequest.Builder().build();
            relativeLayout.addView(adView2, 0);
            adView2.loadAd(adRequest);
            adView2.setAdListener(new AdListener() {
                @Override
                public void onAdLoaded() {
                    // Code to be executed when an ad finishes loading.
                }

                @Override
                public void onAdFailedToLoad(LoadAdError adError) {
                    // Code to be executed when an ad request fails.
                    try {
                        applovingbanner(contextbanner, banner1);

                    } catch (Exception e) {

                        Log.e("onAdFailedToLoad: ", e.getMessage());
                    }
                    Log.e("onAdFailedToLoad: ", adError.getMessage());
                }

                @Override
                public void onAdOpened() {
                    // Code to be executed when an ad opens an overlay that
                    // covers the screen.
                }

                @Override
                public void onAdClicked() {
                    // Code to be executed when the user clicks on an ad.
                }


                @Override
                public void onAdClosed() {
                    // Code to be executed when the user is about to return
                    // to the app after tapping on an ad.
                }
            });

            admob_banner_p++;
            if (admob_banner_p >= config.admob_bn.size()) {
                admob_banner_p = 0;
            }
        }
    }
    public static void banner_unity(Context context, LinearLayout relativeLayout) {

        if(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            if (relativeLayout.getChildCount() != 0) {
                relativeLayout.removeAllViews();
            }
            Activity activity = (Activity) context;
            // LinearLayout banner_unity = activity.findViewById(R.id.banner_container);
            bottomBanner = new BannerView((Activity) context, config.unity_bn_id, new UnityBannerSize(450, 50));
            bottomBanner.setListener(bannerListener);
            //  bottomBannerView = Context.findViewById(R.id.bottomBanner);
            relativeLayout.addView(bottomBanner);

            bottomBanner.load();

        }
    }
    static  int banner_facebook_p = 0;
    public static  void showbanner(Context wiyha){
        if(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {

            Activity activity = (Activity) wiyha;
            LinearLayout relativeLayout = ((Activity) wiyha).findViewById(R.id.banner_container);
            contextbanner = wiyha;
            banner1 = relativeLayout;


            if (relativeLayout.getChildCount() != 0) {
                relativeLayout.removeAllViews();
            }


            if (config.banner_array.get(banner_index).equals("admob"))
            {
                admob_banner(wiyha, relativeLayout);
                Log.e("run: ", config.banner_array.get(banner_index));
                banner_index++;

            }
           else if (config.banner_array.get(banner_index).equals("apploving"))
            {
                applovingbanner(wiyha, relativeLayout);
                Log.e("run: ", config.banner_array.get(banner_index));
                banner_index++;
            }
            else if (config.banner_array.get(banner_index).equals("unity")) {
                Log.e("run: ", config.banner_array.get(banner_index));
                banner_unity(wiyha, relativeLayout);
                banner_index++;
            }
            else if (config.banner_array.get(banner_index).equals("startapp")) {
                Log.e("run: ", config.banner_array.get(banner_index));
                //   banner_start_app(wiyha);
                banner_index++;
            }
            else if (config.banner_array.get(banner_index).equals("own")) {
                Log.e("run: ", config.banner_array.get(banner_index));
                //   banner_start_app(wiyha);
                ownbanner(wiyha, relativeLayout);
                banner_index++;
            }
            else if (config.banner_array.get(banner_index).equals("ironsrc")) {
                Log.e("run: ", config.banner_array.get(banner_index));
                //   banner_start_app(wiyha);
                ironsrcBanner(contextbanner);
                banner_index++;
            }
            else {
                banner_index++;

            }
            if (banner_index >= config.banner_array.size()) {
                banner_index = 0;
            }

        }
    }
    public static  void showbanner2(Context wiyha){

        if(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            contextbanner = wiyha;
            Activity activity = (Activity) wiyha;
            LinearLayout relativeLayout = ((Activity) wiyha).findViewById(R.id.banner_container2);
            banner2 = relativeLayout;

            if (relativeLayout.getChildCount() != 0) {
                relativeLayout.removeAllViews();
            }

            if (config.banner_array.get(banner_index).equals("admob")) {
                admob_banner(wiyha, relativeLayout);
                Log.e("run: ", config.banner_array.get(banner_index));
                banner_index++;

            }
            if (config.banner_array.get(banner_index).equals("apploving"))
            {
                applovingbanner(wiyha, relativeLayout);
                Log.e("run: ", config.banner_array.get(banner_index));
                banner_index++;

            }
            else if (config.banner_array.get(banner_index).equals("unity")) {
                Log.e("run: ", config.banner_array.get(banner_index));
                banner_unity(wiyha, relativeLayout);
                banner_index++;
            }
            else if (config.banner_array.get(banner_index).equals("startapp")) {
                Log.e("run: ", config.banner_array.get(banner_index));
                //   banner_start_app(wiyha);
                banner_index++;
            }
            else if (config.banner_array.get(banner_index).equals("own")) {
                Log.e("run: ", config.banner_array.get(banner_index));
                //   banner_start_app(wiyha);
                ownbanner(wiyha, relativeLayout);
                banner_index++;
            }
            else if (config.banner_array.get(banner_index).equals("ironsrc")) {
                Log.e("run: ", config.banner_array.get(banner_index));
                //   banner_start_app(wiyha);
                ironsrcBanner(contextbanner);
                banner_index++;
            }
            else {
                banner_index++;

            }
            if (banner_index >= config.banner_array.size()) {
                banner_index = 0;

            }

        }

    }
    public  static void ownbanner(final Context context, LinearLayout relativeLayout){

        if(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            if (config.activate_own_ads.equals("1")) {
                if (relativeLayout.getChildCount() != 0) {
                    relativeLayout.removeAllViews();
                }
                ImageView imageView = new ImageView(context);
                //  imageView.setImageResource(R.drawable.beerbottle);

                Random r = new Random();
                int randomNumber = r.nextInt(config.ownbanner_array.size());
                Log.e("wiyha random: ", String.valueOf(randomNumber) + "//" + config.owninter_array.size());

                Glide.with(context).load(config.ownbanner_array.get(randomNumber).getPicture()).placeholder(R.drawable.loading1).into(imageView);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        function.openlink(context, config.ownbanner_array.get(randomNumber).getLink());
                    }
                });
                // RelativeLayout relativeLayout = (RelativeLayout) context.findViewById(R.id.RelativeLayout01);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                );
//        layoutParams.addRule(RelativeLayout.BELOW, R.id.ButtonRecalculate);
//        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

                relativeLayout.addView(imageView, layoutParams);
                //  Picasso.get().load(link).placeholder(R.drawable.loading1).into(imageView);
            }
        }
    }

    public static Context contextreward;


    public static  void show_native(Context context
    ){
        if(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            contextnative = context;
            //    nativeview=view;
            Activity activity = (Activity) context;


            LinearLayout relativeLayout = activity.findViewById(R.id.native_container);


            //  relativeLayout=  n.relativeLayout;
            if (relativeLayout.getChildCount() != 0) {
                relativeLayout.removeAllViews();
            }

            //   relativeLayout.removeAllViews();


            Log.e("f: ", String.valueOf(native_index));
            if (config.native_ads.get(native_index).equals("admob")) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View childLayout = inflater.inflate(R.layout.admob_native, (ViewGroup) activity.findViewById(R.id.my_template)

                );

                // TEXTVIEW
                if (childLayout.getParent() != null) {
                    ((ViewGroup) childLayout.getParent()).removeView(childLayout); // <- fix
                }

// EDITTEXT

                // relativeLayout.removeAllViews();
                relativeLayout.addView(childLayout);
                //    relativeLayout.removeView(activity.findViewById(R.id.native_ad_container));
                //    relativeLayout.removeViewAt(relativeLayout.getChildCount()-1);
                native_admob(context);
                Log.e("run: ", config.native_ads.get(native_index));
                native_index++;

            }
            if (config.native_ads.get(native_index).equals("apploving")) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View childLayout = inflater.inflate(R.layout.admob_native, (ViewGroup) activity.findViewById(R.id.my_template)

                );

                // TEXTVIEW
                if (childLayout.getParent() != null) {
                    ((ViewGroup) childLayout.getParent()).removeView(childLayout); // <- fix
                }

// EDITTEXT

                // relativeLayout.removeAllViews();
                relativeLayout.addView(childLayout);
                //    relativeLayout.removeView(activity.findViewById(R.id.native_ad_container));
                //    relativeLayout.removeViewAt(relativeLayout.getChildCount()-1);
                createNativeAd_apploving(context, relativeLayout);
                Log.e("run: ", config.native_ads.get(native_index));
                native_index++;

            }
            else if (config.native_ads.get(native_index).equals("own")) {

                //     relativeLayout.removeView(activity.findViewById(R.id.my_template));

                ownnative(context, relativeLayout);
                Log.e("run: ", config.native_ads.get(native_index));
                native_index++;

            }
            else {
                native_index++;
            }
            if (native_index >= config.native_ads.size()) {

                native_index = 0;
            }
        }

    }
    public static  void show_native(Context context,View view
    ){
        if(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            contextnative = context;
            nativeview = view;
            Activity activity = (Activity) context;


            LinearLayout relativeLayout = view.findViewById(R.id.native_container);


            //  relativeLayout=  n.relativeLayout;
            if (relativeLayout.getChildCount() != 0) {
                relativeLayout.removeAllViews();
            }

            //   relativeLayout.removeAllViews();


            Log.e("f: ", String.valueOf(native_index));
            if (config.native_ads.get(native_index).equals("admob")) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View childLayout = inflater.inflate(R.layout.admob_native, (ViewGroup) activity.findViewById(R.id.my_template)

                );

                // TEXTVIEW
                if (childLayout.getParent() != null) {
                    ((ViewGroup) childLayout.getParent()).removeView(childLayout); // <- fix
                }

// EDITTEXT

                // relativeLayout.removeAllViews();
                relativeLayout.addView(childLayout);
                //    relativeLayout.removeView(activity.findViewById(R.id.native_ad_container));
                //    relativeLayout.removeViewAt(relativeLayout.getChildCount()-1);
                native_admob(context);
                Log.e("run: ", config.native_ads.get(native_index));
                native_index++;

            }
            if (config.native_ads.get(native_index).equals("apploving")) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View childLayout = inflater.inflate(R.layout.admob_native, (ViewGroup) activity.findViewById(R.id.my_template)

                );

                // TEXTVIEW
                if (childLayout.getParent() != null) {
                    ((ViewGroup) childLayout.getParent()).removeView(childLayout); // <- fix
                }

// EDITTEXT

                // relativeLayout.removeAllViews();
                relativeLayout.addView(childLayout);
                //    relativeLayout.removeView(activity.findViewById(R.id.native_ad_container));
                //    relativeLayout.removeViewAt(relativeLayout.getChildCount()-1);
                createNativeAd_apploving(context, relativeLayout);
                Log.e("run: ", config.native_ads.get(native_index));
                native_index++;

            }
            else if (config.native_ads.get(native_index).equals("own")) {

                //     relativeLayout.removeView(activity.findViewById(R.id.my_template));

                ownnative(context, relativeLayout);
                Log.e("run: ", config.native_ads.get(native_index));
                native_index++;

            }
            else {
                native_index++;
            }
            if (native_index >= config.native_ads.size()) {

                native_index = 0;
            }
        }

    }
    static  int native_admob_p = 0;
    public static void native_admob(final Context context) {
        if(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            final ColorDrawable background = new ColorDrawable(0xFFFFFFFF);
            Activity activity = (Activity) context;
            // Log.e( "native_admob: ", config.admob_n );
            AdLoader adLoader = new AdLoader.Builder(context, config.admob_n.get(native_admob_p))
                    .forNativeAd(new com.google.android.gms.ads.nativead.NativeAd.OnNativeAdLoadedListener() {
                                     @Override
                                     public void onNativeAdLoaded(@NonNull com.google.android.gms.ads.nativead.NativeAd nativeAd) {
                                         NativeTemplateStyle styles = new
                                                 NativeTemplateStyle.Builder().withMainBackgroundColor(background).build();
                                         TemplateView template = ((Activity) context).findViewById(R.id.my_template);
                                         template.setStyles(styles);
                                         template.setNativeAd(nativeAd);
                                     }
                                 }
                    ).withAdListener(new AdListener() {
                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            Log.e("FailedToLoad n admob: ", loadAdError.getMessage());
                            createNativeAd_apploving(context,nativelayout);

                            super.onAdFailedToLoad(loadAdError);
                        }
                    })
                    .build();


            adLoader.loadAd(new AdRequest.Builder().build());
            native_admob_p++;
            if (native_admob_p >= config.admob_n.size()) {
                native_admob_p = 0;
            }
        }

    }
    static  int fb_native_p = 0;
    private static void showNativeAdWithDelay() {
        if(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            /**
             * Here is an example for displaying the ad with delay;
             * Please do not copy the Handler into your project
             */
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    // Check if nativeAd has been loaded successfully
                    if (nativeAd == null || !nativeAd.isAdLoaded()) {
                        return;
                    }
                    // Check if ad is already expired or invalidated, and do not show ad if that is the case. You will not get paid to show an invalidated ad.
                    if (nativeAd.isAdInvalidated()) {
                        return;
                    }
                    inflateAd(nativeAd); // Inflate NativeAd into a container, same as in previous code examples
                }
            }, 1000 * 60 * 15); // Show the ad after 15 minutes
        }
    }
    public static void inflateAd(NativeAd nativeAd) {
        if(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            try {

                nativeAd.unregisterView();
                Activity activity = (Activity) contextnative;
                // Add the Ad view into the ad container.
                nativeAdLayout = activity.findViewById(R.id.native_ad_container);

                LayoutInflater inflater = LayoutInflater.from(contextnative);
                // Inflate the Ad view.  The layout referenced should be the one you created in the last step.
                adView = (LinearLayout) inflater.inflate(R.layout.native_ads, nativeAdLayout, false);
                nativeAdLayout.addView(adView);

                // Add the AdOptionsView
                LinearLayout adChoicesContainer = activity.findViewById(R.id.ad_choices_container);
                AdOptionsView adOptionsView = new AdOptionsView(contextnative, nativeAd, nativeAdLayout);
                adChoicesContainer.removeAllViews();
                adChoicesContainer.addView(adOptionsView, 0);

                // Create native UI using the ad metadata.
                MediaView nativeAdIcon = adView.findViewById(R.id.native_ad_icon);
                TextView nativeAdTitle = adView.findViewById(R.id.native_ad_title);
                MediaView nativeAdMedia = adView.findViewById(R.id.native_ad_media);
                TextView nativeAdSocialContext = adView.findViewById(R.id.native_ad_social_context);
                TextView nativeAdBody = adView.findViewById(R.id.native_ad_body);
                TextView sponsoredLabel = adView.findViewById(R.id.native_ad_sponsored_label);
                Button nativeAdCallToAction = adView.findViewById(R.id.native_ad_call_to_action);

                // Set the Text.
                nativeAdTitle.setText(nativeAd.getAdvertiserName());
                nativeAdBody.setText(nativeAd.getAdBodyText());
                nativeAdSocialContext.setText(nativeAd.getAdSocialContext());
                nativeAdCallToAction.setVisibility(nativeAd.hasCallToAction() ? View.VISIBLE : View.INVISIBLE);
                nativeAdCallToAction.setText(nativeAd.getAdCallToAction());
                sponsoredLabel.setText(nativeAd.getSponsoredTranslation());

                // Create a list of clickable views
                List<View> clickableViews = new ArrayList<>();
                clickableViews.add(nativeAdTitle);
                clickableViews.add(nativeAdCallToAction);

                // Register the Title and CTA button to listen for clicks.
                nativeAd.registerViewForInteraction(
                        adView, nativeAdMedia, nativeAdIcon, clickableViews);
            } catch (Exception e) {
                Activity activity = (Activity) contextnative;
                // Add the Ad view into the ad container.

                LinearLayout relativeLayout = activity.findViewById(R.id.native_container);
                ownnative(contextnative, relativeLayout);
                Log.e("inflateAd wiyha: ", e.getMessage());

            }
        }
    }
    public static  void ownnative(Context context,LinearLayout relativeLayout){
        if(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            if (config.activate_own_ads.equals("1")) {
                if (relativeLayout.getChildCount() != 0) {
                    relativeLayout.removeAllViews();
                }
                ImageView imageView = new ImageView(context);
                //  imageView.setImageResource(R.drawable.beerbottle);
                Random r = new Random();
                int randomNumber = r.nextInt(config.ownnative_array.size());
                Log.e("wiyha random: ", String.valueOf(randomNumber) + "//" + config.ownnative_array.size());


                Glide.with(context).load(config.ownnative_array.get(randomNumber).getPicture()).placeholder(R.drawable.loading1).into(imageView);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        function.openlink(context, config.ownnative_array.get(randomNumber).getLink());
                    }
                });
                // RelativeLayout relativeLayout = (RelativeLayout) context.findViewById(R.id.RelativeLayout01);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT
                );
//        layoutParams.addRule(RelativeLayout.BELOW, R.id.ButtonRecalculate);
//        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);

                relativeLayout.addView(imageView, layoutParams);
                //  Picasso.get().load(link).placeholder(R.drawable.loading1).into(imageView);
            }
        }
    }






    public  static  void apploving_reward(){

        if(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            // dialog=d;
            try {
                if (rewardedAd.isReady()) {
                    rewardedAd.showAd();
                } else {
                    try {
                        rewardedAd.loadAd();
                    } catch (Exception e) {
                        Log.e(TAG, "apploving_reward: " + e.getMessage());
                    }

                }
            } catch (Exception e) {
                Log.e("apploving_reward: ", e.getMessage());

            }

        }
    }
    static int fb_reward_p =0;

    public static  void load_reward_unity (Context context) {
        if(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            contextreward = context;
            UnityAds.load(config.unity_r_id);
        }
    }
    public static  void reward_unity (Context context) {
        if(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            contextreward = context;
            if (UnityAds.isReady(config.unity_r_id)) {
                UnityAds.show((Activity) context, config.unity_r_id);
            } else {
                // apploving_reward();
                UnityAds.load(config.unity_r_id);
            }

        }
    }
    static int admob_reward = 0;


    public static void load_reward_admob(Context context)
    {
        if(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            contextreward = context;
            AdRequest adRequest = new AdRequest.Builder().build();

            RewardedAd.load(context, config.admob_r.get(admob_reward),
                    adRequest, new RewardedAdLoadCallback() {


                        @Override
                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
                            // Handle the error.
                            Log.d(TAG, loadAdError.getMessage());
                            mRewardedAd = null;
                        }

                        @Override
                        public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
                            mRewardedAd = rewardedAd;
                            Log.d(TAG, "Ad was loaded.");
                        }
                    });




        }

    }
    public static void admob_reward(Context context){

        if(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            contextreward = context;
//            AdRequest adRequest = new AdRequest.Builder().build();
//
//            RewardedAd.load(context, config.admob_r.get(admob_reward),
//                    adRequest, new RewardedAdLoadCallback() {
//
//
//                        @Override
//                        public void onAdFailedToLoad(@NonNull LoadAdError loadAdError) {
//                            // Handle the error.
//                            Log.d(TAG, loadAdError.getMessage());
//                            mRewardedAd = null;
//                        }
//
//                        @Override
//                        public void onAdLoaded(@NonNull RewardedAd rewardedAd) {
//                            mRewardedAd = rewardedAd;
//                            Log.d(TAG, "Ad was loaded.");
//                        }
//                    });
            if (mRewardedAd == null) {

                Log.e("admob_reward: ", "null");
                return;
            }
            mRewardedAd.setFullScreenContentCallback(new FullScreenContentCallback() {
                @Override
                public void onAdShowedFullScreenContent() {
                    // Called when ad is shown.
                    Log.d(TAG, "Ad was shown.");
                    mRewardedAd = null;
                }


                @Override
                public void onAdDismissedFullScreenContent() {
                    // Called when ad is dismissed.
                    // Don't forget to set the ad reference to null so you
                    // don't show the ad a second time.
                    Log.d(TAG, "Ad was dismissed.");
                    load_reward_admob(contextreward);
                }
            });
            if (mRewardedAd != null) {
                Activity activityContext = (Activity) context;
                mRewardedAd.show(activityContext, new OnUserEarnedRewardListener() {
                    @Override
                    public void onUserEarnedReward(@NonNull RewardItem rewardItem) {
                        // Handle the reward.
                        Log.d(TAG, "The user earned the reward.");
//                int rewardAmount = rewardItem.getAmount();
//                String rewardType = rewardItem.getType();
                        usermustberewarded();
                    }
                });
            } else {
                Log.d(TAG, "The rewarded ad wasn't ready yet.");
            }
            //0600803032
            admob_reward++;
            if (admob_reward >= config.admob_r.size()) {
                admob_reward = 0;
            }

        }
    }


    public static void showreward(Context context) {
        if(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            contextreward = context;
            Log.e("show reward: ", String.valueOf(ads_counter_reward + "//" + config.ads_array_reward.size()));
         if (config.ads_array_reward.get(ads_counter_reward).equals("admob")) {
                //   Log.e("ads_methode: ", config.ads_array.get(ads_counter));
                ads_counter_reward++;
                admob_reward(context);

            }
        else if (config.ads_array_reward.get(ads_counter_reward).equals("unity")) {
                //  Log.e("ads_methode: ", config.ads_array.get(ads_counter));
                ads_counter_reward++;
                reward_unity(context);


            }
         else if (config.ads_array_reward.get(ads_counter_reward).equals("apploving")) {
             //  Log.e("ads_methode: ", config.ads_array.get(ads_counter));
             ads_counter_reward++;
             show_apploving_reward(context);


         }
         else if (config.ads_array_reward.get(ads_counter_reward).equals("tapdaq")) {
                //      Log.e("ads_methode: ", config.ads_array.get(ads_counter));
                ads_counter_reward++;
                //tapdaq_reward(context);


            }
        else if (config.ads_array_reward.get(ads_counter_reward).equals("ironsrc")) {
                //      Log.e("ads_methode: ", config.ads_array.get(ads_counter));
                ads_counter_reward++;
                ironsrc_reward(context);


            }
        else {
                ads_counter_reward++;
            }


            if (ads_counter_reward >= config.ads_array_reward.size()) {
                ads_counter_reward = 0;


            }
        }
    }





    public static Context contextnative;
    public static RewardedAd mRewardedAd;
    public static RewardedVideoAd rewardedVideoAd;




    // Implement a function to display an ad if the Ad Unit or Placement is ready:




    public static class NativeAdLayout extends RelativeLayout {
        private LayoutInflater mInflater;

        private FrameLayout mAdview;
        private TextView mTitleView;
        private TextView mSubtitleTextView;
        private TextView mBodyTextView;
        private TextView mCaptionTextView;
        private ImageView mImageView;
        private Button mButton;
        private FrameLayout mAdChoicesView;
        private FrameLayout mIconView;
        private TextView mPriceTextView;
        private TextView mStoreTextView;
        private TextView mStarRating;
        private FrameLayout mMediaView;

        public NativeAdLayout(Context context) {
            super(context);
            mInflater = LayoutInflater.from(context);
            init();
        }

        public NativeAdLayout(Context context, AttributeSet attrs) {
            super(context, attrs);
            mInflater = LayoutInflater.from(context);
            init();
        }

        public NativeAdLayout(Context context, AttributeSet attrs, int defStyleAttr) {
            super(context, attrs, defStyleAttr);
            mInflater = LayoutInflater.from(context);
            init();
        }

        private void init()
        {
            View v = mInflater.inflate(R.layout.nativead_layout, this, true);
            mTitleView = v.findViewById(R.id.title_textview);
            mSubtitleTextView = v.findViewById(R.id.subtitle_textview);
            mBodyTextView = v.findViewById(R.id.body_textview);
            mCaptionTextView = v.findViewById(R.id.caption_textview);
            mImageView = v.findViewById(R.id.image_view);
            mButton = v.findViewById(R.id.cta_button);
            mAdChoicesView = v.findViewById(R.id.adchoices_view);
            mIconView = v.findViewById(R.id.icon_image_view);
            mPriceTextView = v.findViewById(R.id.price_textview);
            mStoreTextView = v.findViewById(R.id.store_textview);
            mStarRating = v.findViewById(R.id.star_rating_textview);
            mMediaView = v.findViewById(R.id.media_view);
            mAdview = v.findViewById(R.id.ad_view);
        }

        public void clear(){
            mTitleView.setText("");
            mSubtitleTextView.setText("");
            mBodyTextView.setText("");
            mCaptionTextView.setText("");
            mButton.setText("");
            mPriceTextView.setText("");
            mStoreTextView.setText("");
            mStarRating.setText("");

            mAdview.removeAllViews();
            mMediaView.removeAllViews();
            mAdChoicesView.removeAllViews();
            mImageView.setImageBitmap(null);
            mIconView.removeAllViews();
        }

    }
    // Implement listener methods:
    private static class UnityBannerListener implements BannerView.IListener {
        @Override
        public void onBannerLoaded(BannerView bannerAdView) {
            // Called when the banner is loaded.
            UnityAds.load(config.unity_bn_id);
            Log.e("onBannerLoaded: ", "onBannerLoaded: ");
        }

        @Override
        public void onBannerFailedToLoad(BannerView bannerAdView, BannerErrorInfo errorInfo) {
            Log.d("SupportTest", "Banner Error" + errorInfo);
            try {
                ownbanner(contextbanner,banner1);
                if(banner2.getChildCount()==0) {
                    ownbanner(contextbanner,banner2);
                }

            }catch (Exception e){

                Log.e( "onBannerFailedToLoad: ",e.getMessage() );
            }

            // Note that the BannerErrorInfo object can indicate a no fill (see API documentation).
        }

        @Override
        public void onBannerClick(BannerView bannerAdView) {
            // Called when a banner is clicked.
        }


        @Override
        public void onBannerLeftApplication(BannerView bannerAdView) {
            // Called when the banner links out of the application.
        }
    }
    private static class UnityAdsListener implements IUnityAdsListener  {

        private Context context_inter;

        @Override
        public void onUnityAdsReady(String placementId) {
            // Implement functionality for an ad being ready to show.
        }

        @Override
        public void onUnityAdsStart(String placementId) {
            // Implement functionality for a user starting to watch an ad.
        }

        @Override
        public void onUnityAdsFinish(String placementId, UnityAds.FinishState finishState) {
            // Implement functionality for a user finishing an ad.

            // Implement conditional logic for each ad completion status:
            if (placementId.equals(config.unity_r_id)) {
                if (finishState.equals(UnityAds.FinishState.COMPLETED)) {
                    usermustberewarded();
                    UnityAds.load(config.unity_r_id);
                    // Reward the user for watching the ad to completion.
                } else if (finishState == UnityAds.FinishState.SKIPPED) {
                    // Do not reward the user for skipping the ad.
                } else if (finishState == UnityAds.FinishState.ERROR) {
                    /* Log an error. */
                }
            }
        }



        @Override
        public void onUnityAdsError(UnityAds.UnityAdsError error, String message) {
            // Implement functionality for a Unity Ads service error occurring.

            try {
                own_inter(context_inter);
            }catch (Exception e){
                Log.e( "onBannerFailed: ",e.getMessage() );

            }
        }
    }
    /*
        public static void ads_inbackground()  {
        Log.e( "inter_fb_time: ","fb" );
    //        if (interstitialAd.isAdLoaded()){
    //            interstitialAd.show();
    //        }else{
    //            interstitialAd.loadAd();
    //        }
    if (config.adinbackground==1) {
        int delay = config.delay; //milliseconds

        mHandlerSleep.postDelayed(new Runnable() {
            public void run() {
                //do something
                ads_methode();
                mHandlerSleep.postDelayed(this, delay);
            }
        }, delay);

    }else {
        ads_methode();
    }
        }*/
    public static NativeAdListener nativeAdListener = new NativeAdListener() {

        @Override
        public void onMediaDownloaded(Ad ad) {
            showNativeAdWithDelay();
        }

        @Override
        public void onError(Ad ad, AdError adError) {
            Activity activity = (Activity) contextnative;




        }

        @Override
        public void onAdLoaded(Ad ad) {
            // Race condition, load() called again before last ad was displayed
            if (nativeAd == null || nativeAd != ad) {

                return;
            }
            // Inflate Native Ad into Container
            try {
                inflateAd(nativeAd);
            }catch (Exception e){
                Log.e( "onAdLoaded: ",e.getMessage() );
            }

        }

        @Override
        public void onAdClicked(Ad ad) {

        }

        @Override
        public void onLoggingImpression(Ad ad) {

        }

    };
    public static com.facebook.ads.AdListener adListener = new com.facebook.ads.AdListener() {
        @Override
        public void onError(Ad ad, AdError adError) {
            // Ad error callback
            try { ownbanner(contextbanner,banner1);

                if(banner2.getChildCount()==0) {
                    ownbanner(contextbanner,banner2);
                }


            }catch (Exception e){
                Log.e( "onError: fb",e.getMessage() );

            }

            Log.e("onError", "onError: " + adError.getErrorMessage());
        }

        @Override
        public void onAdLoaded(Ad ad) {
            // Ad loaded callback
            Log.e("onAdLoaded", "loadeed: " + ad);
        }

        @Override
        public void onAdClicked(Ad ad) {
            // Ad clicked callback
        }

        @Override
        public void onLoggingImpression(Ad ad) {
            // Ad impression logged callback
        }
    };

    public static class apploving extends Activity
            implements MaxRewardedAdListener
    {

        private int           retryAttempt;

        void createRewardedAd(Context context )
        {
            Activity activity = (Activity) context;
            rewardedAd = MaxRewardedAd.getInstance( config.apploving_reward_id, activity );
            rewardedAd.setListener( this );

            rewardedAd.loadAd();
        }

        // MAX Ad Listener
        @Override
        public void onAdLoaded(final MaxAd maxAd)
        {
            // Rewarded ad is ready to be shown. rewardedAd.isReady() will now return 'true'

            // Reset retry attempt
            retryAttempt = 0;
        }

        @Override
        public void onAdLoadFailed(final String adUnitId, final MaxError error)
        {
            // Rewarded ad failed to load
            // We recommend retrying with exponentially higher delays up to a maximum delay (in this case 64 seconds)

            retryAttempt++;
            long delayMillis = TimeUnit.SECONDS.toMillis( (long) Math.pow( 2, Math.min( 6, retryAttempt ) ) );

            new Handler().postDelayed( new Runnable()
            {
                @Override
                public void run()
                {
                    rewardedAd.loadAd();
                }
            }, delayMillis );
        }

        @Override
        public void onAdDisplayFailed(final MaxAd maxAd, final MaxError error)
        {
            // Rewarded ad failed to display. We recommend loading the next ad
            Log.e( "wiyhaaa: ",error.getMessage() );
            // rewardedAd.loadAd();
        }

        @Override
        public void onAdDisplayed(final MaxAd maxAd) {}

        @Override
        public void onAdClicked(final MaxAd maxAd) {}

        @Override
        public void onAdHidden(final MaxAd maxAd)
        {
            // rewarded ad is hidden. Pre-load the next ad
            rewardedAd.loadAd();
        }

        @Override
        public void onRewardedVideoStarted(final MaxAd maxAd) {}

        @Override
        public void onRewardedVideoCompleted(final MaxAd maxAd) {}

        @Override
        public void onUserRewarded(final MaxAd maxAd, final MaxReward maxReward)
        {
            // Rewarded ad was displayed and user should receive the reward
//            ImageView firststep = dialog.findViewById(R.id.step1);
//            firststep.setVisibility(View.INVISIBLE);
//            function.put_shared(contextbanner,"step1","done","locked");
//            Log.e( "onUserRewarded: ","true" );
            usermustberewarded();
        }


    }




    static public ProgressDialog progressDialog;

    public static void setupironsrc(Context context)
    {
        Log.e( "setupironsrc: ",config.ironsrc_APP_KEY);
        IronSource.init((Activity) context, config.ironsrc_APP_KEY);
        IntegrationHelper.validateIntegration((Activity) context);

    }
    public static IronSourceBannerLayout banner;
    public static void ironsrcBanner(Context context) {
        if(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            Activity activity = (Activity) context;
            banner = IronSource.createBanner(activity, ISBannerSize.BANNER);
            final LinearLayout frameLayout = activity.findViewById(R.id.banner_container);
            if (frameLayout != null) {
                FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);
                frameLayout.addView(banner, 0, layoutParams);
                IronSource.loadBanner(banner);
                banner.setBannerListener(new com.ironsource.mediationsdk.sdk.BannerListener() {
                    @Override
                    public void onBannerAdLoaded() {
                        // Called after a banner ad has been successfully loaded
                    }

                    @Override
                    public void onBannerAdLoadFailed(IronSourceError error) {
                        // Called after a banner has attempted to load an ad but failed.
                        Log.e("onBannerAdLoadFailed: ", error.getErrorMessage() + error.getErrorCode());
                        activity.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                frameLayout.removeAllViews();
                            }
                        });
                    }

                    @Override
                    public void onBannerAdClicked() {
                        // Called after a banner has been clicked.
                    }

                    @Override
                    public void onBannerAdScreenPresented() {
                        // Called when a banner is about to present a full screen content.
                    }

                    @Override
                    public void onBannerAdScreenDismissed() {
                        // Called after a full screen content has been dismissed
                    }

                    @Override
                    public void onBannerAdLeftApplication() {
                        // Called when a user would be taken out of the application context.
                    }
                });

                Log.e("ironsrcBanner:", "if");
            } else {
                Log.e("ironsrcBanner: ", "else");
            }
        }
    }

    public  void destroyBanner() {
        IronSource.destroyBanner(banner);
    }


    public static void offerwall_ironsrc(Context context)
    {
        IronSource.setOfferwallListener(new OfferwallListener() {
            /**
             * Invoked when there is a change in the Offerwall availability status.
             * @param - available - value will change to YES when Offerwall are available.
             * You can then show the offerwall by calling showOfferwall(). Value will *change to NO when Offerwall isn't available.
             */
            @Override
            public void onOfferwallAvailable(boolean isAvailable) {
                if (isAvailable){
                    IronSource.showOfferwall();
                }
            }
            /**
             * Invoked when the Offerwall successfully loads for the user, after calling the 'showOfferwall' method
             */
            @Override
            public void onOfferwallOpened() {
            }
            /**
             * Invoked when the method 'showOfferWall' is called and the OfferWall fails to load.
             * @param error - A IronSourceError Object which represents the reason of 'showOfferwall' failure.
             */
            @Override
            public void onOfferwallShowFailed(IronSourceError error) {
            }
            /**
             * Invoked each time the user completes an Offer.
             * Award the user with the credit amount corresponding to the value of the *‘credits’ parameter.
             * @param credits - The number of credits the user has earned.
             * @param totalCredits - The total number of credits ever earned by the user.
             * @param totalCreditsFlag - In some cases, we won’t be able to provide the exact
             * amount of credits since the last event (specifically if the user clears
             * the app’s data). In this case the ‘credits’ will be equal to the ‘totalCredits’, and this flag will be ‘true’.
             * @return boolean - true if you received the callback and rewarded the user, otherwise false.
             */
            @Override
            public boolean onOfferwallAdCredited(int credits, int totalCredits, boolean totalCreditsFlag) {
                return true;
            }
            /**
             * Invoked when the method 'getOfferWallCredits' fails to retrieve
             * the user's credit balance info.
             * @param error - A IronSourceError object which represents the reason of 'getOfferwallCredits' failure.
             * If using client-side callbacks to reward users, it is mandatory to return true on this event
             */
            @Override
            public void onGetOfferwallCreditsFailed(IronSourceError error) {
            }
            /**
             * Invoked when the user is about to return to the application after closing
             * the Offerwall.
             */
            @Override
            public void onOfferwallClosed() {
            }
        });
    }



    public static Boolean ready = false;
    public  static void ironsrc_reward(Context context){
        if(ProcessLifecycleOwner.get().getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {

            IronSource.setRewardedVideoListener(new com.ironsource.mediationsdk.sdk.RewardedVideoListener() {

                @Override
                public void onRewardedVideoAdOpened() {
                }

                @Override
                public void onRewardedVideoAdClosed() {
                }

                /**
                 * Invoked when there is a change in the ad availability status.
                 *
                 * @param - available - value will change to true when rewarded videos are *available.
                 *          You can then show the video by calling showRewardedVideo().
                 *          Value will change to false when no videos are available.
                 */
                @Override
                public void onRewardedVideoAvailabilityChanged(boolean available) {
                    //Change the in-app 'Traffic Driver' state according to availability.
                    if (available)
                        ready = true;
                        //IronSource.showRewardedVideo();

                }

                /**
                 * /**
                 * Invoked when the user completed the video and should be rewarded.
                 * If using server-to-server callbacks you may ignore this events and wait *for the callback from the ironSource server.
                 *
                 * @param - placement - the Placement the user completed a video from.
                 */
                @Override
                public void onRewardedVideoAdRewarded(Placement placement) {
                    usermustberewarded();
                    /** here you can reward the user according to the given amount.
                     String rewardName = placement.getRewardName();
                     int rewardAmount = placement.getRewardAmount();
                     */
                }

                /* Invoked when RewardedVideo call to show a rewarded video has failed
                 * IronSourceError contains the reason for the failure.
                 */
                @Override
                public void onRewardedVideoAdShowFailed(IronSourceError error) {
                    //  tapdaq_reward(contextreward);
                }

                /*Invoked when the end user clicked on the RewardedVideo ad
                 */
                @Override
                public void onRewardedVideoAdClicked(Placement placement) {
                }

                /**
                 * Note: the events AdStarted and AdEnded below are not available for all supported rewarded video
                 * ad networks. Check which events are available per ad network you choose
                 * to include in your build.
                 * We recommend only using events which register to ALL ad networks you
                 * include in your build.
                 * Invoked when the video ad starts playing.
                 */
                @Override
                public void onRewardedVideoAdStarted() {
                }

                /* Invoked when the video ad finishes plating. */
                @Override
                public void onRewardedVideoAdEnded() {
                }
            });
            IronSource.shouldTrackNetworkState(context, true);
            if (ready)
                IronSource.showRewardedVideo();
        }

}





    public  static applovingadsclass applovingadsclass;
    private static applovingbanner applovingbanner;

    public  static void applovingbanner(Context context, LinearLayout linearLayout)
    {
        if (linearLayout.getChildCount() != 0) {
            linearLayout.removeAllViews();
        }
        applovingbanner = new applovingbanner();
        applovingbanner.createBannerAd(context, linearLayout);
    }

    public static class applovingadsclass
            implements MaxAdListener
    {
        public static MaxInterstitialAd interstitialAd;
        public int retryAttempt;

        @SuppressLint("ResourceType")
        void createInterstitialAd(Context context)
        {
            interstitialAd = new MaxInterstitialAd( config.apploving_inter, (Activity) context);
            interstitialAd.setListener( this );

            // Load the first ad
            interstitialAd.loadAd();
        }

        // MAX Ad Listener
        @Override
        public void onAdLoaded(final MaxAd maxAd)
        {
            // Interstitial ad is ready to be shown. interstitialAd.isReady() will now return 'true'

            // Reset retry attempt
            retryAttempt = 0;

        }

        @Override
        public void onAdLoadFailed(final String adUnitId, final MaxError error)
        {
            // Interstitial ad failed to load
            // We recommend retrying with exponentially higher delays up to a maximum delay (in this case 64 seconds)
            //inter_unity(context_inter);
//            retryAttempt++;
//            long delayMillis = TimeUnit.SECONDS.toMillis( (long) Math.pow( 2, Math.min( 6, retryAttempt ) ) );
//
//            new Handler().postDelayed(new Runnable()
//            {
//                @Override
//                public void run()
//                {
//                    interstitialAd.loadAd();
//                }
//            }, delayMillis );
        }

        @Override
        public void onAdDisplayFailed(final MaxAd maxAd, final MaxError error)
        {
            // Interstitial ad failed to display. We recommend loading the next ad
            Log.e("onAdDisplayFailed: ", error.getMessage() );
            //   interstitialAd.loadAd();
        }

        @Override
        public void onAdDisplayed(final MaxAd maxAd) {}

        @Override
        public void onAdClicked(final MaxAd maxAd) {}

        @Override
        public void onAdHidden(final MaxAd maxAd)
        {
            // Interstitial ad is hidden. Pre-load the next ad
            // interstitialAd.loadAd();
            interstitialAd.loadAd();
        }

        public  void setInterstitialAd() {

            try {
                if ( interstitialAd.isReady() )
                {
                    interstitialAd.showAd();
                }else {
                    interstitialAd.loadAd();
                }
            }catch (Exception E) {
                Log.e("setInterstitialAd: ", E.getMessage());
            }

        }
    }
    public static class applovingbanner
            implements MaxAdViewAdListener
    {
        private MaxAdView adView;

        @SuppressLint("ResourceAsColor")
        void createBannerAd(Context context, LinearLayout linearLayou2)
        {
            LinearLayout linearLayout = linearLayou2;
            adView = new MaxAdView( config.apploving_banner, (Activity) context);
            adView.setListener( this );

            // Stretch to the width of the screen for banners to be fully functional
            int width = ViewGroup.LayoutParams.MATCH_PARENT;

            // Banner height on phones and tablets is 50 and 90, respectively
            int heightPx = context.getResources().getDimensionPixelSize( R.dimen.banner_height );

            adView.setLayoutParams( new FrameLayout.LayoutParams( width, heightPx ) );

            //Set background or background color for banners to be fully functional
           // adView.setBackgroundColor( R.color.colorTransparent );

            LinearLayout rootView = linearLayou2;
            rootView.addView( adView );

            // Load the ad
            adView.loadAd();
//            linearLayout.removeAllViews();
//            linearLayout.addView(adView);
        }

        // MAX Ad Listener
        @Override
        public void onAdLoaded(final MaxAd maxAd) {}

        @Override
        public void onAdLoadFailed(final String adUnitId, final MaxError error) {}

        @Override
        public void onAdDisplayFailed(final MaxAd maxAd, final MaxError error) {}

        @Override
        public void onAdClicked(final MaxAd maxAd) {}

        @Override
        public void onAdExpanded(final MaxAd maxAd) {}

        @Override
        public void onAdCollapsed(final MaxAd maxAd) {}

        @Override
        public void onAdDisplayed(final MaxAd maxAd) { /* DO NOT USE - THIS IS RESERVED FOR FULLSCREEN ADS ONLY AND WILL BE REMOVED IN A FUTURE SDK RELEASE */ }

        @Override
        public void onAdHidden(final MaxAd maxAd) { /* DO NOT USE - THIS IS RESERVED FOR FULLSCREEN ADS ONLY AND WILL BE REMOVED IN A FUTURE SDK RELEASE */ }
    }


    public static MaxNativeAdLoader nativeAdLoader;
    public static MaxAd             nativeAd_apploving;

    public  static  void show_apploving_reward(Context context)
    {
        if ( rewardedAd.isReady() )
        {
            rewardedAd.showAd();
        }
    }


    public  static  void load_apploving_reward(Context context)
    {
        apploving apploving = new apploving();
        apploving.createRewardedAd(context);
    }

    public static void createNativeAd_apploving(Context context, LinearLayout relativeLayout)
    {
        LinearLayout nativeAdContainer = relativeLayout;

        if (relativeLayout.getChildCount() != 0) {
            relativeLayout.removeAllViews();
        }
        nativeAdLoader = new MaxNativeAdLoader( config.apploving_native, (Activity) context);
        nativeAdLoader.setNativeAdListener( new MaxNativeAdListener()
        {
            @Override
            public void onNativeAdLoaded(final MaxNativeAdView nativeAdView, final MaxAd ad)
            {
                // Clean up any pre-existing native ad to prevent memory leaks.
                if ( nativeAd != null )
                {
                    nativeAdLoader.destroy( nativeAd_apploving );
                }

                // Save ad for cleanup.
                nativeAd_apploving = ad;

                // Add ad view to view.
                nativeAdContainer.removeAllViews();
                nativeAdContainer.addView( nativeAdView );
            }

            @Override
            public void onNativeAdLoadFailed(final String adUnitId, final MaxError error)
            {
                // We recommend retrying with exponentially higher delays up to a maximum delay
                Log.e( "onNativeAdLoadFailed: ", error.getMessage());
                ownnative(contextnative, nativeAdContainer);
            }

            @Override
            public void onNativeAdClicked(final MaxAd ad)
            {
                // Optional click callback
            }
        } );

        nativeAdLoader.loadAd();
    }



    public static void usermustberewarded() {

//        TextView coins_cmp=((Activity) contextreward).findViewById(R.id.coins_text);
//        sqlite_2021 db = new sqlite_2021(contextreward);
//
//
//        db.update_coins("update wiyha set cmp =cmp+5");
//        coins_cmp.setText(String.valueOf(db.getinitailvalue(0)));
//        //   long s1 = Long.parseLong(function.get_shared(contextreward,"time","locker_done"));
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss", Locale.getDefault());
//        String currentDateandTime = sdf.format(new Date());
//        function.put_shared(contextreward,"time",currentDateandTime,"locker_done");
//        long s2 = Long.parseLong(currentDateandTime);
//        Log.e("deftime", String.valueOf(s2));
//        if (s1==0){
//            Toast.makeText(contextreward, "Please Complete the Task Firstly", Toast.LENGTH_LONG).show();
//        }
//        if (s2-s1>config.locker_delay_in_second){
//            Log.e( "onClick: ","if" );
//            Toast.makeText(contextreward, "Please Complete the Task Firstly", Toast.LENGTH_LONG).show();
//        }else
//        {
//
//        }

    }



}