import java.util.ArrayList;
import java.util.HashMap;

public class ExpensesManager {
    //ArrayList<Double> expenses; // Замените на таблицу с именем expensesByCategories
    HashMap<String, ArrayList<Double>> expensesByCategories;
    ArrayList<Double> expenses;

    ExpensesManager() {
        expensesByCategories = new HashMap<>(); // Создайте таблицу

    }
    // Добавьте в метод ещё один параметр — category

    double saveExpense(double moneyBeforeSalary, String category, double expense) {
        moneyBeforeSalary = moneyBeforeSalary - expense;
        System.out.println("Значение сохранено! Ваш текущий баланс в рублях: " + moneyBeforeSalary);
        // Замените на работу с таблицей
        if (expensesByCategories.containsKey(category)) { // Проверьте наличие категории
            System.out.println(expensesByCategories.get(category)); // Получите список трат в этой категории
            expensesByCategories.put(category, expenses.add(expense));// Добавьте трату
            /*for (Double exp : expensesByCategories.get(category)){
                exp.add(expense);
            }*/
        } else {
            expenses = new ArrayList<>(); // Создайте новый список трат и добавьте в него сумму
            expenses.add(expense);
            expensesByCategories.put(category, expenses);// Сохраните категорию и новый список трат в хеш-таблицу
        }
        if (moneyBeforeSalary < 1000) {
            System.out.println("На вашем счету осталось совсем немного. Стоит начать экономить!");
        }
        return moneyBeforeSalary;
    }


    void printAllExpenses() {
        // Замените логику для работы с таблицами
        for (String cat : expensesByCategories.keySet()) {
            for (Double orderPrice : expensesByCategories.get(cat)) {

                System.out.println("Трата № " + cat + ". Потрачено " + orderPrice + " рублей");
            }
        }
    }

    // Метод должен принимать название категории и называться findMaxExpenseInCategory
    double findMaxExpense(String category) {
        double maxExpense = 0;
        /* Замените логику для работы с таблицами
        Если категория есть, то ищем максмальную трату.
        Иначе печатаем "Такой категории пока нет." */
        if (!(expensesByCategories.containsKey(category))) {
            System.out.println("Такой категории пока нет.");
        } else {
            for (Double currentexpense : expensesByCategories.get(category)) {
                if (currentexpense > maxExpense) {
                    maxExpense = currentexpense;
                }
            }
        }return maxExpense;
    }
        void removeAllExpenses () {
            expenses.clear(); // Таблица называется иначе
            System.out.println("Траты удалены.");
        }

}