package hr.android.vesliga.expenseapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Table(name="Expenses")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String expenseName;
    private String expenseType;
    private Double amount;
    private String entryDate;
    private Long userIdentifier;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="user_id")
    @JsonIgnore
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getUserIdentifier() {
        return userIdentifier;
    }

    public void setUserIdentifier(Long userId) {
        this.userIdentifier = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Expense expense = (Expense) o;
        return Objects.equals(id, expense.id) &&
                Objects.equals(expenseName, expense.expenseName) &&
                Objects.equals(expenseType, expense.expenseType) &&
                Objects.equals(amount, expense.amount) &&
                Objects.equals(entryDate, expense.entryDate) &&
                Objects.equals(userIdentifier, expense.userIdentifier) &&
                Objects.equals(user, expense.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, expenseName, expenseType, amount, entryDate, userIdentifier, user);
    }
}
