package utils.constant;
import java.util.Scanner;

/*
 *********************************************************************************************************
 *  @Java Class Name :   Const
 *  @Author          :   <Saurabh Rai>(saurabh.rai@antrazal.com)
 *  @Company         :   Antrazal
 *  @Date            :   04-07-2024
 *  @Description     :   This class holds all the constants.
 *********************************************************************************************************
 */

public class Const {

    // SCANNER
    public static final Scanner SCANNER = new Scanner(System.in);

    public static final String WELCOME = "Welcome to the Zoo";

    public static final String GO_BACK = "<- Go Back";

    // ANIMAL OPTIONS
    public static final String[] MAIN_OPTIONS_LIST = {"Login Existing Zoo", "Create New Zoo", "<- Exit"};
    public static final String[] ZOO_OPTIONS_LIST = {"Add New Animal", "Create New Zone", "Remove Dead Animal", "View All Animals", "View Zone Details", "Zoo Details", "<- Logout"};
    public static final String[][] ANIMALS_LIST = {
            {"Lion", "Mammal", "roar...", "2"},
            {"Elephant", "Mammal", "trumpet...", "4"},
            {"Kangaroo", "Mammal", "grunt...", "10"},
            {"Crocodile", "Reptile", "hiss...", "10"},
            {"Lizard", "Reptile", "chirp...", "10"},
            {"Snake", "Reptile", "hiss...", "10"},
            {"Eagle", "Bird", "screech...", "25"},
            {"Parrot", "Bird", "squawk...", "50"},
            {"Owl", "Bird", "hoot...", "30"},
            {"Salmon", "Fish", "splash...", "50"},
            {"Shark", "Fish", "silent...", "10"},
            {"Goldfish", "Fish", "bubble...", "100"}
    };

    // MESSAGES
    public static final String[] MAIN_MESSAGES = {
            "Enter the name of the zoo: ",  // 0
            "Invalid input. Please enter a valid name (5-30 characters): ", // 1
            "Enter the location of the zoo: ",  // 2
            "Invalid input. Please enter a valid location: ", // 3
            "Enter the name of the zoo owner: ", // 4
            "Invalid input. Please enter a valid name (5-30 characters): ", // 5
            "Enter the username: ", // 6
            "Invalid input. Please enter a valid username (6 characters, letters and numbers only): ", // 7
            "Enter the password: ", // 8
            "Invalid input. Please enter a valid password (8+ characters, 1 uppercase, 1 lowercase, 1 special character): ", // 9
            "Enter the number of zones you want to create: ", // 10
            "Invalid input. Please enter a valid number of zones: ",  // 11
            "Invalid input, You have %d attempts left.\n", // 12
            "Choose an option: ", // 13
            "Invalid option, try again!", // 14
            "Choose valid option: "  // 15
    };

    // ZOO MESSAGES
    public static final String[] ZOO_MESSAGES = {
            "Select animal: ",                                           // 0
            "Enter animal's age: ",                                      // 1
            "Invalid input. Please enter a valid age (1-100): ",        // 2
            "Enter animal's weight: ",                                   // 3
            "Invalid input. Please enter a valid weight (1-1001): ",    // 4
            "Does the zone have a park? (Y/N): ",                      // 5
            "Invalid input. Please enter Y or N: ",                     // 6
            "Does the zone have a canteen? (Y/N): ",                   // 7
            "Enter animal's ID: ",                                       // 8
            "Invalid input. Please enter a valid animal ID (1-999999): ", // 9
            "Select zone category (1-4): ",                             // 10
            "Invalid input. Please enter a valid integer between 1 and 4: ", // 11
    };


    public static final String ERR = "Error : ";
    public static final String NO_ANIMALS_MESSAGE = "There are no animals in the zoo.";
    public static final String EXIT_SUCCESS_MESSAGE = "Successfully exited the zoo!";
    public static final String NO_ZONES_MESSAGE = "There are no zones in the zoo.";

