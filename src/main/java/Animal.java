/**
 * This servlet program is used to print "Hello World" on
 * client browser using annotations.
 */
public class Animal {
    String name;
    String color;

    public String getColor() {
        return color;
    }

    public Animal setColor(String color) {
        this.color = color;
        return this;
    }

    public Animal() {

    }

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }
}