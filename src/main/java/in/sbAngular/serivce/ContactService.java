package in.sbAngular.serivce;

import java.util.List;

import in.sbAngular.entity.Contact;

public interface ContactService {


	public List<Contact> getContact();					//{} --> FindAll()
	public Boolean saveContact(Contact contact);			//{} --> save()
	public Boolean deleteContact(Integer cid);				//{} --> delete()
	public Contact getContactById(Integer cId);				//--> findById()
}
