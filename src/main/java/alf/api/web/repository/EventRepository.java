package alf.api.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import alf.api.web.models.ColumnEvent;

public interface EventRepository extends JpaRepository<ColumnEvent, Long> {

}
