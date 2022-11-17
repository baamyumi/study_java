package ch23;

import java.util.function.Function;

class Animal{
	String name;
	Animal(String name){this.name = name;}
}

class Dog extends Animal{
	Dog(String name){super(name);}
}

class Cow extends Animal{
	Cow(String name){super(name);}
}

public class NewRef2 {

	public static void main(String[] args) {
		addAnimal(Dog::new, "멍멍이");
		addAnimal(Cow::new, "음메에");

	}
	
	static void addAnimal(Function<String, Animal> creator, String s) {
		Animal animal = creator.apply(s);
		System.out.println(animal.name);
	}

}
