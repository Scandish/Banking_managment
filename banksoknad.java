import java.util.Scanner;

class Banksoknad {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Skriv inn ditt 'Navn' og 'KundeID' for tilgang til din Bankkonto: ");
        String navn=sc.nextLine();
        String kundeid=sc.nextLine();
        Bankkonto bank1=new Bankkonto(navn, kundeid);
        bank1.menu();
    }
}