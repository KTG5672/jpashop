package jpabook.jpashop.dto;

import jpabook.jpashop.domain.item.Item;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ItemDTO {

    public ItemDTO(Item item) {
        this.id = item.getId();
        this.name = item.getName();
        this.price = item.getPrice();
        this.stockQuantity = item.getStockQuantity();
    }

    private Long id;
    private String name;
    private int price;
    private int stockQuantity;
}
