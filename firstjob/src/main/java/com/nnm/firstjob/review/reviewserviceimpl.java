package com.nnm.firstjob.review;

import com.nnm.firstjob.company.company;
import com.nnm.firstjob.company.companyservice;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class reviewserviceimpl implements ReviewService{
    private final ReviewRepo reviewRepo;
    private final companyservice companyservice;

    public reviewserviceimpl(ReviewRepo reviewRepo,
                             companyservice companyservice) {
        this.reviewRepo = reviewRepo;
        this.companyservice = companyservice;
    }

    @Override
    public List<Review> getallReviews(Long companyid) {
        List<Review>reviews=reviewRepo.findByCompanyId(companyid);
        return reviews;
    }

    @Override
    public boolean addReview(Long companyid, Review review) {
        company company=companyservice.findcompanybyid(companyid);
        if (company!=null){
            review.setCompany(company);
            reviewRepo.save(review);
            return true;

        }else {
            return false;
        }
    }

    @Override
    public Review getreview(Long companyid, Long reviewid) {
        List<Review>reviews= reviewRepo.findByCompanyId(companyid);
        return reviews.stream().filter(review -> review.getId().equals(reviewid)).findFirst().orElse(null);
    }

    @Override
    public boolean updatereview(Long companyid, Long reviewid, Review updatedreview) {
        if (companyservice.findcompanybyid(companyid)!=null){
            updatedreview.setCompany(companyservice.findcompanybyid(companyid));
            updatedreview.setId(reviewid);
            reviewRepo.save(updatedreview);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deletereview(Long companyid, Long reviewId) {
        if (companyservice.findcompanybyid(companyid)!=null& reviewRepo.existsById(reviewId)){
            Review review= reviewRepo.findById(reviewId).orElse(null);
            company company= review.getCompany();
            company.getReviews().remove(review);
            companyservice.updatecompany(company,companyid);
            reviewRepo.deleteById(reviewId);
            return true;
        } else {
            return false;
        }
    }
}
