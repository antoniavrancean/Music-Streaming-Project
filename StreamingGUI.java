import clase.Ascultator;
import clase.Piesa;
import servicii.PlatformaStreaming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class StreamingGUI extends JFrame {

    private PlatformaStreaming platforma;

    private JTextField titluField;
    private JTextField idField;
    private JTextArea outputArea;

    public StreamingGUI(PlatformaStreaming platforma) {
        this.platforma = platforma;

        setTitle("Music Streaming App");
        setSize(500, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initComponents();
    }

    private void initComponents() {
        setLayout(new BorderLayout());

        // ===== Panel input =====
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Adauga Piesa"));

        inputPanel.add(new JLabel("ID Piesa:"));
        idField = new JTextField();
        inputPanel.add(idField);

        inputPanel.add(new JLabel("Titlu Piesa:"));
        titluField = new JTextField();
        inputPanel.add(titluField);

        JButton adaugaBtn = new JButton("Adauga");
        adaugaBtn.addActionListener(this::adaugaPiesa);

        JButton redaBtn = new JButton("Reda");
        redaBtn.addActionListener(this::redaPiesa);

        inputPanel.add(adaugaBtn);
        inputPanel.add(redaBtn);

        // ===== Output =====
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setBorder(BorderFactory.createTitledBorder("Output"));

        JScrollPane scrollPane = new JScrollPane(outputArea);

        add(inputPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
    }

    private void adaugaPiesa(ActionEvent e) {
        try {
            String id = idField.getText();
            String titlu = titluField.getText();

            Piesa piesa = new Piesa(id, titlu);
            platforma.adaugaPiesa(piesa);

            outputArea.append("Piesa adaugata: " + titlu + "\n");
            idField.setText("");
            titluField.setText("");

        } catch (Exception ex) {
            outputArea.append("Eroare: " + ex.getMessage() + "\n");
        }
    }

    private void redaPiesa(ActionEvent e) {
        try {
            String id = idField.getText();

            platforma.redaPiesa(id, "asc1"); // presupunem un ascultator existent

            outputArea.append("Piesa redata: " + id + "\n");

        } catch (Exception ex) {
            outputArea.append("Eroare: " + ex.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {

        // Cream platforma
        PlatformaStreaming platforma = new PlatformaStreaming();

        // Cream un ascultator de test
        Ascultator ascultator = new Ascultator("asc1", "Maria", "maria@email.com");
        platforma.inregistreazaUtilizator(ascultator);

        // Pornim GUI-ul pe thread-ul grafic
        javax.swing.SwingUtilities.invokeLater(() -> {
            StreamingGUI gui = new StreamingGUI(platforma);
            gui.setVisible(true);
        });
    }
}
