public class TennisGame6 implements TennisGame {
    private String player1Name, player2Name;
    private int player1Score, player2Score;

    public TennisGame6(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    @Override
    public void wonPoint(String playerName) {
        if (playerName.equals("player1"))
            player1Score++;
        else
            player2Score++;
    }

    public String getScore()
    {
        String score1, score2, result, endGameScore, regularScore, tieScore;
        String advantageText = "Advantage ";
        String winText = "Win for ";
        final String[] arrayScore = new String[]{"Love-All", "Fifteen-All", "Thirty-All","Deuce"};

        if (player1Score == player2Score)
        {
            tieScore = switch (player1Score) {
                case 0 -> arrayScore[0];
                case 1 -> arrayScore[1];
                case 2 -> arrayScore[2];
                default -> arrayScore[3];
            };

            result = tieScore;
        }
        else if (player1Score >= 4 || player2Score >= 4)
        {
            // end-game score
            if (player1Score - player2Score == 1) {
                endGameScore = advantageText + player1Name;
            } else if (player1Score - player2Score == -1) {
                endGameScore = advantageText + player2Name;
            } else if (player1Score - player2Score >= 2) {
                endGameScore = winText + player1Name;
            } else {
                endGameScore = winText + player2Name;
            }

            result = endGameScore;
        }
        else
        {
            score1 = getScoreString(player1Score);
            score2 = getScoreString(player2Score);
            regularScore = score1 + "-" + score2;

            result = regularScore;
        }

        return result;
    }
    // Méthode pour obtenir score en fonction du score du joueur
    private String getScoreString(int playerScore) {
        final String[] arrayScore = new String[]{"Love", "Fifteen", "Thirty","Forty"};
        return switch (playerScore) {
            case 0 -> arrayScore[0];
            case 1 -> arrayScore[1];
            case 2 -> arrayScore[2];
            default -> arrayScore[3];
        };
    }
}
