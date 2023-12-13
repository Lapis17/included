package Development.Included;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import Development.Included.service.OperatorService;
import Development.Included.dto.OperatorResponse;


@RestController
@SpringBootApplication
public class IncludedApplication {

    @Autowired
    private OperatorService operatorService;

    @RequestMapping("/")
    public String index() {
        // Fetch data from the database using OperatorService
        List<OperatorResponse> operators = operatorService.getAllOperators();

        // Build an HTML string to display the data with links to operator details
        StringBuilder htmlResponse = new StringBuilder("<h1>Operator Data:</h1>");
        for (OperatorResponse operator : operators) {
            htmlResponse.append("<p><a href=\"/api/operator/search?byName=")
                        .append(operator.getName()).append("\">")
                        .append(operator.getName()).append("</a></p>");
        }

        return htmlResponse.toString();
    }

    @RequestMapping("/api/operator/search")
    public String searchPage() {
        return "search";
    }

    public static void main(String[] args) {
        SpringApplication.run(IncludedApplication.class, args);
    }
}

