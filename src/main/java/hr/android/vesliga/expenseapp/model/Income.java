package hr.android.vesliga.expenseapp.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@NoArgsConstructor
@Table(name="Incomes")
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String incomeName;
    private String incomeType;
    private Double amount;
    private String entryDate;
    private Long userIdentifier;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="user_id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIncomeName() {
        return incomeName;
    }

    public void setIncomeName(String incomeName) {
        this.incomeName = incomeName;
    }

    public String getIncomeType() {
        return incomeType;
    }

    public void setIncomeType(String incomeType) {
        this.incomeType = incomeType;
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

    public void setUserIdentifier(Long userIdentifier) {
        this.userIdentifier = userIdentifier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Income income = (Income) o;
        return Objects.equals(id, income.id) &&
                Objects.equals(incomeName, income.incomeName) &&
                Objects.equals(incomeType, income.incomeType) &&
                Objects.equals(amount, income.amount) &&
                Objects.equals(entryDate, income.entryDate) &&
                Objects.equals(userIdentifier, income.userIdentifier) &&
                Objects.equals(user, income.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, incomeName, incomeType, amount, entryDate, userIdentifier, user);
    }
}
