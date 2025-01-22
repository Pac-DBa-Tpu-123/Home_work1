package main.project1.hangmanGame;

public class HangmanPics {

    private static final String PART_ONE_OF_THE_GALLOWS = " \n+--+\n";
    private static final String PART_TOW_OF_THE_GALLOWS = " |  |\n";
    private static final String PART_TREE_OF_THE_GALLOWS = "    |\n";
    private static final String PART_FOUR_OF_THE_GALLOWS = "=========";
    private static final String PART_FIVE_OF_THE_GALLOWS = " O  |\n";
    private static final String PART_SIX_OF_THE_GALLOWS = "/|\\ |\n";

    static final String[] HANGMAN_PICS = {
        PART_ONE_OF_THE_GALLOWS
            + PART_TOW_OF_THE_GALLOWS
            + PART_TREE_OF_THE_GALLOWS
            + PART_TREE_OF_THE_GALLOWS
            + PART_TREE_OF_THE_GALLOWS
            + PART_TREE_OF_THE_GALLOWS
            + PART_FOUR_OF_THE_GALLOWS,

        PART_ONE_OF_THE_GALLOWS
            + PART_TOW_OF_THE_GALLOWS
            + PART_FIVE_OF_THE_GALLOWS
            + PART_TREE_OF_THE_GALLOWS
            + PART_TREE_OF_THE_GALLOWS
            + PART_TREE_OF_THE_GALLOWS
            + PART_FOUR_OF_THE_GALLOWS,

        PART_ONE_OF_THE_GALLOWS
            + PART_TOW_OF_THE_GALLOWS
            + PART_FIVE_OF_THE_GALLOWS
            + PART_TOW_OF_THE_GALLOWS
            + PART_TREE_OF_THE_GALLOWS
            + PART_TREE_OF_THE_GALLOWS
            + PART_FOUR_OF_THE_GALLOWS,

        PART_ONE_OF_THE_GALLOWS
            + PART_TOW_OF_THE_GALLOWS
            + PART_FIVE_OF_THE_GALLOWS
            + "/|  |\n"
            + PART_TREE_OF_THE_GALLOWS
            + PART_TREE_OF_THE_GALLOWS
            + PART_FOUR_OF_THE_GALLOWS,

        PART_ONE_OF_THE_GALLOWS
            + PART_TOW_OF_THE_GALLOWS
            + PART_FIVE_OF_THE_GALLOWS
            + PART_SIX_OF_THE_GALLOWS
            + PART_TREE_OF_THE_GALLOWS
            + PART_TREE_OF_THE_GALLOWS
            + PART_FOUR_OF_THE_GALLOWS,

        PART_ONE_OF_THE_GALLOWS
            + PART_TOW_OF_THE_GALLOWS
            + PART_FIVE_OF_THE_GALLOWS
            + PART_SIX_OF_THE_GALLOWS
            + "/   |\n"
            + PART_TREE_OF_THE_GALLOWS
            + PART_FOUR_OF_THE_GALLOWS,

        PART_ONE_OF_THE_GALLOWS
            + PART_TOW_OF_THE_GALLOWS
            + PART_FIVE_OF_THE_GALLOWS
            + PART_SIX_OF_THE_GALLOWS
            + "/ \\ |\n"
            + PART_TREE_OF_THE_GALLOWS
            + PART_FOUR_OF_THE_GALLOWS
    };

    private HangmanPics() {
        throw new UnsupportedOperationException("Utility class");
    }

}
