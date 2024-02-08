package com.nnm.firstjob.job.impl;

import com.nnm.firstjob.job.job;
import com.nnm.firstjob.job.jobservice;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
@Service
public class jobserviceimpl implements jobservice {
    public List<job> jobs=new ArrayList<>();

    private Long nextid=1L;
    @Override
    public List<job> findall() {

        return jobs;
    }

    @Override
    public void createjob(job job) {
        job.setId(nextid++);
        jobs.add(job);
    }

    @Override
    public job getjobbyid(Long id) {
        for (job job : jobs) {
            if (job.getId() == id) {
                return job;
            }
        }
        return null;
    }

    @Override
    public boolean deletejobbyid(Long id) {
        for (job job : jobs) {
            if (job.getId() == id) {
                jobs.remove(job);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean updatejob(Long id, job updatejob) {
        for (job job : jobs) {
            if (job.getId() == id) {
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
                return true;
            }
        }
        return false;
    }



}
