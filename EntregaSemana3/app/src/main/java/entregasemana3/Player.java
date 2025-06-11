package entregasemana3;

public class Player {
    private RecordScore score;
    private String username;
    private String password;

    public Player(String userName, String pass) {
        username = userName;
        password = pass;
        score = new RecordScore();
    }

    public RecordScore getScore(){
        return score;
    }
}
