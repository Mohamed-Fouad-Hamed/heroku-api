package alf.api.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import alf.api.web.dao.IMenu;
import alf.api.web.models.Menu;

@Service("menuService")
@Transactional
public class MenuService implements IMenuService {

	@Autowired
	private IMenu mMenu;

	@Override
	public Menu findById(int id) {
		return mMenu.findById(id);
	}

	@Override
	public List<Menu> findByText(String Text) {
		return mMenu.findByText(Text);
	}

	@Override
	public List<Menu> findAll() {
		return mMenu.findAll();
	}

	@Override
	public List<Menu> findNotIn(int id) {
		return mMenu.findNotIn(id);
	}

	@Override
	public void save(Menu menu) {
		mMenu.save(menu);
	}

	@Override
	public void update(Menu menu) {

		/*
		 * Menu entity = mMenu.findById(menu.getMnuid()); if(null != entity) {
		 * entity.setHeadertext(menu.getHeadertext());
		 * entity.setContainermenu(menu.getContainermenu());
		 * entity.setC_object(menu.getC_object());
		 * entity.setIsparent(menu.isIsparent()); entity.setLevel(menu.getLevel());
		 * entity.setIschild(menu.isIschild()); entity.setTypeIcon(menu.getTypeIcon());
		 * entity.setMenuicon(menu.getMenuicon()); entity.setMtype(menu.getMtype());
		 * entity.setVisible(menu.isVisible()); entity.setShortcut(menu.getShortcut());
		 * }
		 */
		mMenu.edit(menu);

	}

	@Override
	public void deleteById(int id) {

		mMenu.deleteById(id);
	}

}
