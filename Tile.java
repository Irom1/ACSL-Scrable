public class Tile {
    // instance variables
    public String letter;
    public int score;
    public int position;
    public int wordMultiplier = 1;
    // constructor
    public Tile(String letter, int position) {
        this.letter = letter;
        this.position = position;
        score = scoreLetter(letter);
        score *= scorePosition(position);
    }
    // accessors
    public int getScore() {
        return score;
    }
    public int getWordMultiplier() {
        return wordMultiplier;
    }
    // other methods used in constructor
    private int scoreLetter(String letter) {
        int score = 1;
        if (letter.equals("J") || letter.equals("X")) score = 8;
        else if (letter.equals("V") || letter.equals("Y")) score = 4;
        else if (letter.equals("B") || letter.equals("M")) score = 3;
        else if (letter.equals("D") || letter.equals("R")) score = 2;
        return score;
    }
    private int scorePosition(int position) {
        // The squares that are every other multiple of 3 ( 3, 9, 15...) are Double Letter score squares.
        // The squares that are multiples of 5 and not used above are Triple Letter score squares.
        // The squares that are multiples of 7 and not used above are Double Word score squares.
        // The squares that are multiples of 8 and not used above are Triple Word score squares.
        int score = 1;
        if (position % 6 == 3) score = 2;
        else if(position % 5 == 0) score = 3;
        else if(position % 7 == 0) wordMultiplier = 2;
        else if(position % 8 == 0) wordMultiplier = 3;
        return score;
    }
}
