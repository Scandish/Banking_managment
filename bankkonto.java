import java.util.Scanner;

class Bankkonto {
    // private eller public? eller standard java?
    double balance;
    double prevTransaction;
    String kundeNavn;
    String kundeID;

    Bankkonto(String kundeNavn, String kundeID) {
        this.kundeNavn = kundeNavn;
        this.kundeID = kundeID;
    }

    void innskudd(double amount) {
        if (amount != 0){
            balance += amount;
            prevTransaction = amount;
        }
    }
    void uttak(double mengde) {
        if(mengde != 0 && balance>=mengde) {
            balance -= mengde;
            prevTransaction =-mengde; //Forrigetransaskjon vil jo være det vi tar ut i negativ, siden vi mister penger fra konto
        }
        else if(balance<mengde) {
            System.out.println("Ikke nok penger på konto."); 
        }

    }

    void hentForTrans() {
        if (prevTransaction>0) {
            System.out.println("Innskud: " + prevTransaction);
        }
        else if (prevTransaction<0) {
            System.out.println("Uttak: " + Math.abs(prevTransaction));
        }
        else {
            System.out.println("Ingen transaksjon tok plass.");
        }
    }

    void menu(){
        char option;
        Scanner sc=new Scanner(System.in);
        System.out.println("Velkommen" + " " + kundeNavn);
        System.out.println("Din ID:" + " " + kundeID);
        System.out.println("\n");
        System.out.println("a) Sjekk Balance");
        System.out.println("b) Innskudd Mengde");
        System.out.println("c) Ta ut mengde");
        System.out.println("d) Forrige Transaksjon");
        System.out.println("e) Exit");
        do{
            System.out.println("********************************************");
            System.out.println("Velg et alternativ");
            option=sc.next().charAt(0);
            System.out.println("\n");

            switch (option){
                case 'a':
                    System.out.println("......................");
                    System.out.println("Balanse ="+balance);
                    System.out.println("......................");
                    System.out.println("\n");
                    break;
                case 'b':
                    System.out.println("......................");
                    System.out.println("Legg inn et innskudd :");
                    System.out.println("......................");
                    double amount=sc.nextDouble();
                    innskudd(amount);
                    System.out.println("\n");
                    break;
                case 'c':
                    System.out.println("......................");
                    System.out.println("Legg inn mengden for uttak :");
                    System.out.println("......................");
                    double mengde=sc.nextDouble();
                    uttak(mengde);
                    System.out.println("\n");
                    break;
                case 'd':
                    System.out.println("......................");
                    System.out.println("Forrige transaksjon :");
                    hentForTrans();
                    System.out.println("......................");
                    System.out.println("\n");
                    break;

                case 'e':
                    System.out.println("......................");
                    break;
                default:
                    System.out.println("Velg et gyldig alternativ.");
                    break;
            }

        }while(option!='e');

        System.out.println("Tusen takk for at du bruker vår bank tjenester.");
    }
}


