package dtos;

public class NumberOfParticipantsPerSportDTO {
    private String sport;
    private int count;

    public NumberOfParticipantsPerSportDTO(String sport, int count) {
        this.sport = sport;
        this.count = count;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "NumberOfParticipantsPerSportDTO{" +
                "sport='" + sport + '\'' +
                ", count=" + count +
                '}';
    }
}
