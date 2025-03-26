import java.io.*;
import java.util.Scanner;
import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.datatransfer.DataFlavor;

public class Notepad extends JFrame{
    String fName;
    public JTextArea tArea;
    Notepad(){
        tArea=new JTextArea();
        add(tArea);

        JMenuBar mBar=new JMenuBar();

        JMenu fileMenu=new JMenu("File");
        JMenuItem nOption=new JMenuItem("new");
        JMenuItem oOption=new JMenuItem("Open");
        JMenuItem sOPtion=new JMenuItem("Save");
        JMenuItem cOption=new JMenuItem("Close");
        fileMenu.add(nOption);
        fileMenu.add(oOption);
        fileMenu.add(sOPtion);
        fileMenu.add(cOption);
        nOption.addActionListener(new Ne_Option());
        oOption.addActionListener(new Ope_Option());
        sOPtion.addActionListener(new Sav_Option());
        cOption.addActionListener(new clo_Option());
        mBar.add(fileMenu);

        JMenu editMenu=new JMenu("Edit");
        JMenuItem CutOption=new JMenuItem("Cut");
        JMenuItem CopyOption=new JMenuItem("Copy");
        JMenuItem PasteOption=new JMenuItem("Paste");
        editMenu.add(CutOption);
        editMenu.add(CopyOption);
        editMenu.add(PasteOption);
        CutOption.addActionListener(new Cu_Option());
        CopyOption.addActionListener(new Cop_Option());
        PasteOption.addActionListener(new Pas_Option());
        mBar.add(editMenu);

        setJMenuBar(mBar);
        setTitle("NotePad in JAVA");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(600,600);
    }
    class Ne_Option implements ActionListener{
        public void actionPerformed(ActionEvent ne){
            tArea.setText("");
        }
    }
    class Ope_Option implements ActionListener{
        public void actionPerformed(ActionEvent ne){
            JFileChooser fileChooser=new JFileChooser();
            fileChooser.setDialogTitle("Select a Text File");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);

            int result=fileChooser.showOpenDialog(Notepad.this);
            if(result==JFileChooser.APPROVE_OPTION){
                File selectedFile=fileChooser.getSelectedFile();
                fName=selectedFile.getAbsolutePath();
                setTitle(fName);
                readFile(selectedFile);  
        }
    }
}
    class clo_Option implements ActionListener{
        public void actionPerformed(ActionEvent close){
            System.exit(0);
        }
    }
    class Sav_Option implements ActionListener{
        public void actionPerformed(ActionEvent save){
            JFileChooser filechooser=new JFileChooser();
            filechooser.setDialogTitle("Save the text file");
            int result=filechooser.showSaveDialog(Notepad.this);
            if(result==JFileChooser.APPROVE_OPTION){
                File file= filechooser.getSelectedFile();
                fName=file.getAbsolutePath();
            
            if (!fName.toLowerCase().endsWith(".txt")) {
                fName += ".txt";
                file=new File(fName);
            }
            try(BufferedWriter bw=new BufferedWriter(new FileWriter(file))){
                bw.write(tArea.getText());
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(Notepad.this, "Error writing file", "Error", JOptionPane.ERROR_MESSAGE);
            }
            setTitle(fName);
            tArea.requestFocus();
        }
            

        }
    }
    class Cu_Option implements ActionListener{
        public void actionPerformed(ActionEvent cut){
            String stxt=tArea.getSelectedText();
            StringSelection sc=new StringSelection(stxt);
            Clipboard cBoard = Toolkit.getDefaultToolkit().getSystemClipboard();
            cBoard.setContents(sc,null);
            tArea.replaceRange("", tArea.getSelectionStart(),tArea.getSelectionEnd());
        }
    }
    class Cop_Option implements ActionListener{
        public void actionPerformed(ActionEvent copy){
            String ctxt=tArea.getSelectedText();
            StringSelection cboard=new StringSelection(ctxt);
            Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(cboard,null);

        }
    }
    class Pas_Option implements ActionListener{
        public void actionPerformed(ActionEvent paste){
            Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
            try{
                Transferable data=clipboard.getContents(null);
                String pastedText = (String) data.getTransferData(DataFlavor.stringFlavor);
                tArea.insert(pastedText, tArea.getCaretPosition());
            }
            catch(Exception e){
                System.out.println("error");
            }

        }
    }
private void readFile(File file){
    try(Scanner sc=new Scanner(file)){
        tArea.setText("");
        while(sc.hasNextLine()){
            tArea.append(sc.nextLine()+"\n");
        }
    }
    catch(Exception e){
        JOptionPane.showMessageDialog(this, "error reading file", "Error", JOptionPane.ERROR_MESSAGE);
    }
}
 public static void main(String[] args) {
    new Notepad();
 }
}


