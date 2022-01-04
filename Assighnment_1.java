
/**
 * Assighnment_1 - Write a description here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
// Standard import for the Scanner class
import java.util.*;
public class Assighnment_1 {
    public static void main (String [] args) {
        /* Name : Hanin Geabel   Date 11-10-2021
         we will write a programe that comput the amount of personal exeption and the amount of regular and special duty and tax
         and display if the teavellar has limited alcohole and Tobacco depends on how many days was the travellar absent and the total amount of imported
         goods.
         starting with import three inputs[Travel name(last,first,initailas), length of absents, The amount of import goods]. Then we going to check if the 
         length of absents less than a day or between 1 day but less than 2 days or 2 days or more. 
         */
        // declear the varebles that i need 
        double maxPersonalExeption,useableExemption,specialDutyTaxes,regularDutyTaxes;
        char dollar= '$';
        Scanner in = new Scanner (System.in);
        //obtain three inputs from the user:
        System.out.print("Traveller's name (last, first, initials): ");
        String travellersName = in.nextLine();
        System.out.print("Length of absence (# of days): "); 
        double numberOfDay = in.nextDouble();
        System.out.print("Total amount of imported goods ($ CAD): ");
        double amountOfGoods = in.nextDouble();
        in.nextLine();
        String[] names = travellersName.split(", ");
    
        System.out.println("Import Exemption Report for "+names[1]+" "+ names[2]+" "+names[0]);
        
        System.out.println("---------------------------------------------------------------\n");
        /*checking how many days was absent:(if less than one day, it will be no personal exeption and will display no  Alcohol & Tobacco as will as no 
        regular and special duty and tax*/
        if (numberOfDay<1)
        {
            maxPersonalExeption = 0;
            useableExemption = 0;
            specialDutyTaxes =0;
            regularDutyTaxes = amountOfGoods;
            System.out.printf("Absence Period (days) %26.1f\n",numberOfDay);
            System.out.printf("...Maximum Personal Exemption  %14c%.2f \n",dollar ,maxPersonalExeption); 
            System.out.println("...Include Limited Alcohol & Tobacco?          No\n");
            System.out.printf("Usable Personal Exemption %30c%.2f\n",dollar,useableExemption);
            System.out.printf("Amount Subject to Special Duty & Taxes %17c%.2f\n",dollar,specialDutyTaxes);
            System.out.printf("Amount Subject to Special Duty & Taxes %16c%.2f\n",dollar,regularDutyTaxes);
            System.out.println("\t\t\t\t\t\t   -----------");
            System.out.printf("Total Amount of Imported Goods %24c%.2f\n",dollar,amountOfGoods);
            System.out.println("---------------------------------------------------------------\n");
        }
        /*if the absent days are more than one day but less than 2 days, we will check the amount of 
          imported goods. if it is <=200,the travelar can claimed the all amount as a personal exeption and will display no  Alcohol & 
         Tobacco as will as no regular and special duty and tax*/
        else if (1<=numberOfDay && numberOfDay<2)
        {
            if(amountOfGoods<= 200)
            {
                maxPersonalExeption = 200;
                System.out.println("...Include Limited Alcohol & Tobacco?No");
                useableExemption = amountOfGoods;
                specialDutyTaxes =0;
                regularDutyTaxes =0;
                System.out.printf("Absence Period (days) %26.1f\n",numberOfDay);
            System.out.printf("...Maximum Personal Exemption  %11c%.2f \n",dollar ,maxPersonalExeption); 
            System.out.println("...Include Limited Alcohol & Tobacco?         No\n");
            System.out.printf("Usable Personal Exemption %30c%.2f\n",dollar,useableExemption);
            System.out.printf("Amount Subject to Special Duty & Taxes %19c%.2f\n",dollar,specialDutyTaxes);
            System.out.printf("Amount Subject to Special Duty & Taxes %19c%.2f\n",dollar,regularDutyTaxes);
            System.out.println("\t\t\t\t\t\t     ---------");
            System.out.printf("Total Amount of Imported Goods %25c%.2f\n",dollar,amountOfGoods);
            System.out.println("---------------------------------------------------------------\n");
            }
            /* else( amount Of Goods is >200),the travelar can not claimed the amount as a personal exeption and will display no  Alcohol & 
         Tobacco and the regular and special duty and tax will apply*/
            else
            {
                maxPersonalExeption = 200;
                System.out.println("...Include Limited Alcohol & Tobacco?No");
                useableExemption = 0;
                specialDutyTaxes =0;
                regularDutyTaxes =amountOfGoods; 
                System.out.printf("Absence Period (days) %26.1f\n",numberOfDay);
            System.out.printf("...Maximum Personal Exemption  %12c%.2f \n",dollar ,maxPersonalExeption); 
            System.out.println("...Include Limited Alcohol & Tobacco?          No\n");
            System.out.printf("Usable Personal Exemption %30c%.2f\n",dollar,useableExemption);
            System.out.printf("Amount Subject to Special Duty & Taxes %17c%.2f\n",dollar,specialDutyTaxes);
            System.out.printf("Amount Subject to Special Duty & Taxes %15c%.2f\n",dollar,regularDutyTaxes);
            System.out.println("\t\t\t\t\t\t   ----------");
            System.out.printf("Total Amount of Imported Goods %23c%.2f\n",dollar,amountOfGoods);
            System.out.println("-------------------------------------------------------------\n");
            
            }
        }
            /*if the absent days are more than or = 2 days, we will check the amount of 
        imported goods. if it is <=800,the travelar can claim the amount Of Goods as a personal exeption. and will display limit Alcohol & 
         Tobacco and no regular and special duty and tax*/
        else 
        {
            if (amountOfGoods<=800)
            {
                maxPersonalExeption =800;
                useableExemption = amountOfGoods;
                specialDutyTaxes =0;
                regularDutyTaxes =0;
                System.out.printf("Absence Period (days) %26.1f\n",numberOfDay);
            System.out.printf("...Maximum Personal Exemption  %11c%.2f \n",dollar ,maxPersonalExeption); 
            System.out.println("...Include Limited Alcohol & Tobacco?        Yes\n");
            System.out.printf("Usable Personal Exemption %30c%.2f\n",dollar,useableExemption);
            System.out.printf("Amount Subject to Special Duty & Taxes %19c%.2f\n",dollar,specialDutyTaxes);
            System.out.printf("Amount Subject to Special Duty & Taxes %19c%.2f\n",dollar,regularDutyTaxes);
            System.out.println("\t\t\t\t\t\t     ---------");
            System.out.printf("Total Amount of Imported Goods %25c%.2f\n",dollar,amountOfGoods);
            System.out.println("--------------------------------------------------------------\n");
            }
                /*we will check the amount of 
        imported goods. if it is >800 and less than or equal 1100. if so, we will cliam a 800 as a  personal exeption and will take7% of the remaining 
        as a special duty and tax*/
            else if (amountOfGoods>800 && amountOfGoods<= 1100)
            {
            maxPersonalExeption =800;
            useableExemption = 800;
            specialDutyTaxes =(amountOfGoods-useableExemption);
            regularDutyTaxes =0;
            System.out.printf("Absence Period (days) %26.1f\n",numberOfDay);
            System.out.printf("...Maximum Personal Exemption  %11c%.2f \n",dollar ,maxPersonalExeption); 
            System.out.println("...Include Limited Alcohol & Tobacco?        Yes\n");
            System.out.printf("Usable Personal Exemption %30c%.2f\n",dollar,useableExemption);
            System.out.printf("Amount Subject to Special Duty & Taxes %17c%.2f\n",dollar,specialDutyTaxes);
            System.out.printf("Amount Subject to Special Duty & Taxes %17c%.2f\n",dollar,regularDutyTaxes);
            System.out.println("\t\t\t\t\t\t     ----------");
            System.out.printf("Total Amount of Imported Goods %25c %.2f\n",dollar,amountOfGoods);
            System.out.println("--------------------------------------------------------------\n");
            }
            /*if the amount of imported goods is >1100. if so, we will cliam a 800 as a  personal exeption and will take7% of th3 300$ as a special duty and tax 
        then the remaining will be as a regular Duty Taxes  */
            else 
            {
            maxPersonalExeption =800; 
            useableExemption = 800;
            specialDutyTaxes =300;
            regularDutyTaxes = amountOfGoods-1100;
            System.out.printf("Absence Period (days) %26.1f\n",numberOfDay);
            System.out.printf("...Maximum Personal Exemption  %11c%.2f \n",dollar ,maxPersonalExeption); 
            System.out.println("...Include Limited Alcohol & Tobacco?         Yes\n");
            System.out.printf("Usable Personal Exemption %30c%.2f\n",dollar,useableExemption);
            System.out.printf("Amount Subject to Special Duty & Taxes %17c%.2f\n",dollar,specialDutyTaxes);
            System.out.printf("Amount Subject to Special Duty & Taxes %17c%.2f\n",dollar,regularDutyTaxes);
            System.out.println("\t\t\t\t\t\t     ----------");
            System.out.printf("Total Amount of Imported Goods %24c%.2f\n",dollar,amountOfGoods);
            System.out.println("----------------------------------------------------------------\n");
            }
            
        }
        
        }

        
    }

