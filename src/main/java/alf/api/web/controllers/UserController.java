package alf.api.web.controllers;

import java.util.List;

import javax.validation.Valid;

import alf.api.web.models.BaseItem;
import alf.api.web.models.Menu;
import alf.api.web.models.Role;
import alf.api.web.models.User;
import alf.api.web.payload.response.MessageResponse;
import alf.api.web.repository.IBaseItemRepository;
import alf.api.web.repository.MenuRepository;
import alf.api.web.repository.UserRepository;
import alf.api.web.repository.IRoleRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    MenuRepository menuRepository;

    @Autowired
    IBaseItemRepository baseItemRepository;

    @Autowired
    IRoleRepository iRoleRepository;

    @GetMapping("/users")
    public ResponseEntity<?> allUsers() {
        final List<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/menus")
    public ResponseEntity<?> allMenus() {
        final List<Menu> menus = menuRepository.findAll();
        return ResponseEntity.ok(menus);
    }

    @GetMapping("/roles")
    public ResponseEntity<?> allRoles() {
        final List<Role> roles = iRoleRepository.findAll();
        return ResponseEntity.ok(roles);
    }

    @GetMapping("/listBaseItemByType-{id}")
    public ResponseEntity<?> listBaseItemByType(@PathVariable(value = "id") final long id) {

        final List<BaseItem> baseItems = baseItemRepository.getListBaseItems(id);
        return ResponseEntity.ok(baseItems);
    }

    @PostMapping("/addRole")
    public ResponseEntity<?> createMenu(@Valid @RequestBody final Role role) {
        return updateRole(role);
    }

    @PutMapping("/editRole")
    public ResponseEntity<?> editMenu(@Valid @RequestBody final Role role) {
        return updateRole(role);
    }

    private ResponseEntity<?> updateRole(Role role) {
        if (null == role)
            return ResponseEntity.badRequest().body(new MessageResponse(""));

        Role roleUpdated = null;
        try {

            role.getPrivileges().forEach((privilege) -> {
                privilege.setRole(role);
            });

            role.getRole_baseitemtypes().forEach((type) -> {
                type.getRole_baseitem().forEach((item) -> {
                    item.setBaseitemtype(type);
                });
                type.setRole(role);
            });

            roleUpdated = iRoleRepository.save(role);
        } catch (final Exception ex) {
            System.out.print("    ERROR  : " + ex.getMessage());

            return ResponseEntity.badRequest().body(new MessageResponse(0, 400, "Role does not create "));
        }

        return ResponseEntity.ok(new MessageResponse(200, "Role created successfully  ", roleUpdated));
    }

}
