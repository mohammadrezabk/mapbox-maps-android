package com.mapbox.maps.plugin.location;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import androidx.annotation.Nullable;

import com.mapbox.maps.plugin.location.listeneres.CancelableCallback;

class MapboxAnimatorListener extends AnimatorListenerAdapter {

    @Nullable
    private final CancelableCallback cancelableCallback;

    MapboxAnimatorListener(@Nullable CancelableCallback cancelableCallback) {
        this.cancelableCallback = cancelableCallback;
    }

    /**
     * <p>Notifies the cancellation of the animation. This callback is not invoked
     * for animations with repeat count set to INFINITE.</p>
     *
     * @param animation The animation which was canceled.
     */
    @Override
    public void onAnimationCancel(Animator animation) {
        if (cancelableCallback != null) {
            cancelableCallback.onCancel();
        }
    }

    /**
     * <p>Notifies the end of the animation. This callback is not invoked
     * for animations with repeat count set to INFINITE.</p>
     *
     * @param animation The animation which reached its end.
     */
    @Override
    public void onAnimationEnd(Animator animation) {
        if (cancelableCallback != null) {
            cancelableCallback.onFinish();
        }
    }
}