package alf.api.web;

import alf.api.web.models.Role;

import java.util.List;

import alf.api.web.repository.RoleRepository;
import alf.api.web.repository.UserRepository;
import alf.api.web.models.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class StartDefaultData implements ApplicationRunner {

    @Autowired
    private RoleRepository repoRole;

    @Autowired
    private UserRepository repoUser;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<Role> roles = repoRole.findAll();
        if (roles.size() < 8) {
            repoRole.save(new Role(1, "ROLE_ADMIN"));
            repoRole.save(new Role(2, "ROLE_MODERATOR"));
            repoRole.save(new Role(3, "ROLE_ALL_PRIVILEGES"));
            repoRole.save(new Role(4, "ROLE_USER"));
            repoRole.save(new Role(5, "ROLE_USER_STORES"));
            repoRole.save(new Role(6, "ROLE_USER_SALES"));
            repoRole.save(new Role(7, "ROLE_USER_PURCHASES"));
            repoRole.save(new Role(8, "ROLE_GUEST"));
        }

        if (!repoUser.existsByUsername("admin")) {
            User admin = new User("admin", "ids.fouad@gmail.com",
                    "$2a$10$veR/zY2Am/ymleYkyeR.ZOIDvSrSSbqcDmaVosS06PM0sZEph5iVe", "ar", "");
            Role adminRole = repoRole.findByName("ROLE_ADMIN")
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            admin.getRoles().add(adminRole);
            repoUser.save(admin);
        }

    }
}