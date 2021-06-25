package com.idat.examen.crud;

import java.util.List;
import java.util.Optional;

import com.idat.examen.models.Vendor;

import org.springframework.data.repository.CrudRepository;

public interface IVendorCR extends CrudRepository<Vendor, Integer> {
     // @Query(value = "SELECT * FROM vendor u WHERE u.company LIKE '%1?%'", nativeQuery = true)
     Optional<List<Vendor>> findByCompanyLike(String company);
}
