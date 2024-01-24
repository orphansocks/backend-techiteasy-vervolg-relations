package nl.novi.techiteasy1121.repositories;

import nl.novi.techiteasy1121.models.RemoteController;
import org.springframework.data.jpa.repository.JpaRepository;

// DE REPOSITORY IS INTERFACE & EXTENDS DE JPAREPOSITORY
// DAN HOEF JE ZELF NIET DE DATABASE QUERIES TE SCHRIJVEN
// IN DE REPOSITORY VIND JE ENTITEITEN VAN MODEL REMOTECONTROLLER MET DATATYPE LONG (VAN DE ID)
public interface RemoteControllerRepository extends JpaRepository<RemoteController, Long> {
}
