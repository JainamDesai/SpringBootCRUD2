package com.SpringCRUDBySearch.SpringCRUDBySearch.factory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.*;
import com.SpringCRUDBySearch.SpringCRUDBySearch.model.MobileStore;

public interface Helper extends JpaRepository<MobileStore, Integer> {
	@Query("SELECT mobile FROM MobileStore mobile where mobile.mobile_name LIKE %:mobile_name%")
	public List<MobileStore> findBymobile_name(@Param("mobile_name") String mobile_name);

}
