package menus;

import clients.Client;
import files.FileHandler;
import loans.Loan;
import loansManager.Manager;
import java.util.Scanner;

public interface Command {
    void execute();
    String getName();
}

class LoanSearchCommand implements Command {
    private FileHandler fileHandler;

    public LoanSearchCommand(FileHandler fileHandler) {
        this.fileHandler = fileHandler;
    }

    @Override
    public void execute() {
        Loan.searchForLoans(fileHandler);
    }

    @Override
    public String getName() {
        return "Search for loans";
    }
}

class ApplyForLoanCommand implements Command {
    private Client client;

    public ApplyForLoanCommand(Client client) {
        this.client = client;
    }

    @Override
    public void execute() {
        client.applyForLoan();
    }

    @Override
    public String getName() {
        return "Apply for a loan";
    }
}

class ViewClientLoansCommand implements Command {
    private Client client;

    public ViewClientLoansCommand(Client client) {
        this.client = client;
    }

    @Override
    public void execute() {
        client.viewClientLoans();
    }

    @Override
    public String getName() {
        return "View your loans";
    }
}

class RequestEarlyRepaymentCommand implements Command {
    private Client client;

    public RequestEarlyRepaymentCommand(Client client) {
        this.client = client;
    }

    @Override
    public void execute() {
        client.requestEarlyRepayment();
    }

    @Override
    public String getName() {
        return "Request early repayment";
    }
}

class RequestCreditLineExtensionCommand implements Command {
    private Client client;

    public RequestCreditLineExtensionCommand(Client client) {
        this.client = client;
    }

    @Override
    public void execute() {
        client.requestCreditLineExtension();
    }

    @Override
    public String getName() {
        return "Request credit line extension";
    }
}

class AddNewLoanCommand implements Command {
    private Manager manager;

    public AddNewLoanCommand(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter loan amount: ");
        double amount = scanner.nextDouble();

        System.out.println("Enter bank name: ");
        String bankName = scanner.next();

        System.out.println("Enter term in months: ");
        int termInMonths = scanner.nextInt();

        System.out.println("Enter interest rate: ");
        double interestRate = scanner.nextDouble();

        manager.addLoan(amount, bankName, termInMonths, interestRate);
    }

    @Override
    public String getName() {
        return "Add a new loan";
    }
}

class RemoveLoanCommand implements Command {
    private Manager manager;

    public RemoveLoanCommand(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter loan ID to remove: ");
        int loanId = scanner.nextInt();
        manager.deleteLoan(loanId);
    }

    @Override
    public String getName() {
        return "Remove a loan";
    }
}

class ModifyLoanDetailsCommand implements Command {
    private Manager manager;

    public ModifyLoanDetailsCommand(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void execute() {
        manager.updateLoan();
    }

    @Override
    public String getName() {
        return "Modify loan details";
    }
}

class ViewPendingRequestsCommand implements Command {
    private Manager manager;

    public ViewPendingRequestsCommand(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void execute() {
        manager.viewPendingRequests();
    }

    @Override
    public String getName() {
        return "View client requests";
    }
}

class ProcessRequestCommand implements Command {
    private Manager manager;

    public ProcessRequestCommand(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter request ID to process: ");
        int requestId = scanner.nextInt();
        manager.processRequest(requestId);
    }

    @Override
    public String getName() {
        return "Process a request";
    }
}

class ViewApprovedLoansCommand implements Command {
    private Manager manager;

    public ViewApprovedLoansCommand(Manager manager) {
        this.manager = manager;
    }

    @Override
    public void execute() {
        manager.viewApprovedLoans();
    }

    @Override
    public String getName() {
        return "View approved loans";
    }
}
