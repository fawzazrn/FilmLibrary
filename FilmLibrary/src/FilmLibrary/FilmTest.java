package FilmLibrary;
import java.io.IOException;

public class FilmTest {
	
	private static int sel;

	public static void main(String args[]) throws IOException {
		Menu m = new Menu();
		m.displaymenu();
		sel = m.selmenu();
		
		while(sel!=4) {
			if(sel==1) {
			Movie mov = new Movie();
			mov.enterMovie();
			mov.displayMovie();
			mov.write2file();
			
		}
		
			if(sel==2) {
			Movie read = new Movie();
			read.readFile();
			
		}
		
			if(sel==3) {
			Movie clear = new Movie();
			clear.clearFile();
			
		}
			
			if(m.selcontinue()==1) {
				m.displaymenu();
				sel=m.selmenu();
			}
			else {
				System.exit(0);
			}
		}
		
			
		
		
	}
}
