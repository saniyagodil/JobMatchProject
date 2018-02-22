package com.company.resume.ResumeRepositories;

import com.company.resume.ResumeModels.Skill;
import org.springframework.data.repository.CrudRepository;


public interface SkillsRepository extends CrudRepository<Skill, Long> {

    Skill findByName(String name);
}

