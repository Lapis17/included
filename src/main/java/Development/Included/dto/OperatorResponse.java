package Development.Included.dto;



import lombok.Builder;
import lombok.Data;

//import org.springframework.data.annotation.Id;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OperatorResponse {
	private String id;
	private String name;
	private String address;
	private String phoneNumber;
	private String contactPerson;

	
	

}
