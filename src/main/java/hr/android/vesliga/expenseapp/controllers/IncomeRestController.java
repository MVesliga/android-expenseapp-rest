package hr.android.vesliga.expenseapp.controllers;

import hr.android.vesliga.expenseapp.model.*;
import hr.android.vesliga.expenseapp.repositories.IncomeRepository;
import hr.android.vesliga.expenseapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/incomes", produces = "application/json")
@CrossOrigin
public class IncomeRestController {

    @Autowired
    IncomeRepository incomeRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/{id}")
    public Iterable<Income> findAll(@PathVariable Long id){
        return incomeRepository.findByUserIdentifier(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public Income save(@RequestBody Income income){
        User user = userRepository.findById(income.getUserIdentifier()).get();
        income.setUser(user);
        return incomeRepository.save(income);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        incomeRepository.deleteById(id);
    }

    @GetMapping("/balance/{yearOfEntry}")
    public Iterable<Balance> listByExpenseMonth(@PathVariable int yearOfEntry){
        return incomeRepository.listByIncomeMonth(yearOfEntry);
    }

    @GetMapping("/balance/{monthOfEntry}/{yearOfEntry}")
    public Iterable<Type> listByExpenseType(@PathVariable int monthOfEntry, @PathVariable int yearOfEntry){
        return incomeRepository.listByIncomeType(monthOfEntry, yearOfEntry);
    }
}
