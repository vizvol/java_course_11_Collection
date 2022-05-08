import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        String result;
        boolean singExit = false;
        boolean signRepeatMenu = false;
        boolean signRepeatOper;
        int choiceMenu;
        int choiceOperation;
        String numText;
        String operation;
        String Expression;
        int a = 0;
        int b = 0;
        String answer;
        int res = 0;
        boolean isInt = false;
        // поля для заполнения класса
        String name;
        int age = 0;
        String group;
        Subject subject;

        TreeSet<Student> studentSet = new TreeSet<>();

        // строим меню пока не будет выбран пункт "5. Выйти из программы"
        while (!singExit){
            mainMenu();
            numText = (new Scanner(System.in)).nextLine() ;
            // распознование числа
            if (!isNumber(numText)) {
                System.out.println("Не удалось распознать операцию! Повторите выбор:");
                continue;
            }
            choiceMenu = Integer.parseInt(numText);
            // 1. Ввести ученика

            if (choiceMenu == 1) {
                System.out.print("Введите ФИО ученика: ");
                Expression = (new Scanner(System.in)).nextLine();
                name = Expression;
                isInt = false;
                while (!isInt) {
                    System.out.print("Введите возраст ученика: ");
                    Expression = (new Scanner(System.in)).nextLine();
                    // распознование числа
                    if (!isNumber(Expression)) {
                        System.out.println("Не удалось распознать возраст ученика! Повторите ввод:");
                        continue;
                    }
                    age = Integer.parseInt(Expression);
                    isInt = true;
                }

                System.out.print("Введите класс ученика: ");
                Expression = (new Scanner(System.in)).nextLine();
                group = Expression;

                isInt = false;
                while (!isInt) {
                    System.out.println("Выберите любимый предмет ученика: ");
                    for (Subject s : Subject.values())
                        System.out.println(s.ordinal() + 1  + ". " + s);

                    Expression = (new Scanner(System.in)).nextLine();
                    String message = "Не удалось распознать любимый предмет ученика! Повторите выбор:";
                    if (!isNumber(Expression)) {
                        System.out.println(message);
                        continue;
                    }
                    int intSubject = Integer.parseInt(Expression) - 1;
                    if (intSubject < 0 || intSubject >= Subject.values().length ) {
                        System.out.println(message);
                        continue;
                    }
                    subject = Subject.values()[intSubject];
                    //System.out.println(subject);
                    isInt = true;
                    Student student = new Student(name, age, group, subject);
                    if ( studentSet.contains(student) )
                        System.out.println("Ученик уже есть в базе!");
                    else {
                        studentSet.add(student);
                        System.out.println("Ученик добавлен!");
                    }
                    continue;
                }

                System.out.println( );

            }
            // 2. Вывести всех студентов по возрастанию
            else if (choiceMenu == 2) {
                for (Student student : studentSet) {
                    System.out.println(student);
                }
            }
            // 3. Вывести всех студентов по убыванию
            else if (choiceMenu == 3) {
                for (Student student : studentSet.descendingSet()) {
                    System.out.println(student);
                }
            }
            // 4. Удалить ученика по индексу
            else if (choiceMenu == 4) {
                System.out.println("Введите номер ученика из списка для удаления: ");
                int i = 1;
                for (Student student : studentSet) {
                    System.out.println( i + " " + student);
                    i++;
                }
                Expression = (new Scanner(System.in)).nextLine();
                // распознование числа
                if (!isNumber(Expression)) {
                    System.out.println("Не удалось распознать номер ученика!");
                    continue;
                }
                int j = Integer.parseInt(Expression);
                i = 1;
                for (Student student : studentSet) {
                    if ( i == j ) {
                        studentSet.remove(student);
                        break;
                    }
                    i++;
                }

            }

            // 5. Выйти из программы
            else if ( choiceMenu == 5 ) {
                System.out.println("До свидания!");
                singExit = true;
            }
            //
            else {
                System.out.println("Введите номер пункта меню из предложенных вариантов!");
                continue;
            }

        }


    }
    // метод построения меню первого уровня
    public static void mainMenu() {
        System.out.println( "1. Ввести ученика" + "\n" +
                            "2. Вывести всех учеников по возрастанию" + "\n" +
                            "3. Вывести всех учеников по убыванию" + "\n" +
                            "4. Удалить ученика по индексу" + "\n" +
                            "5. Выйти из программы" + "\n"
                          );
    }
    // метод распознавания числа из строки
    public static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    }

