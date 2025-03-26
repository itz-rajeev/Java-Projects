import javax.swing.border.CompoundBorder;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

public class StudentMgmtApp {

   static String[] colName = { "delete", "ID", "Name", "Age", "Standard" };
   static Object[][] studentList = new Object[][] { { false, 1, "rajeev", 23, 12 } };
   static DefaultTableModel studentModel;
   static JTable studentTable;

   private StudentMgmtApp() {
      JFrame jFrame = new JFrame("Student Management Application");
      jFrame.setBounds(100, 100, 500, 300);
      jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      studentModel = new DefaultTableModel(studentList, colName);  
    studentTable = new JTable(studentModel);

      JTabbedPane tabbedPane = new JTabbedPane();

      CreateStudentPanel createStudentPanel = new CreateStudentPanel();
      ReadDeletStudentPanel readDeletStudentPanel = new ReadDeletStudentPanel();

      tabbedPane.addTab("Create Student", createStudentPanel);
      tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

      tabbedPane.addTab("Read/Delete Student", readDeletStudentPanel);
      tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

      jFrame.setContentPane(tabbedPane);
      jFrame.setVisible(true);

   }

   public static void main(String[] args) {
      new StudentMgmtApp();
   }

   static JTextField addLabelAndTextField(String labelText, int yPos, Container containingPanel) {
      JLabel label = new JLabel(labelText);
      GridBagConstraints gridBagConstraintsForLabel = new GridBagConstraints();
      gridBagConstraintsForLabel.fill = GridBagConstraints.BOTH;
      gridBagConstraintsForLabel.insets = new Insets(0, 0, 5, 5);
      gridBagConstraintsForLabel.gridx = 0;
      gridBagConstraintsForLabel.gridy = yPos;
      containingPanel.add(label, gridBagConstraintsForLabel);

      JTextField textField = new JTextField();
      GridBagConstraints gridBagConstraintForTextField = new GridBagConstraints();
      gridBagConstraintForTextField.fill = GridBagConstraints.BOTH;
      gridBagConstraintForTextField.insets = new Insets(0, 0, 5, 0);
      gridBagConstraintForTextField.gridx = 1;
      gridBagConstraintForTextField.gridy = yPos;
      containingPanel.add(textField, gridBagConstraintForTextField);
      textField.setColumns(10);
      return textField;
   }

   static JButton addButton(String btnText, int yPos, Container containingPanel) {
      JButton button = new JButton(btnText);
      GridBagConstraints gridBagConstraintForButton = new GridBagConstraints();
      gridBagConstraintForButton.fill = GridBagConstraints.BOTH;
      gridBagConstraintForButton.insets = new Insets(0, 0, 5, 5);
      gridBagConstraintForButton.gridx = 0;
      gridBagConstraintForButton.gridy = yPos;
      containingPanel.add(button, gridBagConstraintForButton);
      return button;
   }
    static void append(Object[][] array,Object[] value){
      Object[][] result=Arrays.copyOf(array,array.length + 1);
      result[result.length - 1]=value;
      StudentMgmtApp.studentList=result;
   }

}

class CreateStudentPanel extends JPanel {
   private JTextField idTextField;
   private JTextField nameTextField;
   private JTextField ageTextField;
   private JTextField stdTextField;

   CreateStudentPanel() {
      Border border = getBorder();
      Border margin = new EmptyBorder(10, 10, 10, 10);
      setBorder(new CompoundBorder(border, margin));

      GridBagLayout panelGridBagLayout = new GridBagLayout();
      panelGridBagLayout.columnWidths = new int[] { 86, 86, 0 };
      panelGridBagLayout.rowHeights = new int[] { 20, 20, 20, 20, 20, 0 };
      panelGridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
      setLayout(panelGridBagLayout);

      idTextField = StudentMgmtApp.addLabelAndTextField("ID :", 0, this);
      nameTextField = StudentMgmtApp.addLabelAndTextField("Name :", 1, this);
      ageTextField = StudentMgmtApp.addLabelAndTextField("Age :", 2, this);
      stdTextField = StudentMgmtApp.addLabelAndTextField("Standard :", 3, this);
      JButton createStudentButton = StudentMgmtApp.addButton("Create", 4, this);

      createStudentButton.addActionListener(e -> createStudent());
   }

   private void createStudent() {
      String studentId = idTextField.getText();
      String studentAge = ageTextField.getText();
      String studentName = nameTextField.getText();
      String studentStd = stdTextField.getText();

      Object[]studentData=new Object[]{false,studentId,studentName,studentAge,studentStd};
      StudentMgmtApp.append(StudentMgmtApp.studentList,studentData);
      StudentMgmtApp.studentModel.addRow(studentData);

      idTextField.setText("");
      ageTextField.setText("");
      nameTextField.setText("");
      stdTextField.setText("");
   }
}

class ReadDeletStudentPanel extends JPanel {
   ReadDeletStudentPanel() {
      setPreferredSize(new Dimension(400, 200));

      JButton deleteButton = StudentMgmtApp.addButton("Delete", 0, this);
      deleteButton.addActionListener(e -> deleteStudent());

      StudentMgmtApp.studentModel = new DefaultTableModel(StudentMgmtApp.studentList,StudentMgmtApp.colName);

      StudentMgmtApp.studentTable = new JTable(StudentMgmtApp.studentModel) {
         @Override
         public Class<?> getColumnClass(int column) {
            switch (column) {
               case 0:
                  return Boolean.class;
               case 1:
                  return String.class;
               case 2:
                  return String.class;
               case 3:
                  return String.class;
               case 4:
                  return String.class;
               default:
                  return Boolean.class;
            }
         }
      };
      // turn off table`s auto resize so that JScrollPane will show a horizontal
      // scroll bar.
      StudentMgmtApp.studentTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

      JScrollPane pane = new JScrollPane(StudentMgmtApp.studentTable);
      add(pane, BorderLayout.CENTER);
   }

   private void deleteStudent() {
      DefaultTableModel model = (DefaultTableModel) StudentMgmtApp.studentTable.getModel();
      for (int i = 0; i < model.getRowCount(); i++) {
         Boolean checked = (Boolean) model.getValueAt(i, 0);
         if (checked != null && checked) {
            model.removeRow(i);
            i--;
         }
      }
   }
}