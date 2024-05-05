package com.example.testspringapr24;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OfferOrderViewService
{

    OrderRepository orderRepository;
    OrderstatusRepository orderstatusRepository;

    OfferOrderViewService(OrderRepository orderRepository,
                          OrderstatusRepository orderstatusRepository)
    {
        this.orderRepository = orderRepository;
        this.orderstatusRepository = orderstatusRepository;
    }

    public Optional<OfferOrderView> createOfferOrderView(String offerid, OfferOrderView view)
    {
        List<Order> orderList = orderRepository.findByOfferid(offerid);
        List<Order> finalOrderList = orderList.stream().
                filter(order -> orderstatusRepository.findByOrderid(order.getOrderid()).get().getStatus().equals("OPEN")).
                collect(Collectors.toList());

        if(finalOrderList.isEmpty())
        {
            return Optional.empty();
        }
        else
        {
            view.setOfferid(offerid);
            view.setOrders(finalOrderList);

            return Optional.of(view);
        }

    }

}