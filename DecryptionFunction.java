 // Import the File class
 import java.io.File;

import java.io.FileNotFoundException;

 // Import the Scanner class to read text files
import java.util.Scanner; 

class CaesarCipher {
public static StringBuffer Decrypt(String cipher, int s) 
    { String text = "";

    try {
        File myObj = new File("Keys.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
        text = myReader.nextLine();
        }
        myReader.close();
     } catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
        }
       StringBuffer result= new StringBuffer(); 
  
        for (int i=0; i<cipher.length(); i++) 
        { 
            for (int j = 0; j<text.length(); j++){

            if (cipher.charAt(i) == text.charAt(j)) 
            { 
                int n = j;
                n = n + 65;
                n = n - s - 65;

                if (n < 0){
                    n = 91 + n;
                    char ch2 = (char) n;
                    result.append(ch2);
                }
                else{
                char ch1 = (char)(n % 26 + 65); 
                result.append(ch1);
                }
                break;
            }    
        }  
        }
        return result; 
    }
    public static void main(String[] args) 
    {
        System.out.println(Decrypt("H&NN?S?|N*", 4));
    }    
}