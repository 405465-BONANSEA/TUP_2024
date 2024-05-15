package ar.edu.utn.frc.tup.lciii;

/**
 * Esta clase representa un usuario que va a jugar nuestro juego
 * Puede instanciarse como el usuario que jugará y como la app.
 */
public class User {

    /**
     * Name of the player
     */
    private String name;

    /**
     * Accumulated score of the match
     */
    private Integer score;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }


    public User() {
    }

    public User(String playerName, Integer score) {
        this.name = playerName;
        this.score = score;
    }
}
