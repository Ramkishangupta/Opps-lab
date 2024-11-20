package assignment;
import java.util.Scanner;
class complex {
	int ans;
	public void firstinput() {
		Scanner sc =new Scanner(System.in);
		ans=sc.nextInt();
	}
	float real,imag;
	public void input() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter complex no");
		System.out.print("The real part is : ");
		real=sc.nextInt();
		System.out.print("The imaginary part is : ");
		imag=sc.nextInt();
	}
	public complex add(complex C1,complex C2) {
		complex C3=new complex();
		C3.real=C1.real+C2.real;
		C3.imag=C1.imag+C2.imag;
		return C3;
	}
	public complex sub(complex C1,complex C2) {
		complex C3=new complex();
		C3.real=C1.real-C2.real;
		C3.imag=C1.imag-C2.imag;
		return C3;
	}
	public complex mul(complex C1,complex C2) {
		complex C3=new complex();
		C3.real=C1.real*C2.real-C1.imag*C2.imag;
		C3.imag=C1.real*C2.imag+C2.real*C1.imag;
		return C3;
	}
	public complex div(complex C1,complex C2) {
		complex C3=new complex();
		if(C2.real!=0 && C2.imag!=0) {
		C3.real=(C1.real*C2.real+C1.imag*C2.imag)/(C2.real*C2.real+C2.imag*C2.imag);
		C3.imag=(C1.real*C2.imag+C2.real*C1.imag)/(C2.real*C2.real+C2.imag*C2.imag);
		}
		else {
			System.out.println("div not possible");
		}
		return C3;
	}
	public void display_given_no(complex C1,complex C2) {
		System.out.println("First complex no"+C1.real+"+"+C1.imag+"i");
		System.out.println("First complex no"+C2.real+"+"+C2.imag+"i");
	}
	public void display() {
		System.out.println("resultant complex no is"+real+"+"+imag+"i");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		complex C1=new complex();
		complex C2=new complex();
		complex C= new complex();
	//1.input();
	//2.input();
		System.out.println("What Operation You Want To perform Number");
		System.out.println("press 1 to add:");
		System.out.println("press 2 to subtraction:");
		System.out.println("press 3 for Multiplication:");
		System.out.println("press 4 for Division:");
		System.out.println("press 0 to exit");
		C.firstinput();
		while(C.ans==1 || C.ans==2 || C.ans==3 || C.ans==4) {
			C1.input();
		    C2.input();	  
		    if(C.ans==1) {
		    C=C.add(C1,C2);
		    C.display_given_no(C1,C2);
		    C.display();
		    }
		    else if(C.ans==2) {
		    	C=C.sub(C1,C2);
			    C.display_given_no(C1,C2);
			    C.display();
		    }
		    else if(C.ans==3) {
		    	C=C.mul(C1,C2);
			    C.display_given_no(C1,C2);
			    C.display();
		    }
		    else {
		    	C=C.div(C1,C2);
			    C.display_given_no(C1,C2);
			    C.display();
		    }
			System.out.print("\n");
			System.out.println("What Operation You Want To perform Number");
			System.out.println("press 1 to add:");
			System.out.println("press 2 to subtraction:");
			System.out.println("press 3 for Multiplication:");
			System.out.println("press 4 for Division:");
			System.out.println("press 0 to exit");
		    C.firstinput();
		}
	
	}

}