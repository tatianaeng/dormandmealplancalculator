/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package dormandmealplancalculator;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.geometry.Pos;

/**
 *
 * @author tatianaeng
 */

/*
Using constructs from this chapter or earlier, complete either
- Programming Challenges #1, Dorm and Meal Plan Calculator on p906  OR
- Programming Challenges #2, Skateboard Designer on p906-907

State which programming challenge you are submitting.

In addition to your program running correctly, you will be graded on:
- use of comments. Your program needs to be properly commented.
- use of appropriate variable names.
- use of proper formatting of your output
- your GUI layout

Each class should be in a separate file (except for event listeners).

When you are done, find the source file(s) in the project directory, find your java file(s) there and attach them to this assignment.
You also need to include a screenshot of the results. Your screenshot needs to display your name somewhere in the results.

---

A university has the following dormitories:
- Allen Hall: $1,800 per semester
- Pike Hall: $2,200 per semester
- Farthing Hall: $2,800 per semester
- University Suites: $3,000 per semester

The university also offers the following meal plans:
- 7 meals per week: $600 per semester
- 14 meals per week: $1,100 per semester
- Unlimited meals: $1,800 per semester

Create an application with two ComboBox controls. One should hold the names of the dormitories, and the other should hold the meal plans.
The user should select a dormitory and a meal plan, and the application should show the total charges for the semester.
*/
public class DormAndMealPlanCalculator extends Application
{
    
    // variables
    final String allenHall = "Allen Hall: $1,800.00 per semester";
    final String pikeHall = "Pike Hall: $2,200.00 per semester";
    final String farthingHall = "Farthing Hall: $2,800.00 per semester";
    final String universitySuites = "University Suites: $3,000.00 per semester";
    final String sevenMeals = "7 meals per week: $600.00 per semester";
    final String fourteenMeals = "14 meals per week: $1,100.00 per semester";
    final String unlimitedMeals = "Unlimited meals: $1,800.00 per semester";
    final double allenHallPrice = 1800.00;
    final double pikeHallPrice = 2200.00;
    final double farthingHallPrice = 2800.00;
    final double universitySuitesPrice = 3000.00;
    final double sevenMealsPrice = 600.00;
    final double fourteenMealsPrice = 1100.00;
    final double unlimitedMealsPrice = 1800.00;
    double dormCost;
    double mealPlanCost;
    double totalCost;

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args)
    {
        // launch the application
        launch(args);
    }
    
    @Override
    public void start (Stage primaryStage)
    {
        // set the stage title
        primaryStage.setTitle("Yale University - Dorm and Meal Plan Calculator");
        
        // create labels
        Label welcomeLabel1 = new Label("Hi, Tatiana Eng.");
        Label welcomeLabel2 = new Label("Welcome to Yale!  Please select a dorm option and meal plan option from the dropdowns below.");
        Label dormLabel = new Label("Select a dorm:");
        Label mealPlanLabel = new Label("Select a meal plan:");
        Label totalLabel = new Label("Your dorm and meal plan total for the semester will be displayed here.");
        
        // create a ComboBox for the dorm options
        ComboBox<String> dormComboBox = new ComboBox<>();
        dormComboBox.getItems().addAll(allenHall,pikeHall,farthingHall, universitySuites);
        
        // create a ComboBox for the meal plan options
        ComboBox<String> mealPlanComboBox = new ComboBox<>();
        mealPlanComboBox.getItems().addAll(sevenMeals, fourteenMeals, unlimitedMeals);
        
        // create an event handler for when the user selects an item from the dormComboBox
        dormComboBox.setOnAction(event ->
        {
            if (dormComboBox.getValue().equals(allenHall))
                dormCost = allenHallPrice;
            else if (dormComboBox.getValue().equals(pikeHall))
                dormCost = pikeHallPrice;
            else if (dormComboBox.getValue().equals(farthingHall))
                dormCost = farthingHallPrice;
            else if (dormComboBox.getValue().equals(universitySuites))
                dormCost = universitySuitesPrice;
            else
                dormCost = 0.00;
            
            // calculate totalCost
            totalCost = dormCost + mealPlanCost;
        
            // update totalLabel based on the user's selections
            totalLabel.setText(String.format("Your dorm and meal plan total for the semester is $%,.2f", totalCost));
        });
        
        // create an event handler for when the user selects an item from the mealPlanComboBox
        mealPlanComboBox.setOnAction(event ->
        {
            if (mealPlanComboBox.getValue().equals(sevenMeals))
                mealPlanCost = sevenMealsPrice;
            else if (mealPlanComboBox.getValue().equals(fourteenMeals))
                mealPlanCost = fourteenMealsPrice;
            else if (mealPlanComboBox.getValue().equals(unlimitedMeals))
                mealPlanCost = unlimitedMealsPrice;
            else
                mealPlanCost = 0.00;
            
            // calculate totalCost
            totalCost = dormCost + mealPlanCost;
        
            // update totalLabel based on the user's selections
            totalLabel.setText(String.format("Your dorm and meal plan total for the semester is $%,.2f", totalCost));
        });
        
        // create an hbox for the dormLabel and mealPlanLabel
        HBox hbox1 = new HBox(83, dormLabel, mealPlanLabel);
        hbox1.setAlignment(Pos.CENTER);
        
        // create an hbox for the 2 comboboxes and center them
        HBox hbox2 = new HBox(35,dormComboBox, mealPlanComboBox);
        hbox2.setAlignment(Pos.CENTER);
        
        // add everything to a vbox and center everything
        VBox vbox = new VBox(20, welcomeLabel1, welcomeLabel2, hbox1, hbox2, totalLabel);
        vbox.setAlignment(Pos.CENTER);
        
        // create a scene
        Scene scene = new Scene(vbox, 750, 400);
        
        // add the scene to the stage
        primaryStage.setScene(scene);
        
        // show the stage
        primaryStage.show();
    }
    
}
