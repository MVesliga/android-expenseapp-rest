package hr.android.vesliga.expenseapp.repositories;

import hr.android.vesliga.expenseapp.model.*;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface IncomeRepository extends CrudRepository<Income,Long> {
    Iterable<Income>findAll();
    Iterable<Income>findByUser(User user);
    Iterable<Income>findByUserIdentifier(Long id);
    Income save(Income income);
    void deleteById(Long id);

    @Query("SELECT new hr.android.vesliga.expenseapp.model.Balance(MONTH(i.entryDate), SUM(i.amount)) from Income i where YEAR(i.entryDate) = :yearOfEntry GROUP BY MONTH(i.entryDate)")
    Iterable<Balance> listByIncomeMonth(@Param("yearOfEntry") int yearOfEntry);

    @Query("SELECT new hr.android.vesliga.expenseapp.model.Type(i.incomeType, sum(i.amount)) from Income i where MONTH(i.entryDate) = :monthOfEntry and year(i.entryDate) = :yearOfEntry group by i.incomeType")
    Iterable<Type> listByIncomeType(@Param("monthOfEntry") int monthOfEntry, @Param("yearOfEntry") int yearOfEntry);
}
