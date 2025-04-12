package llds.splitwise.entities;

public class UserLevelOwe {
    String user1Id;
    String user2Id;
    double user1Contribution;
    double user2Contribution;

    public UserLevelOwe(String user1Id, String user2Id, double user1Contribution, double user2Contribution) {
        this.user1Id = user1Id;
        this.user2Id = user2Id;
        this.user1Contribution = user1Contribution;
        this.user2Contribution = user2Contribution;
    }

    public void setUser1Contribution(double user1Contribution) {
        this.user1Contribution = user1Contribution;
    }

    public void setUser2Contribution(double user2Contribution) {
        this.user2Contribution = user2Contribution;
    }


}
