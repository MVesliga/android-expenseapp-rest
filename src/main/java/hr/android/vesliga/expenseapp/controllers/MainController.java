package hr.android.vesliga.expenseapp.controllers;

import hr.android.vesliga.expenseapp.model.Expense;
import hr.android.vesliga.expenseapp.model.Income;
import hr.android.vesliga.expenseapp.model.User;
import hr.android.vesliga.expenseapp.repositories.ExpenseRepository;
import hr.android.vesliga.expenseapp.repositories.IncomeRepository;
import hr.android.vesliga.expenseapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users")
public class MainController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ExpenseRepository expenseRepository;
    @Autowired
    IncomeRepository incomeRepository;

    @GetMapping("/showUsers")
    public String showUsers(Model model){
        Iterable<User> users = userRepository.findAll();

        model.addAttribute("users", users);

        return "showUsers";
    }

    @GetMapping("/showExpenses")
    public String showExpenses(@RequestParam(name="username")String username, Model model){
        User user = userRepository.findByUsername(username);
        Iterable<Expense> expenses = expenseRepository.findByUser(user);

        model.addAttribute("expenses", expenses);

        return "showExpenses";
    }

    @GetMapping("/showIncomes")
    public String showIncomes(@RequestParam(name="username")String username, Model model){
        User user = userRepository.findByUsername(username);
        Iterable<Income> incomes = incomeRepository.findByUser(user);

        model.addAttribute("incomes", incomes);

        return "showIncomes";
    }
}
