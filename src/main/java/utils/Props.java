package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author Robson Rodrigues
 *
 */
public class Props {
	
	/**
	 * Obtem os valores do arquivo e os retorna com tipo Properties
	 * 
	 * @return
	 * @throws IOException
	 */
	public static Properties getProp() throws IOException {
		Properties props = new Properties();
		FileInputStream file = new FileInputStream(
				"./resources/prop.properties");
		props.load(file);
		try {
			return props;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * Obtem os valores do arquivo e os retorna verdadeiro ou falso conforme propriedade
	 * 
	 * @return
	 * @throws IOException
	 */
	public static boolean getBooleanProp(String prop) throws IOException {
			return Boolean.parseBoolean(getProp().getProperty(prop).toString());
	}
	
	
}
