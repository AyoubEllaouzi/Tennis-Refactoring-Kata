
public class TennisGame1 implements TennisGame {
    private int player1Score = 0, player2Score = 0;
    private String player1Name, player2Name;

    public TennisGame1(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore() {
        StringBuilder score = new StringBuilder();
        if (player1Score == player2Score) {
            final String[] scoreArray = new String[]{"Love-All", "Fifteen-All", "Thirty-All", "Deuce"};
            score.append(switch (player1Score) {
                case 0 -> scoreArray[0];
                case 1 -> scoreArray[1];
                case 2 -> scoreArray[2];
                default -> scoreArray[3];
            });
        } else if (player1Score >= 4 || player2Score >= 4) {
            int minusResult = player1Score - player2Score;
            String avantageText = "Advantage ";
            String winText = "Win for ";

            if (minusResult == 1)
                score.append(avantageText).append(player1Name);
            else if (minusResult == -1)
                score.append(avantageText).append(player2Name);
            else if (minusResult >= 2)
                score.append(winText).append(player1Name);
            else
                score.append(winText).append(player2Name);
        } else {
            final String[] scoreArray = new String[]{"Love", "Fifteen", "Thirty", "Forty"};
            for (int i = 1; i <= 2; i++) {
                if (i == 2)
                    score.append("-");
                int tempScore = (i == 1) ? player1Score : player2Score;
                switch (tempScore) {
                    case 0 -> score.append(scoreArray[0]);
                    case 1 -> score.append(scoreArray[1]);
                    case 2 -> score.append(scoreArray[2]);
                    case 3 -> score.append(scoreArray[3]);
                }
            }
        }
        return score.toString();
    }

    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            player1Score += 1;
        if (playerName.equals("player2"))
            player2Score += 1;
    }
}
