package ar.com.streams.main;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import ar.com.streams.model.Person;

public class Streams {

	public static void main(String[] args) {
		List<Person> persons = new LinkedList<Person>();
		
		persons.add(new Person("Juan Perez", LocalDate.now().minusYears(39l), Person.Sex.MALE,"juanperez@gmail.com"));
		persons.add(new Person("Soledad Palomino", LocalDate.now().minusYears(35l), Person.Sex.FEMALE,"soledadjofre@gmail.com"));
		persons.add(new Person("Yanina Trejo", LocalDate.now().minusYears(19l), Person.Sex.FEMALE,"yaninatrejo@gmail.com"));
		persons.add(new Person("Monica Montenegro", LocalDate.now().minusYears(50l), Person.Sex.FEMALE,"monicamontenegro@gmail.com"));
		persons.add(new Person("Raul Culasso", LocalDate.now().minusYears(22l), Person.Sex.MALE,"raulculasso@gmail.com"));
		
		// Listar nombre de personas de sexo masculino
		System.out.println("Personas de sexo masculino");
		persons
		.stream()
		.filter(p -> p.getGender() == Person.Sex.MALE)
		.forEach(p -> System.out.println(p.getName()));
		System.out.println();
		
		// Listar nombre de personas de sexo femenino y mayores a 20 anios
		System.out.println("Personas de sexo femenino y edad mayor a 20 anios");
		persons
		.stream()
		.filter(p -> p.getGender() == Person.Sex.FEMALE && p.getAge() > 20)
		.forEach(p -> System.out.printf("%s edad: %s \n", p.getName(), p.getAge()));
		System.out.println();
		
		// Promedio de edad de las personas
		Double ageAverage = persons
		.stream()
		.mapToInt(p -> p.getAge())
		.average()
		.getAsDouble();
		System.out.printf("Promedio de edad de las personas %s ", ageAverage);
		System.out.println();
		System.out.println();
		
		// Suma de edades de las personas
		int ageSum = persons
				.stream()
				.mapToInt(p -> p.getAge())
				.sum();
		System.out.printf("Suma de edad de las personas %s ", ageSum);
		System.out.println();
		System.out.println();
		
		boolean existsMayor30 = persons
				.stream()
				.anyMatch(p -> p.getAge() > 51);
		if(existsMayor30) {
			System.out.println("Al menos una persona mayor a 51");
			System.out.println();
		}
			
		String sortedNames = persons
				.stream()
				.map(p -> p.getName())
				.sorted(Comparator.reverseOrder())
				.collect(Collectors.joining(", "));
		System.out.println("Nombres ordenados Alfabeticamente de forma Descendente: " + sortedNames);
		System.out.println();
		
		List<Integer> personsAges = persons
				.stream()
				.map(p -> p.getAge())
				.sorted()
				.collect(Collectors.toList());
		System.out.println("Edades: " + personsAges.toString());
		
	}

}
