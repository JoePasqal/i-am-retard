import java.util.ArrayList;

public abstract class DomesticAnimal extends Animal {
    protected ArrayList<String> commands;

    public DomesticAnimal(String name, String birthDate) {
        super(name, birthDate);
        this.commands = new ArrayList<>();
    }

    public void learnCommand(String command) {
        commands.add(command);
    }

    @Override
    public void printCommands() {
        System.out.println("Commands for " + name + ": " + commands);
    }
}
