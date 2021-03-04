package com.mapbox.maps.plugin.location;

import android.animation.TypeEvaluator;
import androidx.annotation.NonNull;
import androidx.annotation.Size;

class PaddingEvaluator implements TypeEvaluator<double[]> {
    private final double[] padding = new double[4];

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
    public double[] evaluate(float fraction, @NonNull @Size(min = 4) double[] startValue,
                             @NonNull @Size(min = 4) double[] endValue) {
        padding[0] = startValue[0] + (endValue[0] - startValue[0]) * fraction;
        padding[1] = startValue[1] + (endValue[1] - startValue[1]) * fraction;
        padding[2] = startValue[2] + (endValue[2] - startValue[2]) * fraction;
        padding[3] = startValue[3] + (endValue[3] - startValue[3]) * fraction;
        return padding;
    }
}
