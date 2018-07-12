package pl.lodomaniak.icecream;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lodomaniak.icecream.api.CompanyTO;

import java.security.Principal;

@RestController
@RequestMapping("/api/company")
@Api(tags = "Company", description = "Perform operations on Companies.")
public class CompanyRestController {

    private final CompanyService companyService;

    @Autowired
    public CompanyRestController(final CompanyService companyService) {
        this.companyService = companyService;
    }

    @ApiOperation(value = "Receive companies.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Company received")})
    @GetMapping("/mine")
    public ResponseEntity<?> getCompanies(@AuthenticationPrincipal final User user) {
        return ResponseEntity.ok(companyService.getCompanies(user));
    }

}
