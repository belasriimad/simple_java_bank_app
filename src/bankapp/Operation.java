/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankapp;

import java.util.Scanner;
import static javafx.application.Platform.exit;

/**
 *
 * @author Imad
 */
public class Operation implements CreateMenu{
    int solde;
    int operationPrec;
    String nom;
    String client_id;
    public Operation(String cname,String c_id){
        this.nom = cname;
        this.client_id = c_id;
    }
    public void Versement(int amount){
        if(amount != 0){
            solde = solde + amount;
            operationPrec = amount;
        }
    }
    public void Retrait(int amount){
        if(amount != 0){
            solde = solde - amount;
            operationPrec = -amount;
        }
    }
    public void operationsPrecedentes(){
        if(operationPrec > 0){
            System.out.println("Deposit amount : "+ operationPrec);
        }else if(operationPrec < 0){
            System.out.println("Withdrawal amount : "+ Math.abs(operationPrec));
        }else{
            System.out.println("Nothing done.");
        }
    }

    @Override
    public void showMenu() {
        char option = 'o';
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome :"+ nom);
        System.out.println("Your id :"+ client_id);
        System.out.println("\n");
        System.out.println("A.Check my wallet");
        System.out.println("B.Deposit");
        System.out.println("C.Withdrawal");
        System.out.println("D.Last Operation");
        System.out.println("E.Exit");
        do{
            System.out.println("================================================================");
            System.out.println("Choose an option");
            System.out.println("================================================================");
            option = scanner.next().charAt(0);
            switch(option){
                case 'A' :
                    System.out.println("===============================");
                    System.out.println("Your balance :"+ solde);
                    System.out.println("===============================");
                    System.out.println("\n");
                break;
                case 'B' :
                System.out.println("===============================");
                    System.out.println("The amount to deposit :");
                    int amount = scanner.nextInt();
                    Versement(amount);
                    System.out.println("\n");
                break;
                case 'C' :
                System.out.println("===============================");
                    System.out.println("The amount to withdraw :");
                    int amt = scanner.nextInt();
                    Retrait(amt);
                    System.out.println("\n");
                break;
                case 'D' :
                    System.out.println("===============================");
                    operationsPrecedentes();
                    System.out.println("==============================="); 
                    System.out.println("\n");
                break;
                case 'E' :
                    System.out.println("==============================="); 
                break;
                default:
                    System.out.println("Invalid action!"); 
                break;
            }
        }while(option != 'E');
        System.out.println("Thanks."); 
    }
    
}
