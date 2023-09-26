package com.vimeo;

import android.view.ViewGroup;

import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class AdViewModule extends ViewGroupManager<AdView> {

  private AdView adView;

  @Override
  public String getName() {
    return "AdView";
  }

  @Override
  protected AdView createViewInstance(final ThemedReactContext reactContext) {
    if (adView == null) {
      adView = new AdView(reactContext);
      adView.setAdSize(AdSize.BANNER);
      adView.setAdUnitId("ca-app-pub-3940256099942544/1033173712");

      AdRequest adRequest = new AdRequest.Builder().build();
      adView.loadAd(adRequest);

      ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
          ViewGroup.LayoutParams.MATCH_PARENT,
          ViewGroup.LayoutParams.WRAP_CONTENT
      );
      adView.setLayoutParams(params);
    }
    return adView;
  }

  @ReactProp(name = "unitId")
  public void setAdUnitId(AdView adView, String adUnitId) {
    adView.setAdUnitId(adUnitId);
    AdRequest adRequest = new AdRequest.Builder().build();
    adView.loadAd(adRequest);
  }

  @Override
  public void onDropViewInstance(AdView view) {
    super.onDropViewInstance(view);
    if (adView != null) {
      adView.destroy();
      adView = null;
    }
  }
}