package objects;

public class Contact {
    private String salutation;
    private String firstName;
    private String middleName;
    private String lastName;
    private String suffix;
    private String accountName;
    private String title;
    private String email;
    private String phone;
    private String mobile;
    private String department;
    private String fax;

    private Contact() {
    }

    public String getSalutation() {
        return salutation;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getTitle() {
        return title;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getMobile() {
        return mobile;
    }

    public String getDepartment() {
        return department;
    }

    public String getFax() {
        return fax;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSuffix() {
        return suffix;
    }

    public static class Builder {
        Contact newContact;

        public Builder() {
            newContact = new Contact();
        }

        public Builder setSalutation(String salutation) {
            newContact.salutation = salutation;
            return this;
        }

        public Builder setFirstName(String firstName) {
            newContact.firstName = firstName;
            return this;
        }

        public Builder setMiddleName(String middleName) {
            newContact.middleName = middleName;
            return this;
        }

        public Builder setLastName(String lastName) {
            newContact.lastName = lastName;
            return this;
        }

        public Builder setSuffix(String suffix) {
            newContact.suffix = suffix;
            return this;
        }

        public Builder setAccountName(String accountName) {
            newContact.accountName = accountName;
            return this;
        }

        public Builder setTitle(String title) {
            newContact.title = title;
            return this;
        }

        public Builder setEmail(String email) {
            newContact.email = email;
            return this;
        }

        public Builder setPhone(String phone) {
            newContact.phone = phone;
            return this;
        }

        public Builder setMobile(String mobile) {
            newContact.mobile = mobile;
            return this;
        }

        public Builder setDepartment(String department) {
            newContact.department = department;
            return this;
        }

        public Builder setFax(String fax) {
            newContact.fax = fax;
            return this;
        }

        public Contact build() {
            return newContact;
        }
    }
}
