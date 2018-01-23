import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test {

	public static String printerError(String s) 
	{
		int count = 0;
		String result = "";

		if (s.length() >= 1)
		{
			for (int i = 0; i < s.length(); i++)
			{
				if (s.charAt(i) > 'm')
				{
					count++;
				}
			}
			System.out.print("error_printer(s) => ");
			result = count + "/" + s.length();
		}
		else
		{
			result = "error, re-enter";
		}
		return result;
	}

	public static String duplicate(String s)
	{
		String[] returnArray = s.split("");
		String returnString = "";
		for (int i = 0; i < returnArray.length; i++)
		{
			if (i == 0)
			{
				String f = Character.toString(s.charAt(i));
				returnArray[i] = f.toUpperCase();
				returnString = returnString + returnArray[i] + "-";
				//System.out.println(returnArray[i]);
			}
			else 
			{
				String f = returnArray[i].toUpperCase();;
				for (int j = 0; j < i; j++)
				{
					String h = Character.toString(s.charAt(i));
					String b = h.toLowerCase();	
					f = f + b;
				}
				returnArray[i] = f;
				returnString = returnString + returnArray[i] + "-";
				//returnArray[i] = returnArray[i] + returnArray[i];
				//System.out.println(returnArray[i]);

			}
		}

		returnString = returnString.substring(0, returnString.length() - 1);
		return returnString;
	}

	public static String revRot(String strng, Integer sz) 
	{
		if (sz <= 0 || sz == null)
		{
			return "";
		}
		else if (sz > strng.length())
		{
			return "";
		}
		int arraySize = (int) Math.ceil(strng.length() / sz);
		String[] returnArray = new String[arraySize];
		int index = 0;
		for(int i = 0; i < strng.length(); i = i + sz)
		{
			if(strng.length() - i >= sz)
			{
				returnArray[index++] = strng.substring(i, i + sz);
			}
		}
		//-----------

		boolean rr[] = new boolean[arraySize];
		for (int j = 0; j < returnArray.length; j++)
		{
			int result = 0;
			for (int i = 0; i < sz; i++)
			{
				int d = Character.getNumericValue(returnArray[j].charAt(i));
				int pow = d * d * d;
				result = result + pow;
			}
			if (result % 2 == 0)
			{
				rr[j] = true;
				//reverse chunk
			}
			else 
			{
				rr[j] = false;
				//rotate to the left by 1
			}
		}
		//---------
		for (int i = 0; i < arraySize; i++)
		{
			if (rr[i])
			{
				returnArray[i] = new StringBuilder(returnArray[i]).reverse().toString();
				//System.out.println(returnArray[i]);
			}
			else 
			{
				returnArray[i] = returnArray[i].substring(1) + returnArray[i].substring(0, 1);
				//System.out.println(returnArray[i]);
			}
		}
		//String returnString = Arrays.toString(returnArray);
		StringBuilder builder = new StringBuilder();
		for(String s : returnArray) {
			builder.append(s);
		}
		String returnString = builder.toString();

		return returnString;
	}

	public static int duplicatesCount(String text) 
	{
		String newText = text.toLowerCase();
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		char[] carray = newText.toCharArray();
		for (char c : carray)
		{
			if (map.containsKey(c))
			{
				map.put(c, map.get(c) +1);
			}
			else
			{
				map.put(c, 1);
			}
		}
		Set <Character> setChar = map.keySet();
		int returnC = 0;
		for (Character c : setChar)
		{
			if (map.get(c) > 1)
			{
				returnC++;
			}
		}
		return returnC;
	}
	public static int duplicateCount(String nText)
	{
		String text = nText.toLowerCase();
		int cnt = 0;
	    while (text.length() > 1) {
	        char firstLetter = text.charAt(0);
	        if (text.lastIndexOf(firstLetter) > 0) {
	            cnt++;
	            text = text.replaceAll(("" + firstLetter), "");
	        } else {
	            text = text.substring(1, text.length());
	        }
	    }

	    return cnt;
	
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//		System.out.println(revRot("123456987654", 6));
		//		System.out.println(revRot("123456987653", 6));
		//		System.out.println(revRot("66443875", 4));
		//		System.out.println(revRot("66443875", 8));
		//System.out.println(duplicate("abcDefghi"));
		System.out.println(duplicateCount("abcdea"));
		System.out.println(duplicateCount("abcdeae"));
		System.out.println(duplicateCount("aA11"));






	}

}
