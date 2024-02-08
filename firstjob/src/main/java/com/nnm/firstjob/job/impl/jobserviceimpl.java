package com.nnm.firstjob.job.impl;

import com.nnm.firstjob.job.job;
import com.nnm.firstjob.job.jobrepo;
import com.nnm.firstjob.job.jobservice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class jobserviceimpl implements jobservice {

    //public List<job> jobs=new ArrayList<>();

    jobrepo jobrepo;

    public jobserviceimpl(com.nnm.firstjob.job.jobrepo jobrepo) {
        this.jobrepo = jobrepo;
    }

    //private Long nextid=1L;
    @Override
    public List<job> findall() {

        return jobrepo.findAll();
    }

    @Override
    public void createjob(job job) {
       // job.setId(nextid++);
        //jobs.add(job);
        jobrepo.save(job);
    }

    @Override
    public job getjobbyid(Long id) {
        /*for (job job : jobs) {
            if (job.getId() == id) {
                return job;
            }
        }
        return null;*/
        return jobrepo.findById(id).orElse(null);

    }

    @Override
    public boolean deletejobbyid(Long id) {
        /*for (job job : jobs) {
            if (job.getId() == id) {
                jobs.remove(job);
                return true;
            }
        }
        return false;*/
        try {
            jobrepo.deleteById(id);
            return true;
        }catch(Exception e){
            return false;
        }
    }

    @Override
    public boolean updatejob(Long id, job updatejob) {
        Optional<job>jobOptional=jobrepo.findById(id);
            if (jobOptional.isPresent()) {
                job job =jobOptional.get();
                if (updatejob.getTitle() != null) {
                    job.setTitle(updatejob.getTitle());
                }
                if (updatejob.getDiscraption() != null) {
                    job.setDiscraption(updatejob.getDiscraption());
                }
                if (updatejob.getLocation() != null) {
                    job.setLocation(updatejob.getLocation());
                }
                if (updatejob.getMinsalary() != null) {
                    job.setMinsalary(updatejob.getMinsalary());
                }
                if (updatejob.getMaxsalary() != null) {
                    job.setMaxsalary(updatejob.getMaxsalary());
                }
                jobrepo.save(job);
                return true;
            }
        return false;
    }



}
