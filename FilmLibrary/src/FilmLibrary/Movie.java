package FilmLibrary;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Movie {

	private String movietitle;
	private double score;
	private String filename = "/Users/Fawwaz Azrin/Documents/Java/FilmLibrary/movielist.txt";
	Scanner s = new Scanner(System.in);
	Scanner d = new Scanner(System.in);
	private String movietitle2;
	
	public void enterMovie() {
		System.out.printf("ENTER movie title: \t");
		movietitle = s.nextLine();
		System.out.printf("ENTER movie score: \t");
		score = d.nextDouble();
		
	}
	
	public void displayMovie() {
		System.out.println("Data entered is: ");
		System.out.println(movietitle + "      " + score);
	}
	
	public void write2file() throws IOException {
		File f = new File("/Users/Fawwaz Azrin/Documents/Java/FilmLibrary/movielist.txt");
		
		try {
			if(f.createNewFile()) {
				System.out.println("File is created");
			}else {
				System.out.println("File already exists");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		appendStr2File();
		
	}
	
	public void appendStr2File() throws IOException {
		
		BufferedWriter out = new BufferedWriter(new FileWriter(filename, true));
		out.append(movietitle + "                 " + score + System.lineSeparator());
		out.close();
		
	}
	
	public void readFile() throws FileNotFoundException {
		BufferedReader in = new BufferedReader(new FileReader("movielist.txt"));
		String mystr;
		System.out.printf("\n\n");
		System.out.println("TITLE" + "                 " + "SCORE");
		try {
			while((mystr=in.readLine()) != null) {
				System.out.println(mystr);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void clearFile() throws FileNotFoundException {
		PrintWriter clear = new PrintWriter(filename);
		clear.write("");
		clear.close();
		System.out.println("\n\n" + "**********DATA IS CLEARED**********");
	}
}
