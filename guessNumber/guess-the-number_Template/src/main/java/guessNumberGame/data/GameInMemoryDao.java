package guessNumberGame.data;

import guessNumberGame.models.Game;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

//@Repository
public class GameInMemoryDao implements GameDao {

    private static final List<Game> games = new ArrayList<>();

    @Override
    public Game add(Game game) {

        int nextId = games.stream()
                .mapToInt(Game::getGameId)
                .max()
                .orElse(0) + 1;

        game.setGameId(nextId);
        games.add(game);
        return game;
    }

    @Override
    public List<Game> getAll() {
        return new ArrayList<>(games);
    }

    @Override
    public Game findById(int id) {
        return games.stream()
                .filter(i -> i.getGameId() == id)
                .findFirst()
                .orElse(null);
    }

    @Override
    public boolean update(Game game) {

        int index = 0;
        while (index < games.size()
                && games.get(index).getGameId() != game.getGameId()) {
            index++;
        }

        if (index < games.size()) {
            games.set(index, game);
        }
        return index < games.size();
    }

    @Override
    public boolean deleteById(int id) {
        return games.removeIf(i -> i.getGameId() == id);
    }

}
