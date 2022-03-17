package alf.api.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

import alf.api.web.models.BaseItem;

public interface IBaseItemRepository extends JpaRepository<BaseItem, Long> {

    @Query(value = "select * from base_item u where u.type_id =:id", nativeQuery = true)
    List<BaseItem> getListBaseItems(@Param("id") Long id);

    @Query(value = "select * from base_item u where u.type_id =:id", nativeQuery = true)
    List<BaseItem> getListBaseItemsByCategory(@Param("id") Long id);
}
