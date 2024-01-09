package larionov.menu;

import larionov.menu.entities.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.File;
import java.nio.file.Files;
import java.util.Scanner;

@SpringBootApplication
public class MenuApplication {

    public static void main(String[] args) {
        SpringApplication.run(MenuApplication.class, args);

        System.out.println("*******************************Info*******************************");



/*        int choice;
        do {
            choice = welcome();
        } while (choice != 4);

        System.out.println("Arrivederci!");

}
    public static int welcome () {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MenuApplication.class);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Benvenuto");
        System.out.println("Questo è il nostro menu :D");
        Menu menu = (Menu) ctx.getBean("getMenu");
        System.out.println(menu);
        System.out.println("E' pronto per ordinare?");

        System.out.println("Cosa le porto?");

        System.out.println("4. Esci");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                Pizza napoli = (Pizza) ctx.getBean("napoli");
                scanner.nextLine();
                break;
            case 2:
                System.out.println("xd");
                break;
            case 3:
                System.out.println("*******************************************************");
                break;
            case 4:
                scanner.close();
                break;
            default:
                System.out.println("Scelta non valida. Riprova.");

        }
        ctx.close();
        return choice;
    }*/

}}