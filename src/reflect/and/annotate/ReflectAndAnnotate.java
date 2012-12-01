/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reflect.and.annotate;

import java.io.*;

/**
 *
 * @author sturm
 */
public class ReflectAndAnnotate {
	public static void main(String[] args) {
		TalkAbout ta = new TalkAbout(Candidate.class);
		PrintStream outfile = null;
		
		try {
		outfile = new PrintStream(
				new BufferedOutputStream(
						new FileOutputStream("TalkAbout.xml")
						)
				);
		}
		catch (Exception e) {
			System.out.println("Failed to write to file\n" + e.getStackTrace());
		}
		// ta.print(outfile);
		ta.print(System.out);
		
		outfile.close();
	}

}
