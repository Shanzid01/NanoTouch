package com.slideme.sam.manager.net.response;

import com.slideme.sam.manager.model.data.Review;
import com.slideme.sam.manager.util.C1922m;
import java.util.List;

public class ReviewResponse extends BaseNetworkResponse {
    public List<Review> review;

    public Review getReview() {
        if (C1922m.m5794a(this.review)) {
            return null;
        }
        return (Review) this.review.get(0);
    }
}
