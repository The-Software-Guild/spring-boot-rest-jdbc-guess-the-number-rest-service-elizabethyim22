package guessNumberGame.controllers;

import guessNumberGame.Service.GameService;
import guessNumberGame.data.GameDao;
import guessNumberGame.data.RoundDao;
import guessNumberGame.models.Game;
import java.util.List;

import guessNumberGame.models.Round;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class GameController {


    private final GameDao gameDao;
    private final RoundDao roundDao;


    public GameController(GameDao gameDao, RoundDao roundDao) {
       this.gameDao=gameDao;
       this.roundDao=roundDao;
    }

    @PostMapping("/begin")
    @ResponseStatus(HttpStatus.CREATED)
    public Game create() {
        GameService gameService = new GameService();
        Game newGame = gameService.newGame();
        gameDao.add(newGame);
        return gameService.getGames(newGame);
    }


    @PostMapping("/guess")
    @ResponseStatus(HttpStatus.CREATED)
    public Round guessNumber(@RequestBody Round body) {
        Game game = gameDao.findById(body.getGameId());
        GameService gameService = new GameService();
        Round round = gameService.guessNumber(game, body.getGuess(), gameDao);
        return roundDao.add(round);
    }

    @GetMapping("/game")
    public List<Game> all() {
        List<Game> games = gameDao.getAll();
        GameService gameService = new GameService();
        gameService.getAllGames(games);
        return games;
    }

    @GetMapping("game/{id}")
    public Game getGameById(@PathVariable int id) {
        Game game = gameDao.findById(id);
        GameService gameService = new GameService();
        return gameService.getGames(game);
    }

    @GetMapping("rounds/{gameId}")
    public List<Round> getGameRounds (@PathVariable int gameId){
        return roundDao.getAllOfGame(gameId);
    }

}