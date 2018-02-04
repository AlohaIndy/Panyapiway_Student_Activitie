package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.Address;

public interface AddressRepository extends JpaRepository<Address, Long>{

	public Address findByPersonId(long personId);
	
}
