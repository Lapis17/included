package Development.Included.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import Development.Included.dto.OperatorRequest;
import Development.Included.service.OperatorService;
import Development.Included.dto.OperatorResponse;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("api/operator")
@RequiredArgsConstructor
public class OperatorController {

    private final OperatorService operatorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createOperator(@RequestBody OperatorRequest operatorRequest) {
        operatorService.createOperator(operatorRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OperatorResponse> getAllOperators() {
        return operatorService.getAllOperators();
    }

    @GetMapping("/search")
    public ModelAndView getOperatorsByName(@RequestParam String byName) {
        try {
            List<OperatorResponse> operators = operatorService.getOperatorsByName(byName);
            ModelAndView modelAndView = new ModelAndView("searchResults");
            modelAndView.addObject("operators", operators);
            return modelAndView;
        } catch (Exception e) {
            ModelAndView modelAndView = new ModelAndView("error");
            modelAndView.addObject("error", "An error occurred while processing the request");
            return modelAndView;
        }
    }
}
