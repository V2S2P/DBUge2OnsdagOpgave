package dtos;

public class GenderCountDTO {
    private String gender;
    private int count;

    public GenderCountDTO(String gender, int count) {
        this.gender = gender;
        this.count = count;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "GenderCountDTO{" +
                "gender='" + gender + '\'' +
                ", count=" + count +
                '}';
    }
}
