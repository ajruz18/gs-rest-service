package hello;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {
	
    // TODO Implement the /words/{word} endpoint
	@RequestMapping(value = "/words/{word}", method = RequestMethod.GET)
	public AnagramOrPalindrome sgetAnagramOrPalindrome(@PathVariable("word") String word) {
		
		AnagramOrPalindrome anagramOrPalindrome = WordFacade.checkAnagramOrPalindrome(word);
		
		return anagramOrPalindrome;
	}

}
