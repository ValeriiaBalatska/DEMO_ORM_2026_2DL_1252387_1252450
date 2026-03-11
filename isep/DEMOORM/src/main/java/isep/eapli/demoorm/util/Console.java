/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isep.eapli.demoorm.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author mcn
 */
public class Console {

    private static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static String readLine(String prompt) {
        try {
            System.out.print(prompt);
            return in.readLine();
        } catch (IOException ex) {
            System.out.println("  Error reading input. Please try again.");
            return "";
        }
    }

    public static int readInteger(String prompt) {
        do {
            try {
                String strInt = readLine(prompt);
                if (strInt == null || strInt.trim().isEmpty()) {
                    System.out.println("  Please enter a valid number.");
                    continue;
                }
                return Integer.parseInt(strInt.trim());
            } catch (NumberFormatException ex) {
                System.out.println("  Invalid input. Please enter a number.");
            }
        } while (true);
    }

    public static boolean readBoolean(String prompt) {
        do {
            String strBool = readLine(prompt);
            if (strBool == null || strBool.trim().isEmpty()) {
                System.out.println("  Please enter 'y' or 'n'.");
                continue;
            }
            strBool = strBool.trim().toLowerCase();
            if (strBool.equals("y") || strBool.equals("s") || strBool.equals("yes")) {
                return true;
            } else if (strBool.equals("n") || strBool.equals("no")) {
                return false;
            }
            System.out.println("  Please enter 'y' or 'n'.");
        } while (true);
    }

    public static int readOption(int low, int high, int exit) {
        int option;
        do {
            option = Console.readInteger("Choose option: ");
            if (option == exit) {
                break;
            }
            if (option < low || option > high) {
                System.out.println("  Please choose between " + low + " and " + high + " (or " + exit + " to exit).");
            }
        } while (option < low || option > high);
        return option;
    }

    public static Date readDate(String prompt) {
        do {
            try {
                String strDate = readLine(prompt);
                if (strDate == null || strDate.trim().isEmpty()) {
                    System.out.println("  Please enter a date (dd-MM-yyyy).");
                    continue;
                }
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                df.setLenient(false);
                return df.parse(strDate.trim());
            } catch (ParseException ex) {
                System.out.println("  Invalid date format. Please use dd-MM-yyyy.");
            }
        } while (true);
    }

    public static Calendar readCalendar(String prompt) {
        do {
            try {
                String strDate = readLine(prompt);
                if (strDate == null || strDate.trim().isEmpty()) {
                    System.out.println("  Please enter a date (dd-MM-yyyy).");
                    continue;
                }
                SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
                df.setLenient(false);
                return DateTime.dateToCalendar(df.parse(strDate.trim()));
            } catch (ParseException ex) {
                System.out.println("  Invalid date format. Please use dd-MM-yyyy.");
            }
        } while (true);
    }

    public static double readDouble(String prompt) {
        do {
            try {
                String input = readLine(prompt);
                if (input == null || input.trim().isEmpty()) {
                    System.out.println("  Please enter a valid number.");
                    continue;
                }
                return Double.parseDouble(input.trim());
            } catch (NumberFormatException ex) {
                System.out.println("  Invalid input. Please enter a number.");
            }
        } while (true);
    }

    public static void waitForKey(String prompt) {
        System.out.println(prompt);
        try {
            in.readLine();
        } catch (IOException ex) {
            // silently continue
        }
    }

    private Console() {
        // to make sure this is an utility class
    }
}
