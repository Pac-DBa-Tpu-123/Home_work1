package main.hw4;

public record Animal(
    String name,
    Type type,
    Sex sex,
    int age,
    int height,
    int weight,
    boolean bites
) {
    public enum Type {
        CAT, DOG, BIRD, FISH, SPIDER
    }

    public enum Sex {
        M, F
    }

    private static final int NUMBER_OF_PAWS_CAT_AND_DOG = 4;
    private static final int NUMBER_OF_PAWS_SPIDER = 8;

    public int paws() {
        return switch (type) {
            case CAT, DOG -> NUMBER_OF_PAWS_CAT_AND_DOG;
            case BIRD -> 2;
            case FISH -> 0;
            case SPIDER -> NUMBER_OF_PAWS_SPIDER;
        };
    }
}
