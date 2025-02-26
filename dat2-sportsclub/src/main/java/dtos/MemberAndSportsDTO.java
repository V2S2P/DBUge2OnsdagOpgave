package dtos;

import entities.Member;

import java.util.List;

public class MemberAndSportsDTO {
    private Member member;
    private List<String> sports;

    public MemberAndSportsDTO(Member member, List<String> sports) {
        this.member = member;
        this.sports = sports;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<String> getSports() {
        return sports;
    }

    public void setSports(List<String> sports) {
        this.sports = sports;
    }

    @Override
    public String toString() {
        return "MemberAndSportsDTO{" +
                "member=" + member +
                ", sports=" + sports +
                '}';
    }
}
