package io.pragra.jpareview.api;

import io.pragra.jpareview.dtos.ErrorDto;
import io.pragra.jpareview.entity.Order;
import io.pragra.jpareview.exceptions.OrderNotFoundException;
import io.pragra.jpareview.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.time.Instant;

@Controller
@ResponseBody
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class OrderApi {
    private final OrderService service;

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody  Order order, @RequestHeader ("X-MARKET") String market){
        log.info("GOT HEADER {}", market);
        Order serviceOrder = service.createOrder(order);
        return ResponseEntity.status(201).header("X-COMPLETE","true").body(serviceOrder);
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getAll(){
        return ResponseEntity.status(201).header("X-COMPLETE","true").body(service.findAll());
    }

    @GetMapping(value = "/order/{uuid}",  produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<?> getAll(@PathVariable String uuid){
        try {
            Order order = service.findById(uuid);
            return ResponseEntity.ok().body(order);
        }catch (OrderNotFoundException ex) {
            return ResponseEntity
                    .status(404)
                    .body(
                            ErrorDto.builder()
                                    .errCode("AP404")
                                    .apiCode("ORDER101")
                                    .errMessage(ex.getMessage())
                                    .timeStamp(Instant.now()).build());
        }

    }
}
