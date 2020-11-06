package bstorm.akim.SpringJPA.presentation;

import bstorm.akim.SpringJPA.exception.NoElementFoundException;
import bstorm.akim.SpringJPA.metier.dto.GradeDTO;
import bstorm.akim.SpringJPA.metier.service.GetterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

@Component
public class InterfaceConsoleImpl implements InterfaceConsole {

    @Autowired
    private GetterService<GradeDTO, String> service;

//    public InterfaceConsoleImpl(GetterService<GradeDTO, String> service) {
//        this.service = service;
//    }

    // region fonctionnalités

    private void afficherMenu(){
        System.out.println("MENU : " +
                "\n\t1 - afficher les grades" +
                "\n\t2 - afficher un grade" +
                "\n\t3 - quitter");
    }
    private int getChoix(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Quel est votre choix?");

        try{
            return sc.nextInt();
        }
        catch (InputMismatchException e){
            return -1;
        }

    }
    private void mapAction(int choix){
        switch (choix){
            case 1://- afficher les grades
                afficherGrades();
                break;
            case 2://- afficher un grade
                afficherUnGrade();
                break;
            case 3://- quitter
                quitter();
                break;
            case -1://- entrée invalide (non int)
                System.out.println("Veuillez entrer un int.");
                break;
            default://- entrée invalide (pas de lien avec action)
                System.out.println("PAs d'action liée");

        }
    }

    // region actions

    private void afficherGrades(){
        service.getAll().forEach(System.out::println);
    }
    private void afficherUnGrade(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Quel grade voulez vous consulter ?");
        try{
            System.out.println( service.getOne(scanner.next()) );
        }
        catch (NoElementFoundException e){
            System.out.println("L'élément n'existe pas");
        }

    }
    private void quitter(){
        System.out.println("Merci pour l'utilisation, bon week end.");
    }

    // endregion

    // endregion

    @Override
    public void start() {

        int choix = -1;
        do{
            afficherMenu();
            choix = getChoix();
            mapAction(choix);
        } while(choix != 3);

    }

    @Override
    public void afterPropertiesSet() throws Exception {
        start();
    }
}
