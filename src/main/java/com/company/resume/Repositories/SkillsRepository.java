package com.company.resume.Repositories;

import com.company.resume.Models.Skill;
import org.springframework.data.repository.CrudRepository;


public interface SkillsRepository extends CrudRepository<Skill, Long> {

    Iterable <Skill> findAllSkillByNameContainingIgnoreCase(String query);
}

