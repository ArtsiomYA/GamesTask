import java.util.*;
import java.util.stream.Collectors;

public class ServicePlayers {

    public void registerPlayers(String nickName, Collection<String> games) {

        if (isPlayerExist(nickName)) {
            System.out.println("This nick is exist!");
        } else {
            Player player = new Player();
            player.setNickName(nickName);
            Map<String, Integer> rating = new HashMap<>();
            games.forEach(g -> rating.put(g,0));
            player.setRating(rating);
            Db.addPlayers(player);
        }

    }

    private boolean isPlayerExist(String nickName) {
        return Db.getPlayers().stream().map(Player::getNickName).collect(Collectors.toList()).contains(nickName);
    }

    public void addRating(String nickName, String game) {
        Db.getPlayerForName(nickName).ifPresent(p -> p.getRating().computeIfPresent(game, (key, value) -> value+1));
    }

}
