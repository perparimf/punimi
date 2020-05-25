import javax.swing.*;
import java.util.Random;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
public class SimpleBankingApplication {
  long accountNumber;            
    long accountNumberGenerator=0000;   
    String AccountHolderName;     
    
    String AccountType;           
    int AccTypeNumVal;
    long accountBalance;          
    String password;               
   
    public void createAccount() 
    {
        Random rand = new Random();

        String a1 =  JOptionPane.showInputDialog("  Miresevini ne EBanking\nShkruani emrin tuaj");

        accountNumber=rand.nextInt(1000); 

        AccountHolderName=a1;
        String a2 = JOptionPane.showInputDialog("Shkruani fjalekalimin tuaj : ");
        password=a2;
        String a3 =  JOptionPane.showInputDialog("Zgjedhni tipinin e llogarise Savings/Current");
        AccountType=a3;



        String a4 =  JOptionPane.showInputDialog("Shtypni balancin fillestare: ");
        accountBalance=Integer.parseInt(a4);
        if(accountBalance<0){
            JOptionPane.showMessageDialog(null,"Balanci i llogarise duhet te jete minimum 0");
            System.exit(0);
        }

        JOptionPane.showMessageDialog(null,"Llogaria juaj u krijua me sukses.\nNumri i llogarise tuaj eshte"+accountNumber+" Ju lutem mbajeni mend.");

       
    }

    public void DisplayAccount() 
    {
        JOptionPane.showMessageDialog(null,"Te dhenat personale per llogarine\nNumri i llogarise "+accountNumber+"-- \nEmri i llogarise"+AccountHolderName
                +" \nTipi i llogarise"+AccountType+" \n Balanci i llogarise"+accountBalance+"\n Fjalekalimi: --");

      
        
    }

    public void DepositAmount()
    {
              long depositAmt;
        String b1 = JOptionPane.showInputDialog("Miresevini te portali i depozitit\n Ju po depozitoni per llogarine" +accountNumber+
                " \n Shtypni shumen qe deshironi ta depozitoni ");

        depositAmt=Integer.parseInt(b1);
        accountBalance=accountBalance+depositAmt;
       JOptionPane.showMessageDialog(null,"Shuma u depozitua me sukses.. \n Balanci juaj i ri eshte: "+accountBalance);

    }


    public void WithdrawAmount() 
    {

        long withdrawAmt;
        String c1 = JOptionPane.showInputDialog("Miresevini te portali i terheqjes\n Ju po terhiqni per llogarine" +accountNumber+
                " \n Shtypni shumen qe deshironi ta terhiqni");

        withdrawAmt=Integer.parseInt(c1);
        accountBalance=accountBalance-withdrawAmt;
        JOptionPane.showMessageDialog(null,"Shuma u terhoq me sukses.. \n Balanci juaj i ri eshte: "+accountBalance);

    }

    public void login() 
    {
        int ch=0;
       
        long accNum=0;
        String passWd="0";
        String c = JOptionPane.showInputDialog("Shtypni numrin e llogarise tuaj");

        accNum=(long)(Integer.parseInt(c));
        String c1 = JOptionPane.showInputDialog("Shtypni fjalekalimin tuaj");
        passWd= c1;
        if (accNum==this.accountNumber && passWd.equals(passWd)) {
            String c2 =JOptionPane.showInputDialog("Ju u kyqet me sukses me numrin e llogarise"+accountNumber+"\n Zgjedhni opsionin e meposhtem"+
                    "\n 1.Depozitoni shumen"+"\n 2.Terhiqni shumen"+"\n 3.Shfaqni informacionet per llogarine" +"\n 4. Mbyllni llogarine"+"\n 5. Exit");

            ch=Integer.parseInt(c2);
            switch(ch)
            {
                case 1: DepositAmount();
                    break;
                case 2: WithdrawAmount();
                    break;
                case 3: DisplayAccount();
                    break;
                case 4: JOptionPane.showMessageDialog(null,"You cannot close your account. Feature Coming Soon...");
                    break;
                case 5: System.exit(0);
                    break;
            }
        }
        else if(accNum!=accountNumber && passWd!=password) {
            JOptionPane.showMessageDialog(null,"Ju keni shtypur gabimisht numrin e llogarise ose fjalekalimin. Ju lutem kontrolloni perseri.");
            
            System.exit(0);
        }
        else{
            JOptionPane.showMessageDialog(null,"Unknown Error Occured. Try Agian Later");
        
            System.exit(0);
        }
    }


    SimpleBankingApplication()
    {
        accountNumber=0000;
        AccountHolderName="UNDEFINED";
        AccountType="UNDEFINED";
        accountBalance=0000;
        accountNumberGenerator=0000;
        AccTypeNumVal=9;
    }

    public static void main(String[] args)  {
     SimpleBankingApplication a1 = new SimpleBankingApplication();
     UIManager um=new UIManager();
 um.put("OptionPane.background",Color.yellow);
 um.put("Panel.background",Color.red);
    ImageIcon icon = new ImageIcon("eb.jpeg");
      JLabel label = new JLabel(icon);
      JPanel panel = new JPanel(new GridBagLayout());
      panel.add(label);
      panel.setOpaque(true);
            
       
        int ch;
        int i=0;
        JOptionPane.showMessageDialog(null,panel,"ebanking",JOptionPane.DEFAULT_OPTION);
        while(i!=5)
        {

            String c3 =JOptionPane.showInputDialog("Zgjedhni opsionet ne vazhdim\n 1.Krijoni llogarine\n 2.Kyquni\n 3. Exit");

            ch=Integer.parseInt(c3);
            switch(ch)
            {
                case 1: a1.createAccount();
                    break;

                case 2: a1.login();
                    break;

                case 3: System.exit(0);
                    break;

            }

        }
    }
}
