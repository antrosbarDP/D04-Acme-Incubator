
package acme.features.administrator.inquiry;

import java.util.Collection;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import acme.entities.inquiries.Inquiry;
import acme.framework.repositories.AbstractRepository;

@Repository
public interface AdministratorInquiryRepository extends AbstractRepository {

	@Query("select n from Inquiry n where NOW() <= n.deadline ")
	Collection<Inquiry> findMany();

	@Query("select n from Inquiry n where n.id=?1")
	Inquiry findOneById(int id);
}
