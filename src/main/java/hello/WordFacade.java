package hello;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class WordFacade {

	
	public static AnagramOrPalindrome checkAnagramOrPalindrome(String word) {
		AnagramOrPalindrome anagramOrPalindrome = new AnagramOrPalindrome();

		anagramOrPalindrome.setWord(word);

		Boolean isPalindrome = checkPalindrome(word);
		anagramOrPalindrome.setPalindrome(isPalindrome);

		Boolean isAnagramOfPalindrome = checkAnagramOfPalindrome(word);
		anagramOrPalindrome.setAnagramOfPalindrome(isAnagramOfPalindrome);
		
		return anagramOrPalindrome;
	}

	private static boolean checkPalindrome(String word){
        if(word.length() == 1 || word.length() == 0) 
             return true; 
        else{ 
            if(word.charAt(0) == word.charAt(word.length()-1) )            
                return checkPalindrome(word.substring(1,word.length()-1)); 
            return false;             
        } 
    } 
	
	private static boolean checkAnagramOfPalindrome(String word){ 
		int pr = WordUtil.factorial(word.length());
		
		String[] arrayResult = WordUtil.permute(word,pr);
		List<String> wordList = new ArrayList<String>(new HashSet<String>(Arrays.asList(arrayResult)));
		
		for(String stringCheck : wordList) {
			boolean auxCheckWord = checkPalindrome(stringCheck);
			if(auxCheckWord == true) {
				return true;
			}
		}
		return false;
    } 

}
