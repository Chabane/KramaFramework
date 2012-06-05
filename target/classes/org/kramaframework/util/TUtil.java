package org.kramaframework.util;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletConfig;

import org.jdom.Document;
import org.kramaframework.exception.KramaConfigurationBuildFailedException;
import org.kramaframework.exception.KramaConfigurationFileNotFoundException;
import org.kramaframework.exception.KramaConfigurationIsNotDefinedException;
import org.kramaframework.js.JsDependencies;
import org.kramaframework.xml.TXmlLoader;


/**
 * Util class
 * @author chabane
 * @version 1.0
 */
public class TUtil {
	
	public static final String HORIZONTAL_PANEL = "krama-horizontalPanel";
	public static final String VERTICAL_PANEL = "krama-VerticalPanel";
	public static TXmlLoader loader;
	public static Document document;
	
	/**
	 * Test if a format of string it's correct
	 * @param list
	 * @return boolean
	 */
	public static boolean stringOk(String chaine) {

		if (chaine != null && chaine.length() != 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * Test if a format of list it's correct
	 * @param list
	 * @return boolean
	 */
	public static boolean listOk(List list) {

		if (list != null && !list.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * Write a javascript and css source code on file
	 * @param file
	 * @param source
	 * @throws IOException
	 */
	public static void writeInFile(String file, String source)
			throws IOException {
		System.out.println(file);
		File f = new File(file);
		if(!f.exists()){
			  f.createNewFile();
			  FileWriter fw = new FileWriter(f);
			  fw.write(source);
			  fw.flush();
			  fw.close();
		} else {
			 FileWriter fw = new FileWriter(file);
		  	 fw.write(source);
		  	 fw.flush();
		     fw.close();
	    }
	}

	/**
	 * Encapsulates a panel with a DIV
	 * @param html
	 * @return String
	 */
	public static String encapsulate(String html, String panel) {

		if(HORIZONTAL_PANEL.equals(panel))
				return "<div class='" + HORIZONTAL_PANEL + "'>" + html + "</div>";
		else if (VERTICAL_PANEL.equals(panel))
				return "<div class='" + VERTICAL_PANEL + "'>" + html + "</div>";
		else
			return "<div>"+html+"</div>";
	}

	/**
	 * This Method determinate if a kind of attributValue is a same that param
	 * 
	 * @param attributeValue
	 * @param param
	 * @return boolean
	 */
	public static boolean isSameKind(String attributeValue, Object param) {

		if (attributeValue.equals("java.lang.String") && param == null) {
			return true;
		} else if (attributeValue.equals("java.lang.Boolean")
				&& param instanceof Boolean) {
			return true;
		} else if (attributeValue.equals("java.lang.Long")
				&& param instanceof Long) {
			return true;
		} else if (attributeValue.equals("java.lang.String")
				&& param instanceof String) {
			return true;
		} else if (attributeValue.equals("java.lang.Float")
				&& param instanceof Float) {
			return true;
		} else if (attributeValue.equals("java.lang.Double")
				&& param instanceof Double) {
			return true;
		} else if (attributeValue.equals("java.lang.Integer")
				&& param instanceof Integer) {
			return true;
		} else if (attributeValue.equals("java.lang.Byte")
				&& param instanceof Byte) {
			return true;
		} else if (attributeValue.equals("java.lang.Character")
				&& param instanceof Character) {
			return true;
		} else if (attributeValue.equals("java.lang.Short")
				&& param instanceof Short) {
			return true;
		} 
		return false;
	}
	
	/**
	 * Load a xml configuration 
	 * @param config
	 */
	public static void load(ServletConfig config){
		
		 // Recuperate a param-value of context-param
	     String configXML = config.getServletContext().getInitParameter("configKrama");
		 // Recuperate a path of krama-config xml file
		 configXML = config.getServletContext().getRealPath(configXML);
		 // Recuperate a instance of xml loader class
		 loader = TXmlLoader.getInstance();
		 try {
			 // Open a krama-config xml file
			 document = loader.open(configXML);
		 } catch (KramaConfigurationFileNotFoundException e) {
			 e.printStackTrace();
		 } catch (KramaConfigurationIsNotDefinedException e) {
			 e.printStackTrace();
		 } catch (KramaConfigurationBuildFailedException e) {
			 e.printStackTrace();
		 }
	}
	
	/**
	 * Read a javascript function from javascript file
	 * @param number
	 * @param name
	 * @return a javascript function
	 */
	public static String readUtilFile(int number, String name){
		  String javascriptFunction = "";	
		try{
			  String commentline = "//["+number+"]["+name+"]";
			  String nextCommentline = "//["+((int)number+1)+"]";
			  // Open the file that is the first 
			  // command line parameter
			  FileInputStream fstream = new FileInputStream("textfile.txt");
			  // Get the object of DataInputStream
			  DataInputStream in = new DataInputStream(fstream);
			  BufferedReader br = new BufferedReader(new InputStreamReader(in));
			  String strLine;
			  String[] split;
			  boolean begin = false;
			  boolean end = false;
			  //http://www.highereddegree.info/
			  //http://www.jeefspeed.info/	
			  //http://85.31.186.21/
			  //http://www.filmze.com/modules/films/index.php?vid=8225
			  //never back down 1 et 2
			  //Read File Line By Line
			  while ((strLine = br.readLine()) != null && end == false)   {
			   
				  if(begin){
					  javascriptFunction += strLine;
				  }
				  split = strLine.split(nextCommentline);
				  if(commentline.equals(strLine)){
					  begin = true;
				  }else if(split.length != 0){
					  end = true;
				  }
			  }
			  //Close the input stream
			  in.close();
			 }catch (Exception e){//Catch exception if any
				 //System.err.println("Error: " + e.getMessage());
			 }
		return javascriptFunction;
		  }
	
}
