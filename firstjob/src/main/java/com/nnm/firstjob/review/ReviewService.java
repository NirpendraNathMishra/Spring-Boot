package com.nnm.firstjob.review;

import java.util.List;

public interface ReviewService {
    List<Review>getallReviews(Long companyid);
    boolean addReview(Long companyid,Review review);
    Review getreview(Long companyid,Long reviewid);
    boolean updatereview(Long companyid,Long reviewid, Review review);
    boolean deletereview(Long companyid,Long reviewId);
}
