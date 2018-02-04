package PIM.WEBSERIVE.ACTIVITIE.STUDENT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import PIM.WEBSERIVE.ACTIVITIE.STUDENT.Model.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

	public Account findByUsernameAndPassword(String username, String password);
	
	public Account findByUsername(String username);
	
	public Account findById(Long id);

}
