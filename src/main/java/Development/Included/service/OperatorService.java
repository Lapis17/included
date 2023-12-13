package Development.Included.service;

import java.util.List;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import Development.Included.dto.OperatorRequest;
import Development.Included.model.Operator;
import Development.Included.repository.OperatorRepository;
import Development.Included.dto.OperatorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Service
@RequiredArgsConstructor
@Slf4j
public class OperatorService {
	
	
	private final OperatorRepository operatorRepository;
	
	
	
	public void createOperator(OperatorRequest operatorRequest)
	{
		Operator operator = Operator.builder()
				.name(operatorRequest.getName())
				.address(operatorRequest.getAddress())
				.phoneNumber(operatorRequest.getPhoneNumber())
				.contactPerson(operatorRequest.getContactPerson())
				.build();
		
		operatorRepository.save(operator);
		log.info("Operator {} is saved", operator.getId());
	}



	public List<OperatorResponse> getAllOperators() {
		
		List<Operator> operators = operatorRepository.findAll();
		
		return operators.stream().map(this::mapToOperatorResponse).toList();
	}
	
	private OperatorResponse mapToOperatorResponse(Operator operator) {
		return OperatorResponse.builder()
				.id(operator.getId())
				.name(operator.getName())
				.address(operator.getAddress())
				.phoneNumber(operator.getPhoneNumber())
				.contactPerson(operator.getContactPerson())
				.build();
	}
	

	
	 public List<OperatorResponse> getOperatorsByName(String byName) {
	        List<Operator> operators = operatorRepository.findByNameContainingIgnoreCase(byName);
	        return operators.stream().map(this::mapToOperatorResponse).toList();
	    }

	 public OperatorResponse getOperatorByName(String byName) throws NotFoundException {
		    List<Operator> operators = operatorRepository.findByNameContainingIgnoreCase(byName);

		    if (operators.isEmpty()) {
		        throw new NotFoundException();
		    }

		    // Assuming you want to return the first operator if there are multiple matches
		    Operator operator = operators.get(0);

		    return mapToOperatorResponse(operator);
		}


	
}
