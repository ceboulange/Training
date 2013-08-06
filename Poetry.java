import java.util.*;
import java.util.regex.*;
import static java.lang.System.*;

public class Poetry{
//Here I try to find the rhyme pattern of a poem given in input
//Poems are supposed to be string array where one line is one element

   public static void main(String [] args)
	{
		String[] poem = {"test wehe light","dssf fight","trdfsz","efwee","df dfdwf corner","aglyory","ad might","edew memyory"};
		String res = rhymeScheme(poem);
		out.println("rhyme scheme = " + res);
	}
	
	public static String findPattern(String line){
		String pattern = "";
        
        //Get last word
        Matcher m = Pattern.compile("([a-zA-Z]+)$").matcher(line);
        
        //Get pattern
        if(m.find()){
        	String word = m.group(1);
        	boolean vowelFound = false;
        	int patternStart = 0;
        	int maxChar = word.length()-1;
        	
        	for(int k = maxChar; k >= 0; k--){
        		if(("aeiouAEIOU".indexOf(word.charAt(k)) != -1)
        		|| (k != maxChar && "yY".indexOf(word.charAt(k)) != -1)){
        			vowelFound = true;
        			patternStart = k;
        		}
        		else{
        			if(vowelFound){
        				break;
        			}
        		}
        	}
        	pattern = word.substring(patternStart);
    	}
    	return pattern;
	}
   
    public static String rhymeScheme(String [] poem){
        String rhyme = "";
        char currentChar = 'a';
        HashMap<String, Character> rhymeHT = new HashMap<String, Character>();
        
        for(int i=0; i<poem.length; i++){
        	String pattern = findPattern(poem[i]);
        	
            if(pattern == "") rhyme += " ";
            else if(rhymeHT.containsKey(pattern)){
            	rhyme += rhymeHT.get(pattern);
            }
            else{
            	rhymeHT.put(pattern,currentChar);
            	rhyme += currentChar;
            	currentChar = nextChar(currentChar);
            }
        }
        return rhyme;
    }
    
    public static char nextChar(char c){
    	if(c == 'z') return 'A';
    	else{ 
    		c++;
    		return c;
    	}
    }
}
