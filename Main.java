import java.util.Scanner;

public class Main {
    private static PetRegistry registry = new PetRegistry();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            System.out.println("\n*** Домашний Реестр Животных ***");
            System.out.println("1. Добавить животное");
            System.out.println("2. Вывести команды животного");
            System.out.println("3. Обучить животное новой команде");
            System.out.println("4. Вывести список животных по дате рождения");
            System.out.println("5. Вывести общее количество животных");
            System.out.println("6. Выйти");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Очистка буфера сканера

            switch (choice) {
                case 1:
                    addNewAnimal();
                    break;
                case 2:
                    printCommands();
                    break;
                case 3:
                    teachCommand();
                    break;
                case 4:
                    registry.printAnimalsByBirthDate();
                    break;
                case 5:
                    registry.printTotalAnimalsCount();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор, попробуйте снова.");
            }
        }

        scanner.close();
        System.out.println("Программа завершена.");
    }

    private static void addNewAnimal() {
        System.out.println("Добавление нового животного.");
        System.out.print("Введите тип животного (Cat/Dog/Hamster): ");
        String type = scanner.nextLine();
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения (YYYY-MM-DD): ");
        String birthDate = scanner.nextLine();

        DomesticAnimal animal;
        switch (type.toLowerCase()) {
            case "cat":
                animal = new Cat(name, birthDate);
                break;
            case "dog":
                animal = new Dog(name, birthDate);
                break;
            case "hamster":
                animal = new Hamster(name, birthDate);
                break;
            default:
                System.out.println("Неподдерживаемый тип животного. Попробуйте снова.");
                return;
        }
        registry.addPet(animal);
        System.out.println("Животное добавлено: " + animal.getClass().getSimpleName() + " - Имя: " + name);
    }

    private static void printCommands() {
        System.out.print("Введите имя животного для отображения команд: ");
        String name = scanner.nextLine();
        registry.printAnimalCommands(name);
    }

    private static void teachCommand() {
        System.out.print("Введите имя животного для обучения новой команде: ");
        String name = scanner.nextLine();
        System.out.print("Введите команду для обучения: ");
        String command = scanner.nextLine();
        registry.teachAnimalCommand(name, command);
    }
}
