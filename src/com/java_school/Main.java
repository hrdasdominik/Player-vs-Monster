package com.java_school;

public class Main {

    public static void main(String[] args) {
        /*
            Player to smo mi,
            Monster to je comp,
            Radnje je combat,
            Igrica traje dok netko nije porazen.
        */

        // PLAYER
        String playerName;
        int playerHealth;
        int playerMana;
        int playerDefense;
        int playerDamage;
        int playerSpeed;
        int playerStamina;
        boolean playerIsAlive;

        // MONSTER
        String monsterName;
        int monsterHealth;
        int monsterDefense;
        int monsterDamage;
        int monsterSpeed;
        int monsterStamina;
        boolean monsterIsAlive;

        /*
            Light-attack, heavy-attack, defense, counter-attack, dodge, run-away, stamina-potion, wait
        */

        // STATS FOR PLAYER
        playerName = "Tvrtko";
        playerHealth = 10;
        playerMana = 5;
        playerDefense = 2;
        playerDamage = 2; // Light attack
        playerSpeed = 3;
        playerStamina = 10;
        playerIsAlive = true;

        // STATS FOR MONSTER
        monsterName = "Jozha";
        monsterHealth = 10;
        monsterDefense = 1;
        monsterDamage = 2; // Light attack
        monsterSpeed = 4;
        monsterStamina = 12;
        monsterIsAlive = true;

        // STATS FOR GAME FUNCTIONS
        int turn = 0;

        System.out.println("FIGHT!");

        // Svaki novi turn, turn se mora povecati za 1
        while(playerIsAlive == true && monsterIsAlive == true) {

            // EVENT 1

            turn += 1;
            System.out.println("Turn: " + turn);

            lightAttack(playerName, monsterName, playerStamina, monsterHealth, playerDamage);

            System.out.println("================================================");

            // EVENT 2

            turn += 1;
            System.out.println("Turn: " + turn);

            heavyAttack(monsterName, playerName, monsterStamina, playerHealth, monsterDamage);

            System.out.println("================================================");

            // EVENT 3

            turn += 1;
            System.out.println("Turn: " + turn);
            System.out.println(playerName + " your turn!");
            System.out.println(playerName + " tries to defend!");

            playerHealth += playerDefense;

            System.out.println("================================================");

            // EVENT 4

            turn += 1;
            System.out.println("Turn: " + turn);

            lightAttack(monsterName, playerName, monsterStamina, playerHealth, monsterDamage);

            System.out.println("================================================");

            if(playerHealth <= 0) {
                playerIsAlive = false;
                System.out.println(playerName + " is dead!");
            }

            else if(monsterHealth <= 0) {
                monsterIsAlive = false;
                System.out.println(monsterName + " is dead!");
                System.out.println(monsterName + " will be back!");
            }
        }
    }

    // <====================================== GAME FUNCTIONS ================================================>

                                        // playerName,          monsterName,      playerStamina,       monsterHealth,      playerDamage
    public static void lightAttack(String attackerName, String defenderName, int attackerStamina, int defenderHealth, int attackerDamage) {
        System.out.println(attackerName + " your turn!");
        System.out.println(attackerName + " tries to light attack " + defenderName);

        attackerStamina -= 2;
        defenderHealth -= attackerDamage;

        System.out.println(defenderName + " lost " + attackerDamage + " health points!");
        System.out.println(defenderName + " now has " + defenderHealth + " health points!");
    }

    public static void heavyAttack(String attackerName, String defenderName, int attackerStamina, int defenderHealth, int attackerDamage) {
        System.out.println(attackerName + " your turn!");
        System.out.println(attackerName + " tries to heavy attack " + defenderName);

        attackerStamina -= 4;
        defenderHealth -= attackerDamage * 2;

        System.out.println(defenderName + " lost " + attackerDamage*2 + " health points!");
        System.out.println(defenderName + " now has " + defenderHealth + " health points!");
    }
}
