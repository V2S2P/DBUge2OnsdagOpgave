import dtos.MemberAndSportsDTO;
import dtos.NumberOfParticipantsPerSportDTO;
import dtos.NumberOfParticipantsPerTeamDTO;
import entities.Member;
import entities.Registration;
import persistence.Database;
import persistence.MemberMapper;
import persistence.RegistrationMapper;

import java.util.List;

public class Main {

    private final static String USER = "postgres";
    private final static String PASSWORD = "postgres";
    private final static String URL = "jdbc:postgresql://localhost:5432/sportsclub?currentSchema=public";

    public static void main(String[] args) {

        Database db = new Database(USER, PASSWORD, URL);
        MemberMapper memberMapper = new MemberMapper(db);
        RegistrationMapper registrationMapper = new RegistrationMapper(db);
        List<Member> members = memberMapper.getAllMembers();
        List<Registration> registrations = registrationMapper.getAllRegistrations();

        showMembers(members);
        //showMemberById(memberMapper, 13);

        List<NumberOfParticipantsPerSportDTO> dtoList = memberMapper.getNumberOfParticipantsPerSport();
        System.out.println("Antal deltagere per sportsgren");
        dtoList.forEach(System.out::println);

        List<NumberOfParticipantsPerTeamDTO> dtoList1 = memberMapper.getNumberOfParticipantsPerTeam();
        System.out.println("Antal deltagere per team");
        dtoList1.forEach(System.out::println);

        List<MemberAndSportsDTO> dtoList2 = memberMapper.getMemberAndSportsById(10);
        dtoList2.forEach(System.out::println);

        /*  
            int newMemberId = insertMember(memberMapper);
            deleteMember(newMemberId, memberMapper);
            showMembers(members);
            updateMember(13, memberMapper);
        */
    }

    private static void deleteMember(int memberId, MemberMapper memberMapper) {
        if (memberMapper.deleteMember(memberId)){
            System.out.println("Member with id = " + memberId + " is removed from DB");
        }
    }

    private static int insertMember(MemberMapper memberMapper) {
        Member m1 = new Member("Ole Olsen", "Banegade 2", 3700, "Rønne", "m", 1967);
        Member m2 = memberMapper.insertMember(m1);
        showMemberById(memberMapper, m2.getMemberId());
        return m2.getMemberId();
    }

    private static void updateMember(int memberId, MemberMapper memberMapper) {
        Member m1 = memberMapper.getMemberById(memberId);
        m1.setYear(1970);
        if(memberMapper.updateMember(m1)){
            showMemberById(memberMapper, memberId);
        }
    }

    private static void showMemberById(MemberMapper memberMapper, int memberId) {
        System.out.println("***** Vis medlem nr. 13: *******");
        System.out.println(memberMapper.getMemberById(memberId).toString());
    }

    private static void showMembers(List<Member> members) {
        System.out.println("***** Vis alle medlemmer *******");
        for (Member member : members) {
            System.out.println(member.toString());
        }
    }
    private static void showRegistrations(List<Registration> registrations){
        System.out.println("***** Vis alle registreringer *****");
        for (Registration registration : registrations){
            System.out.println(registration.toString());
        }
    }


}
