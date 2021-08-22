package in.ashokit.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import in.ashokit.entity.Contact;
import in.ashokit.repository.ContactRepository;

public class ContactSeviceImpl implements ContactService {
	
	@Autowired
	private ContactRepository contactRepo;
 
	@Override
	public boolean saveContact(Contact contact) {
		contact.setContactId(101);
		contact.setContactName("OSAMA");
		contact.setContactNumber(987654321L);
		contact.setContactEmail("osama123@gmail.com");
		contact.setActiveSwitch('y');
		contact.setCreatedDate(LocalDate.of(2021, 8, 20));//can use @CreationTimeStamp in EntityClass
		contact.setUpdatedDate(LocalDate.now());
		contactRepo.save(contact);
		
		contact.setContactId(102);
		contact.setContactName("shahid");
		contact.setContactNumber(987657321L);
		contact.setContactEmail("osama1@gmail.com");
		contact.setActiveSwitch('y');
		contact.setCreatedDate(LocalDate.of(2021, 9, 20));//can use @CreationTimeStamp in EntityClass
		contact.setUpdatedDate(LocalDate.now());
		contactRepo.save(contact);
		if(contactRepo.equals(null)) {
			return false;
		}else
		{
			return true;
		}
	}

	@Override
	public List<Contact> getAllContacts() {
		
		List<Contact> findAll = contactRepo.findAll();
		return findAll;
	}

	@Override
	public Contact getContactById(Integer contactId) {
		Contact contact=new Contact();
		
		Optional<Contact> findById = contactRepo.findById(101);
		if(findById.isPresent()) {
			System.out.println(findById.get());
			return contact;
		}else {
			System.out.println("Record not found");
			return contact;
		}
		
		
	}

	@Override
	public boolean deleteContactById(Integer contactId) {
		contactRepo.deleteById(102);
		return true;
	}

}
