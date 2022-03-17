package alf.api.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import alf.api.web.models.BaseItemType;

public interface IBaseItemTypeRepository extends JpaRepository<BaseItemType, Long> {

}
