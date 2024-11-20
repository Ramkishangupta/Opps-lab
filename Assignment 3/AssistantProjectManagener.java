package employee;

import java.util.Scanner;

public class AssistantProjectManagener  extends employee{
	int basic_pay;

    public AssistantProjectManagener(int basicpay) {
        super(basicpay);  
    }

    public int input_pay() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee basic pay: ");
        basic_pay = sc.nextInt();
        return basic_pay;
    }
}
