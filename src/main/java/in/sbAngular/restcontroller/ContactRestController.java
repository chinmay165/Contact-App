package in.sbAngular.restcontroller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.sbAngular.constants.AppConstants;
import in.sbAngular.entity.Contact;
import in.sbAngular.properties.AppProperties;
import in.sbAngular.serivce.ContactService;


@RestController
public class ContactRestController {

	@Autowired
	private ContactService contactSer;
	
	@Autowired
	private AppProperties prop;
	
	/*@GetMapping(value = "/allcontact")
	public ResponseEntity<List> getContactDetails(){
		List<Contact> contact = contactSer.getContact();
		
		return new ResponseEntity<>(contact, HttpStatus.OK);
	}*/
	
	
	@PostMapping("/contact")
	public String saveConact(@RequestBody Contact contact) {
		//System.out.println(contact);
		Boolean saveContact = contactSer.saveContact(contact);
		
		Map<String, String> msg = prop.getMessages();
		
		if(saveContact)
			return msg.get(AppConstants.CONTACT_SAVE_SUCCESS);
		else
			return msg.get(AppConstants.CONTACT_SAVE_FAILED);
	}
	
	@GetMapping("/contacts")
	public List<Contact> getAllContact(){
		return contactSer.getContact();
	}
	
	@DeleteMapping("/contact/{cid}")
	public String deleteContact(@PathVariable("cid") Integer contactId) {
		Boolean deleteContact = contactSer.deleteContact(contactId);
		
		Map<String, String> msg = prop.getMessages();
		
		if(deleteContact)
			return msg.get(AppConstants.CONTACT_DEL_SUCCESS);
		else
			return msg.get(AppConstants.CONTACT_DEL_FAILED);
	}
	
	@GetMapping("/contact/{cid}")
	public Contact editContact(@PathVariable("cid") Integer contactId) {
		return contactSer.getContactById(contactId);
		
		
	}
}
