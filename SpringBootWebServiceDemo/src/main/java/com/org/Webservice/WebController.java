package com.org.Webservice;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {
	@RequestMapping("/src/sample") // it maps the /src/sample endpoints to function 
	public SampleResponse Sample(@RequestParam(value="name",defaultValue="ResFul WebService" ) String name) {
		SampleResponse res = new SampleResponse();
		res.setId("105");
		res.setName("Your service is : "+name);
		
		
		return res;
	}
	
	@RequestMapping("/goodpage")
	public String goodpage() {
		String s= "this is good page for me and here we are using http method";
		return s;
	}
	
	@RequestMapping(value = "/test" , method = RequestMethod.POST)
    public PostResponse Test(@RequestBody PostRequest inputload) {
        PostResponse res = new PostResponse();
        res.setId(inputload.getId());
        res.setMessage("Hello , how are you "+inputload.getName());
        res.setRef("Taking ref from some friends ");

        return res;
    }
}
