package com.mapbox.maps.plugin.location;

import android.animation.TypeEvaluator;

import androidx.annotation.NonNull;

import com.mapbox.geojson.Point;

class PointEvaluator implements TypeEvaluator<Point> {

    /**
     * This function returns the result of linearly interpolating the start and end values, with
     * <code>fraction</code> representing the proportion between the start and end values. The
     * calculation is a simple parametric calculation: <code>result = x0 + t * (x1 - x0)</code>,
     * where <code>x0</code> is <code>startValue</code>, <code>x1</code> is <code>endValue</code>,
     * and <code>t</code> is <code>fraction</code>.
     *
     * @param fraction   The fraction from the starting to the ending values
     * @param startValue The start value.
     * @param endValue   The end value.
     * @return A linear interpolation between the start and end values, given the
     *         <code>fraction</code> parameter.
     */
    @NonNull
    @Override
    public Point evaluate(float fraction, @NonNull Point startValue, @NonNull Point endValue) {
        return Point.fromLngLat(
                startValue.longitude() + ((endValue.longitude() - startValue.longitude()) * fraction),
                startValue.latitude() + ((endValue.latitude() - startValue.latitude()) * fraction)
        );
    }
}