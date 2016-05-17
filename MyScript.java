import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class MyScript {

	public static void main(String[] args) {
		/*
		 * Zach
		 * 
		 * This script was originally used for 
		 * modifying JSON files given to me by
		 * the National Institute of Standards 
		 * and Technology (N.I.S.T.) so that
		 * they could be more efficiently used
		 * in the LabPal Android application.
		 * 
		 */
		
		JSONObject main = new JSONObject();
		JSONArray main_arr = new JSONArray();
		
		JSONParser parser = new JSONParser();
		try {
			
			
			Object nam_obj = parser.parse(new FileReader("C:\\Users\\Zachary\\workspace\\JsonScript\\src\\names.txt"));
			JSONObject nam_jsonObject = (JSONObject)nam_obj;
			JSONArray nam_arr = (JSONArray)nam_jsonObject.get("Names");
			
			Object vib_obj = parser.parse(new FileReader("C:\\Users\\Zachary\\workspace\\JsonScript\\src\\vibrations.txt"));
			JSONObject vib_jsonObject = (JSONObject)vib_obj;
			JSONArray vib_arr = (JSONArray)vib_jsonObject.get("ExpVibrations");
			

			
			for(int i = 0; i < nam_arr.size(); i++){
				JSONObject temp_nam_obj = (JSONObject)nam_arr.get(i);
				String temp_name = temp_nam_obj.get("Name").toString();
				String temp_casno = temp_nam_obj.get("casno").toString();
				
				for(int z = 0; z < vib_arr.size(); z++){
				
					JSONObject temp_vib_obj = (JSONObject)vib_arr.get(z);
					String temp_match = temp_vib_obj.get("casno").toString();
					if(temp_casno.equals(temp_match)){
						
						if(temp_vib_obj.containsKey("Intensity")){
							JSONObject new_obj = new JSONObject();
							new_obj.put("Name", temp_name);
							new_obj.put("Intensity", temp_vib_obj.get("Intensity"));
							new_obj.put("Frequency", temp_vib_obj.get("Frequency"));
							//main.put(temp_name, new_obj);
							main_arr.add(new_obj);
							System.out.println(temp_vib_obj.get("Frequency"));
						}
					}
				}
			}
			main.put("VibData", main_arr);
			FileWriter writer = new FileWriter("C:\\Users\\Zachary\\workspace\\JsonScript\\src\\result.txt");
			writer.write(main.toJSONString());
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
