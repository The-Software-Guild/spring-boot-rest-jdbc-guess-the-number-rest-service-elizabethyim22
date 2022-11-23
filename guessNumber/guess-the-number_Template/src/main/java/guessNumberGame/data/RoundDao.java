package guessNumberGame.data;

import guessNumberGame.models.Round;

import java.util.List;
public interface RoundDao {
    Round add(Round round);

    List<Round> getAll();

    List<Round> getAllOfGame(int gameId);

    Round findById(int id);

    // true if item exists and is updated
    boolean update(Round round);

    // true if item exists and is deleted
    boolean deleteById(int id);
}
