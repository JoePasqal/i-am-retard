public abstract class Animal {
    protected String name;
    protected String birthDate;
    // Стат перемен для подсчета усех животных
    protected static int animalCount = 0;

    public Animal(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        animalCount++;
    }

    // типа абстракт метод для вывода команд
    public abstract void printCommands();

    // Геттер для статической переменной animalCount
    public static int getAnimalCount() {
        return animalCount;
    }
}
