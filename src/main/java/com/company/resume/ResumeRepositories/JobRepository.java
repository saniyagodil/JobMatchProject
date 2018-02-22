package com.company.resume.ResumeRepositories;

import com.company.resume.ResumeModels.Job;
import com.company.resume.ResumeModels.Resume;
import com.company.resume.ResumeModels.Skill;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface JobRepository extends CrudRepository<Job, Long>{

    Collection<Job> findAllJobsBySkillsContaining(Collection<Skill> skills);

}