    // ANIMAL QRY
    public static final String FIND_ZONE_BY_ZOO_AND_CATEGORY = "SELECT zone_id FROM zones WHERE zoo_id = ? AND animal_category = ?";
    public static final String FIND_AVAILABLE_CAGE_FOR_ANIMAL = "SELECT cage_id, animal_type FROM cages WHERE zone_id = ? AND (animal_type = ? OR animal_type IS null) AND (max_capacity - current_animal_count) > 0 ORDER BY (max_capacity - current_animal_count) ASC LIMIT 1";
    public static final String UPDATE_CAGE_ANIMAL_TYPE_AND_CAPACITY = "UPDATE cages SET animal_type = ?, max_capacity = ? WHERE cage_id = ?";
    public static final String FIND_ZONE_WITH_AVAILABLE_CAGE_SLOTS = "SELECT zone_id FROM zones WHERE zoo_id = ? AND animal_category = ? AND (max_cages - current_cage_count) > 0 ORDER BY (max_cages - current_cage_count) ASC LIMIT 1";
    public static final String INSERT_NEW_CAGE = "INSERT INTO cages (zone_id, animal_type, max_capacity) VALUES (?, ?, ?)";
    public static final String FIND_NEWLY_CREATED_CAGE = "SELECT cage_id FROM cages WHERE zone_id = ? AND animal_type = ? AND current_animal_count = 0";
    public static final String INCREMENT_CAGE_COUNT_IN_ZONE = "UPDATE zones SET current_cage_count = current_cage_count + 1 WHERE zone_id = ?";
    public static final String INCREMENT_ANIMAL_COUNT_IN_CAGE = "UPDATE cages SET current_animal_count = current_animal_count + 1 WHERE cage_id = ?";
    public static final String INSERT_ANIMAL_IN_CAGE = "INSERT INTO animals (cage_id, animal_name, age, weight) VALUES (?, ?, ?, ?)";
    public static final String FIND_ALL_ALIVE_ANIMALS_BY_ZOO = "SELECT a.animal_id, a.animal_name, c.cage_id, z.zone_id FROM animals a INNER JOIN cages c ON a.cage_id = c.cage_id INNER JOIN zones z ON c.zone_id = z.zone_id WHERE z.zoo_id = ? AND a.isAlive = true;";
    public static final String MARK_ANIMAL_AS_DEAD = "UPDATE animals SET isAlive = 0 WHERE animal_id = ?";
    public static final String FIND_CAGE_BY_ANIMAL_ID = "SELECT cage_id FROM animals WHERE animal_id = ?";
    public static final String DECREMENT_ANIMAL_COUNT_IN_CAGE = "UPDATE cages SET current_animal_count = current_animal_count - 1 WHERE cage_id = ?";
    public static final String RESET_EMPTY_CAGE_TYPE_AND_CAPACITY = "UPDATE cages SET animal_type = null, max_capacity = 100 WHERE cage_id = ? AND current_animal_count = 0";
    public static final String INSERT_OWNER = "INSERT INTO owner(zoo_id, owner_name) VALUES (?, ?)";
    public static final String UPDATE_CAGE_ANIMAL_COUNT = "UPDATE cages SET current_animal_count = current_animal_count + 1 WHERE cage_id = ?";

    // ANIMAL STATEMENTS
    public static final String SUCCESS_ANIMAL_ADDED = "Animal added to the zoo.";
    public static final String ERROR_NO_ZONE_AVAILABLE = "There is no available space to add this animal to the zoo.";
    public static final String SUCCESS_ANIMAL_REMOVED = "Animal removed successfully.";


    // ZONE QRY
    public static final String FIND_MAX_ZONES_BY_ZOO_ID = "SELECT max_zones FROM zoo WHERE zoo_id = ?";
    public static final String COUNT_ZONES_BY_ZOO_ID = "SELECT COUNT(zone_id) AS zone_count FROM zones WHERE zoo_id = ?";
    public static final String INSERT_NEW_ZONE = "INSERT INTO zones (zoo_id, animal_category, has_park, has_canteen) VALUES (?, ?, ?, ?)";
    public static final String FIND_ALL_ZONES_BY_ZOO_ID = "SELECT zone_id, animal_category FROM zones WHERE zoo_id = ?";

    // ZONE STATEMENTS
    public static final String ERROR_INSUFFICIENT_SPACE_FOR_ZONE = "There is not enough space to create a new zone.";
    public static final String SUCCESS_ZONE_CREATED = "New zone created successfully.";

