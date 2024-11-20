package employee;

import java.util.Scanner; 

public class ProjectManager  extends employee{
	int basic_pay;

    public ProjectManager(int basicpay) {
        super(basicpay);  
    }
    public int input_pay() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee basic pay: ");
        basic_pay = sc.nextInt();
        return basic_pay;
    }
}
