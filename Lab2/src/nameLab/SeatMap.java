package nameLab;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class SeatMap
{
	public SeatMap()
	{
		
	}
	
	public int countNames() // count the total number of names within the file
	{
		int numNames = 0;
		try
		{
			
			File input = new File("Names.dat");
			Scanner fileReader = new Scanner (input);
			String line;
			while(fileReader.hasNextLine() != false)
			{
				numNames++;
				line = fileReader.nextLine();
			}
			fileReader.close();
			
		}
		catch (IOException e)
		{
			System.err.println("IOException in reading input file!");
		}
		return numNames;
	}
	
	public void fillArray(String[][] emptyArray, int r, int c) // fill the array with the names of students
	{
		try
		{
			File input = new File("Names.dat");
			Scanner fileReader = new Scanner (input);
			for (int i = 0; i < r; i++)
			{
				for (int j = 0; j < c; j++)
				{
					emptyArray[i][j] = fileReader.nextLine();
				}
			}
			fileReader.close();
		}
		catch (IOException e) 
    	{
    		System.err.println("IOException in reading input file!!!");
    	}	
	}
	
	public static void main(String[] args)
	{
		SeatMap newMap = new SeatMap();
		
		Scanner lineReader = new Scanner (System.in);
		
		int numNames = newMap.countNames();
		int rows = (numNames / 10) + (numNames % 10); 
		int cols = 10; // this is an arbitrary assignment so that every grid will have 10 columns
		
		String[][] nameArray = new String[rows][cols];
		newMap.fillArray(nameArray, rows, cols);
		
		System.out.println("Which row would you like to search? (the greatest you may enter is " + rows + "): ");
		int searchRow = lineReader.nextInt()-1; // subtract 1 to adjust for the difference in array indices and real world grids
		System.out.println("Which column would you like to search? (the greatest you may enter is " + cols +"): ");
		int searchCol = lineReader.nextInt()-1; // subtract 1 to adjust for the difference in array indices and real world grids
		
		if(nameArray[searchRow][searchCol] != " ")  // check for empty seat
			System.out.println(nameArray[searchRow][searchCol] + "is in that seat.");
		else
			System.out.println("That seat is empty");
		
		lineReader.close();
	}
}