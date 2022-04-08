package in.sbAngular.serivce;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import in.sbAngular.entity.Contact;
import in.sbAngular.repository.ContactRepository;

@Service
public class ContactServiceImp implements ContactService {

	@Autowired
	private ContactRepository contactRepo;
	
	@Override
	public Boolean saveContact(Contact contact) {
		contact.setActiveSw("Y");
		System.out.println(contact.toString());
		Contact csave = contactRepo.save(contact);
		if(csave.getContactId() != null) {
		return true;
		}
		return false;
	}
	
	@Override
	public List<Contact> getContact() {
		Contact contact = new Contact();
		contact.setActiveSw("Y");		// Filtering-- only Active=Y record will fetch		
		return contactRepo.findAll(Example.of(contact));
	}

	@Override
	public Boolean deleteContact(Integer cid) {
		Optional<Contact> cfindById = contactRepo.findById(cid);
		if(cfindById.isPresent()) {
			Contact contact = cfindById.get();
			contact.setActiveSw("N");
			Contact save = contactRepo.save(contact);
			return true;
		}
		return false;
	}

	@Override
	public Contact getContactById(Integer cid) {
		Optional<Contact> cfindById = contactRepo.findById(cid);
		if(cfindById.isPresent()) {
			return cfindById.get();
		}
		return null;
	}

}
