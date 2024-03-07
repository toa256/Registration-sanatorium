package com.kolia.TEST.repos;


import com.kolia.TEST.Models.Patients;
import com.kolia.TEST.Models.Reserve;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ReserveRepository extends CrudRepository<Reserve, Long>
{
    @Query("SELECT p FROM Reserve p WHERE CONCAT(p.name, ' ', p.surname, ' ', p.middle_name, ' ', p.history , ' ', p.tel , ' ', p.born_data) LIKE %?1%")
    public List<Reserve> findAll(String keyword);
}
