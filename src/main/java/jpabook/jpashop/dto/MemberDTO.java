package jpabook.jpashop.dto;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class MemberDTO {

    public MemberDTO(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.address = member.getAddress();
    }

    private Long id;
    private String name;
    private Address address;
}
