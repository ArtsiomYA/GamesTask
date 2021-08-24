import java.util.List;

public class Main {

//    Служит в качестве контроллера
    public static void main(String[] args) {
        ServicePlayers sp = new ServicePlayers();
        sp.registerPlayers("maza-faka", List.of("PBG", "DOTA", "DOMINO"));
        System.out.println(Db.getPlayers().toString());
        sp.addRating("maza-faka", "DOTA");
        System.out.println(Db.getPlayers().toString());
        sp.registerPlayers("Alex1995", List.of("DOTA", "FOOTBALL"));
        System.out.println(Db.getPlayers().toString());
        sp.addRating("Alex1995", "DOTA");
        sp.addRating("Alex1995", "DOTA");
        System.out.println(Db.getPlayers().toString());
        System.out.println(Db.getGames());
        System.out.println(Db.getRagingByGame("maza-faka", "DOTA"));
        System.out.println(Db.getBestPlayersByGame("PBG"));
        sp.addRating("maza-faka", "DOTA");
        sp.addRating("maza-faka", "DOTA");
        System.out.println(Db.getPlayers());
        System.out.println(Db.getBestPlayersByGames());
    }
}
