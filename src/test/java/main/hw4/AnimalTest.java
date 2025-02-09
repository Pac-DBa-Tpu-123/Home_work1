package main.hw4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {

    private List<Animal> animals;
    private WorkWithAnimal workWithAnimal;

    @BeforeEach
    public void setUp() {
        animals = Arrays.asList(
            new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 3, 50, 5000, false),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.F, 2, 40, 4000, true),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.F, 5, 120, 30000, true),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 7, 150, 40000, false),
            new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 3, 25, 1500, false),
            new Animal("Bird2", Animal.Type.BIRD, Animal.Sex.M, 1, 15, 1000, true),
            new Animal("Fish1", Animal.Type.FISH, Animal.Sex.F, 1, 12, 500, false),
            new Animal("Fish2", Animal.Type.FISH, Animal.Sex.M, 2, 20, 1000, false),
            new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.M, 5, 10, 300, true),
            new Animal("Spider2", Animal.Type.SPIDER, Animal.Sex.F, 1, 5, 100, true)
        );
        workWithAnimal = new WorkWithAnimal(animals);
    }

    @Test
    public void testSortByHeight() {
        List<Animal> sortedAnimals = workWithAnimal.sortByHeight();
        assertEquals("Spider2", sortedAnimals.get(0).name());
        assertEquals("Spider1", sortedAnimals.get(1).name());
        assertEquals("Fish1", sortedAnimals.get(2).name());
        assertEquals("Bird2", sortedAnimals.get(3).name());
        assertEquals("Fish2", sortedAnimals.get(4).name());
        assertEquals("Bird1", sortedAnimals.get(5).name());
        assertEquals("Cat2", sortedAnimals.get(6).name());
        assertEquals("Cat1", sortedAnimals.get(7).name());
        assertEquals("Dog1", sortedAnimals.get(8).name());
        assertEquals("Dog2", sortedAnimals.get(9).name());
    }

    @Test
    public void testSortByWeightDescending() {
        List<Animal> sortedAnimals = workWithAnimal.sortByWeightDescending(5);
        assertEquals(5, sortedAnimals.size());
        assertEquals("Dog2", sortedAnimals.get(0).name());
        assertEquals("Dog1", sortedAnimals.get(1).name());
        assertEquals("Cat1", sortedAnimals.get(2).name());
        assertEquals("Cat2", sortedAnimals.get(3).name());
        assertEquals("Bird1", sortedAnimals.get(4).name());
    }

    @Test
    public void testCountByType() {
        Map<Animal.Type, Integer> countByType = workWithAnimal.countByType();
        assertEquals(10, countByType.values().stream().mapToInt(Integer::intValue).sum());
        assertEquals(2, countByType.get(Animal.Type.CAT));
        assertEquals(2, countByType.get(Animal.Type.DOG));
        assertEquals(2, countByType.get(Animal.Type.BIRD));
        assertEquals(2, countByType.get(Animal.Type.FISH));
        assertEquals(2, countByType.get(Animal.Type.SPIDER));
    }

    @Test
    public void testLongestName() {
        Animal longestNameAnimal = workWithAnimal.longestName();
        assertEquals("Spider1", longestNameAnimal.name());
    }

    @Test
    public void testMoreSex() {
        Animal.Sex moreSex = workWithAnimal.moreSex();
        assertEquals(Animal.Sex.M, moreSex);
    }

    @Test
    public void testHeaviestByType() {
        Map<Animal.Type, Animal> heaviestByType = workWithAnimal.heaviestByType();
        assertEquals("Dog2", heaviestByType.get(Animal.Type.DOG).name());
        assertEquals("Cat1", heaviestByType.get(Animal.Type.CAT).name());
        assertEquals("Bird1", heaviestByType.get(Animal.Type.BIRD).name());
        assertEquals("Fish2", heaviestByType.get(Animal.Type.FISH).name());
        assertEquals("Spider1", heaviestByType.get(Animal.Type.SPIDER).name());
    }

    @Test
    public void testKthOldestAnimal() {
        Animal kthOldestAnimal = workWithAnimal.kthOldestAnimal(2);
        assertEquals("Dog1", kthOldestAnimal.name());
    }

    @Test
    public void testHeaviestBelowHeight() {
        Optional<Animal> heaviestBelowHeight = workWithAnimal.heaviestBelowHeight(100);
        assertTrue(heaviestBelowHeight.isPresent());
        assertEquals("Cat1", heaviestBelowHeight.get().name());
    }

    @Test
    public void testTotalPaws() {
        int totalPaws = workWithAnimal.totalPaws();
        assertEquals(36, totalPaws);
    }

    @Test
    public void testAgeNotEqualPaws() {
        List<Animal> ageNotEqualPaws = workWithAnimal.ageNotEqualPaws();
        assertEquals(10, ageNotEqualPaws.size());
    }

    @Test
    public void testBitesAndTallerThan100() {
        List<Animal> bitesAndTallerThan100 = workWithAnimal.bitesAndTallerThan100();
        assertEquals(1, bitesAndTallerThan100.size());
        assertEquals("Dog1", bitesAndTallerThan100.get(0).name());
    }

    @Test
    public void testCountWeightGreaterThanHeight() {
        int countWeightGreaterThanHeight = workWithAnimal.countWeightGreaterThanHeight();
        assertEquals(10, countWeightGreaterThanHeight);
    }

    @Test
    public void testNamesWithMoreThanTwoWords() {
        List<Animal> namesWithMoreThanTwoWords = workWithAnimal.namesWithMoreThanTwoWords();
        assertTrue(namesWithMoreThanTwoWords.isEmpty());
    }

    @Test
    public void testHasDogTallerThan() {
        boolean hasDogTallerThan = workWithAnimal.hasDogTallerThan(100);
        assertTrue(hasDogTallerThan);
    }

    @Test
    public void testTotalWeightByTypeAndAge() {
        Map<Animal.Type, Integer> totalWeightByTypeAndAge = workWithAnimal.totalWeightByTypeAndAge(1, 3);
        assertEquals(4, totalWeightByTypeAndAge.size());
        assertEquals(9000, totalWeightByTypeAndAge.get(Animal.Type.CAT));
        assertEquals(2500, totalWeightByTypeAndAge.get(Animal.Type.BIRD));
        assertEquals(null, totalWeightByTypeAndAge.get(Animal.Type.DOG));
    }

    @Test
    public void testSortByTypeSexName() {
        List<Animal> sortedAnimals = workWithAnimal.sortByTypeSexName();
        assertEquals("Cat1", sortedAnimals.get(0).name());
        assertEquals("Cat2", sortedAnimals.get(1).name());
        assertEquals("Dog2", sortedAnimals.get(2).name());
        assertEquals("Dog1", sortedAnimals.get(3).name());
        assertEquals("Bird1", sortedAnimals.get(4).name());
        assertEquals("Bird2", sortedAnimals.get(5).name());
        assertEquals("Fish2", sortedAnimals.get(6).name());
        assertEquals("Fish1", sortedAnimals.get(7).name());
        assertEquals("Spider1", sortedAnimals.get(8).name());
        assertEquals("Spider2", sortedAnimals.get(9).name());
    }

    @Test
    public void testSpidersBiteMoreThanDogs() {
        boolean spidersBiteMoreThanDogs = workWithAnimal.spidersBiteMoreThanDogs();
        assertTrue(spidersBiteMoreThanDogs);
    }

    @Test
    public void testHeaviestFishInMultipleLists() {
        List<List<Animal>> animalLists = Arrays.asList(
            Arrays.asList(
                new Animal("Fish3", Animal.Type.FISH, Animal.Sex.F, 2, 15, 1000, false),
                new Animal("Fish4", Animal.Type.FISH, Animal.Sex.M, 3, 20, 2000, false)
            ),
            Arrays.asList(
                new Animal("Fish5", Animal.Type.FISH, Animal.Sex.F, 1, 10, 500, false)
            )
        );
        Animal heaviestFish = workWithAnimal.heaviestFishInMultipleLists(animalLists);
        assertEquals("Fish4", heaviestFish.name());
    }
}
