package me.koply.sahbaturgulbatur;

import me.koply.sahbaturgulbatur.records.Game;
import me.koply.sahbaturgulbatur.records.Horse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Main {

    public Main() {
        try {
            Game[] games = getGames();
            printGames(games);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Main();
    }

    private void printGames(Game[] games) {
        for (Game g : games) {
            g.printInformation();
        }
    }

    private Game[] getGames() throws IOException {
        String url = "https://liderform.com.tr/program";
        Document doc = Jsoup.connect(url).get();
        Elements raceblocks = doc.select(".race-block");
        Game[] games = new Game[raceblocks.toArray().length];
        int i = 0;
        for (Element race : raceblocks) {
            Game game = new Game();
            game.setTitle(race.selectFirst(".title").text());
            game.setDescription(race.selectFirst(".race-info-text").text());
            game.setRunwaylength(race.selectFirst(".length-block .runway-text").text());

            Elements table = race.select(".table-normal tbody tr");
            Horse[] horses = new Horse[table.toArray().length];
            int j = 0;
            for (Element e : table) {
                Horse horse = new Horse();
                Elements tdelements = e.select("td");
                horse.setName(tdelements.get(2).selectFirst(".table_name_big").text());
                horse.setWeight(tdelements.get(4).text());
                horse.setJokey(tdelements.get(6).selectFirst(".table_name_big").text());
                horse.setAge(Integer.parseInt(tdelements.get(7).text().split("/")[2]));
                horses[j] = horse;
                j++;
            }
            game.setHorses(horses);
            games[i] = game;
            i++;
        }
        // jsoup ile sitedeki .race-block elementlerini çek ve hepsini döngü ile listeye ekle
        return games;
    }
}
