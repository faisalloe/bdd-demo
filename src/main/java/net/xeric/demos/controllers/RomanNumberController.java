package net.xeric.demos.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import net.xeric.demos.services.RomanNumberService;


@RestController
public class RomanNumberController {
    
	@Autowired
    RomanNumberService romanNumberService;
    
	
    @RequestMapping("/romanNumber")
    public @ResponseBody RomanEntry toRomanNum(@RequestParam(value="num", defaultValue="0") int num){
    
    	String val = romanNumberService.toRoman(num);
    	RomanEntry e = new RomanEntry("num", val);
    	
    	
        return e;
    }
    
    public class RomanEntry{
    	
    	private String key;
    	private String val;
		public String getKey() {
			return key;
		}
		public void setKey(String key) {
			this.key = key;
		}
		public String getVal() {
			return val;
		}
		public void setVal(String val) {
			this.val = val;
		}
		public RomanEntry(String key, String val) {
			super();
			this.key = key;
			this.val = val;
		}
    	
    	
    	
    }
    
}
