package entities;

public class Registration {
    private String name;
    private int memberId;
    private String teamId;
    private int price;

    public Registration(String name, int memberId, String teamId, int price) {
        this.name = name;
        this.memberId = memberId;
        this.teamId = teamId;
        this.price = price;
    }

    public Registration(int memberId, String teamId, int price) {
        this.memberId = memberId;
        this.teamId = teamId;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Registration{" +
                "name='" + name + '\'' +
                ", memberId=" + memberId +
                ", teamId='" + teamId + '\'' +
                ", price=" + price +
                '}';
    }
}
