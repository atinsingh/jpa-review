package io.pragra.jpareview.service;

import io.pragra.jpareview.entity.Order;
import io.pragra.jpareview.exceptions.OrderNotFoundException;
import io.pragra.jpareview.repo.OrdertRepo;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrdertRepo repo;

    public Order createOrder(Order o) {
        return this.repo.save(o);
    }

    public List<Order> creatMany(List<Order> orders) {
        return this.repo.saveAll(orders);
    }

    public Order findById(String uuidString) {
        UUID uuid = UUID.fromString(uuidString);
        System.out.println(uuidString);
        System.out.println(uuid.toString());
        Optional<Order> byId = repo.findAll().stream().filter(o->o.getId().equals(uuid)).findFirst();
        return byId.orElseThrow(()->new OrderNotFoundException("Order for UUID doesn't exitst"));

    }

    public List<Order> findAll(){
        return repo.findAll();
    }

}

