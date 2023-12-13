package Development.Included.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(value = "operator")
@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class Operator {
    @Id
    private String id;
    private String name;
    private String address;
    private String phoneNumber;
    private String contactPerson;

}
