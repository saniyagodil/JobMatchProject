package com.company.resume.Repositories;

import com.company.resume.Models.Job;
import com.company.resume.Models.Organization;
import com.company.resume.Models.Skill;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public interface JobRepository extends CrudRepository<Job, Long>{


//    HashSet<Job> findAllByJobSkillsContains(HashSet<Skill> skills);
//
//    HashSet<Job> findJobByJobSkillsIn(HashSet<Skill> mySkills);

    HashSet<Job> findAllByJobOrg(Organization organization);

    Iterable<Job> findAllByJobSkillsIn(Set<Skill> skills);

}
