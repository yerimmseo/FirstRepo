package theory;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class E07_JSON {

	/*
		# JSON
		- JavaScriptÀÇ ObjectÅ¸ÀÔ°ú ±²ÀåÈ÷ À¯»çÇÑ ÇüÅÂÀÇ µ¥ÀÌÅÍ Ç¥Çö ¹æ½Ä
		- ¹®ÀÚ¿­¸¸À¸·Î ´Ù¾çÇÑ µ¥ÀÌÅÍ¸¦ °£°áÇÏ°Ô Ç¥ÇöÇÒ ¼ö ÀÖ¾î¼­ ÀÎ±â°¡ ¸¹´Ù
		- { "Key" : Value, "Key" : Value, ... }
		
		# JSONÀÇ Value¿¡ Ç¥Çö °¡´ÉÇÑ Å¸ÀÔµé
		- '', "" : String
		- ¼ýÀÚ, ¼Ò¼ö : Number
		- [] : Array
		- {} : Object (JAVAÀÇ Map)
	*/
	File fileMap = new File("./data/myMap.json");
	
	public String mapToJsonStr(HashMap map) {
		HashMap<String, Object> myMap = map;
		StringBuilder str = new StringBuilder();
		
		for (String key : myMap.keySet()) {
			Object value = myMap.get(key);
			
			if (value instanceof Object[]) {
				Object[] arr = (Object[])value;
				
				str.append("\"" + key + "\"" + ": [");
				for (int i = 0; i < arr.length; i++) {
					if (arr[i] instanceof String) {
						if (i == arr.length - 1) {
							str.append("\"" + arr[i] + "\"");
						} else {
							str.append("\"" + arr[i] + "\"" + ", ");
						}
					} else {
						if (i == arr.length - 1) {
							str.append(arr[i]);
						} else {
							str.append(arr[i] + ", ");
						}
					}
				}
				str.append("],\n");
			} else if (value instanceof String) {
				str.append("\"" + key + "\"" + ": " + "\"" + value + "\"" + ",\n");
			} else {
				str.append("\"" + key + "\"" + ": " + value + ",\n");
			}
		}
		return str.toString();
	}
	
	public void mapToJsonFile(HashMap myMap) {
		String str = mapToJsonStr(myMap);
		
		try {
			FileOutputStream fout = new FileOutputStream(fileMap);
			DataOutputStream dout = new DataOutputStream(fout);
			
			dout.writeUTF(str);
			
			dout.close();
			fout.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public HashMap<String, Object> fileToMap() {
		HashMap<String, Object> myMap = new HashMap<>();
		ArrayList<String> keyList = new ArrayList<>();
		ArrayList<String> valueList = new ArrayList<>();

		try {
			FileInputStream fin = new FileInputStream(fileMap);
			DataInputStream din = new DataInputStream(fin);
			
			String str = din.readUTF();
//			System.out.println(str);
			
			Pattern regexOfKey = Pattern.compile("[\\w]*\":");
			Pattern regexOfValue = Pattern.compile(":\s\\[?[°¡-ÆR-\\w\"\s,]*\\]?,");
			Matcher matchKey = regexOfKey.matcher(str);
			Matcher matchValue = regexOfValue.matcher(str);
			
			while (matchKey.find()) {
				String[] keys = matchKey.group().split("\":");
				
				for (String key : keys) {
					keyList.add(key);
				}
			}
			
			while (matchValue.find()) {
				String[] values = matchValue.group().split(":\s"); 
				
				for (String value : values) {
					if (!value.isBlank()) {
						valueList.add(value.substring(0, value.length()-1));
					}
				}
			}
			
			for (int i = 0; i < keyList.size(); i++) {
				String value = valueList.get(i);
				String key = keyList.get(i);
				
				if (value.contains("[") && value.contains("]") && value.contains("\"")) {
					Pattern regexStr = Pattern.compile("[\\w]+");
					Matcher matchStr = regexStr.matcher(value);
					
					ArrayList<String> strList = new ArrayList<>();
					
					int count = 0;
					while (matchStr.find()) {
						strList.add(matchStr.group());
						count++;
					}
					
					String[] strArr = new String[count];
					
					for (int j = 0; j < count; j++) {
						strArr[j] = strList.get(j);
					}
					myMap.put(key, strArr);
				} else if (value.contains("[") && value.contains("]")) {
					Pattern regexOfInt = Pattern.compile("[0-9]+");
					Matcher matchInt = regexOfInt.matcher(value);
					
					ArrayList<Integer> intList = new ArrayList<>();
					
					int count = 0;
					while (matchInt.find()) {
						Integer num = Integer.parseInt(matchInt.group());
						intList.add(num);
						count++;
					}
					
					Integer[] intArr = new Integer[count];
					
					for (int j = 0; j < count; j++) {
						intArr[j] = intList.get(j);
					}
					myMap.put(key, intArr);
				} else if (value.contains("\"")){
					myMap.put(key, value.substring(1, value.length() - 1));
				} else {
					myMap.put(key, value);
				}
			}
			
			for (String key : myMap.keySet()) {
				Object value = myMap.get(key);
				
				if (value instanceof Object[]) {
					Object[] arr = (Object[])value;
					
					System.out.print("\"" + key + "\"" + ": [");
					for (int i = 0; i < arr.length; i++) {
						if (arr[i] instanceof String) {
							if (i == arr.length - 1) {
								System.out.print("\"" + arr[i] + "\"");
							} else {
								System.out.print("\"" + arr[i] + "\"" + ", ");
							}
						} else {
							if (i == arr.length - 1) {
								System.out.print(arr[i]);
							} else {
								System.out.print(arr[i] + ", ");
							}
						}
					}
					System.out.print("],\n");
				} else if (value instanceof String) {
					System.out.print("\"" + key + "\"" + ": " + "\"" + value + "\"" + ",\n");
				} else {
					System.out.print("\"" + key + "\"" + ": " + value + ",\n");
				}
			}
			
			
			din.close();
			fin.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return myMap;
	}
	
	public static void main(String[] args) {
		
		// myMap¿¡ ÀúÀåµÈ µ¥ÀÌÅÍµéÀ» JASONÇüÅÂÀÇ ¹®ÀÚ¿­·Î ¸¸µé¾î ÆÄÀÏ¿¡ Ãâ·ÂÇÏ´Â ¸Þ¼­µå¸¦ ¸¸µé¾îº¸¼¼¿ä
		// (È®ÀåÀÚ´Â .json)
		HashMap<String, Object> myMap = new HashMap<>();
		
		myMap.put("name", "È«±æµ¿");
		myMap.put("age", 123);
		myMap.put("tel", "010-1234-1234");
		myMap.put("tel2", null);
		myMap.put("language", new String[] {"C", "JAVA", "JavaScript", "React"});
		myMap.put("lotto", new Integer[] {1, 2, 3, 4, 5, 6, 7});
		System.out.println(myMap.entrySet());
		
		E07_JSON json = new E07_JSON();
		json.mapToJsonFile(myMap);

		// ÀÛ¼ºµÈ ÆÄÀÏÀÇ ³»¿ëÀ» ´Ù½Ã JAVA ¸ÊÀ¸·Î ·ÎµåÇÏ´Â ¸Þ¼­µå¸¦ ¸¸µé¾îº¸¼¼¿ä
		HashMap<String, Object> testMap = json.fileToMap();
		System.out.println(testMap.entrySet());
		
	}

}












