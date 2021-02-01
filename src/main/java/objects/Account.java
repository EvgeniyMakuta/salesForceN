package objects;

public class Account {
    private String accountName;
    private String website;
    private String type;
    private String description;
    private String phone;
    private String industry;
    private Integer employees;

    private Account() {
    }

    public String getDescription() {
        return description;
    }

    public String getPhone() {
        return phone;
    }

    public String getIndustry() {
        return industry;
    }

    public Integer getEmployees() {
        return employees;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getWebsite() {
        return website;
    }

    public String getType() {
        return type;
    }

    public static class Builder {
        private Account newAccount;

        public Builder() {
            newAccount = new Account();
        }

        public Builder setAccountName(String accountName) {
            newAccount.accountName = accountName;
            return this;
        }

        public Builder setWebsite(String website) {
            newAccount.website = website;
            return this;
        }

        public Builder setType(String type) {
            newAccount.type = type;
            return this;
        }

        public Builder setDescription(String description) {
            newAccount.description = description;
            return this;
        }

        public Builder setPhone(String phone) {
            newAccount.phone = phone;
            return this;
        }

        public Builder setIndustry(String industry) {
            newAccount.industry = industry;
            return this;
        }

        public Builder setEmployees(Integer employees) {
            newAccount.employees = employees;
            return this;
        }

        public Account build() {
            return newAccount;
        }
    }
}
