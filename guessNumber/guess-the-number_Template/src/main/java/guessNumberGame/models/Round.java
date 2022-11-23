package guessNumberGame.models;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Objects;

public class Round {
    private int round_id;
    int game_id;
    Timestamp guess_time;
    String guess;
    String result;

    public int getId() {
        return round_id;
    }

    public void setId(int round_id) {
        this.round_id = round_id;
    }

    public int getGameId() {
        return game_id;
    }

    public void setGameId(int game_id) {
        this.game_id = game_id;
    }

    public Timestamp getTimeStamp() {
        return guess_time;
    }

    public void setTimeStamp(Timestamp timeStamp) {
        this.guess_time = timeStamp;
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        this.guess = guess;
    }

    public String getGuessResult() {
        return result;
    }

    public void setGuessResult(String guessResult) {
        this.result = guessResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Round round = (Round) o;
        return round_id == round.round_id && game_id == round.game_id && Objects.equals(guess_time, round.guess_time) && Objects.equals(guess, round.guess) && Objects.equals(result, round.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(round_id, game_id, guess_time, guess, result);
    }
}
