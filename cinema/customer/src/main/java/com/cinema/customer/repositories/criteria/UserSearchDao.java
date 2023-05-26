package com.cinema.customer.repositories.criteria;

import com.cinema.customer.domain.User;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.hibernate.Criteria;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserSearchDao {
    private final EntityManager em;

    public List<User> findAllUsersBySimpleQuery(String name, String email) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);

        //select * from users
        Root<User> root = criteriaQuery.from(User.class);

        //prepare  WHERE  clause
        // WHERE name like '%li%'
        Predicate namePredicate = criteriaBuilder
                .like(root.get("name"), "%" + name + "%");

        Predicate emailPredicate = criteriaBuilder
                .like(root.get("email"), "%" + email + "%");

        var nameOrEmailPredicate = criteriaBuilder.or(namePredicate, emailPredicate);

        // => final query ==> select * from user where name like '%li' or email like '%ali'
        criteriaQuery.where(nameOrEmailPredicate);

        TypedQuery<User> finalQuery = em.createQuery(criteriaQuery);

        return finalQuery.getResultList();
    }

    public List<User> findAllByCriteria(SearchRequest request) {
        CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);

        List<Predicate> predicates = new ArrayList<>();

        //select * from User
        Root<User> root = criteriaQuery.from(User.class);

        if (request.getName() != null) {
            Predicate namePredicate = criteriaBuilder.like(
                    root.get("name"), "%" + request.getName() + "%"
            );
            predicates.add(namePredicate);
        }

        if (request.getEmail() != null) {
            Predicate emailPredicate = criteriaBuilder.like(
                    root.get("email"), "%" + request.getEmail() + "%"
            );
            predicates.add(emailPredicate);
        }

        criteriaQuery.where(criteriaBuilder.or(predicates.toArray(new Predicate[0])));
        TypedQuery<User> finalQuery = em.createQuery(criteriaQuery);

        return finalQuery.getResultList();
    }
}
