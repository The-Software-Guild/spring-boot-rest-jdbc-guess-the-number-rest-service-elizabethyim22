package guessNumberGame.models;


import java.util.Objects;

public class Game {
    private int game_id;
    private String answer;
    private boolean isFinished;

    public int getGameId() {
        return game_id;
    }

    public void setGameId(int game_id) {
        this.game_id = game_id;
    }

    public String getAnswer() {
        return this.answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public boolean getIsFinished() {
        return isFinished;
    }

    public void setIsFinished(boolean finished) {
        this.isFinished = finished;
    }

    public String toString(){
        String game_id = String.valueOf(this.getGameId());
        String ans = this.getAnswer();
        String isFin = String.valueOf(this.getIsFinished());

        return String.format("Id: %s \nans: %s \nisFin: %s", game_id, ans, isFin);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return game_id == game.game_id && isFinished == game.isFinished && Objects.equals(answer, game.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(game_id, answer, isFinished);
    }
}
