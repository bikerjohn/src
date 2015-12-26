package page_objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class File_Read_Utility{

	public static void main(String args[]) {

		String fileName = "C:/Users/Bikerjohn/Documents/Survey_Data.txt";
		List<String> list = new ArrayList<>();

		try (BufferedReader br = Files.newBufferedReader(Paths.get(fileName))) {

			//br returns as stream and convert it into a List
			list = br.lines().collect(Collectors.toList());
			Long count = list.stream().count();
			System.out.println(count);

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		list.forEach(System.out::println);


	}

}

