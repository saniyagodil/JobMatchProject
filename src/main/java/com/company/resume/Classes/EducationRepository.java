package com.company.resume.Classes;

import com.company.resume.Classes.Degree;
import org.springframework.data.repository.CrudRepository;



public interface EducationRepository extends CrudRepository<Degree, Long> {
}
