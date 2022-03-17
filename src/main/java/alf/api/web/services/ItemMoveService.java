package alf.api.web.services;

import java.util.List;
import java.util.Optional;
import alf.api.web.Specification.ItemMoveSpecification;
import alf.api.web.models.ItemMove;
import alf.api.web.models.ItemMoveSearcher;
import alf.api.web.repository.MoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ItemMoveService {

    @Autowired
    private MoveRepository moveRepository;

    public ItemMoveService() {
    }

    public ItemMove findById(long id) {
        ItemMove itemMove = null;
        Optional<ItemMove> option = moveRepository.findById(id);
        if (option.isPresent())
            itemMove = option.get();
        return itemMove;
    }

    public List<ItemMove> findAll() {
        return moveRepository.findAll();
    }

    public Page<ItemMove> findAll(Pageable pageable) {
        return moveRepository.findAll(pageable);
    }

    public Page<ItemMove> findAll(ItemMoveSearcher itemMove, Pageable pageable) {
        ItemMoveSpecification search = new ItemMoveSpecification(itemMove);
        return moveRepository.findAll(search, pageable);
    }

    protected void setDetails(ItemMove itemMove) {
        itemMove.getItemmovedetails().forEach((detail) -> {
            detail.setItemmove(itemMove);
        });
    }

    public ItemMove save(ItemMove entity) {
        setDetails(entity);
        return moveRepository.save(entity);
    }

    public ItemMove update(ItemMove entity) {
        setDetails(entity);
        return moveRepository.save(entity);
    }

    public void delete(long id) {
        ItemMove entity = findById(id);
        moveRepository.delete(entity);
    }

}
