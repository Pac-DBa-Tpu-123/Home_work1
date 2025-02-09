package main.hw4;

import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class WorkWithAnimal {

    private static final int ANIMAL_GROWTH = 100;

    private final List<Animal> animals;

    public WorkWithAnimal(List<Animal> animals) {
        this.animals = animals;
    }

    // Задача 1:
    public List<Animal> sortByHeight() {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::height))
            .collect(Collectors.toList());
    }

    // Задача 2:
    public List<Animal> sortByWeightDescending(int k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::weight).reversed())
            .limit(k)
            .collect(Collectors.toList());
    }

    // Задача 3:
    public Map<Animal.Type, Integer> countByType() {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(e -> 1)));
    }

    // Задача 4:
    public Animal longestName() {
        return animals.stream()
            .max(Comparator.comparingInt(a -> a.name().length()))
            .orElse(null);
    }

    // Задача 5:
    public Animal.Sex moreSex() {
        long males = animals.stream().filter(a -> a.sex() == Animal.Sex.M).count();
        long females = animals.stream().filter(a -> a.sex() == Animal.Sex.F).count();
        return males > females ? Animal.Sex.M : Animal.Sex.F;
    }

    // Задача 6:
    public Map<Animal.Type, Animal> heaviestByType() {
        return animals.stream()
            .collect(Collectors.toMap(
                Animal::type,
                a -> a,
                (a1, a2) -> a1.weight() > a2.weight() ? a1 : a2
            ));
    }

    // Задача 7:
    public Animal kthOldestAnimal(int k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::age).reversed())
            .skip(k - 1)
            .findFirst()
            .orElse(null);
    }

    // Задача 8:
    public Optional<Animal> heaviestBelowHeight(int k) {
        return animals.stream()
            .filter(a -> a.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    // Задача 9:
    public int totalPaws() {
        return animals.stream()
            .mapToInt(Animal::paws)
            .sum();
    }

    // Задача 10:
    public List<Animal> ageNotEqualPaws() {
        return animals.stream()
            .filter(a -> a.age() != a.paws())
            .collect(Collectors.toList());
    }

    // Задача 11:
    public List<Animal> bitesAndTallerThan100() {
        return animals.stream()
            .filter(a -> a.bites() && a.height() > ANIMAL_GROWTH)
            .collect(Collectors.toList());
    }

    // Задача 12:
    public int countWeightGreaterThanHeight() {
        return (int) animals.stream()
            .filter(a -> a.weight() > a.height())
            .count();
    }

    // Задача 13:
    public List<Animal> namesWithMoreThanTwoWords() {
        return animals.stream()
            .filter(a -> a.name().split(" ").length > 2)
            .collect(Collectors.toList());
    }

    // Задача 14:
    public boolean hasDogTallerThan(int k) {
        return animals.stream()
            .anyMatch(a -> a.type() == Animal.Type.DOG && a.height() > k);
    }

    // Задача 15:
    public Map<Animal.Type, Integer> totalWeightByTypeAndAge(int k, int l) {
        return animals.stream()
            .filter(a -> a.age() >= k && a.age() <= l)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    // Задача 16:
    public List<Animal> sortByTypeSexName() {
        return animals.stream()
            .sorted(Comparator
                .comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name))
            .collect(Collectors.toList());
    }

    // Задача 17:
    public boolean spidersBiteMoreThanDogs() {
        long spidersBite = animals.stream()
            .filter(a -> a.type() == Animal.Type.SPIDER && a.bites())
            .count();
        long dogsBite = animals.stream()
            .filter(a -> a.type() == Animal.Type.DOG && a.bites())
            .count();
        return spidersBite > dogsBite;
    }

    // Задача 18:
    public Animal heaviestFishInMultipleLists(List<List<Animal>> animalLists) {
        return animalLists.stream()
            .flatMap(Collection::stream)
            .filter(a -> a.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }

    // Задача 19:
    public Map<String, Set<ValidationError>> validateAnimals() {
        Map<String, Set<ValidationError>> validationErrors = new HashMap<>();
        for (Animal animal : animals) {
            Set<ValidationError> errors = new HashSet<>();
            if (animal.age() < 0) {
                errors.add(new ValidationError("Возраст", "Возраст не может быть отрицательным"));
            }
            if (animal.height() < 0) {
                errors.add(new ValidationError("Рост", "Рост не может быть отрицательным"));
            }
            if (animal.weight() < 0) {
                errors.add(new ValidationError("Вес", "Вес не может быть отрицательным"));
            }
            if (!errors.isEmpty()) {
                validationErrors.put(animal.name(), errors);
            }
        }
        return validationErrors;
    }

    // Задача 20:
    public Map<String, String> readableValidationErrors() {
        return validateAnimals().entrySet().stream()
            .collect(Collectors.toMap(
                Map.Entry::getKey,
                e -> e.getValue().stream()
                    .map(ValidationError::getMessage)
                    .collect(Collectors.joining(", "))
            ));
    }

    public static class ValidationError {
        private final String field;
        private final String message;

        public ValidationError(String field, String message) {
            this.field = field;
            this.message = message;
        }

        public String getField() {
            return field;
        }

        public String getMessage() {
            return message;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            ValidationError that = (ValidationError) o;
            return field.equals(that.field) && message.equals(that.message);
        }

        @Override
        public int hashCode() {
            return Objects.hash(field, message);
        }
    }

}
