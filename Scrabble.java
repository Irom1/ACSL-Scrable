public class Scrabble {
    private String[] letters;

    public Scrabble(String word) {
        letters = word.split(", ");
    }

    public int playPositions(String input) {
        int highestScore = 0;
        String[] sections = input.split(", ");
        for (int i = 0; i < sections.length; i += 2) {
            int position = 0;
            boolean hozo = false;
            position = Integer.parseInt(sections[i]);
            if (sections[i + 1].equals("H")) hozo = true;
            int score = playWord(position, hozo);
            if (score > highestScore) highestScore = score;
        }
        return highestScore;
    }

    private int playWord(int position, boolean hozo) {
        int score = 0;
        // find locations of letters and create tiles
        Tile[] tiles = new Tile[letters.length];
        int letterIndex = 0;
        for(String letter: letters) {
            Tile tile = new Tile(letter, position);
            tiles[letterIndex] = tile;
            score += tile.getScore();
            if (hozo) position++;
            else position += 10;
            letterIndex++;
        }
        // check for word multipliers
        for (Tile tile: tiles) {
            score *= tile.getWordMultiplier();
        }
        // return score
        return score;
    }
}
