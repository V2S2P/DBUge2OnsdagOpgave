package dtos;

public class NumberOfParticipantsPerTeamDTO {
    private int count;
    private String team_id;

    public NumberOfParticipantsPerTeamDTO(int count, String team_id) {
        this.count = count;
        this.team_id = team_id;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTeam_id() {
        return team_id;
    }

    public void setTeam_id(String team_id) {
        this.team_id = team_id;
    }

    @Override
    public String toString() {
        return "NumberOfParticipantsPerTeamDTO{" +
                "count=" + count +
                ", team_id='" + team_id + '\'' +
                '}';
    }
}
