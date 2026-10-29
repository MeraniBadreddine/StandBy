package com.standby.tv;

import android.service.dreams.DreamService;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.FrameLayout;

/**
 * Pure system screensaver. Full-screen, centered, no options button.
 */
public final class StandbyDreamService extends DreamService {

    private WebView webView;
    private StandbyBridge bridge;

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();

        setInteractive(false);
        setFullscreen(true);
        setScreenBright(false);

        bridge = new StandbyBridge(this);
        webView = PreviewActivity.createClockWebView(this, false, bridge);

        // Critical: force WebView to fill the entire dream window
        // Without this, content can stick to top/bottom instead of centering
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );
        webView.setLayoutParams(lp);

        FrameLayout root = new FrameLayout(this);
        root.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        ));
        root.setBackgroundColor(0xFF000000);
        root.addView(webView, lp);

        setContentView(root);
    }

    @Override
    public void onDreamingStarted() {
        super.onDreamingStarted();
        if (webView != null) {
            webView.onResume();
            webView.resumeTimers();
        }
    }

    @Override
    public void onDreamingStopped() {
        if (webView != null) {
            webView.onPause();
            webView.pauseTimers();
        }
        super.onDreamingStopped();
    }

    @Override
    public void onDetachedFromWindow() {
        if (bridge != null) {
            bridge.destroy();
            bridge = null;
        }
        if (webView != null) {
            webView.destroy();
            webView = null;
        }
        super.onDetachedFromWindow();
    }
}
