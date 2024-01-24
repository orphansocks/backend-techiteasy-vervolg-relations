package nl.novi.techiteasy1121.repositories;

import nl.novi.techiteasy1121.models.CIModule;
import org.springframework.data.jpa.repository.JpaRepository;


// DE REPOSITORY IS INTERFACE & EXTENDS DE JPAREPOSITORY
// DAN HOEF JE ZELF NIET DE DATABASE QUERIES TE SCHRIJVEN
// IN DE REPOSITORY VIND JE ENTITEITEN VAN MODEL CIMODULE MET DATATYPE LONG(VAN DE ID)
public interface CIModuleRepository extends JpaRepository<CIModule, Long> {
}
