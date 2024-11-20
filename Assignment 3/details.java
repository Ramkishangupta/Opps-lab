package employee;

import java.util.Scanner;

public class details extends employee {
    int basic_pay;

    public details(int basicpay) {
        super(basicpay);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pay = 0;
        employee[] employees = null;
        employee[] teamlead = null;
        employee[] assistantmanager = null;
        employee[] manager = null;
        System.out.println("Enter 1 to start");
        System.out.println("Enter 5 to exit");
        int n = sc.nextInt();
        while (n == 1) {
            System.out.println("Enter Your choice");
            System.out.println("Enter 1 to make Programmer object");
            System.out.println("Enter 2 to make Teamlead object");
            System.out.println("Enter 3 to make Assistant Project Manager object");
            System.out.println("Enter 4 to make Project Manager object");
            int ans = sc.nextInt();

            if (ans == 1) {
                Programmer e = new Programmer(0);
                int no = e.input_no();
                employees = new Programmer[no];
                for (int i = 0; i < no; i++) {
                    employees[i] = new Programmer(0);
                    System.out.println("Enter employee details:");
                    employees[i].inputdetail();
                    pay = e.input_pay();
                    employees[i].salary(pay);
                    employees[i].netsal();
                    employee.count++;
                }
            } else if (ans == 2) {
                Teamlead l = new Teamlead(0);
                int no = l.input_no();
                teamlead = new Teamlead[no];
                for (int i = 0; i < no; i++) {
                    teamlead[i] = new Teamlead(0);
                    System.out.println("Enter employee details:");
                    teamlead[i].inputdetail();
                    pay = l.input_pay();
                    teamlead[i].salary(pay);
                    teamlead[i].netsal();
                    employee.count++;
                }
            } else if (ans == 3) {
                AssistantProjectManagener a = new AssistantProjectManagener(0);
                int no = a.input_no();
                assistantmanager = new AssistantProjectManagener[no];
                for (int i = 0; i < no; i++) {
                    assistantmanager[i] = new AssistantProjectManagener(0);
                    System.out.println("Enter employee details:");
                    assistantmanager[i].inputdetail();
                    pay = a.input_pay();
                    assistantmanager[i].salary(pay);
                    assistantmanager[i].netsal();
                    employee.count++;
                }
            } else{
                ProjectManager p = new ProjectManager(0);
                int no = p.input_no();
                manager = new ProjectManager[no];
                for (int i = 0; i < no; i++) {
                    manager[i] = new ProjectManager(0);
                    System.out.println("Enter employee details:");
                    manager[i].inputdetail();
                    pay = p.input_pay();
                    manager[i].salary(pay);
                    manager[i].netsal();
                    employee.count++;
                }
            }

            System.out.println("Enter 1 to continue, 5 to exit");
            n = sc.nextInt();
        }
        System.out.println("Do you want to see employee details? 1/Yes 0/No");
        int ans1 = sc.nextInt();
        if (ans1 == 1) {
            if (ans1 == 1) {
                if (employees != null) {
                    for (employee employee : employees) {
                        employee.display(pay);
                    }
                }
                if (teamlead != null) {
                    for (employee employee : teamlead) {
                        employee.display(pay);
                    }
                }
                if (assistantmanager != null) {
                    for (employee employee : assistantmanager) {
                        employee.display(pay);
                    }
                }
                if (manager != null) {
                    for (employee employee : manager) {
                        employee.display(pay);
                    }
                }
                System.out.println("Total no of employee " +count);
                System.out.println("_____________________________________");
            }
        }
        else {
            System.out.println("There is no Object");
        }


        sc.close();
    }
}
