package main.hw4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidateAnimalsTest {

    private List<Animal> animals;
    private WorkWithAnimal workWithAnimal;

    @BeforeEach
    public void setUp() {
        animals = Arrays.asList(
            new Animal("Cat1", Animal.Type.CAT, Animal.Sex.M, 3, 50, 5000, false),
            new Animal("Cat2", Animal.Type.CAT, Animal.Sex.F, 2, 40, 4000, true),
            new Animal("Dog1", Animal.Type.DOG, Animal.Sex.F, -5, 120, 30000, true),
            new Animal("Dog2", Animal.Type.DOG, Animal.Sex.M, 7, 150, 40000, false),
            new Animal("Bird1", Animal.Type.BIRD, Animal.Sex.M, 3, 25, 1500, false),
            new Animal("Bird2", Animal.Type.BIRD, Animal.Sex.M, 1, 15, -1000, true),
            new Animal("Fish1", Animal.Type.FISH, Animal.Sex.F, 1, 12, 500, false),
            new Animal("Fish2", Animal.Type.FISH, Animal.Sex.M, 2, 20, 1000, false),
            new Animal("Spider1", Animal.Type.SPIDER, Animal.Sex.M, 5, 10, 300, true),
            new Animal("Spider2", Animal.Type.SPIDER, Animal.Sex.F, 1, -5, 100, true)
        );
        workWithAnimal = new WorkWithAnimal(animals);
    }

    @Test
    public void testValidateAnimals() {
        Map<String, Set<WorkWithAnimal.ValidationError>> validationErrors = workWithAnimal.validateAnimals();

        Map<String, Set<WorkWithAnimal.ValidationError>> expected = new HashMap<>();
        expected.put("Dog1", Set.of(new WorkWithAnimal.ValidationError("Возраст", "Возраст не может быть отрицательным")));
        expected.put("Bird2", Set.of(new WorkWithAnimal.ValidationError("Вес", "Вес не может быть отрицательным")));
        expected.put("Spider2", Set.of(new WorkWithAnimal.ValidationError("Рост", "Рост не может быть отрицательным")));

        assertEquals(expected, validationErrors);
    }

    @Test
    public void testReadableValidationErrors() {
        Map<String, String> readableErrors = workWithAnimal.readableValidationErrors();

        Map<String, String> expected = new HashMap<>();
        expected.put("Dog1", "Возраст не может быть отрицательным");
        expected.put("Bird2", "Вес не может быть отрицательным");
        expected.put("Spider2", "Рост не может быть отрицательным");

        assertEquals(expected, readableErrors);
    }
}
