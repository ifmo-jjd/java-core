package ru.itmo.lessons.lesson20;

import java.io.Serializable;

public class Game implements Serializable {

    transient private BinHandler<Game> gameHandler;

    public Game() {
        this.gameHandler = new BinHandler<>();
    }

    public void save(){
        gameHandler.writeToFile(this);
    }

    public void read(){
       Game game = gameHandler.readFromFile();
       // this.user = game.user;
       // this.units = game.units;
    }
}
