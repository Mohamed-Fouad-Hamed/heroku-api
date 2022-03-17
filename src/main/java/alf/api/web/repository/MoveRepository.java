package alf.api.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import alf.api.web.models.ItemMove;

public interface MoveRepository extends JpaRepository<ItemMove, Long>, JpaSpecificationExecutor<ItemMove> {

}