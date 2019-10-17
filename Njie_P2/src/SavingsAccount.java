public class SavingsAccount {

    static private double annualInterestRate;
    private double savingBalance;

    public SavingsAccount()
    {
        savingBalance = 0.00;
        annualInterestRate = 0.00;
    }

    private SavingsAccount(double savingBalance)
    {
        this.savingBalance = savingBalance;
    }

    private double getSavingBalance()
    {
        return this.savingBalance;
    }


    private static void modifyInterestRate(double newInterestRate)
    {
        annualInterestRate = newInterestRate;
    }

    private void calculateMonthlyInterest()
    {
        double monthlyInterest = 0;
        monthlyInterest = (double)(this.savingBalance*annualInterestRate/12);
        this.savingBalance += monthlyInterest;
    }

    public static void main(String[] args) {

        SavingsAccount  firstAccount = new SavingsAccount (2000.0);
        SavingsAccount  secondAccount= new SavingsAccount (3000.0);

        //interest rate 0.04
        SavingsAccount.modifyInterestRate (0.04);

        firstAccount.calculateMonthlyInterest();
        secondAccount.calculateMonthlyInterest();

        System.out.println("Current Month");
        System.out.println("First Saving Account Total balance is  $"+ firstAccount.getSavingBalance());
        System.out.println("Second Saving Account Total Balance is $"+ secondAccount.getSavingBalance());

        // New annual Rate 0.05
        SavingsAccount.modifyInterestRate(0.05);

        firstAccount.calculateMonthlyInterest();
        secondAccount.calculateMonthlyInterest();
        System.out.println("Next Month");
        System.out.println("First Saving Account Total balance is $"+ firstAccount.getSavingBalance());
        System.out.println("Second Saving Account Total Balance is  $"+ secondAccount.getSavingBalance());

    }
}
