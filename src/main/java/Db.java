import java.util.*;
import java.util.stream.Collectors;

public class Db {
    private static List<Player> players = new ArrayList<>();

    private Db() {

    }

    public static List<Player> getPlayers() {
        return players;
    }

    public static void addPlayers(Player player) {
        players.add(player);
    }

    public static Optional<Player> getPlayerForName(String nickName) {
        return players.stream().filter(p -> nickName.equals(p.getNickName())).findFirst();
    }

    public static Set<String> getGames() {
//        Закоменнтированный возвращает список всех игр
//        return players.stream().map(x->x.getRating().keySet())
//                .flatMap(Collection::stream).collect(Collectors.toSet());

//        Данный стрим возвращает список игр в которые играют игроки
        return players.stream().map(x->x.getRating().keySet()).skip(1)
                .collect(()-> new HashSet<>(players.get(0).getRating().keySet()), Set::retainAll, Set::retainAll);
    }

    public static Optional<Integer> getRagingByGame(String nickName, String game) {
        return Db.getPlayerForName(nickName).stream().map(g->g.getRating().get(game)).findFirst();
    }

    public static List<String> getBestPlayersByGame(String game) {
        return players.stream().filter(x-> x.getRating().containsKey(game)).sorted(Comparator.comparingInt(o -> o.getRating()
                        .get(game))).map(Player::getNickName).limit(10).collect(Collectors.toList());
    }

    public static List<String> getBestPlayersByGames() {
        return players.stream().sorted(Comparator.comparingInt(o -> o.getRating().values().stream().reduce(Integer::sum).orElse(0)))
                .map(Player::getNickName).limit(10).collect(Collectors.toList());
    }
}
