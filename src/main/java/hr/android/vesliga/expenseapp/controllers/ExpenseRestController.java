package hr.android.vesliga.expenseapp.controllers;

import hr.android.vesliga.expenseapp.model.Balance;
import hr.android.vesliga.expenseapp.model.Expense;
import hr.android.vesliga.expenseapp.model.Type;
import hr.android.vesliga.expenseapp.model.User;
import hr.android.vesliga.expenseapp.repositories.ExpenseRepository;
import hr.android.vesliga.expenseapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/expenses", produces = "application/json")
@CrossOrigin
public class ExpenseRestController {

    @Autowired
    ExpenseRepository expenseRepository;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/{id}")
    public Iterable<Expense> findAll(@PathVariable Long id){
        return expenseRepository.findByUserIdentifier(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json")
    public Expense save(@RequestBody Expense expense){
        User user = userRepository.findById(expense.getUserIdentifier()).get();
        expense.setUser(user);
        return expenseRepository.save(expense);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        expenseRepository.deleteById(id);
    }

    @GetMapping("/balance/{yearOfEntry}")
    public Iterable<Balance> listByExpenseMonth(@PathVariable int yearOfEntry){
        return expenseRepository.listByExpenseMonth(yearOfEntry);
    }

    @GetMapping("/balance/{monthOfEntry}/{yearOfEntry}")
    public Iterable<Type> listByExpenseType(@PathVariable int monthOfEntry, @PathVariable int yearOfEntry){
        return expenseRepository.listByExpenseType(monthOfEntry, yearOfEntry);
    }
}
