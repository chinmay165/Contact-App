package in.sbAngular.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.sbAngular.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Integer> {

}
