import java.util.Map;

public class Player {
    private String nickName;
    private Map<String, Integer> rating;


    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Map<String, Integer> getRating() {
        return rating;
    }

    public void setRating(Map<String, Integer> rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Player{" +
                "nickName='" + nickName + '\'' +
                ", rating=" + rating +
                '}';
    }
}
