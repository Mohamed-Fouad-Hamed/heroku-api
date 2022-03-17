package alf.api.web.dao;

import java.util.List;

import alf.api.web.models.Menu;

public interface IMenu {

	Menu findById(int id);

	List<Menu> findByText(String Text);

	List<Menu> findAll();

	List<Menu> findNotIn(int id);

	void save(Menu menu);

	void edit(Menu menu);

	void deleteById(int id);

}
