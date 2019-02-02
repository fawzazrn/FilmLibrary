package FilmLibraryUI;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import FilmLibrary.Movie;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

public class Controller {

	//private Scene scene1;
	//private Scene scene2;
	private Boolean v;
	private String movietitle;
	private double score;
	private Movie m;
	private String filename = "/Users/Fawwaz Azrin/Documents/Java/FilmLibrary/movielist.txt";
	
	@FXML Button readbutton;
	@FXML Button addbutton;
	@FXML Button clearbutton;
	@FXML Button submitbutton;
	@FXML TextField moviefield;
	@FXML TextField scorefield;
	@FXML Text movietext;
	@FXML Text scoretext;
	@FXML TextArea textarea;
	@FXML Label datalabel;
	
	public Controller() {
		m = new Movie();
	}
	
	public void initialize() {
		visibility(false);
		textarea.setVisible(false);
		datalabel.setVisible(false);
		
	}
	
	public void visibility(boolean v) {
		scorefield.setVisible(v);
		moviefield.setVisible(v);
		movietext.setVisible(v);
		scoretext.setVisible(v);
		submitbutton.setVisible(v);
		textarea.setVisible(!v);
		
	}
	
	@FXML
	public void addFunction() {
		datalabel.setVisible(false);
		moviefield.clear();
		scorefield.clear();
		visibility(true);
	}
	
	@FXML
	public void enterMovie(ActionEvent event) throws Exception {
		movietitle = moviefield.getText();
		System.out.println(movietitle);
		score = Double.parseDouble(scorefield.getText());
		System.out.println(score);
		write2file();
		datalabel.setVisible(true);
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
	
	@FXML
	public void readfile() throws FileNotFoundException, Exception {
		datalabel.setVisible(false);
		textarea.clear();
		textarea.appendText("TITLE" + "                 " + "SCORE" + System.lineSeparator());
		visibility(false);
		BufferedReader in = new BufferedReader(new FileReader("movielist.txt"));
		String read;
		try {
			while((read=in.readLine()) != null) {
				textarea.appendText(read + System.lineSeparator());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	public void clearFile() throws FileNotFoundException {
		PrintWriter clear = new PrintWriter(filename);
		clear.write("");
		clear.close();
		System.out.println("\n\n" + "**********DATA IS CLEARED**********");
	}
	
	/*
	public void setSecondScreen(Scene scene) {
		scene2 = scene;
	}
	
	public void openSecondScreen(ActionEvent event) {
		Stage p
		s = (Stage) ((Node)event.getSource()).getScene().getWindow();
		ps.setScene(scene2);
	}*/
}
