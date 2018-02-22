package com.company.resume.ResumeRepositories;

import com.company.resume.ResumeModels.Experience;
import org.springframework.data.repository.CrudRepository;



public interface ExperiencesRepository extends CrudRepository<Experience, Long> {
}
