import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ToDoApp extends JFrame {
    private DefaultListModel<String> taskListModel;
    private JList<String> taskList;
    private JTextField taskInput;

    public ToDoApp() {
        setTitle("To-Do List");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Title
        JLabel title = new JLabel("My To-Do List", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        // Task List
        taskListModel = new DefaultListModel<>();
        taskList = new JList<>(taskListModel);
        add(new JScrollPane(taskList), BorderLayout.CENTER);

        // Input and Buttons
        JPanel inputPanel = new JPanel(new BorderLayout());
        taskInput = new JTextField();
        JButton addButton = new JButton("Add Task");
        JButton removeButton = new JButton("Remove Selected");

        inputPanel.add(taskInput, BorderLayout.CENTER);
        inputPanel.add(addButton, BorderLayout.EAST);
        add(inputPanel, BorderLayout.SOUTH);
        add(removeButton, BorderLayout.NORTH);

        // Button Listeners
        addButton.addActionListener(e -> {
            String task = taskInput.getText().trim();
            if (!task.isEmpty()) {
                taskListModel.addElement(task);
                taskInput.setText("");
            }
        });

        removeButton.addActionListener(e -> {
            int selectedIndex = taskList.getSelectedIndex();
            if (selectedIndex != -1) {
                taskListModel.remove(selectedIndex);
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ToDoApp::new);
    }
}