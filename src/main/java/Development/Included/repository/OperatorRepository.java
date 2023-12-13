package Development.Included.repository;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.repository.CrudRepository;
import Development.Included.model.Operator;

	public interface OperatorRepository extends MongoRepository<Operator, String> {
		List<Operator> findByNameContainingIgnoreCase(String name);
	}


