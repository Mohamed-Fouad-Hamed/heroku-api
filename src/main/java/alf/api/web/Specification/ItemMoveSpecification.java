package alf.api.web.Specification;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import alf.api.web.models.ItemMove;
import alf.api.web.models.ItemMoveSearcher;

import org.springframework.data.jpa.domain.Specification;

public class ItemMoveSpecification implements Specification<ItemMove> {
    
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private ItemMoveSearcher itemMoveSearcher;

    public ItemMoveSpecification(ItemMoveSearcher itemMoveSearcher) {
        this.itemMoveSearcher = itemMoveSearcher;
    }

    @Override
    public Predicate toPredicate(Root<ItemMove> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate> predicates = new ArrayList<>();

        if ((this.itemMoveSearcher.getId() != null) && (this.itemMoveSearcher.getId() != 0) ) {
			predicates.add(criteriaBuilder.equal(root.get("id"), this.itemMoveSearcher.getId()));
        }
        
        if ((this.itemMoveSearcher.getFirst_id() != 0)) {
			predicates.add(criteriaBuilder.equal(root.get("first_id"), this.itemMoveSearcher.getFirst_id()));
		}
        
        if (this.itemMoveSearcher.getSecond_id() != 0) {
			predicates.add(criteriaBuilder.equal(root.get("second_id"), this.itemMoveSearcher.getSecond_id()));
		}
        
        if (this.itemMoveSearcher.getStore_keeper() != null && (!this.itemMoveSearcher.getStore_keeper().equals(""))) {
			predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("store_keeper")), "%" + this.itemMoveSearcher.getStore_keeper().toLowerCase() + "%"));
		}
        

		if (this.itemMoveSearcher.getOrder_date_start() != null && this.itemMoveSearcher.getOrder_date_end() != null ) {
            predicates.add(criteriaBuilder.between(root.<Date>get("order_date"), this.itemMoveSearcher.getOrder_date_start(), this.itemMoveSearcher.getOrder_date_end()) );
		}
        
        if (this.itemMoveSearcher.getOrder_time_in_start() != null && this.itemMoveSearcher.getOrder_time_in_end() != null) {
			predicates.add(criteriaBuilder.between(root.<Date>get("order_time_in"), this.itemMoveSearcher.getOrder_time_in_start() , this.itemMoveSearcher.getOrder_time_in_end()));
		}
        

        if (this.itemMoveSearcher.getOrder_time_out_start() != null && this.itemMoveSearcher.getOrder_time_out_end() != null) {
			predicates.add(criteriaBuilder.between(root.<Date>get("order_time_out"), this.itemMoveSearcher.getOrder_time_out_start() , this.itemMoveSearcher.getOrder_time_out_end()));
		}
     
		if (predicates.size() > 0) {
			return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
		}
        
        return null;
    }

 
   
 

}