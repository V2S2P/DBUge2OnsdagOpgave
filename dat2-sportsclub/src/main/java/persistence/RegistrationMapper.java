package persistence;

import dtos.NumberOfParticipantsPerSportDTO;
import dtos.NumberOfParticipantsPerTeamDTO;
import entities.Member;
import entities.Registration;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RegistrationMapper {

        private Database database;

        public RegistrationMapper(Database database) {
            this.database = database;
        }

        public boolean addToTeam(Registration registration){
            boolean result = false;
            String sql = "insert into registration (member_id, team_id, price) values (?,?,?)";
            try (Connection connection = database.connect()) {
                try (PreparedStatement ps = connection.prepareStatement(sql)) {
                    ps.setInt(1, registration.getMemberId());
                    ps.setString(2, registration.getTeamId());
                    ps.setInt(3, registration.getPrice());
                    int rowsAffected = ps.executeUpdate();
                    if (rowsAffected == 1){
                        result = true;
                    }
                } catch (SQLException throwables) {
                    // TODO: Make own throwable exception and let it bubble upwards
                    throwables.printStackTrace();
                }
            } catch (SQLException throwables) {
                // TODO: Make own throwable exception and let it bubble upwards
                throwables.printStackTrace();
            }
            return result;
        }
    public List<Registration> getAllRegistrations() {

        List<Registration> registrationsList = new ArrayList<>();

        String sql = "SELECT member.name, registration.member_id, team_id, price " +
                "FROM registration " +
                "JOIN member ON registration.member_id = member.member_id " +
                "ORDER BY member.member_id";


        try (Connection connection = database.connect()) {
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
                ResultSet rs = ps.executeQuery();
                while (rs.next()) {
                    String name = rs.getString("name");
                    int memberId = rs.getInt("member_id");
                    String teamId = rs.getString("team_id");
                    int price = rs.getInt("price");
                    registrationsList.add(new Registration(name,memberId,teamId,price));
                }
            } catch (SQLException throwables) {
                // TODO: Make own throwable exception and let it bubble upwards
                throwables.printStackTrace();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return registrationsList;
    }
}
