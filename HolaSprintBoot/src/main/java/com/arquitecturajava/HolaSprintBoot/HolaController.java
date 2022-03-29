/**
 * 
 */
package com.arquitecturajava.HolaSprintBoot;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author salt
 *
 */
@Controller
public class HolaController {

	@RequestMapping("/")
    @ResponseBody
    String home() {
        return "Hola Mundo";
    }
	
	@RequestMapping("/hola")
    @ResponseBody
    String hola2() {
        return "Hola 2";
    }
	
}
