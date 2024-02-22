
public class TennisGame3 implements TennisGame {

    private int player1Score, player2Score;
    private String player1Name, player2Name;

    public TennisGame3(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        final String[] scoreArray = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        String advantageText = "Advantage ";
        String winText = "Win for ";
        String playerName;
        if (player1Score < 4 && player2Score < 4 && (player1Score + player2Score) != 6) {
            if (player1Score == player2Score){
                return scoreArray[player1Score] + "-All";
            }else{
                return scoreArray[player1Score] + "-" + scoreArray[player2Score];
            }
        } else {
            if (player1Score == player2Score)
                return "Deuce";
            if(player1Score > player2Score){
                playerName = player1Name;
            }else{
                playerName = player2Name;
            }
            int result = (player1Score-player2Score)*(player1Score-player2Score);
            if(result==1){
                return  advantageText + playerName;
            }else{
                return winText + playerName;
            }
        }
    }
    
    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            this.player1Score += 1;
        else
            this.player2Score += 1;
    }

}
