package com.company.resume.Repositories;

import com.company.resume.Models.Job;
import com.company.resume.Models.Skill;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.HashSet;

public interface JobRepository extends CrudRepository<Job, Long>{


    HashSet<Job> findAllByJobSkillsContains(HashSet<Skill> skills);
//
//    HashSet<Job> findJobByJobSkillsIn(HashSet<Skill> mySkills);

    HashSet<Job> findByJobOrg(String organization);

}
