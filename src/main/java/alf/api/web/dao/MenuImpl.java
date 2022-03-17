package alf.api.web.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import alf.api.web.models.Menu;

@Repository("mMenu")
public class MenuImpl extends AbstractDao<Integer, Menu> implements IMenu {

	static final Logger logger = LoggerFactory.getLogger(MenuImpl.class);

	@Override
	public Menu findById(int id) {
		Menu menu = getByKey(id);
		return menu;
	}

	@Override
	public List<Menu> findByText(String Text) {
		logger.info("List Menus find by text : {}", Text);
		// Criteria crit = createEntityCriteria();
		// crit.add(Restrictions.disjunction().add(Restrictions.like("headertext",
		// Text,MatchMode.ANYWHERE)));
		List<Menu> menus = (List<Menu>) findByAttributeContainsText("headertext", Text);
		return menus;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Menu> findAll() {
		logger.info("List All Menus ");
		// Criteria criteria = createEntityCriteria().addOrder(Order.asc("mnuid"));
		// criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);//To avoid
		// duplicates.
		List<Menu> menus = (List<Menu>) createEntityCriteria().getResultList();
		return menus;
	}

	@Override
	public void save(Menu entity) {
		persist(entity);

	}

	@Override
	public void edit(Menu entity) {
		update(entity);
	}

	@Override
	public void deleteById(int id) {
		// Criteria crit = createEntityCriteria();
		// crit.add(Restrictions.eq("mnuid", id));
		Menu Menu = (Menu) getByKey(id);
		if (null != Menu)
			delete(Menu);
	}

	@Override
	public List<Menu> findNotIn(int id) {
		// Criteria crit = createEntityCriteria();
		// crit.add(Restrictions.not(Restrictions.eq("mnuid", id)));
		List<Menu> menus = (List<Menu>) findNotInId("mnuid", id);
		return menus;
	}

}