    // ZONE QRY
    public static final String FIND_ZOO_BY_USERNAME = "SELECT * FROM zoo WHERE username = ?";
    public static final String INSERT_NEW_ZOO = "INSERT INTO zoo(zoo_name, zoo_location, username, password, max_zones) VALUES (?, ?, ?, ?, ?)";
    public static final String INSERT_ZOO_OWNER = "INSERT INTO owner(zoo_id, owner_name) VALUES (?, ?)";
    public static final String AUTHENTICATE_USER = "SELECT * FROM zoo WHERE username = ? AND password = ? COLLATE utf8mb4_bin";
    public static final String FIND_ZOO_ID_BY_USERNAME = "SELECT zoo_id FROM zoo WHERE username = ?";
    public static final String FIND_ZOO_DETAILS_WITH_OWNER = "SELECT z.zoo_id, z.zoo_name, z.zoo_location, o.owner_name FROM zoo z JOIN owner o ON z.zoo_id = o.zoo_id WHERE z.zoo_id = ?";
    public static final String SELECT_ZONE_DETAILS_WITH_ANIMAL_COUNT = "SELECT z.zone_id, z.animal_category, z.current_cage_count, z.has_park, z.has_canteen, SUM(c.current_animal_count) as animal_count FROM zones z JOIN cages c ON z.zone_id = c.zone_id WHERE z.zone_id = ?;";
    public static final String GET_CURRENT_CAGE_COUNT = "SELECT current_cage_count FROM zones WHERE zone_id = ?";
    public static final String GET_ZONE_DETAILS_WITH_EMPTY_ANIMAL_COUNT = "SELECT zone_id, animal_category, current_cage_count, has_park, has_canteen, 0 as animal_count FROM zones WHERE zone_id = ?";
    public static final String GET_MAX_ZONE_CNT = "SELECT max_zones from zoo where zoo_id = ?";
    public static final String REMAINING_ZONES_ROW_FORMAT = "| Remaining Zones : %-20d |\n";



    // ZONE STATEMENTS
    public static final String ERROR_USERNAME_ALREADY_TAKEN = "Username is already taken, please choose another one.";
    public static final String SUCCESS_ZOO_CREATED = "Welcome to the zoo! You have successfully created a new zoo.";
    public static final String SUCCESS_LOGIN = "Login successful. Welcome to the zoo!";
    public static final String ERROR_LOGIN_FAILED = "Login failed. Please check your username and password.";
    public static final String ERROR_USERNAME_NOT_FOUND = "No zoo found with username: ";


    // table printing
    public static final String HEADER_NO_OPTION = "| No.   | Option                         |";
    public static final String HEADER_ID_ANIMAL = "| ID    | Animal Name                    |";
    public static final String HEADER_NO_NAME = "| No.   | Name                           |";
    public static final String HEADER_ID_ZONE = "| ID    | Zone Category                  |";

    public static final String ROW_FORMAT = "| %-5d | %-30s |\n";
    public static final String TABLE_BORDER = "+-------+--------------------------------+";

    public static final String PROMPT_ENTER_ZONE_ID = "Enter zone ID: ";
    public static final String ERROR_INVALID_ZONE_ID = "Invalid input! Please enter a valid zone ID: ";


    // ZOO DETAILS
    public static final String ZOO_INFO_BORDER = "+----------------+---------------------------+";
    public static final String ZOO_ID_ROW = "| Zoo ID         | %-25d |\n";
    public static final String ZOO_NAME_ROW = "| Name           | %-25s |\n";
    public static final String ZOO_LOCATION_ROW = "| Location       | %-25s |\n";
    public static final String ZOO_OWNER_ROW = "| Owner Name     | %-25s |\n";
    public static final String ZOO_ZONE_CNT = "| Zone Count     | %-25s |\n";
    public static final String ZOO_ANIMALS_CNT = "| Animals Count  | %-25s |\n";


    // ZONE DETAILS

    public static final String ZONE_INFO_BORDER = "+------------------+---------------------------+";
    public static final String ZONE_ID_ROW = "| Zone ID          | %-25s |\n";
    public static final String ANIMAL_CATEGORY_ROW = "| Animal Category  | %-25s |\n";
    public static final String TOTAL_CAGES_ROW = "| Total Cages      | %-25s |\n";
    public static final String TOTAL_ANIMALS_ROW = "| Total Animals    | %-25s |\n";
    public static final String HAS_PARK_ROW = "| Has Park         | %-25s |\n";
    public static final String HAS_CANTEEN_ROW = "| Has Canteen      | %-25s |\n";


    //
    public static final String Y = "Yes";
    public static final String N = "No";
}
