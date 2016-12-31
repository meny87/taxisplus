package com.menulabs.taxisplus.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.menulabs.taxisplus.domain.Unidad;

public interface UnidadRepository extends JpaRepository<Unidad, Long> {
	
	@Query("SELECT u.id FROM Unidad u")
	List<Long> getUnidadIDs();
	
	Optional<Unidad> findOneByNumPlacas(String numPlacas);

}
