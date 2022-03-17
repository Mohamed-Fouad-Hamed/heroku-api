package alf.api.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import alf.api.web.models.PanelColumn;

public interface ColumnRepository extends JpaRepository<PanelColumn, Long> {

}
