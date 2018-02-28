package com.company.resume.Repositories;

import com.company.resume.Models.Skill;
import com.company.resume.Models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ResumeRepository extends CrudRepository<Resume, Long> {

    Resume findByUser(User user);

    Collection <Resume>  findAllResumeBySkillsContaining(Collection<Skill> skills);



}
