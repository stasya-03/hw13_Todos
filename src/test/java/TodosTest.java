import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public  void shouldFindSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(1,"Разработать новое приложение");

        Todos todos = new Todos();

        todos.add(simpleTask);

        Task[] expected = {simpleTask};
        Task[] actual = todos.search("приложение");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public  void shouldFindEpic() {
        Epic epic = new Epic(11, new String[]{"Ознакомиться с ТЗ", "Собрать команду"});

        Todos todos = new Todos();

        todos.add(epic);

        Task[] expected = {epic};
        Task[] actual = todos.search("ТЗ");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public  void shouldFindMeeting() {
        Meeting meeting = new Meeting(10, "Новое приложение", "SpeedTest", "10.08.2025");

        Todos todos = new Todos();

        todos.add(meeting);

        Task[] expected = {meeting};
        Task[] actual = todos.search("SpeedTest");

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAllTypesOfTasks() {
        SimpleTask simpleTask = new SimpleTask(1,"Сделать домашку");
        Epic epic = new Epic(11, new String[]{"Сделать домашку", "Убраться в квартире"});
        Meeting meeting = new Meeting(10, "Сделать домашку", "QA", "10.08.2025");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.search("домашку");
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotFindAllTypesOfTasks() {
        SimpleTask simpleTask = new SimpleTask(1,"Сделать домашку");
        Epic epic = new Epic(11, new String[]{"Посмотреть лекцию", "Убраться в квартире"});
        Meeting meeting = new Meeting(10, "Новое приложение", "SpeedTest", "10.08.2025");

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {};
        Task[] actual = todos.search("ничего");
        Assertions.assertArrayEquals(expected, actual);
    }

}
