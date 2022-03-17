package alf.api.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import alf.api.web.models.UserPrivilages;

@Repository
public interface UserPrivilagesRepository extends JpaRepository<UserPrivilages, Long> {
    @Query(value = "SELECT rp.id, rp.role_id, mp.menu_id, mp.name,rp.allow FROM "
            + " role_privileges as rp   left join  menu_privileges as mp "
            + " on  rp.menu_privilege_id = mp.id  left join  user_roles as ur "
            + " on rp.role_id = ur.role_id where rp.allow=true and  ur.user_id = :userId ", nativeQuery = true)
    List<UserPrivilages> allPrivilages(@Param("userId") Long userId);
}
