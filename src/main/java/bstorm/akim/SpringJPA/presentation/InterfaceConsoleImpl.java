package bstorm.akim.SpringJPA.presentation;

public class InterfaceConsoleImpl implements InterfaceConsole {


    @Override
    public void start() {
        // de facon répétée:
        // - afficher le menu
        // - recupérer le choix
        // - lier le choix à une action


        // Les actions :
        // - afficher les grades
        // - afficher un grade
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        start();
    }
}
