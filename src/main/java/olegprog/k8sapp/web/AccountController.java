package olegprog.k8sapp.web;

import lombok.RequiredArgsConstructor;
import olegprog.k8sapp.entity.Account;
import olegprog.k8sapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(path = "/accounts", produces = APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class AccountController {

    private final AccountRepository accountRepository;
    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @GetMapping(path = "/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable(name = "id") Long id) {
        return ResponseEntity
                .ok(accountRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }

    @GetMapping(path = "/info")
    public String[] getDatabaseInfo() {
        return new String[] {url, username, password};
    }

}
