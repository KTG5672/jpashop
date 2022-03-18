package jpabook.jpashop.controller;

import jpabook.jpashop.domain.Order;
import jpabook.jpashop.dto.ItemDTO;
import jpabook.jpashop.dto.MemberDTO;
import jpabook.jpashop.repository.OrderSearch;
import jpabook.jpashop.service.ItemService;
import jpabook.jpashop.service.MemberService;
import jpabook.jpashop.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final MemberService memberService;
    private final ItemService itemService;

    @GetMapping("/order")
    public String createForm(Model model) {
        List<MemberDTO> members = memberService.findMembers().stream().map(MemberDTO::new).collect(Collectors.toList());
        List<ItemDTO> items = itemService.findItems().stream().map(ItemDTO::new).collect(Collectors.toList());

        model.addAttribute("members", members);
        model.addAttribute("items", items);

        return "order/orderForm";
    }

    @PostMapping("/order")
    public String order(@RequestParam("memberId") Long memberId,
                        @RequestParam("itemId") Long itemId,
                        @RequestParam("count") int count) {
        orderService.order(memberId, itemId, count);
        return "redirect:/orders";
    }

    @GetMapping("/orders")
    public String orderList(@ModelAttribute("orderSearch") OrderSearch search, Model model) {
        List<Order> orders = orderService.findOrders(search);
        model.addAttribute("orders", orders);

        return "order/orderList";
    }

    @PostMapping("/orders/{orderId}/cancle")
    public String cancleOrder(@PathVariable("orderId") Long orderId) {
        orderService.cancleOrder(orderId);
        return "redirect:/orders";
    }
}
