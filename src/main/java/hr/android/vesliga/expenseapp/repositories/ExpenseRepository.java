package hr.android.vesliga.expenseapp.repositories;
import hr.android.vesliga.expenseapp.model.Balance;
import hr.android.vesliga.expenseapp.model.Type;
import hr.android.vesliga.expenseapp.model.User;

import hr.android.vesliga.expenseapp.model.Expense;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ExpenseRepository extends CrudRepository<Expense,Long> {
    Iterable<Expense>findAll();
    Iterable<Expense>findByUserIdentifier(Long id);
    Iterable<Expense>findByUser(User user);
    Expense save(Expense expense);
    void deleteById(Long id);
    //select month(entry_date), sum(amount) from expenses  where year(entry_date) = '2019' group by month(entry_date);
    @Query("SELECT new hr.android.vesliga.expenseapp.model.Balance(MONTH(e.entryDate), SUM(e.amount)) from Expense e where YEAR(e.entryDate) = :yearOfEntry GROUP BY MONTH(e.entryDate)")
    Iterable<Balance> listByExpenseMonth(@Param("yearOfEntry") int yearOfEntry);

    //select expense_type, sum(amount) from expenses where month(entry_date) = 4 group by expense_type ;
    @Query("SELECT new hr.android.vesliga.expenseapp.model.Type(e.expenseType, sum(e.amount)) from Expense e where MONTH(e.entryDate) = :monthOfEntry and year(e.entryDate) = :yearOfEntry group by e.expenseType")
    Iterable<Type> listByExpenseType(@Param("monthOfEntry") int monthOfEntry, @Param("yearOfEntry") int yearOfEntry);
}
