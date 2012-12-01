/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reflect.and.annotate;

/**
 *
 * @author sturm
 */
public class Candidate {
	public Candidate ( int x) {
		this.x = x;
	}
	
	public Candidate () {
		Reset();
	}
	
//        @Comment("Hier gehöre ich nicht hin")
	private int x;
	
	@Comment("Hallo Oma! Ich bin im Fersehen!")
	public int get_x () {
		return x;
	}
	
	public void f ( int y, double d ) {
		if (d < 0)
			x = y;
		else
			x = -y;
	}
	
	protected void Reset () {
		x = 42;
	}
	
}
