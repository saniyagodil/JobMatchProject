package com.company.resume.ResumeRepositories;

import com.company.resume.ResumeModels.Degree;
import org.springframework.data.repository.CrudRepository;



public interface EducationRepository extends CrudRepository<Degree, Long> {
}
