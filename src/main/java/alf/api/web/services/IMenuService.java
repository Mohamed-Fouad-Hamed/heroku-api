package alf.api.web.services;

import java.util.List;

import alf.api.web.models.Menu;

public interface IMenuService {

    Menu findById(int id);

    List<Menu> findByText(String Text);

    List<Menu> findAll();

    List<Menu> findNotIn(int id);

    void save(Menu menu);

    void update(Menu menu);

    void deleteById(int id);

}
