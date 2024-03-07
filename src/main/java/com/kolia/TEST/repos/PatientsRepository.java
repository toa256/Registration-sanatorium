package com.kolia.TEST.repos;

import java.util.List;
import com.kolia.TEST.Models.Patients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface PatientsRepository extends CrudRepository<Patients, Long>
{
    @Query("SELECT p FROM Patients p WHERE CONCAT(p.name, ' ', p.surname, ' ', p.middle_name, ' ', p.history , ' ', p.tel , ' ', p.born_data) LIKE %?1%")
    public List<Patients> findAll(String keyword);

}
