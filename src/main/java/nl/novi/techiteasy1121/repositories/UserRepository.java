package nl.novi.techiteasy1121.repositories;


import nl.novi.techiteasy1121.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

// HIERMEE KUNNEN WE GEBRUIKERS OPHALEN EN OPSLAAN UIT DE DATABASE
// DE USER MODEL TOEVOEGEN AAN DE REPOSITORY MET HET DATATYPE VAN DE ID
public interface UserRepository extends JpaRepository<User, String> {
}
