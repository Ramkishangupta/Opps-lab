package employee;
import java.util.Scanner;
public class employee {
	int emp_no;
	int emp_id,mobile_no;
    float DA,HRA,PP,stafclub;
    static float income;
    float netsalary;
    static int count=0;

	public employee(int basicpay) {
		// TODO Auto-generated constructor stub
	}
	public int input_no() {
		Scanner sc=new Scanner(System.in);
        System.out.println("Enter employee no: ");
		emp_no=sc.nextInt();
		return emp_no;
	}
	String emp_name,email,address;
    public void inputdetail() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter employee name: ");
        emp_name = sc.next();
        System.out.println("Enter employee email: ");
        email = sc.next();
        System.out.println("Enter employee address: ");
        address = sc.next();
        System.out.println("Enter employee id: ");
        emp_id = sc.nextInt();
        System.out.println("Enter employee mobile no: ");
        mobile_no = sc.nextInt();
    }
    public float salary(int basicpay) {
        DA = (float) (0.97 * basicpay);
        HRA = (float) (0.1 * basicpay);
        PP = (float) (0.12 * basicpay);
        stafclub = (float) (0.001 * basicpay);
        income = DA + HRA + PP + stafclub;
        return income;
    }
    public float netsal() {
    	netsalary=income-PP-stafclub;
    	return netsalary;
    }
    public void display2(int pay) {
        System.out.println("Employee ID: " + this.emp_id);
        System.out.println("Employee Name: " + this.emp_name);
        System.out.println("Basic Pay: " + pay);
    }
    public void display(int basicpay) {
    	System.out.println("The name of employee is: " + emp_name);
    	System.out.println("The id of employee is: " + emp_id);
    	System.out.println("The Basic pay of employee is: " + basicpay);
        System.out.println("The DA pay of employee is: " + DA);
        System.out.println("The HRA pay of employee is: " + HRA);
        System.out.println("The PP pay of employee is: " + PP);
        System.out.println("The pay of employee is: " + income);
        System.out.println("The netsalarypay of employee is: " + netsalary);
        System.out.println("_____________________________________");
    }
}
