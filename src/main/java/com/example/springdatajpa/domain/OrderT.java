package com.example.springdatajpa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class OrderT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "orderT")
    private List<OrderItem> orderItems = new ArrayList<OrderItem>();

    @OneToOne
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private Date dorderDate;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    public void setMember(Member member) {
        if (this.member != null) {
            this.member.getOrders().remove(this);
        }
        this.member = member;
        member.getOrders().add(this);
    }

    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
        delivery.setOrderT(this);
    }
}
