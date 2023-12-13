package Development.Included.dto;

import lombok.Builder;
import lombok.Data;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OperatorRequest {
	
	private String name;
	private String address;
	private String phoneNumber;
	private String contactPerson;

}
