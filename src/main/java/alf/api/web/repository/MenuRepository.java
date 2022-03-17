package alf.api.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import alf.api.web.models.Menu;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {

}
