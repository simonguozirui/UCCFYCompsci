
import java.util.Scanner;
public class Judge{
    public static void main (String[] args){
        Scanner myscan = new Scanner(System.in);
        System.out.println("Start Judging for NxtHacks");
        Array[] questions = new Array["Social Impact: How helpful is it to the general population?","Creative Component: How creative is the idea","Scalability: How feasible is this project for the future","Theme: Think Global: How accessible is this Hack;","Pitch:How effective and convinncing was the pitch"];
        int score = 0;
        int[] input = new int[myscan.nextInt()];
        for (int i = 0; i < questions.length; i ++){
            System.out.println(questions[i]+"from a scale 1 to 10");
            input[i] = myscan.nextInt();
        }
        System.out.println("The Final Score is: "+ score);
        if (socre == 10*questions.length System.out.println("This hack is amazing");
   }


}
