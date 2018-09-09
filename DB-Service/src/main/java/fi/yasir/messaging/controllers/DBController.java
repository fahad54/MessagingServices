package fi.yasir.messaging.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.yasir.messaging.respositories.UserRepository;

@Controller
@RequestMapping("/user")
public class DBController {

	UserRepository userRespository = new UserRepository();

	@RequestMapping(value = "add/{name}", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String addUser(@PathVariable(value = "name", required = true) String name) throws Exception {
		return userRespository.addUser(name);
	}

	@RequestMapping(value = "remove/{name}", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public String removeUser(@PathVariable(value = "name", required = true) String name) throws Exception {
		return userRespository.remove(name);
	}

	@RequestMapping(method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public List<String> getUsers() {
		return userRespository.getUsers();
	}

}
