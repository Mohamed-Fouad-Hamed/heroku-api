package alf.api.web.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import alf.api.web.models.BaseItem;
import alf.api.web.models.BaseItemType;
import alf.api.web.payload.response.MessageResponse;
import alf.api.web.repository.IBaseItemRepository;
import alf.api.web.repository.IBaseItemTypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/item")
public class ItemController {

  @Autowired
  IBaseItemRepository baseItemRepository;

  @Autowired
  IBaseItemTypeRepository baseItemTypeRepository;

  @GetMapping("/baseitemtypes")
  public ResponseEntity<?> allBaseItemType() {
    final List<BaseItemType> baseTypes = baseItemTypeRepository.findAll();
    return ResponseEntity.ok(baseTypes);
  }

  @GetMapping("/BaseItemById-{id}")
  public ResponseEntity<?> BaseItemById(@PathVariable(value = "id") final long id) {
    final Optional<BaseItem> baseItem = baseItemRepository.findById(id);
    BaseItem oBaseItem = null;
    if (baseItem.isPresent())
      oBaseItem = baseItem.get();
    return ResponseEntity.ok(oBaseItem);
  }

  @GetMapping("/BaseItemTypeById-{id}")
  public ResponseEntity<?> BaseItemTypeById(@PathVariable(value = "id") final long id) {
    final Optional<BaseItemType> baseItemType = baseItemTypeRepository.findById(id);
    BaseItemType oBaseItemType = null;
    if (baseItemType.isPresent())
      oBaseItemType = baseItemType.get();
    List<BaseItemType> listItem = new ArrayList<BaseItemType>();
    if (null != oBaseItemType)
      listItem.add(oBaseItemType);
    return ResponseEntity.ok(listItem);
  }

  @PostMapping("/addItem-{id}")
  public ResponseEntity<?> createItem(@Valid @RequestBody final BaseItem item,
      @PathVariable(value = "id") final long id) {
    return updateItem(item, id);
  }

  @PutMapping("/editItem-{id}")
  public ResponseEntity<?> editItem(@Valid @RequestBody final BaseItem item,
      @PathVariable(value = "id") final long id) {
    return updateItem(item, id);
  }

  private ResponseEntity<?> updateItem(BaseItem item, long id) {
    if (null == item && id > 0)
      return ResponseEntity.badRequest().body(new MessageResponse(""));

    BaseItem itemUpdated = null;
    try {

      Optional<BaseItemType> optionalItemType = baseItemTypeRepository.findById(id);
      BaseItemType itemType = null;

      if (optionalItemType.isPresent())
        itemType = optionalItemType.get();

      if (null != itemType) {

        if (itemType.isHas_info()) {
          if (null != item.getBaseItemInfo())
            item.getBaseItemInfo().setItem(item);
        } else
          item.setBaseItemInfo(null);

        if (itemType.isHas_financial()) {
          if (null != item.getBaseItemFinancial())
            item.getBaseItemFinancial().setItem(item);
        } else
          item.setBaseItemFinancial(null);

        if (itemType.isHas_document()) {
          if (null != item.getBaseItemDocument())
            item.getBaseItemDocument().setItem(item);
        } else
          item.setBaseItemDocument(null);

        if (itemType.isHas_production()) {
          if (null != item.getBaseItemProduction())
            item.getBaseItemProduction().setItem(item);
        } else
          item.setBaseItemProduction(null);

        if (itemType.isHas_device()) {
          if (null != item.getBaseItemDevice())
            item.getBaseItemDevice().setItem(item);
        } else
          item.setBaseItemDevice(null);

        if (itemType.isHas_pointsale()) {
          if (null != item.getBaseItemPointSale())
            item.getBaseItemPointSale().setItem(item);
        } else
          item.setBaseItemPointSale(null);

        item.setType(itemType);

        itemUpdated = baseItemRepository.save(item);
      } else
        return ResponseEntity.badRequest().body(new MessageResponse(""));

    } catch (final Exception ex) {
      System.out.print("    ERROR  : " + ex.getMessage());

      return ResponseEntity.badRequest().body(new MessageResponse(0, 400, "Role does not create "));
    }

    return ResponseEntity.ok(new MessageResponse(200, "Item created successfully  ", itemUpdated));
  }

  @DeleteMapping("/delete-item-{id}")
  public ResponseEntity<?> deleteItem(@PathVariable(value = "id") final long id) {
    try {
      Optional<BaseItem> baseItem = baseItemRepository.findById(id);
      if (baseItem.isPresent())
        baseItemRepository.delete(baseItem.get());
      else
        return ResponseEntity.badRequest().body(new MessageResponse(0, 400, "Base Item  does not delete "));
    } catch (final Exception ex) {
      System.out.print("*** ERROR  : " + ex.getMessage());
      return ResponseEntity.badRequest().body(new MessageResponse(0, 400, "Base Item Type does not create "));
    }
    return ResponseEntity.ok(new MessageResponse("Base Item Type deleted successfully!"));
  }

}
