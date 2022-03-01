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
        while (playerIsAlive == true && monsterIsAlive == true) {

            // EVENT 1

            turn = turnCount(turn);

            monsterHealth = lightAttack(playerName, monsterName, playerStamina, monsterHealth, playerDamage);
            monsterIsAlive = checkHealth(monsterHealth, monsterName);
            if (monsterIsAlive == false) {
                break;
            }

            System.out.println("================================================");

            // EVENT 2

            turn = turnCount(turn);

            playerHealth = heavyAttack(monsterName, playerName, monsterStamina, playerHealth, monsterDamage);
            playerIsAlive = checkHealth(playerHealth, playerName);
            if (playerIsAlive == false) {
                break;
            }

            System.out.println("================================================");

            // EVENT 3

            turn = turnCount(turn);
            System.out.println(playerName + " your turn!");
            System.out.println(playerName + " tries to defend!");


            playerHealth += playerDefense;

            System.out.println("================================================");

            // EVENT 4

            turn = turnCount(turn);

            playerHealth = lightAttack(monsterName, playerName, monsterStamina, playerHealth, monsterDamage);
            playerIsAlive = checkHealth(playerHealth, playerName);
            if (playerIsAlive == false) {
                break;
            }

            System.out.println("================================================");

        }
    }

    // <====================================== GAME FUNCTIONS ================================================>

    // playerName,          monsterName,      playerStamina,       monsterHealth,      playerDamage
    public static int lightAttack(String attackerName, String defenderName, int attackerStamina, int defenderHealth, int attackerDamage) {
        System.out.println(attackerName + " your turn!");
        System.out.println(attackerName + " tries to light attack " + defenderName);

        attackerStamina -= 2;
        defenderHealth -= attackerDamage;

        System.out.println(defenderName + " lost " + attackerDamage + " health points!");
        System.out.println(defenderName + " now has " + defenderHealth + " health points!");

        return defenderHealth;
    }

    public static int heavyAttack(String attackerName, String defenderName, int attackerStamina, int defenderHealth, int attackerDamage) {
        System.out.println(attackerName + " your turn!");
        System.out.println(attackerName + " tries to heavy attack " + defenderName);

        attackerStamina -= 4;
        defenderHealth -= attackerDamage * 2;

        System.out.println(defenderName + " lost " + attackerDamage * 2 + " health points!");
        System.out.println(defenderName + " now has " + defenderHealth + " health points!");

        return defenderHealth;
    }

    public static int turnCount(int turn) {
        turn += 1;
        System.out.println("Turn: " + turn);
        return turn;
    }

    public static boolean checkHealth(int health, String name) {
        if (health <= 0) {
            System.out.println(name + " is dead!");
            return false;
        } else {
            return true;
        }
    }
}
