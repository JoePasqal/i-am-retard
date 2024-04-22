import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PetRegistry {
    private List<DomesticAnimal> pets;

    public PetRegistry() {
        pets = new ArrayList<>();
    }

    // Добавление животного в реестр
    public void addPet(DomesticAnimal pet) {
        pets.add(pet);
    }

    // Вывод списка команд животного
    public void printAnimalCommands(String animalName) {
        for (DomesticAnimal pet : pets) {
            if (pet.name.equals(animalName)) {
                pet.printCommands();
                return;
            }
        }
        System.out.println("Такое животное " + animalName + " не найдено.");
    }

    // Обучение животного новой команде
    public void teachAnimalCommand(String animalName, String command) {
        for (DomesticAnimal pet : pets) {
            if (pet.name.equals(animalName)) {
                pet.learnCommand(command);
                System.out.println("Животное " + animalName + " обучено команде: " + command);
                return;
            }
        }
        System.out.println("Такое животное " + animalName + " не найдено.");
    }

    // Вывод списка животных по дате рождения
    public void printAnimalsByBirthDate() {
        pets.stream()
            .sorted(Comparator.comparing(animal -> animal.birthDate))
            .forEach(animal -> System.out.println(animal.name + " - " + animal.birthDate));
    }

    // Получение общего количества животных в реестре
    public void printTotalAnimalsCount() {
        System.out.println("Общее количество животных в реестре: " + Animal.getAnimalCount());
    }
}
