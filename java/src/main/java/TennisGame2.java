
public class TennisGame2 implements TennisGame
{
    private int player1Score = 0, player2Score = 0;
    private String player1Name, player2Name;

    public TennisGame2(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }
    
    public String getScore() {
        final String[] scoreArray = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
        String advantageText = "Advantage ";
        String winText = "Win for ";
        String score;

        if (player1Score == player2Score) {
            if (player1Score < 3) {
                score = scoreArray[player1Score] + "-All";
            } else {
                score = "Deuce";
            }
        } else if (player1Score >= 4 || player2Score >= 4) {
            int result = Math.abs(player1Score - player2Score);
            if (result >= 2) {
                if (player1Score > player2Score)
                    score = winText + player1Name;
                else
                    score = winText + player2Name;
            } else {
                if (player1Score > player2Score)
                    score = advantageText + player1Name;
                else
                    score = advantageText + player2Name;
            }
        } else {
            score = scoreArray[player1Score] + "-" + scoreArray[player2Score];
        }
        return score;
    }
    
    public void wonPoint(String player) {
        if (player.equals("player1"))
            player1Score++;
        else
            player2Score++;
    }
}