package examplesJava8;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ExamplesJava8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> listInt = new ArrayList<>();
		listInt.add(1);
		listInt.add(15);
		listInt.add(36);
		listInt.add(8);
		listInt.add(2);
		listInt.add(100);
		listInt.add(58);
		
		List<Integer> listSquareInt = listInt.stream()
											 .map(current -> current*2)
											 .collect(Collectors.toList());
		
		System.out.println("list Square Int: " + listSquareInt);
		
		List<Integer> listEvenInt = listInt.stream()
											.filter(current -> current%2==0)
											.collect(Collectors.toList());
		System.out.println("list Even Int: " + listEvenInt);
		
		// Binary Operator
		int sumList = listInt.stream().reduce(0, (acc, current) -> acc + current);
		System.out.println("sum List: " + sumList);
		
		// Hacer un count
		int countItemInList = listInt.stream().reduce(0, (acc, current) -> acc + 1);
		System.out.println("Count: " + countItemInList);
		
		// Devuelva un entero que sea el primer elemento mayor que 10 en la lista
		int item = listInt.stream().filter(current -> current>=10).findFirst().orElse(0);
		System.out.println("First element higher 10: " + item);
		
		//Metodo que devuelva una lista de String en cada posicion tenga "Entero : 1"
		List<String> listIntString = listInt.stream().map(current->"Entero: " + current.toString())
													 .collect(Collectors.toList());
		System.out.println(listIntString);
		
		//Para todos los elementos de la lista que tengan un 1 en cualquier posición devolver su cuadrado
		List<Double> listSquare1 = listInt.stream().filter(current -> current.toString().contains("1"))
													.map(current->Math.pow(current, 2))
													.collect(Collectors.toList());
		System.out.println("List items square: " + listSquare1);
		
		//Devuelve todos los elementos de la lista en un String separado por coma
		String listToString = listInt.stream().map(Object::toString)
											  .reduce("", (acc, current) -> acc.concat(current).concat(","));
		String listStr = listToString.substring(0, listToString.length()-1);
		System.out.println("String: " + listStr);
		
		// Lo que puedo hacer con forEach igual lo hago con map
		listInt.forEach(new Consumer<Integer>() {

			public void accept(Integer t) {
				System.out.println("forEach anonymous class Value::"+ t);
			}
		});
		
		// [2,5,8,3] -> [5*8*3, 2*8*3, 2*5*3, 2*5*8];
		 int producto = listInt.stream().reduce(1, (acc, current) -> acc*current);
		 List<Integer> listProducto = listInt.stream().map(current -> producto/current)
				 									  .collect(Collectors.toList());
		 System.out.println(listProducto);

	}

}
