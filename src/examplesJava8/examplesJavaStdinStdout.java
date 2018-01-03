package examplesJava8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class examplesJavaStdinStdout {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		List<List<Integer>> integerList = new ArrayList<List<Integer>>();
		List<Integer> filas = new ArrayList<>();
		List<Integer> columnas = new ArrayList<>();
		List<String> queryResult = new ArrayList<>();
		
		integerList = addInputInList(scan);
		processColumnsRows(scan, filas, columnas);
		queryResult = findItemsInList(integerList, filas, columnas);
		
		for(String item : queryResult) {
			System.out.println(item);
		}
	}
	
	private static List<List<Integer>> addInputInList(Scanner scan) {
		int countRows = 0;
		int numberOfRows = Integer.parseInt(scan.nextLine());
		List<List<Integer>> intList = new ArrayList<List<Integer>>();
		
		while(countRows!=numberOfRows) {
			String row = scan.nextLine();
			countRows = countRows + 1;
			List<Integer> rowList = createArrayList(row);
			intList.add(rowList);
		}
		
		return intList;
	}
	
	private static void processColumnsRows(Scanner scan, List<Integer> filas, List<Integer> columnas) {
		int numberQuerys = Integer.parseInt(scan.nextLine());
		int countQ = 0;
		while(countQ!=numberQuerys) {
			String q = scan.nextLine();
			countQ = countQ + 1;
			querys(q, filas, columnas);
		}
	}
	
	private static List<String> findItemsInList(List<List<Integer>> integerList, List<Integer> filas, List<Integer> columnas) {
		List<String> queryResult = new ArrayList<>();
		
		for(int i=0; i<filas.size(); i++) {
			List<Integer> eachRow = integerList.get(filas.get(i));
			for(int j=0; j<columnas.size(); j++) {
				if(i==j) {
					if(eachRow.size()>columnas.get(j)) {
						queryResult.add(eachRow.get(columnas.get(j)).toString());
					}
					else {
						queryResult.add("ERROR!");
					}
				}
			}
		}
		
		return queryResult;
	}
	
	private static void querys(String q, List<Integer> filas, List<Integer> columnas) {
		String[] arrayQ = q.split(" ");
		List<String> arrayListQ = Arrays.asList(arrayQ);
		
		filas.add(Integer.valueOf(arrayListQ.get(0)) - 1);
		columnas.add(Integer.valueOf(arrayListQ.get(1)));
	}
	
	private static List<Integer> createArrayList(String row) {
		String[] arrayStr = row.split(" ");
		List<String> arrayListStr = Arrays.asList(arrayStr);
		List<Integer> rowList = arrayListStr.stream().map(current -> Integer.valueOf(current)).collect(Collectors.toList());
		
		return rowList;
	}

}
