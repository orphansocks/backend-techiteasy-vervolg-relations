package nl.novi.techiteasy1121.repositories;

import nl.novi.techiteasy1121.models.TelevisionWallBracket;
import nl.novi.techiteasy1121.models.TelevisionWallBracketKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.List;

// DEZE FILE IS WEGENS TIJDGEBREK RECHTSTREEKS GEKOPIEERD UIT DE UITWERKINGEN
// HOPELIJK KRIJG IK 'M VERWERKT IN MIJN EIGEN PROJECT

public interface TelevisionWallBracketRepository extends JpaRepository<TelevisionWallBracket, TelevisionWallBracketKey> {
    // custom query om alle TelevisionWallBrackets te vinden die bij een bepaalde tv horen
    List<TelevisionWallBracket> findAllByTelevisionId(Long televisionId);
    // custom query om alle TelevisionWallBrackets te vinden die bij een bepaalde wallbracket horen
    List<TelevisionWallBracket> findAllByWallBracketId(Long wallBracketId);
}
