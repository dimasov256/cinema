package com.cinema.order.services.criteria;

import com.cinema.order.domain.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderSearchDao {

    private final EntityManager em;

    public List<Order> findAllOrdersByName(String orderName) {

        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Order> criteriaQuery = criteriaBuilder.createQuery(Order.class);

        Root<Order> root = criteriaQuery.from(Order.class);

        Predicate namePredicate = criteriaBuilder.like(root.get("orderName"), "%" + orderName + "%");

        criteriaQuery.where(namePredicate);

        TypedQuery<Order> finalQuery = em.createQuery(criteriaQuery);

        return finalQuery.getResultList();
    }
}
