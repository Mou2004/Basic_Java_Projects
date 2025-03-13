package ToDoList;

import java.util.ArrayList;
import java.util.Scanner;

public class ToDoListConsole {

        /*
        To-Do List (Console or GUI)
        Skills Covered: Array/ArrayList, loops, user input handling.
        Description:
        Create a simple to-do list application where the user can add, view, and delete tasks.
        In the console version, store tasks in an array or ArrayList and print the tasks in the list. For the GUI version, you can use Swing components like JList and JButton.
         */
        ArrayList<String> list;
        Scanner scanner;
        public ToDoListConsole(){
            this.list=new ArrayList<>();
            this.scanner=new Scanner(System.in);
        }
        public  void addTask(String task){
            list.add(task);
        }
        public void listTasks(){
            if (list.isEmpty()) {
                System.out.println("No tasks available.");
                return;
            }
            for (int i = 0; i < list.size(); i++){
                System.out.println((i + 1) + ". " + list.get(i));

            }
        }

        public void removeTask(int index){
            list.remove(index);
        }
        public void clearAll(){
            list.clear();
        }

        public static void main(String[] args) {
            ToDoList.ToDoListConsole todo = new ToDoList.ToDoListConsole();
            System.out.println("Welcome to To-Dos...");
            Scanner scanner1 = new Scanner(System.in);

            while(true){
                System.out.println("Here you can access the following commands: ");
                System.out.println("1.Add Task\n" +"2.View all tasks\n" +"3.Delete tasks\n"+"4.Exit TodoInterface\n");


                var input = scanner1.nextLine();
                if (input.equals("4")){
                    break;
                }

                switch (input){
                    case "1":
                        System.out.println("Enter Task: ");
                        String task = scanner1.nextLine();
                        todo.addTask(task);
                        break;

                    case "2":
                        System.out.println("Here are all the tasks....");
                        todo.listTasks();
                        break;

                    case "3":
                        System.out.println("Press s to delete a specific task, and a to delete all tasks..");
                        String whichTask = scanner1.nextLine();
                        if (whichTask.equalsIgnoreCase("a")){
                            todo.clearAll();
                            System.out.println("All tasks deleted");
                        }
                        else {
                            System.out.println("Enter the task: ");
                            int indexOfTask = scanner1.nextInt();
                            todo.removeTask(indexOfTask+1);
                            System.out.println("Task removed");
                        }
                        break;
                    default:
                        System.out.println("Invalid input, please enter 1,2,3 or 4");
                }

            }
            scanner1.close();
        }

    }

