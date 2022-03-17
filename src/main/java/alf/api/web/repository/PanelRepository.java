package alf.api.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import alf.api.web.models.MenuPanel;

public interface PanelRepository extends JpaRepository<MenuPanel, Long> {

}
