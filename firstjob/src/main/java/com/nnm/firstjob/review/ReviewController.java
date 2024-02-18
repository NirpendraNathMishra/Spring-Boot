package com.nnm.firstjob.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("companies/{companyid}")
public class ReviewController {
    private ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>>getallReviews(@PathVariable Long companyid){
        return new ResponseEntity<>(reviewService.getallReviews(companyid), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String>addreviews(@PathVariable Long companyid ,@RequestBody Review review){
        boolean isReviesaved= reviewService.addReview(companyid, review);
        if (isReviesaved){
            return new ResponseEntity<>("Review Saved Sucessfilly",HttpStatus.OK);
        }else {
            return new ResponseEntity<>("review Not Saved", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/reviews/{reviewid}")
    public ResponseEntity<Review>getreview(@PathVariable Long companyid,@PathVariable Long reviewid){
        return new ResponseEntity<>(reviewService.getreview(companyid,reviewid),HttpStatus.OK);
    }
}
