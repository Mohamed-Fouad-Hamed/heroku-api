package alf.api.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import alf.api.web.models.Language;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Long> {
}
