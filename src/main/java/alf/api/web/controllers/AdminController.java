package alf.api.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import alf.api.web.exception.ResourceNotFoundException;
import alf.api.web.models.BaseItem;
import alf.api.web.models.BaseItemType;
import alf.api.web.models.Menu;
import alf.api.web.payload.response.MessageResponse;
import alf.api.web.repository.IBaseItemTypeRepository;
import alf.api.web.repository.MenuRepository;
import alf.api.web.repository.IBaseItemRepository;
import alf.api.web.repository.CompanyInfoRepository;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/admin")
public class AdminController {

	@Autowired
	MenuRepository menuRepository;

	@Autowired
	IBaseItemTypeRepository baseItemTypeRepository;

	@Autowired
	IBaseItemRepository baseItemRepository;

	@Autowired
	CompanyInfoRepository companyInfoRepository;

	/** Menus Processes Begin ---> **/

	@GetMapping("/menus")
	public ResponseEntity<?> allMenus() {
		final List<Menu> menus = menuRepository.findAll();
		return ResponseEntity.ok(menus);
	}
	/*
	 * @GetMapping("/menus-like-{param}") public ResponseEntity<?>
	 * getMenusByName(@PathVariable String param){ List<Menu> menus =
	 * menuService.findByText(param); return ResponseEntity.ok(menus); }
	 * 
	 * @GetMapping("/menus-notin-{param}") public ResponseEntity<?>
	 * getMenusNotIn(@PathVariable int param){ List<Menu> menus =
	 * menuService.findNotIn(param); return ResponseEntity.ok(menus); }
	 */

	@PostMapping("/addMenu")
	public ResponseEntity<?> createMenu(@Valid @RequestBody final Menu menu) {
		return updateMenu(menu);
	}

	@PutMapping("/editMenu")
	public ResponseEntity<?> editMenu(@Valid @RequestBody final Menu menu) {
		return updateMenu(menu);
	}

	@DeleteMapping("/delete-menu-{mnuid}")
	public ResponseEntity<?> deleteMenu(@PathVariable(value = "mnuid") final long mnuid) {
		try {
			final Menu mnu = menuRepository.findById(mnuid)
					.orElseThrow(() -> new ResourceNotFoundException("Menu", "Menu id", mnuid));
			menuRepository.delete(mnu);
		} catch (final Exception ex) {
			System.out.print("*** ERROR  : " + ex.getMessage());
			return ResponseEntity.badRequest().body(new MessageResponse(0, 400, "Menu does not create "));
		}
		return ResponseEntity.ok(new MessageResponse("Menu deleted successfully!"));
	}

	private ResponseEntity<?> updateMenu(Menu menu) {
		if (null == menu)
			return ResponseEntity.badRequest().body(new MessageResponse(""));

		Menu menuUpdated = null;
		try {

			menu.getPanels().forEach((panel) -> {
				panel.setmenu(menu);
				panel.getColumns().forEach((column) -> {
					column.setmenuPanel(panel);
					column.getEvents().forEach((event) -> {
						event.setpanelColumn(column);
					});
				});
			});

			menu.getPrivileges().forEach((privilege) -> {
				privilege.setMenu(menu);
			});

			menuUpdated = menuRepository.save(menu);
		} catch (final Exception ex) {
			System.out.print("*** ERROR  : " + ex.getMessage());

			return ResponseEntity.badRequest().body(new MessageResponse(0, 400, "Menu does not create "));
		}

		return ResponseEntity.ok(new MessageResponse(200, "Menu created successfully  ", menuUpdated));
	}

	/* Menus Processes End */

	/** Base Item Type Processes Begin ---> **/

	@GetMapping("/baseitemtypes")
	public ResponseEntity<?> allBaseItemType() {
		final List<BaseItemType> baseTypes = baseItemTypeRepository.findAll();
		return ResponseEntity.ok(baseTypes);
	}

	@GetMapping("/listBaseItemByType-{id}")
	public ResponseEntity<?> listBaseItemByType(@PathVariable(value = "id") final long id) {

		final List<BaseItem> baseItems = baseItemRepository.getListBaseItems(id);
		return ResponseEntity.ok(baseItems);

	}

	@PostMapping("/addBaseItemType")
	public ResponseEntity<?> createBaseItemType(@Valid @RequestBody final BaseItemType baseItemType) {
		return updateBaseItemType(baseItemType);
	}

	@PutMapping("/editBaseItemType")
	public ResponseEntity<?> editBaseItemType(@Valid @RequestBody final BaseItemType baseItemType) {
		return updateBaseItemType(baseItemType);
	}

	@DeleteMapping("/delete-baseitemtype-{id}")
	public ResponseEntity<?> deleteBaseItemType(@PathVariable(value = "id") final long id) {
		try {
			final BaseItemType baseItemType = baseItemTypeRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("base item Type", "base item type id", id));
			baseItemTypeRepository.delete(baseItemType);
		} catch (final Exception ex) {
			System.out.print("*** ERROR  : " + ex.getMessage());
			return ResponseEntity.badRequest().body(new MessageResponse(0, 400, "Base Item Type does not create "));
		}
		return ResponseEntity.ok(new MessageResponse("Base Item Type deleted successfully!"));
	}

	private ResponseEntity<?> updateBaseItemType(BaseItemType baseItemType) {

		if (null == baseItemType)
			return ResponseEntity.badRequest().body(new MessageResponse(""));

		BaseItemType baseItemTypeUpdated = null;

		try {

			baseItemType.getItems().forEach((item) -> {
				item.setType(baseItemType);
			});

			baseItemTypeUpdated = baseItemTypeRepository.save(baseItemType);
		} catch (final Exception ex) {
			System.out.print("*** ERROR  : " + ex.getMessage());

			return ResponseEntity.badRequest().body(new MessageResponse(0, 400, "item does not create "));
		}

		final List<BaseItemType> baseTypes = baseItemTypeRepository.findAll();

		return ResponseEntity
				.ok(new MessageResponse(200, "Menu created successfully  ", baseItemTypeUpdated, baseTypes));

	}

	/* Base Item Type Processes End */

}
