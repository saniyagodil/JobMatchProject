package com.company.resume.Repositories;

import com.company.resume.Models.Degree;
import org.springframework.data.repository.CrudRepository;



public interface EducationRepository extends CrudRepository<Degree, Long> {
}
