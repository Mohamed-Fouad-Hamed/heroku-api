package alf.api.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import alf.api.web.models.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {

}
