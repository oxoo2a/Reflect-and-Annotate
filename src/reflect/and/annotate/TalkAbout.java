/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reflect.and.annotate;

import java.io.*;
import java.lang.reflect.*;

/**
 *
 * @author sturm
 */
public class TalkAbout {
	private Class c;
	
	public TalkAbout ( Class candidate ) {
		c = candidate;
	}
	
	public void print ( PrintStream out ) {
		out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>");
		out.println("<class name=\"" + c.getCanonicalName() + "\">");
		printConstructors(c.getDeclaredConstructors(),out);
		printDeclaredFields(c.getDeclaredFields(),out);
		printDeclaredMethods(c.getDeclaredMethods(),out);
		out.println("</class>");
	}
	
	private void printConstructors ( Constructor ctors[], PrintStream out ) {
		for (Constructor ctor : ctors ) {
			out.println("\t<constructor name=\"" + ctor.getName() + "\" modifiers=\"" + Modifier.toString(ctor.getModifiers()) + "\" >");
			printArgumentTypes(ctor.getParameterTypes(),out);
			out.println("\t</constructor>");
		}
	}

	private void printDeclaredFields ( Field fields[], PrintStream out ) {
		for (Field field : fields ) {
			out.println("\t<field name=\"" + field.getName() + "\" type=\"" + field.getType().toString() + "\" modifiers=\"" +
					Modifier.toString(field.getModifiers()) + "\" />");
		}
	}
	
	private void printDeclaredMethods ( Method ms[], PrintStream out ) {
		for (Method m : ms ) {
			out.println("\t<method name=\"" + m.getName() + "\" modifiers=\"" + Modifier.toString(m.getModifiers()) +
					"\" return_type=\"" + m.getReturnType().getName() + "\">");
			printArgumentTypes(m.getParameterTypes(),out);
			Comment c = m.getAnnotation(Comment.class);
			if (c != null) {
				out.println("\t\t<comment>");
				out.println("\t\t\t" + c.value());
				out.println("\t\t</comment>");
			}
			out.println("\t</method>");
		}
	}
	private void printArgumentTypes ( Class argts[], PrintStream out ) {
		for (Class arg : argts) {
			out.println("\t\t<type name=\"" + arg.getName() + "\" />");
		}
	}
}