package com.company.resume.ResumeRepositories;

import com.company.resume.ResumeModels.Resume;
import com.company.resume.ResumeModels.Skill;
import com.company.resume.UserSetup.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface ResumeRepository extends CrudRepository<Resume, Long> {

    Resume findByUser(User user);

    Collection <Resume>  findAllResumeBySkillsContaining(Collection<Skill> skills);



}
